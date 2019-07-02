/**
 * FileName: channelTransfeTest
 * Author:   Administrator
 * Date:     2019/6/26 15:09
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package main.java.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 〈channel间的数据传输〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/6/26
 * @since 1.0.0
 */
public class channelTransfeTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("F:\\testdata\\a.txt","rw");
        FileChannel fromChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("F:\\testdata\\b.txt","rw");
        FileChannel toChannel = toFile.getChannel();
        long position = 0;
        long count = fromChannel.size();
        //toChannel.transferFrom(fromChannel,position,count);
        fromChannel.transferTo(position,count,toChannel);


    }

}