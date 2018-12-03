<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xjlin.domain.Person"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<h1>获取javabean的属性</h1><hr>
  	<%
  		Person p = new Person();
  		p.setName("芙蓉姐姐");
  		p.setAge(17);

        //${变量} ： el表达式内部隐含调用pageContext.findAttribute("变量")， 即按照作用域从小到大开始找， 找到即止。
  		//要放到域里头去才能被el表达式识别。
  		pageContext.setAttribute("p",p);
  	 %>
  	 ${p.name }${p.age } ${p.name }
  	 <img src="${pageContext.request.contextPath }/1.jpg"/>
  	
  	<h1>获取Map中的数据</h1><hr>
  	<%
  		Map<String,String> map = new HashMap();
  		map.put("name","奥巴马");
  		map.put("age","17");
  		map.put("gender","男");
  		map.put("addr","白宫");
  		map.put("name.xiao","小黑黑");
  		pageContext.setAttribute("map",map);
  		pageContext.setAttribute("name","age");
  	 %>
  	 ${map["name"] }${map["addr"] }
  	 ${map.gender }${map.age }
  	 ${map["name.xiao"] }
  	
  	<h1>获取集合中的数据</h1><hr>
  	<%
  		List<String> list = new ArrayList<String>();
  		list.add("甄嬛");
  		list.add("安玲荣");
  		list.add("凤姐");
  		pageContext.setAttribute("list",list);
  	 %>
  	${list[2] }
  	
  	<h1>获取数组数据</h1><hr>
  	<%
  		String [] names = {"容嬷嬷","紫薇","金锁","小燕子"};
  		pageContext.setAttribute("names",names);
  	 %>
	${names[2]}
  	<h1>获取域中的变量数据</h1><hr>
  	<%
  		String name = "灭绝师太";
  		pageContext.setAttribute("name",name);
  	%>
  	${name }
  	<h1>获取常量数据</h1><hr>
  	${"阿萨德发射点发" } ${199 } ${true }
  </body>
</html>
