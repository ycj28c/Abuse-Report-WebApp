<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="mvc.vo.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	
    <title>My JSP 'functionlist.jsp' starting page</title>
    
   <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/menu.css"/>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	
  </head>
  
  <body>
  <h1>MENU</h1>
  <br>
  		<%
  		ArrayList<Authority> authorityList = (ArrayList<Authority>)(session.getAttribute("authorityList"));
  		if(authorityList.get(0).getPkAuthority()!=null&&!"".equals(authorityList.get(0).getPkAuthority())){ //if user has no authority
  			String roleid = authorityList.get(0).getRoleId();
	  		for(int i = 0;i<authorityList.size();i++){
	  			if(i==0){%>
	  			<h2><%=authorityList.get(i).getRoleId()%></h2>
	  			<ul class = "fontthree">
	  				<li><a href = "<%=authorityList.get(i).getUrl()%>"><%=authorityList.get(i).getName()%></a></li>
	  	<%		}
	  			else if(authorityList.get(i).getRoleId()==roleid||authorityList.get(i).getRoleId().equals(roleid)){%>
	  				<li><a href = "<%=authorityList.get(i).getUrl()%>"><%=authorityList.get(i).getName()%></a></li>
	  	<% 		}
	  			else{%>
	  			</ul>
	  			<h2><%=authorityList.get(i).getRoleId()%></h2>
	  			<ul class = "fontthree">
	  				<li><a href = "<%=authorityList.get(i).getUrl()%>"><%=authorityList.get(i).getName()%></a></li>
	  			<% 	roleid = authorityList.get(i).getRoleId();
	  			}
	  		}
	  	}
	  	else{%>
	  		<ul>
	  <%}%>
  		</ul>
  </body>
</html>
