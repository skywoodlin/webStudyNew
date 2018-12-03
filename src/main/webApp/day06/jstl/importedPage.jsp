<%--
注意， 被include的页面，
1. 除了第一行
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>不会被引入进来， 其它的都会原样copy过来。

2. 如果不写上面那个第一行， 会乱码
--%>

<%@ page language="java" pageEncoding="utf-8"%>
<p>这是一段引入的页面</p>