<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
注意， 被include的页面，
1. 除了第一行
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>不会被引入进来， 其它的都会原样copy过来。

2. 如果不写上面那个第一行， 会乱码
--%>
<html>
  <head>
  </head>
  <body>
  	from xxxxx....
  	<c:import url="importedPage.jsp" var="p" scope="page"></c:import>
  	xxxx
  	yyyy
  	${p }
  	zzzz
    <br>
    ${p }
  </body>
</html>
