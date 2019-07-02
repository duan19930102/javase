/**
 * FileName: Selector
 * Author:   Administrator
 * Date:     2019/6/26 15:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package main.java.io.nio;



import java.io.IOException;

import java.net.InetSocketAddress;

import java.nio.channels.*;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2019/6/26
 * @since 1.0.0
 */
public class SelectorTest {
    private static final int TIMEOUT = 3000;
    public static void main(String[] args) throws IOException {


    }

    public static void selector(){

        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;

        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1",9999));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true){
                if(selector.select(TIMEOUT)==0) {
                    System.err.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}