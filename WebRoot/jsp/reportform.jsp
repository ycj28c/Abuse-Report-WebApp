<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reportform.jsp' starting page</title>
    
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
<table align = "left" border="1" style="border-collapse: collapse;">
			<tr>
            	<td colspan="5" align = "center">NEW REPORT</td>
            	<td class="tdstyle" colspan="1">
               		<input type="submit" value="submit" />
               		<input type="reset" value="reset" />
               		<input type="button" value="return" onclick="gopath('firstpage.jsp')"/><br>
           		</td>
            </tr>
			<tr>
            	<td>Alleged Abuser:</td>    
            	<td><input type ="text"></td> 
            	<td>Alleged Victim:</td>
        		<td><input type ="text"></td>
        		<td>Date of last incident:</td>
            	<script type="text/javascript" src="javascript/calendar.js"></script>
              	<td><input name="time" type="text" id="en_date" onclick="new Calendar(null, null, 1).show(this);" size="10" maxlength="10" readonly="readonly" /></td>
        	</tr>
        	<tr>     		 
            	<td>Types of Abuse:</td>
            	<td><input type ="text"></td> 
        		<td>Frequency of Abuse:</td>
        		<td><input type ="text"></td> 
        		<td>Is victim aware of report?</td>
        		<td><input type ="text"></td>
        	</tr>
        	<tr>
            	<tr>
            		<td colspan="6">In narrative form, please describe the alleged abuse:</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea cols="110" rows="6" name="description" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
              		</td>
              	</tr>
        	</tr>  
        	<tr>
            	<tr>
            		<td colspan="6">Please describe the level of risk to the alleged victim, including his/her currentphysical and emotional state:</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea cols="110" rows="6" name="description" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
              		</td>
              	</tr>
        	</tr> 
        	<tr>
            	<tr>
            		<td colspan="6">Please list any resulting injuries:</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea cols="110" rows="6" name="description" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
              		</td>
              	</tr>
        	</tr> 
        	<tr>
            	<tr>
            		<td colspan="6">Please list witnesses, if any, including daytime phone numbers:</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea cols="110" rows="6" name="description" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
              		</td>
              	</tr>
        	</tr> 
        	<tr>
            	<tr>
            		<td colspan="6">Please describe caregiver relationship between the alleged abuser and the alleged victim.<br>
					(What assistance, if any, does the alleged abuser provide to the person with the disability?)</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea cols="110" rows="6" name="description" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
              		</td>
              	</tr>
        	</tr> 
        	<tr>
            	<td>attachment</td>
            	<td colspan="4">
              		<span id="spanButtonPlaceholder"></span>
		  			<div id="divFileProgressContainer" style="width:450;display:none;"></div>
					<div id="thumbnails">
						<table id="infoTable" border="0" width="100%" style="border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;margin-top:8px;">
						</table>
					</div>         		
              	</td>   	
	            <td class="tdstyle" colspan="1">
	               	<input type="submit" value="submit" />
	               	<input type="reset" value="reset" />
	               	<input type="button" value="return" onclick="gopath('firstpage.jsp')"/><br>
	           	</td>
        	</tr>  	
        	
		</table>    


  </body>
</html>
