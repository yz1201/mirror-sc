package cn.dbdj1201.sc.config;

import cn.dbdj1201.sc.common.dto.AdminUserDetails;
import cn.dbdj1201.sc.component.JwtAuthenticationFilter;
import cn.dbdj1201.sc.component.RestAuthenticationEntryPoint;
import cn.dbdj1201.sc.component.RestfulAccessDeniedHandler;
import cn.dbdj1201.sc.entity.UmsAdmin;
import cn.dbdj1201.sc.entity.UmsPermission;
import cn.dbdj1201.sc.service.IUmsAdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-09 18:24
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUmsAdminService umsAdminService;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;


    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs/**",
            "/webjars/**"
    };

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //允许对网站静态资源的无授权访问
                .antMatchers(HttpMethod.GET,
                        "/", "/*.html", "/favicon.ico", "/**/*.html"
                        , "/**/*.css", "/**/*.js").permitAll()
                //登录注册放行，允许匿名访问
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/admin/login", "/admin/register").permitAll()
                //跨域时会先发一次options请求，放行
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                //测试时全部运行访问
//                .antMatchers("/**").permitAll()
                //除了上面的都要鉴权认证
                .anyRequest().authenticated();
        //禁用缓存
        security.headers().cacheControl();
        //添加JwtFilter
        security.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义的异常控制
        security.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //获取处于登录状态的用户信息
        return username -> {
            UmsAdmin admin = umsAdminService.getOne(new QueryWrapper<UmsAdmin>().eq("username", username));
            if (admin != null) {
                List<UmsPermission> permissionList = umsAdminService.getPermissions(admin.getId());
                return new AdminUserDetails(admin, permissionList);
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
