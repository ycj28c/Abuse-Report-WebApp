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
	<title>Insert title here</title>
	<base href="<%=basePath%>">
	
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
	welcome to xxx system <%=session.getAttribute("username")%>. 
    <input type="button" value="logout" onclick="gopath('login.jsp')"/><br>
    ==================================================================<br>
	<form action="jsp/NewReportServlet?userid=<%=session.getAttribute("userid")%>" method="post">
		<table align = "left" border="1" style="border-collapse: collapse;">
			<tr>
            	<td colspan="2" align = "center">NEW REPORT</td>
            </tr>
			<tr>
            	<td>name</td>
              	<td><input type="text" name="username" /></td>
        	</tr>
        	<tr>
            	<td>time</td>
            	<script type="text/javascript" src="javascript/calendar.js"></script>
              	<td><input name="time" type="text" id="en_date" onclick="new Calendar(null, null, 1).show(this);" size="10" maxlength="10" readonly="readonly" /></td>
        	</tr>
        	<tr>
            	<td>description</td>
            	<td>
              		<textarea cols="17" rows="6" name="description"></textarea>
              	</td>
        	</tr>  
        	<tr>
            	<td>attachment</td>
            	<td>
              		<span id="spanButtonPlaceholder"></span>
		  			<div id="divFileProgressContainer" style="width:450;display:none;"></div>
					<div id="thumbnails">
						<table id="infoTable" border="0" width="100%" style="border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;margin-top:8px;">
						</table>
					</div>         		
              	</td>
        	</tr>  	
        	<tr>
            	<td class="tdstyle" colspan="2">
               		<input type="submit" value="submit" />
               		<input type="reset" value="reset" />
               		<input type="button" value="return" onclick="gopath('firstpage.jsp')"/><br>
           		</td>
 			</tr>
		</table>
	</form>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<%
		String info = (String)request.getAttribute("info");//取得属性 
		if (info != null) { //判断是否有内容 
	%>
	<h4><%=info%></h4>
	<%
		}
	%>
</body>
</html>