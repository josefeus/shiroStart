package josefeus.shiro.start.controller.req;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/13 22:49
 */
@Getter
@Setter
public class UploadReq {
    private MultipartFile file;
}
