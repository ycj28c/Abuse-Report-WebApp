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
    
    <style type="text/css">
		div#container{width:1024px}
		div#header {background-color:#99bbbb;height:68px;}
		div#menu {background-color:#ffff99;height:700px;width:150px;float:left;}
		div#content {background-color:#EEEEEE;height:700px;width:874px;float:left;}
		div#footer {background-color:#99bbbb;clear:both;text-align:center;}
		h1 {margin-bottom:0;}
		h2 {margin-bottom:0;font-size:18px;}
		ul {margin:0;}
		li {list-style:none;}
	</style>
    
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
	<div id="container">	
		<div id="header">
			<h1>DESIGN OF SOFTWARE SYSTEM</h1>
			<jsp:include  page="/jsp/welcome.jsp"/>
		</div>
		<div id="menu" >
			<jsp:include  page="/jsp/menu.jsp"/>
		</div>		
		<div id="content">
		===========================================================================================
			<jsp:include  page="/jsp/report.jsp"/>
		</div>
		<div id="footer">Welcome to xxx system. CS509-Team2</div>
	</div>
  </body> 
</html>
