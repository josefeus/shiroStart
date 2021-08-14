package josefeus.shiro.start.controller;

import josefeus.shiro.start.basic.R;
import josefeus.shiro.start.controller.req.LoginReq;
import josefeus.shiro.start.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 12:24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody LoginReq req) {
        return userService.login(req);
    }

    @GetMapping("/logout")
    public R logout() {
        return userService.logout();
    }
}
