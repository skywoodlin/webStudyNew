<%--
  Created by IntelliJ IDEA.
  User: xiaojie.lin
  Date: 2018/11/7
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String realContextPath = request.getServletContext().getRealPath("");
    String contextPath = request.getContextPath() == "" ? "空" : request.getContextPath();
    String servletPath = request.getServletPath() == "" ? "空" : request.getServletPath();
%>
<html>
<head>
    <title>list</title>
</head>
<body>
request.getServletContext().getRealPath("") = <%=realContextPath%>
<br/>
request.getContextPath() = <%=contextPath%>
<br/>
request.getServletPath() = <%=servletPath%>
<br/>

<a href=problems/jspPageHasSessionByDefault.jsp>jsp页面默认就有session</a><br/>
<a href=1.jsp>1.jsp</a><br/>
<a href=2.jsp>2.jsp</a><br/>
<a href=3.jsp>3.jsp</a><br/>
<a href=4.jsp>4.jsp</a><br/>
<a href=el/el1.jsp>用el从各种数据结构，从域中取值</a><br/>
<a href=el/el2.jsp>el表达式用来执行运算</a><br/>
<a href=el/el3.jsp?name=abc&name=bdc&like=2>el隐藏的11个内置对象</a><br/>
<a href=el/el4.jsp>el4.jsp</a><br/>
<a href=5.jsp>jsp标签 include</a><br/>
<a href=xjlin/sessionTest.jsp>session禁用测试</a><br/>
<a href=xjlin/outAndGetWriter.jsp>out输出和response.getWriter()输出的不同</a><br/>
<a href=jstl/cout.jsp>jstl: c:out</a><br/>
<a href=jstl/cset.jsp>jstl: c:set</a><br/>
<a href=jstl/cremove.jsp>jstl: c:remove</a><br/>
<a href=jstl/cchoose.jsp>jstl: c:choose</a><br/>
<a href=jstl/cforeach.jsp>jstl: c:foreach循环取值用的</a><br/>
<a href=jstl/cforTokens.jsp>jstl: c:forTokens: 分割字符串用的</a><br/>
<a href=jstl/cimport.jsp>jstl: c:import: 包含页面用的</a><br/>
<a href=jstl/cRedirect.jsp>jstl: c:redirect: 请求转发</a><br/>
</body>
</html>
