package com.xjlin.simletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleDemo1 extends SimpleTagSupport {
	private int times;
	
	public void setTimes(int times) {
		this.times = times;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//--控制标签体是否执行
			//----控制标签体不执行,什么都不做标签体就不会执行
			//----控制标签体执行,只要调用封装着标签体的JSPFragment对象的invoke方法就可以执行标签体
			//JspFragment fragment = getJspBody();
			//fragment.invoke(getJspContext().getOut());
			//fragment.invoke(null);
		
		//--控制标签之后的内容是否执行
			//----控制标签之后的内容执行:什么都不做,标签之后的内容就会执行
			//----控制标签之后的内容不执行:抛出SkipPageException这样的一个异常就可以控制标签之后的内容不执行
			//throw new SkipPageException();
		
		//--控制标签体重复执行
		for(int i=0;i<times;i++)
			getJspBody().invoke(null);
		//--修改标签体后进行输出
		//StringWriter writer = new StringWriter();
		//JspFragment fragment = getJspBody();
		//fragment.invoke(writer);
		//String str = writer.toString();
		//str = str.toUpperCase();
		//getJspContext().getOut().write(str);
	}
}
