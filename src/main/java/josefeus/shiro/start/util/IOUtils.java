package josefeus.shiro.start.util;

import josefeus.shiro.start.thread.FileWriteThread;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/14 10:14
 */
@Slf4j
public class IOUtils {
    private final static long byteLength = 1024;

    // 随机读写
    public static boolean randomWrite(String origin, String dest) {
        byte[] buffer = new byte[(int) byteLength];
        try (FileInputStream in = new FileInputStream(origin);
             RandomAccessFile randomAccessFile = new RandomAccessFile(dest, "rw")) {
            int i = 0;
            int hasRead;
            while ((hasRead = in.read(buffer)) > -1) {
                randomAccessFile.seek(i * byteLength);
                randomAccessFile.write(buffer, 0, hasRead);
                i++;
            }
        } catch (IOException e) {
            log.error(e.toString());
            return false;
        }
        return true;
    }

    // 多线程随机读写
    public static boolean randomWriteWithThread(String origin, String dest) {
        byte[] buffer = new byte[(int) byteLength];
        try (FileInputStream in = new FileInputStream(origin)) {
            int i = 0;
            int hasRead;
            while ((hasRead = in.read(buffer)) > -1) {
                FileWriteThread fileWriteThread = new FileWriteThread(dest, i * byteLength, buffer, hasRead);
                fileWriteThread.setName("FileWriteThread--" + i);
                fileWriteThread.start();
                i++;
            }
            log.info("finished");
        } catch (IOException e) {
            log.error(e.toString());
            return false;
        }
        return true;
    }
}
