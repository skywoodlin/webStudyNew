<%--
  Created by IntelliJ IDEA.
  User: xiaojie.lin
  Date: 2018/11/7
  Time: 20:18
  To change this template use File | Settings | File Templates.

  out写到了out缓冲区，
  response.getWriter()获取的是PrintWriter进入response缓冲区里

  页面结束或者缓冲区满的时候， out缓冲区里的数据会刷到response缓冲区里， 这样， 你response缓冲区
  虽然是在out.write后面写进去的， 但是最终页面上还是会放在out前面，

  如果两者要混用， 调用的时候一定要out.flush()后再用PrintWriter
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tit1le</title>
</head>
<body>
<%
    out.write("out对象输出(JspWriter)");
//    out.flush();//一定要混用的话， 要flush
    response.getWriter().print("PrintWriter对象输出(response.getWriter().print())");
%>
</body>
</html>
