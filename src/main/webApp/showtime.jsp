<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <%int num = 0; %>
  	<font color="red">
	  	<%
	  		Date date = new Date();
	  		String dateStr = date.toLocaleString();
			out.write(dateStr);
	  	 %>
	  	 <%= new Date().toLocaleString() %>
  	 </font>
  	<%
  		for(int i=0;i<5;i++){
  			num++;
  	%>
  			<font color="blue">
  		<%
  			out.write(num+"");
		%>
			</font>
	<%
  		} 
  	%> 
  	
  </body>
</html>
