package josefeus.shiro.start.model;

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
public class User {

    private int id;

    private String username;

    private String nickname;

    private String password;

    private String salt;

    private boolean valid;
}
