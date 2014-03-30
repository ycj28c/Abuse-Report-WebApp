<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newinvestigation.jsp' starting page</title>
    
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
  	<form action="LoginServlet" method="post">
    	<table align = "left" border="1" style="border-collapse: collapse;">
    		<tr>
    			<td colspan="3" align = "left">
    				Input ReportID:<input type="text" value="input report id">
    				<input type="button" value="Link Report">
    			</td>	
    		</tr>
    		<tr>
    			<td colspan="3" align = "center">Report Detail</td> 
    		</tr>
    		<tr>
    			<td colspan="3" align = "left">
    				ReportID:<input type="text" name="reportid">
    				Date:<input type="text" name="date">
    				Status:<input type="text" name="status">
    			</td> 
    		</tr>
    		<tr>
    			<td colspan="3" align = "center">DISPOSITION LETTER</td> 
    		</tr>
    		<tr>
    			<td>
    				Description :			
    			</td> 	
    			<td colspan="2" align = "left">
    				<textarea style="width:100%;" name="disdescription">input description</textarea>			
    			</td> 
			</tr>
			<tr>
				<td>
					Attachment :
				</td> 
				<td colspan="2" align = "left">
					<input type="text" name="disattachment">
					<input type="button" value="choose file">
				</td>	
			</tr>
			<tr>
    			<td colspan="3" align = "center">AGENCY RESPONDS</td> 
    		</tr>
			<tr>
    			<td>
    				Respond :			
    			</td> 	
    			<td colspan="2" align = "left">
    				<textarea style="width:100%;" name="respond">input respond</textarea>			
    			</td> 
			</tr>
    		<tr>
    			<td colspan="3" align = "center">DECISION LETTER</td> 
    		</tr>
    		<tr>
    			<td>
    				Description :			
    			</td> 	
    			<td colspan="2" align = "left">
    				<textarea style="width:100%;" name="desdescription">input description</textarea>			
    			</td>  	
			</tr>
			<tr>
				<td>
					Attachment :
				</td> 
				<td colspan="2" align = "left">
					<input type="text" name="desattachment">
					<input type="button" value="choose file">
				</td>
			</tr>
			<tr>
				<td colspan="3" align = "right">
					<input type="submit" value="submit">
					<input type="reset" value="reset">
					<input type="button" value="return">
				</td>
			</tr>
    	</table>
    </form>
  </body>
</html>
