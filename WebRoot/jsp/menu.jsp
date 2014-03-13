<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	
    <title>My JSP 'functionlist.jsp' starting page</title>
    
   <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/menu.css"/>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	
  </head>
  
  <body>
	<h2>Menu</h2>
	<ul class = "fontthree">
		<li><a href = "jsp/ReportListServlet?pageindex=1">All List</a></li>
		<li><a href = "jsp/PrepareNewReport">New report</a></li>
		<li><a href = "javascript:void(0)" >Waiting List</a></li>
		<li><a href = "javascript:void(0)" >Finish List</a></li>
	</ul>
	<h2>Manager</h2>
	<ul class = "fontthree">
		<li><a href = "jsp/newpatient.jsp">New patient</a></li>
	</ul>
  </body>
</html>
