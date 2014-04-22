<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*"%>
<%@ page import="mvc.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<base href="<%=basePath%>">

</head>
<body>
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	<% 
	   Report report = (Report)request.getAttribute("report"); 
	   ArrayList<Attach> list = (ArrayList<Attach>)(request.getAttribute("attachlist"));
	%>
	welcome to xxx system <%=session.getAttribute("username")%>. 
    <input type="button" value="logout" onclick="gopath('login.jsp')"/>
    <input type="button" value="return" onclick="gopath('firstpage.jsp')"/><br>
    ==================================================================<br>
	<form action="jsp/PrintReportServlet?reportid=<%=report.getReportid()%>" method="post">
		<table align = "left" border="1" style="border-collapse: collapse;">
			<tr>
            	<td colspan="5" align = "center">VIEW REPORT</td>
            	<td class="tdstyle" align ="right" colspan="1">
               		<!--  input type="submit" value="print" /-->
               		<input type="button" value="return" onclick="gopath('firstpage.jsp')"/><br>
           		</td>
            </tr>
			<tr>
            	<td>Alleged Abuser:</td>    
            	<td colspan="2"><input type ="text" name = "allegedabuser" value="<%=report.getAbusername()%>" style="width:100%" disabled></td> 
            	<td>Date of last incident:</td>
              	<td colspan="2"><input name="time" type="text" id="en_date" value="<%=report.getTime()%>" size="10" maxlength="10" disabled/>
	        		<br>
	        		<label for="time" class="error"></label>	
        		</td>
        	</tr>
        	<tr>
        		<td>Alleged Victim:</td>
        		<td colspan="2"><input type ="text"name = "allegedvictim" value="<%=report.getVictimname()%>" style="width:100%" disabled></td>
        		<td>Frequency of Abuse:</td>
        		<td colspan="2">
        		<% 	String[] arrayFrequency = report.getFrequency().split(",");	
            	   	String abusefrequencydate = arrayFrequency[0];
            	   	String abusefrequencytend = arrayFrequency[1];
            	%>
            		<select name="abusefrequencydate" id="abusefrequencydate" disabled> 
            			<option></option>  
				        <option value="Daily" <%=abusefrequencydate.equals("Daily")?"selected='selected'":""%> >Daily</option>  
				        <option value="Weekly" <%=abusefrequencydate.equals("Weekly")?"selected='selected'":""%> >Weekly</option>  
				        <option value="Episodic" <%=abusefrequencydate.equals("Episodic")?"selected='selected'":""%> >Episodic</option> 	          
			      	</select> 
			      	<select name="abusefrequencytend" id="abusefrequencytend" disabled>  
			      		<option></option>  
				        <option value="Increasing" <%=abusefrequencytend.equals("Increasing")?"selected='selected'":""%> >Increasing</option>  
				        <option value="Decreasing" <%=abusefrequencytend.equals("Decreasing")?"selected='selected'":""%>>Decreasing</option>  
				        <option value="Constant" <%=abusefrequencytend.equals("Constant")?"selected='selected'":""%>>Constant</option> 
				        <option value="Unknown" <%=abusefrequencytend.equals("Unknown")?"selected='selected'":""%>>Unknown</option> 	          
			      	</select>
			      	<br>
					<label for="abusefrequency" class="error"></label>	
			    </td> 
        		
        	</tr>
        	<tr>     		 
            	<td>Types of Abuse:</td>
            	<td colspan="2">
            	<% 	String[] arrayAbuseType = report.getAbusetype().split(",");
            	   	HashMap<String,String> hashAbuseType = new HashMap<String,String>();	
            	   	for(int i=0;i<arrayAbuseType.length;i++){
            	   		//if the last one is not "Emotional"
            	   		if((arrayAbuseType[i]!="Physical"&&!"Physical".equals(arrayAbuseType[i]))&&
            	   		(arrayAbuseType[i]!="Omission"&&!"Omission".equals(arrayAbuseType[i]))&&
            	   		(arrayAbuseType[i]!="Sexual"&&!"Sexual".equals(arrayAbuseType[i]))&&
            	   		(arrayAbuseType[i]!="Emotional"&&!"Emotional".equals(arrayAbuseType[i]))){
            	   			hashAbuseType.put("Other", arrayAbuseType[i]);
            	   			break;
            	   		}
            	   		hashAbuseType.put(arrayAbuseType[i],arrayAbuseType[i]);
            	   	}
            	%>
            		<input type="checkbox" name="abusetype" value="Physical" <%=hashAbuseType.containsKey("Physical")?"checked":"" %> disabled>Physical 
            		<input type="checkbox" name="abusetype" value="Omission" <%=hashAbuseType.containsKey("Omission")?"checked":"" %> disabled>Omission
            		<input type="checkbox" name="abusetype" value="Sexual" <%=hashAbuseType.containsKey("Sexual")?"checked":"" %> disabled>Sexual
            		<input type="checkbox" name="abusetype" value="Emotional" <%=hashAbuseType.containsKey("Emotional")?"checked":"" %> disabled>Emotional	
            		<br>
            	<%if(hashAbuseType.containsKey("Other")){ %>
            		<input type="checkbox" name="abusetype" id="abusetypeother" value="Other" checked disabled>Other:
            		<input type ="text" name="abusetypeothertext" id="abusetypeothertext" value=<%=hashAbuseType.get("Other") %> style="width:80%" disabled>
            	<%} 
            	else{%>
            		<input type="checkbox" name="abusetype" id="abusetypeother" value="Other" disabled>Other:
            		<input type ="text" name="abusetypeothertext" id="abusetypeothertext" style="width:80%" disabled>
            	<%} %>
            		<br>
					<label for="abusetype" class="error"></label>
				</td>
				<td>Is victim aware of report?</td>
				<td colspan="2">
				<% 
				if(report.getAwareof()=="yes"||report.getAwareof().equals("yes")){%>
					<label><input name="awareof" type="radio" value="yes" checked disabled/>yes</label> 
					<label><input name="awareof" type="radio" value="no" disabled/>no</label>
				<%}
				else{%>
            		<label><input name="awareof" type="radio" value="yes" disabled/>yes</label> 
					<label><input name="awareof" type="radio" value="no" checked disabled/>no</label>	
				<%}%>
					<br>
					<label for="awareof" class="error"></label>	
				</td>
            </tr>  
        	<tr>
        		<td colspan="2">Was an oral report filed with the DPPC Hotline?
					<br>
					<label for="dppchotline" class="error"></label>	
        		</td>
        		<td colspan="4">
        		<% 
				if(report.getDppchotline()=="no"||report.getDppchotline().equals("no")){%>
					<label><input name="dppchotline" type="radio" value="no" checked disabled/>no</label> 
					<label><input name="dppchotline" type="radio" value="yes" disabled/>yes</label>
					<label><input name="dppchotlinetext" id="dppchotlinetext" type="text"  style="width:70%" value="" disabled></label>
				<%}
				else{%>
					<label><input name="dppchotline" type="radio" value="no" disabled/>no</label> 
					<label><input name="dppchotline" type="radio" value="yes" checked disabled/>yes</label>	
					<label><input name="dppchotlinetext" id="dppchotlinetext" type="text"  style="width:70%" value="<%=report.getDppchotline()%>" disabled></label>
				<%}%>
	            </td> 	
        	</tr>
        	<tr>
        		<td colspan="2">Is there any risk to the investigator?      		
					<br>
					<label for="investigatorrisk" class="error"></label>
        		</td>
				<td colspan="4">
				<% 
				if(report.getInvestigatorrisk()=="no"||report.getInvestigatorrisk().equals("no")){%>
					<label><input name="investigatorrisk" type="radio" value="no" checked disabled/>no</label> 
					<label><input name="investigatorrisk" type="radio" value="yes" disabled/>yes</label>
					<label><input name="investigatorrisktext" id="investigatorrisktext" type="text"  style="width:70%" value="" disabled></label>
				<%}
				else{%>
					<label><input name="investigatorrisk" type="radio" value="no" disabled/>no</label> 
					<label><input name="investigatorrisk" type="radio" value="yes" checked disabled/>yes</label>	
					<label><input name="investigatorrisktext" id="investigatorrisktext" type="text"  style="width:70%" value="<%=report.getInvestigatorrisk()%>" disabled></label>
				<%}%>
	            </td>	
        	</tr>
        	<tr>
            	<tr>
            		<td colspan="6">In narrative form, please describe the alleged abuse:
            			<label for="narrativeform" class="error"></label>
            		</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea style="width:100%" name="narrativeform" rows="6" disabled><%=report.getNarrativeform()%></textarea>
              		</td>
              	</tr>
        	</tr>  
        	<tr>
            	<tr>
            		<td colspan="6">Please describe the level of risk to the alleged victim, including his/her currentphysical and emotional state:
            			<label for="risklevel" class="error"></label>
            		</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea style="width:100%" rows="6" name="risklevel" disabled><%=report.getRisklevel()%></textarea>
              		</td>
              	</tr>
        	</tr> 
        	<tr>
            	<tr>
            		<td colspan="6">Please list any resulting injuries:
            			<label for="resultinginjure" class="error"></label>
            		</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea style="width:100%" rows="6" name="resultinginjure" disabled><%=report.getResultinginjure()%></textarea>
              		</td>
              	</tr>
        	</tr> 
        	<tr>
            	<tr>
            		<td colspan="6">Please list witnesses, if any, including daytime phone numbers:</td>
            	</tr>
            	<tr>
            		<td colspan="6" align="left" valign="top">
              			<textarea style="width:100%" rows="5" name="witness" disabled><%=report.getWitness()%></textarea>
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
              			<textarea  rows="5"  style="width:100%" name="caregiverrelationship" disabled><%=report.getCaregiverrelationship()%></textarea>
              		</td>
              	</tr>
        	</tr>  
        	<tr>
            	<td>attachment</td>
            	<td colspan="3">
	            	<div align="center">
						<table id="showattach" border="0" width="100%" style="border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;margin-top:8px;">
		            	<%for(int i = 0;i<list.size();i++){ 
		             		Attach attach = list.get(i);%> 	
		             		<tr>              		
		             			<td><%=attach.getId()%></td>
		             			<td><a href = "<%=attach.getPath()%>"><%=attach.getOldName()%></a></td>
		             		</tr>
		             	<%} %>          	
		            	</table>		            
	            	</div>
            	</td>
            	<td class="tdstyle" colspan="2" align = "right">
               		<!--  input type="submit" value="print" /-->
               		 <input type="button" value="return" onclick="gopath('firstpage.jsp')"/><br>
           		</td>
        	</tr>  	      	
		</table>
	</form>
	<br><br><br><br><br><br><br><br><br><br>
</body>
</html>