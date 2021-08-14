package josefeus.shiro.start.basic;

import lombok.Getter;
import lombok.Setter;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 15:06
 */
@Getter
@Setter
public class R {
    private Integer code;

    private String msg;

    private Object data;

    private R(Integer code) {
        this.code = code;
    }

    private R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private R(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static R success() {
        return new R(200);
    }

    public static R success(String msg) {
        return new R(200, msg);
    }

    public static R success(String msg, Object data) {
        return new R(200, msg, data);
    }

    public static R success(Object data) {
        return new R(200, "", data);
    }

    public static R error() {
        return new R(500);
    }

    public static R error(String msg) {
        return new R(500, msg);
    }

    public static R error(String msg, Object data) {
        return new R(500, msg, data);
    }

    public static R error(Exception e) {
        return new R(500, e.getMessage());
    }
}
