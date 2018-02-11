package cn.com.ylpw.web.crm.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;

/** 
* @ClassName: EncryptUtils 
* @Description: 加密工具类（MD5，AES）
* @author zhaohb
* @date 2015年10月9日 下午1:08:51 
*  
*/
@SuppressWarnings("restriction")
public class EncryptUtils {

	private static final String AES = "AES";
    private static final String AES_KEY_SIGN = "123456abcdef!@#$";//私钥  AES固定格式为128/192/256 bits.即：16/24/32bytes。DES固定格式为128bits，即8bytes。
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";
	
    public static final char[] CHARS = { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','~','!','@','#','$','%','^','&','*'};
    
    public final static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }
	
    public final static byte[] base64Decode(String base64Code) throws Exception {
        return new BASE64Decoder().decodeBuffer(base64Code);
    }
    
	//AES 加密
    public final static String aesEncrypt(String source, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(source, encryptKey));
    }
    
    public final static String aesEncrypt(String source) throws Exception {
        return base64Encode(aesEncryptToBytes(source, AES_KEY_SIGN));
    }

    private final static byte[] aesEncryptToBytes(String source, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance(AES);
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), AES));
        return cipher.doFinal(source.getBytes("utf-8"));
    }
    
	//AES 解密
    public final static String aesDecrypt(String source, String decryptKey) throws Exception {
        return aesDecryptByBytes(base64Decode(source), decryptKey);  
    }
    
    public final static String aesDecrypt(String source) throws Exception {
        return aesDecryptByBytes(base64Decode(source), AES_KEY_SIGN);
    }
    
    private final static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance(AES);  
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), AES));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }
	
    /** 
     * Encrypt string 
     */  
    private final static String encrypt(String source, String algorithm) throws NoSuchAlgorithmException {
        byte[] resByteArray = encrypt(source.getBytes(), algorithm);
        return toHexString(resByteArray);
    }
    
    /** 
     * Encrypt byte array. 
     */  
    private final static byte[] encrypt(byte[] source, String algorithm) throws NoSuchAlgorithmException {  
        MessageDigest md = MessageDigest.getInstance(algorithm);  
        md.reset();  
        md.update(source);  
        return md.digest();
    }
    
    /** 
     * Get hex string from byte array 
     */  
    private final static String toHexString(byte[] res) {  
        StringBuffer sb = new StringBuffer(res.length << 1);  
        for (int i = 0; i < res.length; i++) {  
            String digit = Integer.toHexString(0xFF & res[i]);  
            if (digit.length() == 1) {  
                digit = '0' + digit;  
            }  
            sb.append(digit);  
        }  
        return sb.toString().toUpperCase();  
    }

    //随机生成 AES 私钥 Key
    public final static String randomAES16Key() {
      return randomKey(16);
    }
    
    private final static String randomKey(final int length){
    	StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < length; i++){
          buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }
    
    /**
     * Encrypt string using MD5 algorithm
     */
    public final static String md5Encrypt(String source) {
        if (null == source) return null;
        String result = "";
        try {
            result = encrypt(source, "MD5");
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        String source = "123456";
        System.out.println("待加密数据："+source);
        System.out.println("------------------------------------------------------");
        String gd_aes = aesEncrypt(source);
        System.out.println("默认固定AES加密：" + gd_aes);
        System.out.println("默认固定AES解密：" + aesDecrypt(gd_aes));
        String aesKey = randomAES16Key();
        String dt_aes = aesEncrypt(source, aesKey);
        System.out.println("动态AES加密：" + dt_aes + "\tKey:" + aesKey);
        System.out.println("动态AES解密：" + aesDecrypt(dt_aes, aesKey) + "\tKey:"+aesKey);
        System.out.println("------------------------------------------------------");
    }
}