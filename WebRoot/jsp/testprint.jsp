<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="/javascript/jspdf.min.js"></script> 
<script type="text/javascript">  
//生成并输出  
function createAndOutput(){  
   var doc = new jsPDF();  
   doc.text(20, 20, 'Hello world!');  
   doc.text(20, 30, 'This is client-side Javascript, pumping out a PDF.');  
   doc.addPage(); //生成下一页  
   doc.text(20, 20, 'Do you like that?');  
  
   doc.output('datauri');  
}  
  
//生成并下载  
function createAndDownload(){  
   var doc = new jsPDF();  
   doc.text(20, 20, 'Hello world!');  
   doc.text(20, 30, 'This is client-side Javascript, pumping out a PDF.');  
   doc.addPage(); //生成下一页  
   doc.text(20, 20, 'Do you like that?');  
     
   doc.save('Test.pdf');  
}  
</script>


<a href="javascript:void(0)" onclick="createAndOutput()">output</a>  
<br/>  
<a href="javascript:void(0)" onclick="createAndDownload()">output and download</a>

</body>
</html>