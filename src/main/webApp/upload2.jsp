<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function addOne(){
  			var fdiv = document.getElementById("fdiv");
  			fdiv.innerHTML += '<div><input type="file" name="file1" /><input type="button" value="不要了.." onclick="delOne(this)"/><br><div>';
  		}
  		
  		function delOne(obj){
  			obj.parentNode.parentNode.removeChild(obj.parentNode);
  		}
  	</script>
  </head>
  <body>
  	<h1>文件上传</h1><hr>
  	<input type="button" id="addBut" onclick="addOne()" value="加一个..."/>
  	<form action="${pageContext.request.contextPath }/servlet/UploadServlet" method="POST" enctype="multipart/form-data">
  		<div id="fdiv"></div>
  		<input type="submit" value="上传"/>
  	</form>
  </body>
</html>
