<%--
    不写scope的话， 各种域中的都会删除掉
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="com.xjlin.domain.Person" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
<%
    request.setAttribute("name", "xjlin");
    Map map = new HashMap();
    pageContext.setAttribute("map", map);
%>

remove前: ${name}
<c:remove var="name"></c:remove>
<br>
remove后: ${name}
<br>
removeMap前：${map==null?"没有":"有"}
<c:remove var="map"></c:remove>
<br>
removeMap后：${map==null?"没有":"有"}

</body>
</html>
