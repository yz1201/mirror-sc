package cn.dbdj1201.sc.common.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dbdj1201
 * @Date: 2020-08-09 16:31
 */
@Component
@Slf4j
public class JwtUtils {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Integer expiration;

    /**
     * 生成JWT
     *
     * @param claims
     * @return
     */
    private String doGenerateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpireTime())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    /**
     * 解析Jwt
     *
     * @param token
     * @return payload
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("解析token失败-{}", e.getMessage());
        }
        return claims;
    }

    /**
     * @param token
     * @return
     */
    public String getUsernameFormToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            log.error("无用户信息");
            return null;
        }
        return username;
    }

    /**
     * 校验token
     *
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        return getUsernameFormToken(token).equals(userDetails.getUsername()) && isTokenExpired(token);
    }

    /**
     * 判断token是否失效
     *
     * @param token
     * @return true-未失效 false-已失效
     */
    public boolean isTokenExpired(String token) {
        log.info("校验token是否到期-{}", token);
        Date expireDate = getExpireDateFromToken(token);
        boolean isValid = expireDate.after(new Date());
        if (isValid) {
            log.info("token未超时");
        } else {
            log.warn("token已失效");
        }
        return isValid;
    }

    /**
     * 从token中获取失效时间
     *
     * @param token
     * @return
     */
    private Date getExpireDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    /**
     * 根据用户信息生成Jwt
     *
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return doGenerateToken(claims);
    }

    /**
     * token还能否刷新
     *
     * @param token
     * @return true-可刷新，false-不能刷新
     */
    public boolean canRefresh(String token) {
        return isTokenExpired(token);
    }

    /**
     * 刷新Jwt，设置新的到期时间
     *
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.setExpiration(generateExpireTime());
        return doGenerateToken(claims);
    }


    /**
     * 计算过期时间
     *
     * @return
     */
    private Date generateExpireTime() {
        return DateUtil.offset(DateUtil.date(), DateField.SECOND, expiration);
    }

//    public static void main(String[] args) {
//        System.out.println(generateExpireTime());
//    }
}
