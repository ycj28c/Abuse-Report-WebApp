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
	
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	<script type="text/javascript" src="javascript/swfupload/swfupload.js"></script>
  	<script type="text/javascript" src="javascript/swfupload/handlers.js"></script>
  	<script type="text/javascript" src="javascript/jquery-1.4.2.min.js"></script>
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

</head>
<body>
	<form action="jsp/NewReportServlet?userid=<%=session.getAttribute("userid")%>" method="post">
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
            	<td><input type ="text" style="width:100%"></td> 
            	<td>Alleged Victim:</td>
        		<td><input type ="text"></td>
        		<td colspan="2">Is victim aware of report?
            		<label><input name="Fruit" type="radio" value="" />yes</label> 
					<label><input name="Fruit" type="radio" value="" />no</label>		
				</td>
        	</tr>
        	<tr>
        		<td>Frequency of Abuse:</td>
        		<td>
            		<select name="abusetype" id="abusetype">  
				        <option value="1">Daily</option>  
				        <option value="2">Weeking</option>  
				        <option value="3">Episodic</option> 	          
			      	</select> 
			      	<select name="abusetype" id="abusetype">  
				        <option value="1">Increasing</option>  
				        <option value="2">Decreasing</option>  
				        <option value="3">Constant</option> 
				        <option value="4">unknown</option> 	          
			      	</select>
			    </td> 
        		<td>Date of last incident:</td>
            	<script type="text/javascript" src="javascript/calendar.js"></script>
              	<td><input name="time" type="text" id="en_date" onclick="new Calendar(null, null, 1).show(this);" size="10" maxlength="10" readonly="readonly" /></td>
        	</tr>
        	<tr>     		 
            	<td>Types of Abuse:</td>
            	<td colspan="5">
            		<input type="checkbox" name="director[]" value="Physical">Physical 
            		<input type="checkbox" name="director[]" value="Omission">Omission
            		<input type="checkbox" name="director[]" value="Sexual">Sexual
            		<input type="checkbox" name="director[]" value="Emotional">Emotional	
            		<input type="checkbox" name="director[]" value="other">other:
            		<input type ="text" style="width:51%">
            </tr>  
        	<tr>
        		<td colspan="2">Was an oral report filed with the DPPC Hotline?</td>
        		<td colspan="4">
	            	<label><input name="Fruit" type="radio" value="" />no</label> 
					<label><input name="Fruit" type="radio" value="" />yes</label> 
					<label><input name="Fruit" type="text"  style="width:85%" value="Please note date and time of call" /></label> 
				</td> 		
        	</tr>
        	<tr>
        		<td colspan="2">Is there any risk to the investigator?</td>	
				<td colspan="4">
	            	<label><input name="Fruit" type="radio" value="" />no</label> 
					<label><input name="Fruit" type="radio" value="" />yes</label> 	
					<label><input name="Fruit" type="text"  style="width:85%" value="If yes, please specify" /></label> 
				</td>
        	</tr>
        	<tr>
            	<tr>
            		<td colspan="6">In narrative form, please describe the alleged abuse:</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea style="width:100%" rows="6" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
              		</td>
              	</tr>
        	</tr>  
        	<tr>
            	<tr>
            		<td colspan="6">Please describe the level of risk to the alleged victim, including his/her currentphysical and emotional state:</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea style="width:100%" rows="6" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
              		</td>
              	</tr>
        	</tr> 
        	<tr>
            	<tr>
            		<td colspan="6">Please list any resulting injuries:</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea style="width:100%" rows="6" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
              		</td>
              	</tr>
        	</tr> 
        	<tr>
            	<tr>
            		<td colspan="6">Please list witnesses, if any, including daytime phone numbers:</td>
            	</tr>
            	<tr>
            		<td colspan="6">
              			<textarea style="width:100%" rows="5" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
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
              			<textarea style="width:100%" rows="5" onpropertychange= "this.style.posHeight=this.scrollHeight"></textarea>
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