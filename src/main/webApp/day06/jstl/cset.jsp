<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="com.xjlin.domain.Person" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
<br>
<h1>修改域中的JavaBean的属性的值</h1>
<hr>
<%
    Person p = new Person();
    pageContext.setAttribute("p", p);
%>
<c:set target="${p}" property="name" value="克林顿"></c:set>
${p.name }


<h1>设置或修改域中的Map的值</h1>
<hr>
<%
    Map map = new HashMap();
    pageContext.setAttribute("map", map);

%>
<c:set target="${map}" property="cellphone" value="10010"></c:set>
<c:set target="${map}" property="cellphone" value="10086"></c:set>
${map.cellphone }
</br>
<c:out value="${map.cellphone}"></c:out>

<h1>设置或修改域中的属性值</h1>
<hr>

<c:set var="name" value="韦小宝" scope="session"></c:set>
<c:set var="name" value="韦小宝" scope="application"></c:set>
<c:set var="name" value="韦小宝" scope="page"></c:set>
<c:set var="name" value="韦小宝" scope="request"></c:set>
<c:set var="xjlin" value="tt"></c:set>

<%--<c:set var="name" value="阿珂"></c:set>--%>
<c:out value="${name}"></c:out>
<c:out value="${xjlin}"></c:out>
</br>
${name }
</body>
</html>
