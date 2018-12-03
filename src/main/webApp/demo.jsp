<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<h1>GET提交</h1><hr>
  	<form action="${pageContext.request.contextPath }/servlet/Demo5Servlet" method="GET">
  		name:<input type="text" name="name" /> 
  		addr:<input type="text" name="addr" />
  		<input type="submit" value="提交"/> 
  	</form>
  	<h1>POST提交</h1><hr>
  	<form action="${pageContext.request.contextPath }/servlet/Demo5Servlet" method="POST">
  		name:<input type="text" name="name" /> 
  		addr:<input type="text" name="addr" />
  		<input type="submit" value="提交"/> 
  	</form>
  </body>
</html>
