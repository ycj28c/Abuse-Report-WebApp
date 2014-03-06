<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="mvc.vo.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'report.jsp' starting page</title>

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
     </script>
</head>

<body>
	<div id="main">
		<form name="form1" action="" method="post">
			<table border="1" align="center" style="border-collapse:collapse;">
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
					for (int i = 0; i < list.size(); i++) {
						Report report = list.get(i);
				%>
				<tr align="center">
					<td><input type="checkbox" value='<%=report.getreportid()%>'
						name="num" /></td>
					<td><%=report.getreportid()%></td>
					<td><%=report.getdiscript()%></td>
					<td><%=report.getName()%></td>
					<td><%=report.gettime()%></td>
					<td><a>delete</a></td>
					<td><a>modify</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<table align="center">
				<tr>
					<td><input type="button" value="clickall" name="clickall"
						id="clickall" onclick="ClickAll()"/></td>
					<td><input type="button" value="unclickall" name="unclickall"
						id="unclickall" onclick="UnClickAll()" /></td>
					<td><input type="submit" value="deleteall" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
