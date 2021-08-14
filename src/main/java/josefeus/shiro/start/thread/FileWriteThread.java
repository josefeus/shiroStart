package josefeus.shiro.start.thread;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/14 16:12
 */
@Getter
@Setter
@Slf4j
public class FileWriteThread extends Thread {
    /**
     * 写入的文件名
     */
    private String dest;
    /**
     * 写入的位置
     */
    private long pos;
    /**
     * 写入的数据
     */
    private byte[] buffer;
    /**
     * 本次读写的长度
     */
    private int hasRead;

    public FileWriteThread(String dest, long pos, byte[] buffer, int hasRead) {
        this.dest = dest;
        this.pos = pos;
        this.buffer = new byte[hasRead];
        System.arraycopy(buffer, 0, this.buffer, 0, hasRead);
        this.hasRead = hasRead;
    }

    public FileWriteThread() {
    }

    @Override
    public void run() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(dest, "rw")) {
            randomAccessFile.seek(pos);
            randomAccessFile.write(buffer, 0, hasRead);
            log.info("write from " + pos + " to " + randomAccessFile.getFilePointer());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
