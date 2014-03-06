<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%session.invalidate();%>
<html>
<head>
<title>login page</title>
<script type ="text/javaScript">
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
	<h2>Log in demonstration</h2>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<%
		List<String> info = (List<String>) request.getAttribute("info");//取得属性 
		if (info != null) { //判断是否有内容 
			Iterator<String> iter = info.iterator();//  实例化Iterator 
			while (iter.hasNext()) {
	%>
	<h4><%=iter.next()%></h4>
	<%
		}
		}
	%>
	<form action="LoginServlet" method="post" onsubmit="return validate(this)">
		UserID：<input type="text" name="userid"><br> 
		Password： <input type="password" name="userpass"><br> <input type="submit" value="login"> <input type="reset" value="reset">
	</form>
</body>
</html>