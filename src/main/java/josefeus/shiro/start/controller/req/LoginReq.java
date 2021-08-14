package josefeus.shiro.start.controller.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 12:24
 */
@Getter
@Setter
public class LoginReq {
    
    private String username;

    private String password;
}
