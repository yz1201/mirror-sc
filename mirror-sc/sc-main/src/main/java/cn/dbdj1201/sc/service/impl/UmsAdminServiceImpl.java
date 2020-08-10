package cn.dbdj1201.sc.service.impl;

import cn.dbdj1201.sc.common.utils.JwtUtils;
import cn.dbdj1201.sc.common.utils.SpringContextUtil;
import cn.dbdj1201.sc.dao.IUmsAdminRoleRelationDao;
import cn.dbdj1201.sc.entity.UmsAdmin;
import cn.dbdj1201.sc.entity.UmsPermission;
import cn.dbdj1201.sc.mapper.UmsAdminMapper;
import cn.dbdj1201.sc.service.IUmsAdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author dbdj1201
 * @since 2020-08-09
 */
@Service
@Slf4j
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements IUmsAdminService {

    @Autowired
    private IUmsAdminRoleRelationDao adminRoleRelationDao;

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public List<UmsPermission> getPermissions(Long umsAdminId) {
        return adminRoleRelationDao.getPermissions(umsAdminId);
    }

    /**
     * 注册时，先查询该用户名是否可用，可用然后允许注册
     *
     * @param umsAdmin
     * @return
     */
    @Override
    public UmsAdmin register(UmsAdmin umsAdmin) {
        UmsAdmin dbUser = this.umsAdminMapper.selectOne(new QueryWrapper<UmsAdmin>().eq("username", umsAdmin.getUsername()));
        if (dbUser != null) {
            return null;
        }

        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));
        int insert = this.umsAdminMapper.insert(umsAdmin);
        if (insert != 1) {
            return null;
        }
        return this.umsAdminMapper.selectOne(new QueryWrapper<UmsAdmin>().eq("username", umsAdmin.getUsername()));
    }

    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public String login(String username, String password) {
        String token = null;
//        UmsAdmin umsAdmin = this.umsAdminMapper.selectOne(new QueryWrapper<UmsAdmin>().eq("username", password)
//                .eq("password", password));
        try {
            log.info("登录过程，认证开始");
            UserDetailsService userDetailsService = SpringContextUtil.getBean(UserDetailsService.class);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                log.warn("密码有点问题w(ﾟДﾟ)w");
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            token = jwtUtils.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("认证失败，{}", e.getMessage());
        }
        log.info("认证完成，token为{}", token);
        return token;
    }
}
