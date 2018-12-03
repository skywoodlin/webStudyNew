<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<%
  		pageContext.setAttribute("name","赵敏");
  		request.setAttribute("name","张无忌");
  		session.setAttribute("name","周芷若");
  		application.setAttribute("name","小昭");
  	 %>
	<%= pageContext.findAttribute("name") %>

  </body>
</html>
