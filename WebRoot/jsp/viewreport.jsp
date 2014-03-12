<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*"%>
<%@ page import="mvc.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="<%=basePath%>">

</head>
<body>
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	<% 
	   Report report = (Report)request.getAttribute("report"); 
	   ArrayList<Attach> list = (ArrayList<Attach>)(request.getAttribute("attachlist"));
	%>
	welcome to xxx system <%=session.getAttribute("username")%>. 
    <input type="button" value="logout" onclick="gopath('login.jsp')"/><br>
    ==================================================================<br>
	<form action="jsp/PrintReportServlet?reportid=<%=report.getreportid()%>" method="post">
		<table align = "left" border="1" style="border-collapse: collapse;">
			<tr>
            	<td colspan="2" align = "center">VIEW REPORT</td>
            </tr>
			<tr>
            	<td>name</td>
              	<td><input type="text" name="username" value='<%=report.getName()%>' disabled/></td>
        	</tr>
        	<tr>
            	<td>time</td>
              	<td><input name="time" type="text" id="en_date" value='<%=report.gettime()%>' disabled/></td>
        	</tr>
        	<tr>
            	<td>description</td>
            	<td>
              		<textarea cols="17" rows="6" name="description" disabled><%=report.getdiscript()%></textarea>
              	</td>
        	</tr> 
			<tr>
            	<td>attachment</td>
            	<td>
	            	<div align="center">
						<table id="infoTable" border="0" width="100%" style="border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;margin-top:8px;">
		            	<%for(int i = 0;i<list.size();i++){ 
		             		Attach attach = list.get(i);%> 	
		             		<tr>      	        		
		             			<a>ddd<%=attach.getId()%></a>
		             			<a>aaa<%=attach.getOldName()%></a>
		             			<a>ddcccd<%=attach.getPath()%></a> 
		             		</tr>
		             	<%} %>          	
		            	</table>		            
	            	</div>
            	</td>
        	</tr> 	
        	<tr>
            	<td class="tdstyle" colspan="2">
               		<input type="submit" value="print" />
               		 <input type="button" value="return" onclick="gopath('firstpage.jsp')"/><br>
           		</td>
 			</tr>
		</table>
	</form>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>