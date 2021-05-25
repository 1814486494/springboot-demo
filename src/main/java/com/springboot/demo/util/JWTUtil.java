package com.springboot.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.springboot.demo.key.KeyGenerate;
import org.springframework.scheduling.annotation.Scheduled;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token刷新策略
 * 同时签发refreshToken 并将过期时间设置为token过期时间的两倍
 * 添加一个Token实体类携带token refreshToken expireTime等属性 作为登录返回
 * 前端请求判断token是否过期，过期就携带refreshToken访问，并刷新token，都过期则token失效重新登录
 */
public class JWTUtil {

    //秘钥
    private static String secret = "admin";

    //获取秘钥
    private static Algorithm algorithm = Algorithm.HMAC256(secret);

    //直接注入token,创建对象调用token解析等方法
    private String token;

    //构造注入token
    public JWTUtil(String token) {
        this.token = token;
    }

    //定期生成秘钥
    @Scheduled(cron = "0 0 0 L * ?")
    public void secretGenerate() throws NoSuchAlgorithmException {
        KeyGenerate keyGenerate = new KeyGenerate();
        KeyPair keyPair = keyGenerate.getKeyPair();
        secret = keyGenerate.getPrivateKey(keyPair);
    }

    //token 生成,自定义携带String信息
    public static String generateToken(String account, Date expireTime,String name,String value){
        JWTCreator.Builder builder = JWT.create();
        //设置头信息
        Map<String,Object> headerClaims = new HashMap();
        headerClaims.put("type","JWT");
        headerClaims.put("alg","HS256");

        //        System.out.println(token);
        return builder.withHeader(headerClaims) //头信息
                //荷载信息
                .withClaim(name,value)//自定义
                .withClaim("userName", "zings")
                .withIssuer("server")//签名生成者
                .withSubject(account)//签名主题内容
                .withAudience("client")//签名接收者
                .withIssuedAt(new Date())//token生成时间
                .withExpiresAt(expireTime)//过期时间
                //第三部分取摘要,验证信息完整性
                .sign(algorithm);
    }

    //token 生成
    public static String generateToken(String account, Date expireTime){
        return generateToken(account,expireTime,"jwt","jwt");
    }

    //生成普通token 15分钟过期
    public static String generateToken(String account){
        return generateToken(account,
                DateUtil.localDateTimePlusMin(LocalDateTime.now(),
                        15L),"jwt","jwt");
    }

    //生成刷新token 30分钟过期
    public static String generateRefreshToken(String account){
        return generateToken(account,
                DateUtil.localDateTimePlusMin(LocalDateTime.now(),
                        30L),"refreToken","refreToken");
    }

    //token 解析
    public DecodedJWT tokenParse(String token){
        //获取验证对象
        JWTVerifier verifier = JWT.require(algorithm).build();
        //token验证
        return verifier.verify(token);
    }

    //获取自定义荷载信息
    public Map<String, Claim> getClaims(){
        DecodedJWT decodedJWT = tokenParse(token);
        return decodedJWT.getClaims();
    }

    //获取账号信息
    public String getAccount(){
        DecodedJWT decodedJWT = tokenParse(token);
        return decodedJWT.getSubject();
    }

    //获取过期时间
    public Date getExpireTime(){
        DecodedJWT decodedJWT = tokenParse(token);
        return decodedJWT.getExpiresAt();
    }

    //获得创建时间
    public Date getIssueAt(){
        DecodedJWT decodedJWT = tokenParse(token);
        return decodedJWT.getIssuedAt();
    }

}
