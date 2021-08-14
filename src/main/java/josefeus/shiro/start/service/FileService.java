package josefeus.shiro.start.service;

import josefeus.shiro.start.basic.R;
import josefeus.shiro.start.controller.req.UploadReq;

import javax.servlet.http.HttpServletRequest;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/13 22:50
 */
public interface FileService {

    R upload(UploadReq req, HttpServletRequest request);

    R copy();
}
