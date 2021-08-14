package josefeus.shiro.start.config;

import josefeus.shiro.start.basic.AuthRealm;
import josefeus.shiro.start.filter.ShiroFormAuthenticationFilter;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 12:24
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager, ShiroFormAuthenticationFilter shiroFormAuthenticationFilter) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/h2db/*", "anon");
        map.put("/user/login", "anon");
        map.put("/file/*", "anon");
        map.put("/**", "authc");
        shiroFilterFactoryBean.setLoginUrl("/user/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        LinkedHashMap<String, Filter> filterLinkedHashMap = new LinkedHashMap<>();
        filterLinkedHashMap.put("authc", shiroFormAuthenticationFilter);
        shiroFilterFactoryBean.setFilters(filterLinkedHashMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public ShiroFormAuthenticationFilter shiroFormAuthenticationFilter() {
        return new ShiroFormAuthenticationFilter();
    }

    @Bean
    public DefaultWebSecurityManager getSecurityManager(Realm realm) {
        return new DefaultWebSecurityManager(realm);
    }

    @Bean
    public CredentialsMatcher getCredentialsMatcher() {
        return new HashedCredentialsMatcher("md5");
    }

    @Bean
    public Realm getRealm() {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(getCredentialsMatcher());
        return authRealm;
    }
}
