<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
<%--
    就是用来分割字符串
--%>
<c:forTokens items="www.xjlin.com" delims="." var="str">
    ${str}<br>
</c:forTokens>


</body>
</html>
