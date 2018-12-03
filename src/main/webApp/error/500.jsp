<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	通用错误提示:服务器出错了.请联系管理员..亲......

  <br>
  错误信息： <%=exception.getMessage()%>
  <br>
  错误信息： ${pageContext.exception.printStackTrace()}
  </body>
</html>
