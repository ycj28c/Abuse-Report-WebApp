<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="mvc.vo.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<%@ page import="mvc.vo.*"%>
<%@ page import="structure.*"%>
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
                 clickobj[i].checked = !"checked";
             }    
         }
         function InvertClick(){
             var clickobj = document.getElementsByName("num");
             for(var i = 0 ; i<clickobj.length ; i++){
                 clickobj[i].checked = !clickobj[i].checked ;
             }    
         }  
     </script>
</head>

<body>
	<div id="main">
		<form name="form1" action="jsp/MutiDelReportServlet" method="post">
			<table align="left">
				<tr>
					<td><input type="button" value="clickall" name="clickall"
						id="clickall" onclick="ClickAll()"/></td>
					<td><input type="button" value="unclickall" name="unclickall"
						id="unclickall" onclick="UnClickAll()" /></td>
						<td><input type="button" value="invertclick" name="invertclick"
						id="invertclick" onclick="InvertClick()" /></td>
					<td><input type="submit" value="MutiDelete" /></td>
				</tr>
			</table>
			<br><br>
			<table border="1" align="left" style="border-collapse:collapse;">
				<tr align="center">
					<td colspan="8">Report List</td>
				</tr>
				<tr align="center">
					<td></td>
					<td>Reportid</td>
					<td>Description</td>
					<td>Name</td>
					<td>Time</td>
					<td colspan="3">Operation</td>
				</tr>
				<%
					ArrayList<Report> list = (ArrayList<Report>) (request.getAttribute("backinfo"));
					Page pagex = (Page)(request.getAttribute("reportpage"));
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
							<td><a href="jsp/ViewReportServlet?reportid=<%=report.getreportid() %>">View</a></td>
							<td><a href="jsp/DeleteReportServlet?reportid=<%=report.getreportid() %>">Delete</a></td>
							<td><a href="jsp/GoUpdateReportServlet?reportid=<%=report.getreportid() %>">Edit</a></td>
						</tr>
				<% } %>
				<tr align="center">
					 <td colspan="8"> 
					 	<%if(pagex.currentPage>1){ %>
        					<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=pagex.previousPage %>">Previous Page</a> 
        				<%}else{%>
        					<a>Previous Page</a>
        				<%} %>
        				<%if(pagex.getTotalPage()<6) {
        					for(int indexx=1;indexx<=pagex.getTotalPage();indexx++){%>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=indexx%>"><%=indexx %></a>
        				<% }
        				}
        				else{
        					if(pagex.currentPage<3){
								for(int indexx=1;indexx<=3;indexx++){%>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=indexx%>"><%=indexx %></a>
        				<%  	}%>
        						<a>...</a>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=pagex.getTotalPage()%>"><%=pagex.getTotalPage()%></a>
        				<%	}
        					else if(pagex.currentPage==3){
								for(int indexx=1;indexx<=4;indexx++){%>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=indexx%>"><%=indexx %></a>
        				<%  	}%>
        						<a>...</a>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=pagex.getTotalPage()%>"><%=pagex.getTotalPage()%></a>
        				<%	}
        					else if(pagex.currentPage>pagex.getTotalPage()-3){%>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=1">1</a>
        						<a>...</a>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=pagex.getTotalPage()-3%>"><%=pagex.getTotalPage()-3%></a>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=pagex.getTotalPage()-2%>"><%=pagex.getTotalPage()-2%></a>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=pagex.getTotalPage()-1%>"><%=pagex.getTotalPage()-1%></a>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=pagex.getTotalPage()%>"><%=pagex.getTotalPage()%></a>
        				<%	}
        					else{%>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=1">1</a>
        						<a>...</a>
        				<%		for(int indexx=pagex.currentPage-1;indexx<=pagex.currentPage+1;indexx++){%>
        							<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=indexx%>"><%=indexx %></a>
        				<%		}%>
        						<a>...</a>
        						<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=pagex.getTotalPage()%>"><%=pagex.getTotalPage()%></a>
        				<%	}
        				}%>
        				<%if(pagex.nextPage<=pagex.getTotalPage()) {%>
        					<a href="jsp/ReportListServlet?userid=<%=session.getAttribute("userid")%>&pageindex=<%=pagex.nextPage%>">Next Page</a> 
        				<%}else{%>
        					<a>Next Page</a>
        				<%} %>
					 </td>
				</tr>	
				<% } %>
				
			</table>
		</form>
	</div>
</body>
</html>
