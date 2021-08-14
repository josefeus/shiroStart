package josefeus.shiro.start;

import josefeus.shiro.start.mapper.UserMapper;
import josefeus.shiro.start.model.User;
import josefeus.shiro.start.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author josefeus
 * @version 1.0
 * @project boot_start
 * @date 2021/08/08 20:29
 */
@Slf4j
@Component
public class ShiroStartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Resource
    private UserMapper userMapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        String username = "admin";
        User user = userMapper.selectUserByName(username);String password = new Md5Hash("admin").toHex();
        log.info("username: " + username + ", password: " + password);
        if (user == null) {
            String salt = UUIDUtils.getUUID();
            userMapper.insertUser(username, "管理员" , new Md5Hash(password, salt).toHex(), salt);
        }
    }
}
