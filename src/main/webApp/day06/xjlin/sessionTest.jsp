<%--
  Created by IntelliJ IDEA.
  User: xiaojie.lin
  Date: 2018/11/7
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" pageEncoding="utf-8" %>
<%
    String realContextPath = request.getServletContext().getRealPath("");
    String contextPath = request.getContextPath() == "" ? "空" : request.getContextPath();
    String servletPath = request.getServletPath() == "" ? "空" : request.getServletPath();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=request.getSession().getId() %>
    <%--<%=session %> &lt;%&ndash;虽然不能直接用， 但是可以通过request。getSession()来获得session&ndash;%&gt;--%>
<br/>
</body>
</html>
