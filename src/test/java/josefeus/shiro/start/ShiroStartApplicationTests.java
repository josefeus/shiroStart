package josefeus.shiro.start;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@SpringBootTest
class ShiroStartApplicationTests {

    @Test
    void contextLoads() {
        // String salt = UUIDUtils.getUUID();
        String pwd = new Md5Hash("123456").toHex();
        String pwd1 = new Md5Hash(pwd, "135809afca2846668c1128e354a5f0d3").toHex();
        System.out.println("pwd: " + pwd);
        // System.out.println("salt: " + salt);
        System.out.println("pwd1: " + pwd1);

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode("MTM1ODA5YWZjYTI4NDY2NjhjMTEyOGUzNTRhNWYwZDM=");
        String s = new String(decode);
        System.out.println("s: " + s);
    }

}
