package josefeus.shiro.start.service;

import josefeus.shiro.start.basic.R;
import josefeus.shiro.start.controller.req.LoginReq;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 12:24
 */
public interface UserService {

    R login(LoginReq req);

    R logout();
}
