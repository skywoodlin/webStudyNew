<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <%
  	pageContext.setAttribute("name","wang");
  	request.setAttribute("name","li");
   %>
  	${requestScope.name}
  	${param.size()} ${paramValues.size()}
  	${param.name } ${paramValues.like[0] }${header["Accept-Language"] }
  	${cookie.JSESSIONID.name }${cookie.JSESSIONID.value }
  <br/>
  web.xml中对应用的配置： initParam.xjlintest=
  	${initParam.xjlintest }
  	
  </body>
</html>
