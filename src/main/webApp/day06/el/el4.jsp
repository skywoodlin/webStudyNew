<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib uri="http://www.xjlin.com/MyELFunc" prefix="mf1" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  		${mf1:URLEnc("北京","utf-8") }
  		${fn:toUpperCase("asdfasdfKJKJKJdsagHIHidsfgGUGu") }
  </body>
</html>
