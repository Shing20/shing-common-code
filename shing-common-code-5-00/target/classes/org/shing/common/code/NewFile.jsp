<%-- 2.指令 --%>
<%@ page language="java" import="java.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- 1.静态内容 是html文本 -->


<!-- html注释 ，页面可见-->
<%--JSP注释，页面不可见 --%>

<%// JSP脚本中使用单行注释%>
<%
	/*JSP脚本中使用单行注释*/
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 3.小脚本 -->
	<%
		System.out.print("hello,Shing!");
	%>


	<!-- 4.表达式 -->
	<%
		int userId = 12;
	%>
	<%=userId%>

	%>

	<%// 5.声明%>
	<%!String userName = "Shing";%>
	<%=userName%>
</body>
</html>