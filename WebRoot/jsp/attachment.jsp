<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript" src="javascript/swfupload/swfupload.js"></script>
  <script type="text/javascript" src="javascript/swfupload/handlers.js"></script>
  <script type="text/javascript" src="javascript/jquery-1.4.2.min.js"></script>
  <body style="font-size: 12px;">
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
					button_image_url : "image/SmallSpyGlassWithTransperancy_17x18.png",
					button_placeholder_id : "spanButtonPlaceholder",
					button_width: 100,
					button_height: 18,
					button_text : '<span class="button">add attachment</span>',
					button_text_style : '.button { font-family: Helvetica, Arial, sans-serif; font-size: 12pt; } .buttonSmall { font-size: 10pt; }',
					button_text_top_padding: 0,
					button_text_left_padding: 18,
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
			function goback(){
				var infoTable = document.getElementById("infoTable");
				var row = document.getElementById("1");
				//var row = document.getElementById(fileId);
				var filePath = row.cells[4].innerHTML;
				window.parent.returnValue=filePath;
                window.parent.close();
			}

		</script>
		<!--  -->
		<span id="spanButtonPlaceholder"></span>
		<input type="button" onclick = "goback()" value="finish"></span>
		  <div id="divFileProgressContainer" style="width:450;display:none;"></div>
		<div id="thumbnails">
				<table id="infoTable" border="0" width="90%" style="border: solid 1px #7FAAFF; background-color: #C5D9FF; padding: 2px;margin-top:8px;">
				</table>
			</div>
  </body>
</html>
