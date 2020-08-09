package cn.dbdj1201.sc.component;

import cn.dbdj1201.sc.common.api.CommonResult;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-09 19:03
 * 当访问接口没有权限时，自定义的返回结果
 */
@Component
@Slf4j
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.warn("你没权限访问这个接口，ε=ε=ε=(~￣▽￣)~");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSONUtil.toJsonStr(CommonResult.forbidden(accessDeniedException.getMessage())));
        response.getWriter().flush();
    }
}
