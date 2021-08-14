package josefeus.shiro.start.controller;

import josefeus.shiro.start.basic.R;
import josefeus.shiro.start.controller.req.UploadReq;
import josefeus.shiro.start.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/13 22:48
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    public R upload(UploadReq req, HttpServletRequest request) {
        return fileService.upload(req, request);
    }

    @GetMapping("/copy")
    public R copy() {
        return fileService.copy();
    }
}
