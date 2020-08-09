package cn.dbdj1201.sc.controller;


import cn.dbdj1201.sc.common.api.CommonResult;
import cn.dbdj1201.sc.service.IUmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author dbdj1201
 * @since 2020-08-09
 */
@Api("UmsMemberController")
@RestController
@RequestMapping("/sso")
@Slf4j
public class UmsMemberController {

    @Autowired
    IUmsMemberService memberService;

    @ApiOperation("获取验证码")
    @GetMapping("/authCode")
    public CommonResult<String> getAuthCode(@RequestParam String phoneNumber) {
        String authCode = this.memberService.generateAuthCode(phoneNumber);
        log.info("验证码获取");
        return CommonResult.success(authCode);
    }

    @ApiOperation("验证码校验")
    @GetMapping("/verifyAuthCode")
    public CommonResult<String> verifyAuthCode(@RequestParam String authCode, @RequestParam String phoneNumber) {
        CommonResult<String> commonResult;
        log.info("验证码校验");
        boolean verifyResult = this.memberService.verify(authCode, phoneNumber);
        if (!verifyResult) {
            log.debug("验证码校验失败");
            commonResult = CommonResult.failed("校验失败");
        } else {
            log.info("验证码校验成功");
            commonResult = CommonResult.success("校验成功");
        }
        return commonResult;
    }

}
