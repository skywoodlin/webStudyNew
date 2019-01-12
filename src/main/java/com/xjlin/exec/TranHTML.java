package com.xjlin.exec;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TranHTML extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter writer = new StringWriter();
		getJspBody().invoke(writer);
		String str = writer.toString();
		
		str = filter(str);
		
		getJspContext().getOut().write(str);
	}

	private String filter(String message) {
		if (message == null)
			return (null);

		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuffer result = new StringBuffer(content.length + 50);
		for (int i = 0; i < content.length; i++) {
			switch (content[i]) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(content[i]);
			}
		}
		return (result.toString());

	}
}
