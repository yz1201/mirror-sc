package cn.dbdj1201.sc.controller;


import cn.dbdj1201.sc.common.api.CommonResult;
import cn.dbdj1201.sc.common.dto.UmsAdminInfo;
import cn.dbdj1201.sc.entity.UmsAdmin;
import cn.dbdj1201.sc.entity.UmsPermission;
import cn.dbdj1201.sc.service.IUmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author dbdj1201
 * @since 2020-08-09
 */
@Api("UmsAdminController")
@RestController
@RequestMapping("/admin")
@Slf4j
public class UmsAdminController {

    @Autowired
    private IUmsAdminService adminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdmin) {
        log.info("新用户注册");
        UmsAdmin register = adminService.register(umsAdmin);
        CommonResult<UmsAdmin> commonResult;
        if (register == null) {
            log.warn("注册失败咯");
            commonResult = CommonResult.failed("注册失败");
        } else {
            log.info("注册成功-{}", register);
            commonResult = CommonResult.success(register);
        }
        return commonResult;
    }

    @ApiOperation("登录之后返回JWT")
    @PostMapping("/login")
    public CommonResult<Map<String, String>> login(@RequestBody UmsAdminInfo umsAdminInfo) {
        String token = this.adminService.login(umsAdminInfo.getUsername(), umsAdminInfo.getPassword());
        if (token == null) {
            log.warn("校验失败");
            return CommonResult.validateFailed("用户名或者密码错误");
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取某个用户的所有权限")
    @GetMapping("/permission/{adminId}")
    public CommonResult<List<UmsPermission>> getAllPermission(@PathVariable("adminId") Long adminId) {
        List<UmsPermission> permissions = this.adminService.getPermissions(adminId);
        return CommonResult.success(permissions);
    }

}
