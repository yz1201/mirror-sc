package cn.dbdj1201.sc.service.impl;

import cn.dbdj1201.sc.entity.UmsMember;
import cn.dbdj1201.sc.mapper.UmsMemberMapper;
import cn.dbdj1201.sc.service.IRedisService;
import cn.dbdj1201.sc.service.IUmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Random;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author dbdj1201
 * @since 2020-08-09
 */
@Service
@Slf4j
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements IUmsMemberService {

    @Autowired
    private IRedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public String generateAuthCode(String phoneNumber) {
        String authCode = doGenerateAuthCode();
        this.redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + phoneNumber, authCode);
        this.redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + phoneNumber, AUTH_CODE_EXPIRE_SECONDS);
        log.info("验证码已存入缓存-{}", authCode);
        return authCode;
    }

    @Override
    public boolean verify(String authCode, String phoneNumber) {
        String cacheCode = this.redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + phoneNumber);
        Assert.notNull(authCode, "传空值？");
        log.info("缓存中code-{}", cacheCode);
        log.info("登入code-{}", authCode);
        return authCode.equals(cacheCode);
    }


    private String doGenerateAuthCode() {
        StringBuilder sb = new StringBuilder();
        int len = 6;
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
