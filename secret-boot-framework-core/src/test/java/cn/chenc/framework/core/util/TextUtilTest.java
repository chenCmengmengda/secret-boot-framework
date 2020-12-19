package cn.chenc.framework.core.util;


import org.junit.jupiter.api.Test;

/**
 * 　@description: TODO
 * 　@author secret
 * 　@date 2020/12/13 20:23
 *
 */
public class TextUtilTest {

    @Test
    public void htmlToTextTest(){
        String s=TextUtil.htmlToText("<p>qwer</p>");
        System.out.println(s);
    }
}
