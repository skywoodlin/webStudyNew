package javaTest;

import org.junit.Test;

import java.net.URLEncoder;

/**
 * Created by xjlin on 2018/10/26.
 */
public class UrlEncodingTest{
    @Test
    public void test() {
        String str = "www.中文.abc";
        System.out.println(UrlEncodingTest.urlEncode(str));
    }

    public static String urlEncode(String str) {
        return URLEncoder.encode(str);
    }
}
