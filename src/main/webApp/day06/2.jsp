<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<%out.write("aaa"); %>
  	<%response.getWriter().write("bbb"); %>
  	<%out.write("ccc"); %>
  	<%response.getWriter().write("ddd"); %>
  </body>
</html>
