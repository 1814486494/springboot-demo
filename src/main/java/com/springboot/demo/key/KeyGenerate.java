package com.springboot.demo.key;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.lang.management.BufferPoolMXBean;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @Author:linwenfeng
 * @Time:2020/10/27 21:45
 */
public class KeyGenerate {

    //生成密钥对
    public KeyPair getKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator des = KeyPairGenerator.getInstance("RSA");
        des.initialize(1024);
        KeyPair keyPair = des.generateKeyPair();
        return keyPair;
    }

    //生成公钥
    public String getPublicKey(KeyPair keyPair) {
        PublicKey aPublic = keyPair.getPublic();
        return byteToBase64(aPublic.getEncoded());
    }

    //生成秘钥
    public String getPrivateKey(KeyPair keyPair){
        PrivateKey aPrivate =keyPair.getPrivate();
        return byteToBase64(aPrivate.getEncoded());
    }

    //base64编码后的公钥解码
    public PublicKey parsePublic(String publicKeyStr) throws Exception {
        byte[] publicKeyBytes = base64ToByte(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    //base64编码后的私钥解码
    public  PrivateKey parsePrivate(String privateKeyStr) throws Exception {
        byte[] privateKeyBytes = base64ToByte(privateKeyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey  privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    //公钥加密
    public byte[] publicKeyEncrypt(byte[] content,PublicKey publicKey) throws Exception{
            Cipher rsa = Cipher.getInstance("RSA");
            rsa.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] bytes = rsa.doFinal(content);
            return bytes;
    }

    //私钥解密
    public byte[] privateKeyDecrypt(byte[] content,PrivateKey privateKey) throws Exception{
            Cipher rsa = Cipher.getInstance("RSA");
            rsa.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bytes = rsa.doFinal(content);
            return bytes;
    }

    //byte数组转base64
    private  String byteToBase64(byte[] encode){
        return new BASE64Encoder().encode(encode);
    }

    //base64转byte数组
    private  byte[] base64ToByte(String encode) throws IOException {
        return new BASE64Decoder().decodeBuffer(encode);
    }

}
