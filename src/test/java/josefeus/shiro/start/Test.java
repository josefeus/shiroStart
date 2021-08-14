package josefeus.shiro.start;

import java.io.*;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/14 09:24
 */
public class Test {
    /**
     * RandomAccessFile:可以访问文件任意位置的类
     */
    public static void main(String[] args) {
        // test1();
        // insertAtPos(new File("D://temp/java.txt"), 8, "沧海月明珠有泪\r\n蓝田日暖玉生烟\r\n");
        // appendContent(new File("F:/java.txt"));
        split();
    }

    //使用范例
    static void split() {
        String input = "D://temp/1.mp4";
        String output = "D://temp/fuck.mp4";
        RandomAccessFile raf = null;
        try (FileInputStream in = new FileInputStream(input)) {
            byte[] buffer = new byte[1024];
            int hasRead;

            int i = 0;
            raf = new RandomAccessFile(output, "rw");
            while ((hasRead = in.read(buffer)) > -1) {
                raf.seek(i * 1024L);
                raf.write(buffer, 0, hasRead);
                i++;
                System.out.println("hasRead: " + hasRead + ", i: " + i);
                System.out.println("raf size: " + raf.length());
            }
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test1() {
        try (RandomAccessFile raf = new RandomAccessFile("D://temp/temp.txt", "r");) {
            //获取当前指针位置
            long index = raf.getFilePointer();
            System.out.println("当前指针的位置:" + index);
            //设置指针的位置
            raf.seek(300);
            index = raf.getFilePointer();
            System.out.println("现在指针的位置:" + index);
            int hasRead = 0;
            byte[] buffer = new byte[1024];
            while ((hasRead = raf.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, hasRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 在文件末尾追加内容
     */
    public static void appendContent(File file) {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(raf.length());
            String content = new String("此情可待成追忆".getBytes("GBK"), "ISO8859-1");
            raf.write("三人行必有我师".getBytes("GBK"));
            System.out.println("追加成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将指定字符串插入文件的指定位置
     *
     * @param file
     * @param pos
     * @param content
     */
    public static void insertAtPos(File file, int pos, String content) {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
             FileInputStream fr = new FileInputStream("D://temp/temp.txt");
             FileOutputStream bw = new FileOutputStream("D://temp/temp1.txt")) {
            raf.seek(pos);
            byte[] buffer = new byte[64];
            int hasRead = 0;
            //将指定位置后的内容写入到临时文件中去
            while ((hasRead = raf.read(buffer)) != -1) {
                bw.write(buffer, 0, hasRead);
            }
            //重新定位
            raf.seek(pos);
            //将目标内容写入到目标文件中
            raf.write(content.getBytes("GBK"));
            //将临时文件中的内容写入到目标文件的末尾
            while ((hasRead = fr.read(buffer)) != -1) {
                raf.write(buffer, 0, hasRead);
            }
            new File("D://temp/temp1.txt").delete();
            System.out.println("写入完成!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
