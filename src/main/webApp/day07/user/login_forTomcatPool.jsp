<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<%@ taglib uri="http://www.xjlin.com/UserTag" prefix="UserTag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<div align="center">
 	<h1>我的网站_登录</h1><hr>
        <%=request.getCharacterEncoding()%>
        <%
            String msg1 = (String) request.getAttribute("msg");

//            out.write(msg1);
//            out.write(msg1.getBytes("utf-8").toString());
        %>
 	<font color="red">${msg }</font>
 	<form action="${pageContext.request.contextPath }/user/LoginServlet_tomcatDataSourcePool" method="POST">
		<table border="1">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" value="<UserTag:URLDecoder content="${cookie.remname.value }" encode="utf-8"/>"/></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"/></td>
				<td><input type="checkbox" value="ok" name="remname" 
					<c:if test="${cookie.remname!=null }">
						checked="checked" 
					</c:if>
				/>记住用户名</td>
			</tr>
		</table>
 	</form>
 	</div>
  </body>
</html>