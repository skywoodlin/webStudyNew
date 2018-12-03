package javaTest.ucarJarTest;

import com.xjlin.util.fromUcar.HtmlUtil;
import org.junit.Test;

/**
 * Created by xjlin on 2018/11/12.
 */
public class HtmlUtilTest{
    private static final String str1 = "<abc>abcd</abd>";
    @Test
    public void testGetTagName() {
        System.out.println(HtmlUtil.getTagName(str1));
    }

    @Test
    public void testGetTagName2() {
        System.out.println(HtmlUtil.getTagName(str1,9));
    }
}
