<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  <body>
  	<h1>java方式实现的页面国际化</h1><hr>
  	<%
  		Locale local = request.getLocale();
  		ResourceBundle bundle = ResourceBundle.getBundle("resource",local);
  	 %>
  	<form action="#">
  		<%=bundle.getString("username") %>:<input type="text"/>
  		<%=bundle.getString("password") %>:<input type="password"/>
  		<input type="submit" value="<%=bundle.getString("submit") %>"/>
  	</form>
  	
  
  	<h1>fmt标签方式实现的页面国际化</h1><hr>
    <%--告诉页面将resource bundle存到page域里头去（这里头的bundle已经是过滤过语言的了）， 名字交bundle， 在下面才可以取出来--%>
  	<fmt:setBundle basename="resource" var="bundle" scope="page"/>
  	<form action="#">
  		<fmt:message bundle="${bundle}" key="username"/>:<input type="text"/>
  		<fmt:message bundle="${bundle}" key="password"/>:<input type="password"/>
  		<input type="submit" value="<fmt:message bundle="${bundle}" key="submit"/>"/>
  	</form>
  	
  </body>
</html>
