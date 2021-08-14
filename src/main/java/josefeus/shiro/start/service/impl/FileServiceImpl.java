package josefeus.shiro.start.service.impl;

import josefeus.shiro.start.basic.R;
import josefeus.shiro.start.controller.req.UploadReq;
import josefeus.shiro.start.service.FileService;
import josefeus.shiro.start.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/13 22:50
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Override
    public R upload(UploadReq req, HttpServletRequest request) {
        String range = request.getHeader("Range");
        log.info("Range: {}", range);

        MultipartFile file = req.getFile();
        String filename = file.getOriginalFilename();
        String path = "D://temp/";
        File dest = new File(path + filename);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return R.success();
    }

    @Override
    public R copy() {
        if (IOUtils.randomWriteWithThread("D://temp/1.mp4", "D://temp/2.mp4")) {
            return R.success();
        }
        return R.error();
    }

}
