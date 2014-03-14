<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>New Patient</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	<script type="text/javascript" src="javascript/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="javascript/jquery.validate.js"></script>
	
	<script type="text/javascript">
	$().ready(function() {
		// validate signup form on keyup and submit
		$("#newpatientform").validate({
			rules: {
				name: {
					required: true,
					minlength: 2
				},
				address: {
					required: true,
					minlength: 5
				},
				sex: "required",
				servby:"required",
				disability: "required"
			},
			messages: {
				name: {
					required: "Please enter a username",
					minlength: "Your username must consist of at least 2 characters"
				},
				address: {
					required: "Please provide a address",
					minlength: "Your address must be at least 5 characters long"
				},
				sex: "Please choose a sex",
				servby:"Please choose a service",
				disability: "Please choose at least one disability"
			}
		});
	
		//when the select change to value "Other(Specify)",make the text avaliable
		$("#servby").change(function(){
			var op = $("#servby").val();
			if(op=="Other(Specify)"){
				$("#servbyothertext").attr("disabled",false);
			}	
			else{
				$("#servbyothertext").attr("disabled",true);
				$("#servbyothertext").val("");
			}
		})
			
	});
	
	</script>
	
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/select_autocomplete.css"/>
	<!--define all the error style-->
	<style type="text/css">
		#newpatientform label.error {
			width: auto;
			color: red;
			display: inline;
		}
	</style>
  </head>
  
  <body>
    <form action="jsp/NewPatientServlet" method="post" name="newpatientform" id="newpatientform">
		<table align = "left" border="1" name ="newpatienttable" style="border-collapse: collapse;">
			<tr>
            	<td colspan="6" align = "center">NEW PATIENT</td>
            </tr>
			<tr>
            	<td>Name:</td>    
            	<td><input type ="text" id ="name" name = "name" style="width:100%" /></td> 
            	<td>Address:</td>
        		<td colspan="3"><input type="text" name="address" style="width:100%" /></td>
        	</tr>
        	<tr>     	
        		<td>Age:</td>
        		<td><input type ="text" name="age" style="width:100%"></td>
        		<td>Sex:</td>
            	<td>
	            	<label><input name="sex" type="radio" value="Male" />Male</label> 
					<label><input name="sex" type="radio" value="Female" />Female</label>
					<br>
					<label for="sex" class="error"></label>
				</td> 
        	    <td>Telephone:</td>
            	<td><input type ="text" name ="telephone" style="width:100%"></td>	 
        	</tr>
        	<tr>
        		<td>DOB:</td>
        		<td><input type ="text" name="dob" style="width:100%"></td>
        		<td>Marital status</td> 		
        		<td><input type ="text" name="marstat" style="width:100%"></td> 
            	
            	<td>Communication Needs:</td> 
            	<td><input type ="text" name ="commneed" style="width:100%"></td> 	
            	
        	</tr>
        	<tr>
        		<td>Currently Served By:</td> 
        		<td>
        			<select name="servby" id="servby">
        			  <option></option>
					  <option value ="Dept. of Mental Health">Dept. of Mental Health</option>
					  <option value ="Dept. of Developmental Svcs.">Dept. of Developmental Svcs.</option>
					  <option value ="Mass. Rehab. Comm.">Mass. Rehab. Comm.</option>
					  <option value ="Dept. of Correction">Dept. of Correction</option>
					  <option value ="Dept. of Public Health">Dept. of Public Health</option>
					  <option value ="Mass Comm./Blind">Mass Comm./Blind</option>
					  <option value ="Mass. Comm./Deaf/HH">Mass. Comm./Deaf/HH</option>
					  <option value ="Unknown">Unknown</option>
					  <option value ="Other(Specify)">Other(Specify)</option>
					  <option value ="None">None</option>
					</select>
        			<input type ="text" name="servbyothertext" id="servbyothertext" disabled/>
        			<br>
					<label for="servby" class="error"></label>
        		</td> 
        		<td>Type of Service:</td> 
        		<td><input type ="text" name="servtype" style="width:100%"></td> 
				<td>Client's Ethnicity:</td> 
        		<td><input type ="text" name="ethnicity" style="width:100%"></td> 
        	</tr>
        	<tr>
        		<td>Disability:</td>	
            	<td colspan="2" >
            		<table style="width:100%">
            		<tr>
            			<td><input type="checkbox" name="disability" value="Mobility">Mobility</td>  
            			<td><input type="checkbox" name="disability" value="Mental Retardation">Mental Retardation</td>
				   		<td><input type="checkbox" name="disability" value="Multiple Sclerosis">Multiple Sclerosis 
				   		 
				   	</tr>
				   	<tr>
					   	<td><input type="checkbox" name="disability" value="Seizures">Seizures</td> 
				   		<td><input type="checkbox" name="disability" value="Cerebral Palsy">Cerebral Palsy</td>   	   	
				   		<td><input type="checkbox" name="disability" value="Mental Illness">Mental Illness</td>
				   	</tr>
				   	<tr>  
				   		<td><input type="checkbox" name="disability" value="Visual">Visual</td>			   		 
				   		<td><input type="checkbox" name="disability" value="Head Injury">Head Injury  	   		 
				   		<td><input type="checkbox" name="disability" value="Deaf / Hard of Hearing">Deaf / Hard of Hearing	
				   	</tr>
				   	<tr>
				   		<td><input type="checkbox" name="disability" value="other">other</td>
				   		<td><input type ="text" name="disabilityothertext" colspan="2"></td>	
				   	</tr>
				   	<tr>
				   		<td colspan="2"><label for="disability" class="error"></label></td>
				   	</tr>
				   	</table>
				</td> 
				<td colspan="3">
					<table style="width:100%">
	            		<tr>
	            			<td>Collateral contacts or notifications:(Please list, including telephone numbers.)</td>	   		 
					   	</tr>
					   	<tr>
						   <td><textarea style="width:100%" rows="4" name="collcontact" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea></td>
					   	</tr> 
				   	</table>          		
            	</td>	
        	</tr>
        	<tr>
            	<td class="tdstyle" colspan="6" align = "center">
               		<input type="submit" value="submit"/>
               		<input type="reset" value="reset" />
               		<input type="button" value="return" onclick="gopath('firstpage.jsp')"/>             	
           		</td>	
        	</tr>  	      	
		</table>
	</form>
  </body>
</html>
