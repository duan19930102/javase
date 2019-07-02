/**
 * FileName: ServerConnet
 * Author:   Administrator
 * Date:     2019/7/2 15:23
 * Description: TCP服务器nio写法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package main.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 〈一句话功能简述〉<br> 
 * 〈TCP服务器nio写法〉
 *
 * @author Administrator
 * @create 2019/7/2
 * @since 1.0.0
 */
public class ServerConnet {
    private static final int TIME_OUT = 1000;
    private static final int BUF_SIZE = 1024;
    public static void server(){
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;

        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress("1270.0.01",8080));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                if(selector.select(TIME_OUT) == 0){
                    System.err.println("===");
                    continue;
                }

                Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    if(selectionKey.isAcceptable()) {
                        handleAccept(selectionKey);
                    }

                    if(selectionKey.isConnectable()) {
                        System.out.println("isConnectable = true");
                    }

                    if(selectionKey.isReadable()) {
                        handleRead(selectionKey);
                    }

                    if(selectionKey.isWritable()){
                        handleWrite(selectionKey);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleWrite(SelectionKey selectionKey) {
    }

    private static void handleRead(SelectionKey selectionKey) throws IOException {
        SocketChannel sc = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
        long bytesRead = sc.read(buffer);
        while (bytesRead>0) {
            buffer.flip();
            while (buffer.hasRemaining()){
                System.err.print((char) buffer.get());
            }
            System.err.println();
            buffer.clear();
            bytesRead = sc.read(buffer);
        }

        if(bytesRead==-1) {
            sc.close();
        }
    }

    public static void handleAccept(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannelAccept = (ServerSocketChannel) selectionKey.channel();
        serverSocketChannelAccept.configureBlocking(false);
        serverSocketChannelAccept.register(selectionKey.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(BUF_SIZE));
    }

}