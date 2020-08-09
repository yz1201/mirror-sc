package cn.dbdj1201.sc.component;

import cn.dbdj1201.sc.common.api.CommonResult;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-09 19:07
 * 当未登录或者JWT失效时，自定义返回异常
 */
@Component
@Slf4j
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.warn("当前操作需要登录，或者你的token已经到期了，O(∩_∩)O");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSONUtil.toJsonStr(CommonResult.unauthorized(authException.getMessage())));
        response.getWriter().flush();
    }
}
