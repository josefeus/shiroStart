package josefeus.shiro.start.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import josefeus.shiro.start.basic.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author josefeus
 * @version 1.0
 * @project shiroStart
 * @date 2021/08/08 20:13
 */
@Slf4j
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }

                return this.executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }

                return true;
            }
        } else {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse resp = (HttpServletResponse)response;
            if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
                resp.setStatus(HttpStatus.OK.value());
                return true;
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [{}]" ,this.getLoginUrl());
                }
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(R.error("用户名或密码错误"));
                out.println(json);
                out.flush();
                out.close();
                return false;
            }
        }
    }
}
