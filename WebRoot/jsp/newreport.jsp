<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="<%=basePath%>">

</head>
<body>
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	welcome to xxx system <%=session.getAttribute("username")%>. 
    <input type="button" value="logout" onclick="gopath('login.jsp')"/><br>
    ==================================================================<br>
	<form action="jsp/NewReportServlet?userid=<%=session.getAttribute("userid")%>" method="post">
		<table align = "left" border="1" style="border-collapse: collapse;">
			<tr>
            	<td colspan="2" align = "center">NEW REPORT</td>
            </tr>
			<tr>
            	<td>name</td>
              	<td><input type="text" name="username" /></td>
        	</tr>
        	<tr>
            	<td>time</td>
            	<script type="text/javascript" src="javascript/calendar.js"></script>
              	<td><input name="time" type="text" id="en_date" onclick="new Calendar(null, null, 1).show(this);" size="10" maxlength="10" readonly="readonly" /></td>
        	</tr>
        	<tr>
            	<td>description</td>
            	<td>
              		<textarea cols="17" rows="6" name="description"></textarea>
              	</td>
        	</tr>  	
        	<tr>
            	<td class="tdstyle" colspan="2">
               		<input type="submit" value="submit" />
               		<input type="reset" value="reset" />
               		 <input type="button" value="return" onclick="gopath('firstpage.jsp')"/><br>
           		</td>
 			</tr>
		</table>
	</form>
	<br><br><br><br><br><br><br><br><br><br>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<%
		String info = (String)request.getAttribute("info");//取得属性 
		if (info != null) { //判断是否有内容 
	%>
	<h4><%=info%></h4>
	<%
		}
	%>
</body>
</html>