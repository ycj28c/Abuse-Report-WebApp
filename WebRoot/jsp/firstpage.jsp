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
	session.setAttribute("groupid", request.getAttribute("groupid"));
	session.setAttribute("authorityList", request.getAttribute("authorityList"));
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Abuse Report System</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/firstpage.css"/>
	
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
  </head>
  
  <body>
    <div id="container">	
		<div id="header">
			<h1 class="fontone">DESIGN OF SOFTWARE SYSTEM</h1>
			<br>
			<jsp:include  page="/jsp/welcome.jsp"/>
		</div>
		<div id="menu" >
			<jsp:include  page="/jsp/menu.jsp"/>
		</div>	
		<div id="content">	
		<% 
			String contentPage = (String)request.getAttribute("contentPage");
			if(contentPage==null||"".equals(contentPage)){%>
				<jsp:include  page="/jsp/report.jsp"/>
		<% 	}
			else{%>
				<jsp:include  page="<%=contentPage%>"/>
		<%	}%>
		</div>
		<div id="footer">Welcome to xxx system. CS509-Team2<%@ include file="/fullcalendar/demos/default.html" %></div>
	</div>
  </body>
</html>
