package cn.chenc.framework.core.util;


import org.junit.jupiter.api.Test;

/**
 * 　@description: TODO
 * 　@author secret
 * 　@date 2020/12/5 11:01
 *
 */
public class AesUtilTest {

    @Test
    public void testEncrypt() throws Exception {
        String en=AesUtil.encrypt("test","AesUtilTest");
        System.out.println(en);
    }

    @Test
    public void testDecrypt() throws Exception {
        //加密
        String en=AesUtil.encrypt("test","AesUtilTest");
        //解密
        String de=AesUtil.decrypt("test",en);
        System.out.println(de);
    }

}
