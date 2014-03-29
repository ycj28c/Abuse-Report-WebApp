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
	<title>New Report</title>
	<base href="<%=basePath%>">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/reset.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/select_autocomplete.css"/>
	<style type="text/css">
		#newreport label.error {
			width: auto;
			color: red;
			display: inline;
		}
	</style>
	
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	<script type="text/javascript" src="javascript/swfupload/swfupload.js"></script>
  	<script type="text/javascript" src="javascript/swfupload/handlers.js"></script>
  	<!-- script type="text/javascript" src="javascript/jquery-1.4.2.min.js"></script-->
	<script type="text/javascript" src="javascript/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="javascript/jquery.validate.js"></script>
	<script type="text/javascript">
			var swfu;
			window.onload = function () {
				swfu = new SWFUpload({
					upload_url: "FileUploadServlet",
					
					// File Upload Settings
					file_size_limit : "50 MB",	// 1000MB
					file_types : "*.*",//设置可上传的类型
					file_types_description : "所有文件",
					file_upload_limit : "10",
									
					file_queue_error_handler : fileQueueError,//选择文件后出错
					file_dialog_complete_handler : fileDialogComplete,//选择好文件后提交
					file_queued_handler : fileQueued,
					upload_progress_handler : uploadProgress,
					upload_error_handler : uploadError,
					upload_success_handler : uploadSuccess,
					upload_complete_handler : uploadComplete,
	
					// Button Settings
					//button_image_url : "image/SmallSpyGlassWithTransperancy_17x18.png",
					button_placeholder_id : "spanButtonPlaceholder",
					button_width: 450,
					button_height: 24,
					button_text : '<span class="button">add attachment</span>',
					button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 14pt; } .buttonSmall { font-size: 14pt; }',
					button_text_top_padding: 5,
					button_text_left_padding: 20,
					button_window_mode: SWFUpload.WINDOW_MODE.TRANSPARENT,
					button_cursor: SWFUpload.CURSOR.HAND,
					
					// Flash Settings
					flash_url : "javascript/swfupload/swfupload.swf",
	
					custom_settings : {
						upload_target : "divFileProgressContainer"
					},
					// Debug Settings
					debug: false  //是否显示调试窗口
				});
			};
			function startUploadFile(){
				swfu.startUpload();
			}
	</script>
	<script type="text/javascript">
	$().ready(function() {
		// validate signup form on keyup and submit
		$("#newreport").validate({
			rules: {
				allegedabuser: {
					required: true,
					minlength: 2
				},
				allegedvictim: {
					required: true,
					minlength: 2
				},
				awareof: "required",
				abusetype:"required",
				time:"required",
				abusefrequencydate:"required",
				abusefrequencytend:"required",
				dppchotline:"required",
				investigatorrisk: "required",
				narrativeform: "required",
				risklevel:"required",
				resultinginjure:"required",
			},
			messages: {
				allegedabuser: {
					required: "Please enter a name",
					minlength: "Your name must consist of at least 2 characters"
				},
				allegedvictim: {
					required: "Please provide a name",
					minlength: "Your name must be at least 2 characters long"
				},
				awareof: "Please choose a option",
				abusetype:"Please choose a abuse type",
				time:"Please choose a time",
				abusefrequencydate:"Please choose a abuse frequency",
				abusefrequencytend:"Please choose a abuse frequency",
				dppchotline:"Please choose a dppchotline",
				investigatorrisk: "Please choose a investigator risk",
				narrativeform: "(please write)",
				risklevel: "(please write)",
				resultinginjure: "(please write)",
			}
		});
	
		$("#abusetypeother").change(function(){
			if($(this).is(":checked")){//only is(":checked") works for judge
				$("#abusetypeothertext").attr("disabled",false);
			}	
			else{
				$("#abusetypeothertext").attr("disabled",true);
				$("#abusetypeothertext").val("");
			}
		});
		
		$("input:radio[name='dppchotline']").change(function(){
			var selectValue = $(this).val();
			if(selectValue =="yes"){
				//alert(selectValue);
				$("#dppchotlinetext").attr("disabled",false);
			}	
			else{
				//alert(selectValue);
				$("#dppchotlinetext").attr("disabled",true);
				$("#dppchotlinetext").val("");
			}
		});
		
		$("input:radio[name='investigatorrisk']").change(function(){
			var selectValue = $(this).val();
			if(selectValue =="yes"){
				$("#investigatorrisktext").attr("disabled",false);
			}	
			else{
				$("#investigatorrisktext").attr("disabled",true);
				$("#investigatorrisktext").val("");
			}
		});
			
	});
	</script>
	
</head>
<body>
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	<% 
	   Report report = (Report)request.getAttribute("report"); 
	   ArrayList<Attach> list = (ArrayList<Attach>)(request.getAttribute("attachlist"));
	%>
	welcome to xxx system <%=session.getAttribute("username")%>. 
    <input type="button" value="logout" onclick="gopath('login.jsp')"/><br>
    ==================================================================<br>
	<form action="jsp/UpdateReportServlet?reportid=<%=report.getReportid()%>" method="post">
		<table align = "left" border="1" style="border-collapse: collapse;">
			<tr>
            	<td colspan="5" align = "center">EDIT REPORT</td>
            	<td class="tdstyle" align ="right" colspan="1">
               		<input type="submit" value="update" />
               		<input type="reset" value="reset" />
               		<input type="button" value="return" onclick="gopath('firstpage.jsp')"/><br>
           		</td>
            </tr>
			<tr>
            	<td>Alleged Abuser:</td>    
            	<td colspan="2"><input type ="text" name = "allegedabuser" value="<%=report.getAbusername()%>" style="width:100%"></td> 
            	<td>Date of last incident:</td>
            	<script type="text/javascript" src="javascript/calendar.js"></script>
	        	<td colspan="2"><input name="time" type="text" id="en_date" value="<%=report.getTime()%>" onclick="new Calendar(null, null, 1).show(this);" size="10" maxlength="10" readonly="readonly">
	        		<br>
	        		<label for="time" class="error"></label>	
        		</td>
        	</tr>
        	<tr>
        		<td>Alleged Victim:</td>
        		<td colspan="2"><input type ="text"name = "allegedvictim" value="<%=report.getVictimname()%>" style="width:100%"></td>
        		<td>Frequency of Abuse:</td>
        		<td colspan="2">
        		<% 	String[] arrayFrequency = report.getFrequency().split(",");	
            	   	String abusefrequencydate = arrayFrequency[0];
            	   	String abusefrequencytend = arrayFrequency[1];
            	%>
            		<select name="abusefrequencydate" id="abusefrequencydate"> 
            			<option></option>  
				        <option value="Daily" <%=abusefrequencydate.equals("Daily")?"selected='selected'":""%> >Daily</option>  
				        <option value="Weekly" <%=abusefrequencydate.equals("Weekly")?"selected='selected'":""%> >Weekly</option>  
				        <option value="Episodic" <%=abusefrequencydate.equals("Episodic")?"selected='selected'":""%> >Episodic</option> 	          
			      	</select> 
			      	<select name="abusefrequencytend" id="abusefrequencytend" >  
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
            		<input type="checkbox" name="abusetype" value="Physical" <%=hashAbuseType.containsKey("Physical")?"checked":"" %> >Physical 
            		<input type="checkbox" name="abusetype" value="Omission" <%=hashAbuseType.containsKey("Omission")?"checked":"" %> >Omission
            		<input type="checkbox" name="abusetype" value="Sexual" <%=hashAbuseType.containsKey("Sexual")?"checked":"" %> >Sexual
            		<input type="checkbox" name="abusetype" value="Emotional" <%=hashAbuseType.containsKey("Emotional")?"checked":"" %> >Emotional	
            		<br>
            	<%if(hashAbuseType.containsKey("Other")){ %>
            		<input type="checkbox" name="abusetype" id="abusetypeother" value="Other" checked >Other:
            		<input type ="text" name="abusetypeothertext" id="abusetypeothertext" value=<%=hashAbuseType.get("Other") %> style="width:80%" >
            	<%} 
            	else{%>
            		<input type="checkbox" name="abusetype" id="abusetypeother" value="Other" >Other:
            		<input type ="text" name="abusetypeothertext" id="abusetypeothertext" style="width:80%" disabled>
            	<%} %>
            		<br>
					<label for="abusetype" class="error"></label>
				</td>
				<td>Is victim aware of report?</td>
				<td colspan="2">
				<% 
				if(report.getAwareof()=="yes"||report.getAwareof().equals("yes")){%>
					<label><input name="awareof" type="radio" value="yes" checked />yes</label> 
					<label><input name="awareof" type="radio" value="no" />no</label>
				<%}
				else{%>
            		<label><input name="awareof" type="radio" value="yes" />yes</label> 
					<label><input name="awareof" type="radio" value="no" checked />no</label>	
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
					<label><input name="dppchotline" type="radio" value="no" checked />no</label> 
					<label><input name="dppchotline" type="radio" value="yes" />yes</label>
					<label><input name="dppchotlinetext" id="dppchotlinetext" type="text"  style="width:70%" value="" disabled></label>
				<%}
				else{%>
					<label><input name="dppchotline" type="radio" value="no" />no</label> 
					<label><input name="dppchotline" type="radio" value="yes" checked />yes</label>	
					<label><input name="dppchotlinetext" id="dppchotlinetext" type="text"  style="width:70%" value="<%=report.getDppchotline()%>" ></label>
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
					<label><input name="investigatorrisk" type="radio" value="no" checked />no</label> 
					<label><input name="investigatorrisk" type="radio" value="yes" />yes</label>
					<label><input name="investigatorrisktext" id="investigatorrisktext" type="text"  style="width:70%" value="" disabled></label>
				<%}
				else{%>
					<label><input name="investigatorrisk" type="radio" value="no" />no</label> 
					<label><input name="investigatorrisk" type="radio" value="yes" checked />yes</label>	
					<label><input name="investigatorrisktext" id="investigatorrisktext" type="text"  style="width:70%" value="<%=report.getInvestigatorrisk()%>" ></label>
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
              			<textarea style="width:100%" name="narrativeform" rows="6" ><%=report.getNarrativeform()%></textarea>
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
              			<textarea style="width:100%" rows="6" name="risklevel" ><%=report.getRisklevel()%></textarea>
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
              			<textarea style="width:100%" rows="6" name="resultinginjure" ><%=report.getResultinginjure()%></textarea>
              		</td>
              	</tr>
        	</tr> 
        	<tr>
            	<tr>
            		<td colspan="6">Please list witnesses, if any, including daytime phone numbers:</td>
            	</tr>
            	<tr>
            		<td colspan="6" align="left" valign="top">
              			<textarea style="width:100%" rows="5" name="witness" ><%=report.getWitness()%></textarea>
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
              			<textarea  rows="5"  style="width:100%" name="caregiverrelationship" ><%=report.getCaregiverrelationship()%></textarea>
              		</td>
              	</tr>
        	</tr>  
        	<tr>
            	<td>attachment</td>
            	<td colspan="3">
              		<span id="spanButtonPlaceholder"></span>
		  			<div id="divFileProgressContainer" style="width:450;display:none;"></div>
					<div id="thumbnails">
						<table id="infoTable" border="0" width="100%" style="border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;margin-top:8px;">
						</table>
					</div>         		
              	</td>
            	<td class="tdstyle" colspan="2" align = "right">
               		<input type="submit" value="update" />
               		<input type="reset" value="reset" />
               		<input type="button" value="return" onclick="gopath('firstpage.jsp')"/>             	
           		</td>	
        	</tr>  	      	
		</table>
	</form>
</body>
</html>