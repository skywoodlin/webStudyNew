package com.xjlin.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class ShowIpTag implements Tag {
	private PageContext pc = null;

	public int doEndTag() throws JspException {
		//EVAL_PAGE -- 结束标签之后的剩余页面需要去执行
		//SKIP_PAGE -- 结束标签之后的剩余页面不要去执行
		return 0;
	}

	public int doStartTag() throws JspException {
		try {
			String ip = pc.getRequest().getRemoteAddr();
			pc.getOut().write(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Eval_Body_Include -- 开始标签之后的标签体需要执行
		//Skip_Body -- 开始标签之后的标签体不需要执行
		return 0;
	}

	public Tag getParent() {
		return null;
	}

	public void release() {

	}

	public void setPageContext(PageContext pc) {
		this.pc = pc;
	}

	public void setParent(Tag t) {
		
	}

}
