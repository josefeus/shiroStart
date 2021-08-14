package josefeus.shiro.start.mapper;

import josefeus.shiro.start.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 12:24
 */
@Mapper
public interface UserMapper {

    void insertUser(@Param("username") String username, @Param("nickname") String nickname,
                    @Param("password") String password, @Param("salt") String salt);

    User selectUserByName(@Param("username") String username);

    User getUserById(@Param("id") int id);
}
