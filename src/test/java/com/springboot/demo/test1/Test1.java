package com.springboot.demo.test1;

import com.springboot.demo.key.KeyGenerate;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Test1 {

        public static void main(String[] args) throws Exception {
//                KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
//                rsa.initialize(1024);
//                KeyPair keyPair = rsa.generateKeyPair();
//                PrivateKey aPrivate = keyPair.getPrivate();
//                byte[] encoded = aPrivate.getEncoded();
//                Base64.Encoder encoder = Base64.getEncoder();
//                byte[] encode = encoder.encode(encoded);
//                String str = new String(encode);
//                System.out.println(str);

//                LocalDateTime localDateTime = LocalDateTime.now().plusDays(1);
//                Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//
//                String token = TokenUtil.generateToken("1234", from);
//                TokenUtil tokenUtil = new TokenUtil(token);
//                Date expireTime = tokenUtil.getExpireTime();
//
//                String account = tokenUtil.getAccount();
//                System.out.println(account);
//
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//                String format = simpleDateFormat.format(expireTime);
//
//                System.out.println(format);

//                List list = new ArrayList();
//                list.add("asdsad");
//                list.add("rewrwe");
//                list.add("12312");

//                Object[] objects = list.toArray();
//                String s = Arrays.toString(objects);
//                s = s.substring(1,s.length() - 1);
//                System.out.println(s);

                String pwd = "123456";
                KeyGenerate keyGenerate = new KeyGenerate();
                KeyPair keyPair = keyGenerate.getKeyPair();
//                PublicKey aPublic = keyPair.getPublic();
//                PrivateKey aPrivate = keyPair.getPrivate();
                //获取base64编码的秘钥
                String pulicKey = keyGenerate.getPublicKey(keyPair);
                String privateKey = keyGenerate.getPrivateKey(keyPair);
                //从base64编码解码，获取公钥私钥 多了一个base64编码过程
                PublicKey publicKey = keyGenerate.parsePublic(pulicKey);
                PrivateKey privateKey1 = keyGenerate.parsePrivate(privateKey);

                byte[] bytes = keyGenerate.publicKeyEncrypt(pwd.getBytes(),publicKey);
                byte[] bytes1 = keyGenerate.privateKeyDecrypt(bytes, privateKey1);

                System.out.println(new String(bytes1));

        }

        public void ordinary2(){
                System.out.println("第二个普通方法");
        }
}
