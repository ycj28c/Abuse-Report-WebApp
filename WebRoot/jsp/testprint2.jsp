<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html> 
<head> 
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=GBK"> 
<title>jsPDF</title> 
<script type="text/javascript" src="/javascript/jspdf.min.js"></script> 
<script type="text/javascript"> 
window.onload=function(){ 
var doc = new jsPDF(); 
//var doc = new jsPDF('landscape');//横排 

doc.setProperties({//设置文档属性 
title: 'Title', 
subject: 'This is the subject', 
author: 'Dragon', 
keywords: 'javascript, web 2.0, ajax', 
creator: 'MEEE' 
}); 

doc.setTextColor(0,255,0); 
doc.setFontSize(22); 
doc.setFont("times"); 
doc.setFontType("italic"); 
doc.text(20, 20, 'Hello world!');//添加文字 

doc.setTextColor(255,0,0); 
doc.setFontSize(16); 
doc.setFont("helvetica"); 
doc.setFontType("bold"); 
doc.text(20, 30, 'This is client-side Javascript, pumping out a PDF.'); 

doc.addPage();//添加页 

doc.setLineWidth(1);//设置线宽 
doc.setDrawColor(0,255,0);//设置画笔颜色 
doc.setFillColor(255,0,0);//设置填充颜色 
doc.line(60, 20, 115, 60);//画线，两个坐标 
doc.rect(100, 50, 20, 30); //画矩形，左上角坐标，宽度，高度，只有边框 
doc.ellipse(20, 20, 20, 10, 'F');//画椭圆，中心点坐标，宽度，高度，只有边 
doc.circle(120, 20, 20, 'FD');//画圆，中心点坐标，半径，边框和填充都有 
doc.triangle(100, 100, 110, 100, 120, 130, 'FD'); 

//doc.output('datauri');//直接输出为新的web页 
document.getElementById("iframe123").src = doc.output('datauristring');//在iframe中显示 
} 
</script> 
</head> 
<body> 
<iframe id="iframe123" frameborder="0" width="400" height="500"></iframe> 
</body> 
</html>