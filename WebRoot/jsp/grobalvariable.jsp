<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'grobalvariable.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br>
  <br>
  <br>
  <br>
  <H1 align="center" style="color:blue">Setting the global variable</H1>
  <br>
  <br>
    <form action = "javascript:void(0)" method="post">
    	<table class = "gridtable" border="0" width="500" align="center" style="border-collapse:collapse;">
    		<tr>
    			<td>
    				Report List :
    			</td>
    			<td>
    				<input type="text" style="width:60px" value="90">Day
    			</td>
    		</tr>
    		<tr>
    			<td>
    				List Display Number :
    			</td>
    			<td>
    				<input type="text" style="width:60px" value="17">Line
    			</td>
    		</tr>
    		<tr>
    			<td>
    				Purge Documents :
    			</td>
    			<td>
    				<input type="text" style="width:60px" value="365">Day
    			</td>
    		</tr>
    		<tr>
    			<td>
    				Appeals Deadline Remind :
    			</td>
    			<td>
    				<input type="text" style="width:60px" value="30">Day
    			</td>
    		</tr>
    		<tr>
    			<td>
    				Max Attachment Size :
    			</td>
    			<td>
    				<input type="text" style="width:60px" value="10">MB
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2" align = "center">
    				<br>
    				<br>
    				<input class="myButtontwo" type="submit" value="submit">
    				<input class="myButtontwo" type="reset" value="reset">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
