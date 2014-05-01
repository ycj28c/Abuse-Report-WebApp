<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%
	session.invalidate();
%>
<html>
<head>
<title>login page</title>
<link href="/css/layout.css" rel="stylesheet" type="text/css">
<script type="text/javaScript">
	function validate(f) {
		if (!(/^\w{5,15}$/.test(f.userid.value))) {
			alert("User id must between 5 to 15！");
			f.userid.focus();
			return false;
		}
		if (!(/^\w{5,15}$/.test(f.userpass.value))) {
			alert("Password must between 5 to 15！");
			f.userid.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	
	<div class="container">
		<h2 align="center">
			<a title="This is reporting system login page">Reporting system</a>
		</h2>
		<%
			List<String> info = (List<String>) request.getAttribute("info");
			if (info != null) {
				Iterator<String> iter = info.iterator();
				while (iter.hasNext()) {
		%>
		<h4><%=iter.next()%></h4>
		<%
			}
			}
		%>

		<form action="LoginServlet" method="post"
			onsubmit="return validate(this)">
			<div align="center">
				<a title="User Name">User ID: </a><input type="text" name="userid"
					placeholder="Please input userid"><br> <a
					title="Password">Password: </a> <input type="password"
					name="userpass" placeholder="Please input password"><br>
			</div>
			<div align="center">
				<input type="submit" value="login"> <input type="reset"
					value="reset">
			</div>
			<div align="center">
		<img border="0" src="/image/healthcare-icon.jpg" alt="Pulpit rock" width="256"
			height="128" placeholder="Background Image">
	</div>
		</form>
	</div>
</body>
</html>