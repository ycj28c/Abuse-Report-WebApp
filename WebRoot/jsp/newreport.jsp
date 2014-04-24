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
			//function startUploadFile(){
			//	swfu.startUpload();
			//}
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
	<script type="text/javascript">
	var aa;
	function searchAbuser(){
		alert("dd");
		var allegedabuser = document.getElementById("allegedabuser").value;
		if(allegedabuser=='')
			return false;
		var url = "jsp/CheckPublicLogNumberServlet?publiclognumber=" + 321;
		if(window.ActiveXObject){
			aa = new ActiveXObject("Microsoft.XMLHttp");
		}
		else if(window.XMLHttpRequest){
			aa = new XMLHttpRequest();
		}
		aa.onreadystatechange = processAA;
		aa.open("GET",url,true);
		aa.setRequestHeader("If-Modified-Since","0");
		aa.setRequestHeader("Cache-Control","no-cache");
		aa.send(null);
	}
	function processAA(){
			if(pln.readyState == 4){
				if(pln.status == 200){
					var xml = aa.responseXML;
					alert("request success, receive text:"+aa.responseText);
				}
				else{
					alert("request fail, status code:"+pln.status);
				}
			}
		}
	</script>
	
</head>
<body>
	<form action="jsp/NewReportServlet?userid=<%=session.getAttribute("userid")%>" method="post" name="newreport" id="newreport">
		<table align = "left" border="1" style="border-collapse: collapse;">
			<tr>
            	<td colspan="5" align = "center">NEW REPORT</td>
            	<td class="tdstyle" align ="right" colspan="1">
               		<input type="submit" value="submit" />
               		<input type="reset" value="reset" />
               		<input type="button" value="return" onclick="gopath('firstpage.jsp')"/><br>
           		</td>
            </tr>
			<tr>
            	<td>Alleged Abuser:</td>    
            	<td colspan="2"><input type ="text" name = "allegedabuser" id="allegedabuser" oninput="searchAbuser()" style="width:100%"></td> 
            	<td>Date of last incident:</td>
            	<script type="text/javascript" src="javascript/calendar.js"></script>
              	<td colspan="2"><input name="time" type="text" id="en_date" onclick="new Calendar(null, null, 1).show(this);" size="10" maxlength="10" readonly="readonly">
	        		<br>
	        		<label for="time" class="error"></label>	
        		</td>
        	</tr>
        	<tr>
        		<td>Alleged Victim:</td>
        		<td colspan="2"><input type ="text"name = "allegedvictim" style="width:100%"></td>
        		<td>Frequency of Abuse:</td>
        		<td colspan="2">
            		<select name="abusefrequencydate" id="abusefrequency"> 
            			<option></option>  
				        <option value="Daily">Daily</option>  
				        <option value="Weekly">Weekly</option>  
				        <option value="Episodic">Episodic</option> 	          
			      	</select> 
			      	<select name="abusefrequencytend" id="abusefrequency">  
			      		<option></option>  
				        <option value="Increasing">Increasing</option>  
				        <option value="Decreasing">Decreasing</option>  
				        <option value="Constant">Constant</option> 
				        <option value="Unknown">Unknown</option> 	          
			      	</select>
			      	<br>
					<label for="abusefrequencydate" class="error"></label>
					<br>
					<label for="abusefrequencytend" class="error"></label>	
			    </td> 
        		
        	</tr>
        	<tr>     		 
            	<td>Types of Abuse:</td>
            	<td colspan="2">
            		<input type="checkbox" name="abusetype" value="Physical">Physical 
            		<input type="checkbox" name="abusetype" value="Omission">Omission
            		<input type="checkbox" name="abusetype" value="Sexual">Sexual
            		<input type="checkbox" name="abusetype" value="Emotional">Emotional	
            		<br>
            		<input type="checkbox" name="abusetype" id="abusetypeother" value="Other">Other:
            		<input type ="text" name="abusetypeothertext" id="abusetypeothertext" style="width:80%" disabled>
            		<br>
					<label for="abusetype" class="error"></label>
				</td>
				<td>Is victim aware of report?</td>
				<td colspan="2">
            		<label><input name="awareof" type="radio" value="yes" />yes</label> 
					<label><input name="awareof" type="radio" value="no" />no</label>	
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
	            	<label><input name="dppchotline" type="radio" value="no" />no</label> 
					<label><input name="dppchotline" type="radio" value="yes" />yes</label> 
					<label><input name="dppchotlinetext" id="dppchotlinetext" type="text"  style="width:70%" value="" disabled></label> 
				</td> 	
        	</tr>
        	<tr>
        		<td colspan="2">Is there any risk to the investigator?      		
					<br>
					<label for="investigatorrisk" class="error"></label>
        		</td>
				<td colspan="4">
	            	<label><input name="investigatorrisk" type="radio" value="no" />no</label> 
					<label><input name="investigatorrisk" type="radio" value="yes" />yes</label> 	
					<label><input name="investigatorrisktext" id="investigatorrisktext" type="text"  style="width:70%" value="" disabled></label> 
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
              			<textarea style="width:100%" name="narrativeform" rows="6" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
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
              			<textarea style="width:100%" rows="6" name="risklevel" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
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
              			<textarea style="width:100%" rows="6" name="resultinginjure" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
              		</td>
              	</tr>
        	</tr> 
        	<tr>
            	<tr>
            		<td colspan="6">Please list witnesses, if any, including daytime phone numbers:</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea style="width:100%" rows="5" name="witness" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
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
              			<textarea style="width:100%" rows="5" name="caregiverrelationship" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
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
               		<input type="submit" value="submit" />
               		<input type="reset" value="reset" />
               		<input type="button" value="return" onclick="gopath('firstpage.jsp')"/>             	
           		</td>	
        	</tr>  	      	
		</table>
	</form>
</body>
</html>