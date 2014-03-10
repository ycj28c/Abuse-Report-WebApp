<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="mvc.vo.*"%>
<%@ page import="structure.*"%>
<% 
if(session.getAttribute("userid")==null){
	session.setAttribute("userid", request.getAttribute("userid"));
	session.setAttribute("username", request.getAttribute("username"));
}
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'firstpage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	
  </head>
  
  <body>
    welcome to xxx system <%=session.getAttribute("username")%>. 
    <input type="button" value="logout" onclick="gopath('login.jsp')"/><br>
    ==================================================================<br>
    <form action="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=1" method="post" >
   		<input type="submit" value="reportlist"/>
   		<input type="button" value="newreport" onclick="gopath('newreport.jsp')"/>
	</form>	
	==================================================================<br>
	<jsp:include  page="report.jsp"/>
  </body>
</html>
