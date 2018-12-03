package com.xjlin.tag;

/**
 * Created by xjlin on 2018/11/13.
 */
import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AddTag extends SimpleTagSupport{
    private int num1 = 0;
    private int num2 = 0;
    private int num3 = 0;
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public void setNum3(int num3) {
        this.num3 = num3;
    }
    public void doTag() throws JspException, IOException {
        JspContext ctx = getJspContext();
        JspWriter out = ctx.getOut();
        int sun = num1+num2;
        out.print(num1+"+"+num2+"="+sun);
    }
}
