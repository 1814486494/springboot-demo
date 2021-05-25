package com.springboot.demo.key;

import lombok.Data;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @Author:linwenfeng
 * @Time:2020/10/27 21:43
 */
@Data
public class KeyManager {

    private String privateKey;

    private String publicKey;

}
