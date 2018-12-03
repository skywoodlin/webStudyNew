package com.xjlin.simletag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class SimpleShowIp implements SimpleTag {
	private JspContext pc = null;
	public void doTag() throws JspException, IOException {
		PageContext pcx = (PageContext) pc;
		String ip = pcx.getRequest().getRemoteAddr();
		pcx.getOut().write(ip);
	}

	public JspTag getParent() {
		return null;
	}

	public void setJspBody(JspFragment jspBody) {

	}

	public void setJspContext(JspContext pc) {
		this.pc = pc;
	}

	public void setParent(JspTag parent) {

	}

}
