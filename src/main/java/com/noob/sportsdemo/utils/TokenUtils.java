package com.noob.sportsdemo.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.noob.sportsdemo.entity.User;
import com.noob.sportsdemo.service.IUserService;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class TokenUtils {

    private static IUserService staticUserService;

    @Resource
    private IUserService userService;

    @PostConstruct
    public void setUserService() {//将userService赋值给静态staticUserService
        staticUserService = userService;
    }

    /**
     * 生成token
     *
     * @return
     */
    public static String genToken(String userId, String password) {
        return JWT.create().withAudience(userId) // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2)) // hutool方法，2小时后token过期
                .sign(Algorithm.HMAC256(password)); // 以 password 作为 token 的密钥
    }

    /**
     * 获取当前登录的用户信息
     *
     * @return user对象
     */
    public static User getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (StrUtil.isNotBlank(token)) {
                String userId = JWT.decode(token).getAudience().get(0);
                return staticUserService.getById(Integer.valueOf(userId));
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }


    /**
     * 验证JWT
     *
     */
    public static void verifyJWT(String jwt, String secret)
            throws JwtException, IllegalArgumentException {
         Jwts.parserBuilder()
                .setSigningKey(stringToSecretKey(secret))
                .build()
                .parseClaimsJws(jwt);
    }

    private static SecretKey stringToSecretKey(String secret) {
        return new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }
}