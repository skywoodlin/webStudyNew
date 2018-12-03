<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
<%
    String[] city = {"a", "b", "c", "d", "e"};
    pageContext.setAttribute("city", city);

    List list = new ArrayList();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
    pageContext.setAttribute("list", list);

    Map map = new HashMap();
    map.put("name1", "mapvalue1");
    map.put("name2", "mapvalue2");
    map.put("name3", "mapvalue3");
    map.put("name4", "mapvalue4");
    pageContext.setAttribute("map", map);
%>
数组<br>
<c:forEach items="${city}" var="c">
    ${c}<br>
</c:forEach>

List:<br>
<c:forEach items="${list}" var="l">
    ${l}<br>
</c:forEach>

Map:<br>
<c:forEach items="${map}" var="m">
    ${m.key}:${m.value}<br>
</c:forEach>

指定循环若干次<br>
<c:forEach begin="1" end="10" step="3" var="i">
    ${i},
</c:forEach>
<br>

遍历从10到100的偶数， 如果数字所在的位置是3的倍数， 显示成红色
<c:forEach begin="10" end="100" step="2" var="i" varStatus="stat">
    <c:if test="${stat.count %3 == 0}">
        <font color="red">
            ${i }
        </font>
    </c:if>
    <c:if test="${stat.count %3 != 0}">
        ${i }
    </c:if>
</c:forEach>

</body>
</html>
