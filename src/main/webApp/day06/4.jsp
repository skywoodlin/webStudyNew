<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	from 4.jsp....
    转发时候带请求参数
  	<%--
  		//request.getRequestDispatcher("/index.jsp").include(request,response); 
  		//pageContext.include("/index.jsp");
  		//pageContext.forward("/index.jsp");	
  		<jsp:include page="/index.jsp"></jsp:include>
  	--%>
  	<jsp:forward page="/index.jsp">
  		<jsp:param value="piaopiao" name="name"/>
  	</jsp:forward>
		
  </body>
</html>
