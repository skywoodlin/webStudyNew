package com.xjlin.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class Demo1Tag implements Tag {

	public int doEndTag() throws JspException {
		return SKIP_PAGE;
	}

	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	public Tag getParent() {
		return null;
	}

	public void release() {

	}

	public void setPageContext(PageContext pc) {

	}

	public void setParent(Tag t) {

	}

}
