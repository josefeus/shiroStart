package josefeus.shiro.start.exception;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 13:48
 */
public class BizException extends RuntimeException{

    private static final long serialVersion = 1L;

    protected String errorCode;

    protected String errorMsg;

    public BizException() {
        super();
    }

    public BizException(String message, String errorCode, String errorMsg) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
