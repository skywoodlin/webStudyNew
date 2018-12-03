<%@ page language="java" import="java.util.*" pageEncoding="utf-8" session="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <%
  	request.getSession();
  
  	String url1 = request.getContextPath()+"/session/buy?prod=电视机";
  	url1 = response.encodeURL(url1);
  	String url2 = request.getContextPath()+"/session/buy?prod=冰箱";
  	url2 = response.encodeURL(url2);
  	String url3 = request.getContextPath()+"/session/pay";
  	url3 = response.encodeURL(url3);
   %>
  	<a href="<%= url1 %>">电视机</a>
  	<a href="<%= url2 %>">冰箱</a>
  	<a href="<%= url3 %>">结账</a>
  </body>
</html>
