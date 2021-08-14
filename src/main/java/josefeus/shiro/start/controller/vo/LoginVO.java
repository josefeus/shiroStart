package josefeus.shiro.start.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 18:07
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {
    private int id;

    private String username;

    private String nickname;
}
