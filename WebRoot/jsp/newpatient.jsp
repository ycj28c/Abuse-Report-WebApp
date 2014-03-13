<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newpatient.jsp' starting page</title>
    
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
    <form action="jsp/NewPatientServlet" method="post">
		<table align = "left" border="1" style="border-collapse: collapse;">
			<tr>
            	<td colspan="6" align = "center">NEW PATIENT</td>
            </tr>
			<tr>
            	<td>Name:</td>    
            	<td><input type ="text" style="width:100%"></td> 
            	<td>Address:</td>
        		<td colspan="3"><input type ="text" style="width:100%"></td>
        	</tr>
        	<tr>     	
        		<td>Age:</td>
        		<td><input type ="text" style="width:100%"></td>
        		<td>Sex:</td>
            	<td>
					<label><input name="Fruit" type="radio" value="" />Male</label> 
					<label><input name="Fruit" type="radio" value="" />Female</label>
				</td> 
        	    <td>Telephone:</td>
            	<td><input type ="text" style="width:100%"></td>	 
        	</tr>
        	<tr>
        		<td>DOB:</td>
        		<td><input type ="text" style="width:100%"></td>
        		<td>Marital status</td> 		
        		<td><input type ="text" style="width:100%"></td> 
            	
            	<td>Communication Needs:</td> 
            	<td><input type ="text" style="width:100%"></td> 	
            	
        	</tr>
        	<tr>
        		<td>Currently Served By:</td> 
        		<td><input type ="text" style="width:100%"></td> 
        		<td>Type of Service:</td> 
        		<td><input type ="text" style="width:100%"></td> 
				<td>Client's Ethnicity:</td> 
        		<td><input type ="text" style="width:100%"></td> 
        	</tr>
        	<tr>
        		<td>Disability:</td>	
            	<td colspan="2" >
            		<table style="width:100%">
            		<tr>
            			<td><input type="checkbox" name="director[]" value="Mobility">Mobility</td>  
            			<td><input type="checkbox" name="director[]" value="Mental Retardation">Mental Retardation</td>
				   		<td><input type="checkbox" name="director[]" value="Multiple Sclerosis">Multiple Sclerosis 
				   		 
				   	</tr>
				   	<tr>
					   	<td><input type="checkbox" name="director[]" value="Seizures">Seizures</td> 
				   		<td><input type="checkbox" name="director[]" value="Cerebral Palsy">Cerebral Palsy</td>   	   	
				   		<td><input type="checkbox" name="director[]" value="Mental Illness">Mental Illness</td>
				   	</tr>
				   	<tr>  
				   		<td><input type="checkbox" name="director[]" value="Visual">Visual</td>			   		 
				   		<td><input type="checkbox" name="director[]" value="Head Injury">Head Injury  	   		 
				   		<td><input type="checkbox" name="director[]" value="Deaf / Hard of Hearing">Deaf / Hard of Hearing	
				   	</tr>
				   	<tr>
				   		<td><input type="checkbox" name="director[]" value="other">other</td>
				   		<td><input type ="text" colspan="2"></td>
				   	</tr>
				   	</table>
				</td> 
				<td colspan="3">
					<table style="width:100%">
	            		<tr>
	            			<td>Collateral contacts or notifications:(Please list, including telephone numbers.)</td>	   		 
					   	</tr>
					   	<tr>
						   <td><textarea style="width:100%" rows="4" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea></td>
					   	</tr> 
				   	</table>          		
            	</td>	
        	</tr>
        	<tr>
            	<td class="tdstyle" colspan="6" align = "center">
               		<input type="submit" value="submit" />
               		<input type="reset" value="reset" />
               		<input type="button" value="return" onclick="gopath('firstpage.jsp')"/>             	
           		</td>	
        	</tr>  	      	
		</table>
	</form>
  </body>
</html>
