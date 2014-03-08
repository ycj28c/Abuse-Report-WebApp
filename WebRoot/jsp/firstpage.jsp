<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="mvc.vo.*"%>
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
<script type="text/javascript">       
         function ClickAll(){
             var clickobj = document.getElementsByName("num");
             for(var i = 0 ; i<clickobj.length ; i++){
                 clickobj[i].checked = "checked";
             }           
         }
         function UnClickAll(){
             var clickobj = document.getElementsByName("num");
             for(var i = 0 ; i<clickobj.length ; i++){
                 clickobj[i].checked = !clickobj[i].checked ;
             }    
         }
         function PrintReport(){
             var clickobj = document.getElementsByName("num");
             for(var i = 0 ; i<clickobj.length ; i++){
                 clickobj[i].checked = !clickobj[i].checked ;
             }    
         }
     </script>
  </head>
  
  <body>
    welcome to xxx system <%=session.getAttribute("username")%>. 
    <input type="button" value="logout" onclick="location='login.jsp'"/><br>
    ==================================================================<br>
    <form action="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>" method="post" >
   		<input type="submit" value="reportlist"/>
   		<input type="button" value="newreport" onclick="location='newreport.jsp'"/>
	</form>	
	==================================================================<br>
	<div id="main">
		<form name="form1" action="jsp/MutiDelReportServlet" method="post">
			<table align="left">
				<tr>
					<td><input type="button" value="clickall" name="clickall"
						id="clickall" onclick="ClickAll()"/></td>
					<td><input type="button" value="unclickall" name="unclickall"
						id="unclickall" onclick="UnClickAll()" /></td>
					<td><input type="submit" value="MutiDelete" /></td>
				</tr>
			</table>
			<br><br>
			<table border="1" align="left" style="border-collapse:collapse;">
				<tr align="center">
					<td colspan="7">Report List</td>
				</tr>
				<tr align="center">
					<td></td>
					<td>Reportid</td>
					<td>Description</td>
					<td>Name</td>
					<td>Time</td>
					<td colspan="2">Operation</td>
				</tr>
				<%
					ArrayList<Report> list = (ArrayList<Report>) (request
							.getAttribute("backinfo"));
				%>
				<%
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						Report report = list.get(i);
				%>
				<tr align="center">
					<td><input type="checkbox" value='<%=report.getreportid()%>' name="num" /></td>
					<td><a href="jsp/ViewReportServlet?reportid=<%=report.getreportid() %>"><%=report.getreportid()%></a></td>
					<td><%=report.getdiscript()%></td>
					<td><%=report.getName()%></td>
					<td><%=report.gettime()%></td>
					<td><a href="jsp/DeleteReportServlet?reportid=<%=report.getreportid() %>">delete</a></td>
					<td><a href="jsp/GoUpdateReportServlet?reportid=<%=report.getreportid() %>">modify</a></td>
				</tr>
				<%
					}
				}
				%>
			</table>
		</form>
	</div>
  </body>
</html>
