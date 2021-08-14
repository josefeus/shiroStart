package josefeus.shiro.start.basic;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 13:33
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private void printError(Exception e){
        log.error(e.getMessage());
    }

    @ExceptionHandler(UnknownAccountException.class)
    public R unknownAccountException(UnknownAccountException e) {
        printError(e);
        return R.error("用户名或密码错误");
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public R IncorrectCredentialsException(IncorrectCredentialsException e) {
        printError(e);
        return R.error("用户名或密码错误");
    }
}
