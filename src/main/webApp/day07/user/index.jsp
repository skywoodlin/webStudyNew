<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  </head>
  <body>
	<h1>我的网站</h1><hr>
	<c:if test="${sessionScope.user==null}">
		欢迎光临!游客!
		<a href="${pageContext.request.contextPath }/day07/user/regist.jsp">注册</a>
		<a href="${pageContext.request.contextPath }/day07/user/login.jsp">登录</a>
		<a href="${pageContext.request.contextPath }/day07/user/login_forTomcatPool.jsp">登录_forTomcatPool</a>
	</c:if>
	<c:if test="${sessionScope.user!=null}">
		欢迎回来!${sessionScope.user.username }!
		<a href="${pageContext.request.contextPath }/user/LogoutServlet">注销</a>
	</c:if>
  </body>
</html>
