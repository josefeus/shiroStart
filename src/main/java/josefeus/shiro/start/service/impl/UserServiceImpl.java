package josefeus.shiro.start.service.impl;

import josefeus.shiro.start.basic.R;
import josefeus.shiro.start.controller.req.LoginReq;
import josefeus.shiro.start.controller.vo.LoginVO;
import josefeus.shiro.start.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 12:24
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public R login(LoginReq req) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(req.getUsername(), req.getPassword());
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            log.error(e.getMessage());
            throw new UnknownAccountException();
        } catch (IncorrectCredentialsException e) {
            log.error(e.getMessage());
            throw new IncorrectCredentialsException();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        LoginVO data = new LoginVO(1, (String) subject.getPrincipal(), req.getUsername());
        return R.success("登录成功", data);
    }

    @Override
    public R logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.success("注销成功");
    }
}
