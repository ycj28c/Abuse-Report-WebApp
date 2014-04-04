<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>New Investigation</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		#newinvestigation label.error {
			width: auto;
			color: red;
			display: inline;
		}
	</style>
	
	<script type="text/javascript" src="javascript/browsercompatible.js"></script>
	<script type="text/javascript" src="javascript/jquery-1.9.0.js"></script>
	<script type="text/javascript" src="javascript/jquery.validate.js"></script>
	<script type="text/javascript">
	$().ready(function() {
		// validate signup form on keyup and submit
		$("#newinvestigation").validate({
			rules: {
				reportid: {
					required: true,
					digits: true
				},
				publiclognumber: {
					required: true,
					digits: true
				},
			},
			messages: {
				reportid: {
					required: "Please provide a reportid",
					digits: "Your reportid must be digit"
				},
				publiclognumber: {
					required: "Please provide a publiclognumber",
					digits: "Your publiclognumber must be digit"
				},
			}
		});
	});	
	</script>
	<script type="text/javascript">
		var pln;
		function checkPLN(){
			var publiclognumber = document.getElementById("publiclognumber").value;
			if(publiclognumber=='')
				return false;
			var url = "jsp/CheckPublicLogNumberServlet?publiclognumber=" + publiclognumber;
			if(window.ActiveXObject){
				pln = new ActiveXObject("Microsoft.XMLHttp");
			}
			else if(window.XMLHttpRequest){
				pln = new XMLHttpRequest();
			}
			pln.onreadystatechange = processPLN;
			pln.open("GET",url,true);
			pln.setRequestHeader("If-Modified-Since","0");
			pln.setRequestHeader("Cache-Control","no-cache");
			pln.send(null);
		}
		function processPLN(){
			if(pln.readyState == 4){
				if(pln.status == 200){
					initElement();
					var xml = pln.responseXML;
					//alert("request success, receive text:"+pln.responseText+"\nreceive xml:" + xml);
					var xxoo = xml.getElementsByTagName("status")[0].childNodes[0].nodeValue;
					if(xxoo == "new investigation"){
						openElement();
						var title = document.getElementById("title");
						var children = title.childNodes;	
						title.removeChild(children[0]);
						var investstatus = document.createElement("a");
						investstatus.innerHTML = "NEW INVESTIGATION";
						title.appendChild(investstatus);
						//change update to submit button
						var investigationform = document.getElementById("newinvestigation");
						investigationform.action = "jsp/NewInvestigationServlet";
						var submitform = document.getElementById("submitform");
						submitform.value = "Submit";
					}
					else{
						openElement();
						var title = document.getElementById("title");	
						var children = title.childNodes;
						title.removeChild(children[0]);	
						var investstatus = document.createElement("a");
						investstatus.innerHTML = "UPDATE INVESTIGATION";
						title.appendChild(investstatus);
						//change sumbit to update button
						var investigationform = document.getElementById("newinvestigation");
						investigationform.action = "jsp/UpdateInvestigationServlet";
						var submitform = document.getElementById("submitform");
						submitform.value = "Update";
					
						if(xml.getElementsByTagName("report")!=null&&xml.getElementsByTagName("report")!=""){
							var reportid = xml.getElementsByTagName("reportid")[0].childNodes[0].nodeValue;
							var domreportid = document.getElementById("reportid");
							domreportid.value = reportid;
								
							var date = xml.getElementsByTagName("date")[0].childNodes[0].nodeValue;
							var domdate = document.getElementById("date");
							domdate.value = date;
										
							var status = xml.getElementsByTagName("status")[0].childNodes[0].nodeValue;
							var domstatus = document.getElementById("status");
							domstatus.value = status;
						}
						
						if(xml.getElementsByTagName("disposition")!=null&&xml.getElementsByTagName("disposition")!=""){
							var dispositionid_dis = xml.getElementsByTagName("dispositionid_dis")[0].childNodes[0].nodeValue;
							var dispositionid = document.getElementById("dispositionid");
							dispositionid.value = dispositionid_dis;
							
							var description_dis = xml.getElementsByTagName("description_dis")[0].childNodes[0].nodeValue;
							var disdescription = document.getElementById("disdescription");
							disdescription.value = description_dis;						
							
							var attachpath_dec = xml.getElementsByTagName("attachpath_dis")[0].childNodes[0].nodeValue;
							var attacholdname_dec = xml.getElementsByTagName("attacholdname_dis")[0].childNodes[0].nodeValue;
							var disattachment = document.getElementById("disattachment");
							var disshow_del = document.getElementById("disshow");
							if(disshow_del!=null){
								desattachment.parentNode.removeChild(disshow_del);
							}
							var disshow = document.createElement("a");
							disshow.id = "disshow";
							disshow.href = attachpath_dec;
							disshow.innerHTML = attacholdname_dec;
							disattachment.parentNode.appendChild(disshow);
						}
						if(xml.getElementsByTagName("respond")!=null&&xml.getElementsByTagName("respond")!=""){
							var respondid_res = xml.getElementsByTagName("respondid_res")[0].childNodes[0].nodeValue;
							var respondid = document.getElementById("respondid");
							respondid.value = respondid_res;
						
							var content_res = xml.getElementsByTagName("content_res")[0].childNodes[0].nodeValue;
							var resdescription = document.getElementById("resdescription");
							resdescription.value = content_res;
						}
						if(xml.getElementsByTagName("decision")!=null&&xml.getElementsByTagName("decision")!=""){
							var decisionid_dec = xml.getElementsByTagName("decisionid_dec")[0].childNodes[0].nodeValue;
							var decisionid = document.getElementById("decisionid");
							decisionid.value = decisionid_dec;
						
							var description_dec = xml.getElementsByTagName("description_dec")[0].childNodes[0].nodeValue;
							var desdescription = document.getElementById("desdescription");
							desdescription.value = description_dec;
							
							var attachpath_dec = xml.getElementsByTagName("attachpath_dec")[0].childNodes[0].nodeValue;
							var attacholdname_dec = xml.getElementsByTagName("attacholdname_dec")[0].childNodes[0].nodeValue;
							var desattachment = document.getElementById("desattachment");
							var decshow_del = document.getElementById("decshow");
							if(decshow_del!=null){
								desattachment.parentNode.removeChild(decshow_del);
							}
							var decshow = document.createElement("a");
							decshow.id = "decshow";
							decshow.href = attachpath_dec;
							decshow.innerHTML = attacholdname_dec;
							desattachment.parentNode.appendChild(decshow);
						}
						//desattachment.parentNode.insertBefore(decpathshow, null);
					}
					//alert("request success, receive text:"+pln.responseText+"\nreceive xml:" + xml);
				}
				else{
					alert("request fail, status code:"+pln.status);
				}
			}
		}
		function blockElement(){
			var domdate = document.getElementById("publiclognumber");
			domdate.disabled = false;
			
			var domtabletwo= document.getElementById("tabletwo");
			domtabletwo.style.display="none";
			
			var domsubmitform= document.getElementById("submitform");
			domsubmitform.setAttribute("disabled", true);
			
			var domresetform= document.getElementById("resetform");
			domresetform.setAttribute("disabled", true);
			
			var domcheckAvailable= document.getElementById("checkAvailable");
			domcheckAvailable.disabled = false;
			
			var domreSearch = document.getElementById("reSearch");
			domreSearch.setAttribute("disabled", true);
			
			var domstatus = document.getElementById("reportid");
			domstatus.setAttribute("disabled", true);
						
			var disdescription = document.getElementById("disdescription");
			disdescription.setAttribute("disabled", true);

			var resdescription = document.getElementById("resdescription");
			resdescription.setAttribute("disabled", true);

			var desdescription = document.getElementById("desdescription");
			desdescription.setAttribute("disabled", true);

			var desattachment = document.getElementById("desattachment");
			desattachment.setAttribute("disabled", true);
			
			var disattachment = document.getElementById("disattachment");
			disattachment.setAttribute("disabled", true);
		}
		function openElement(){
			//var domdate = document.getElementById("publiclognumber");
			//domdate.setAttribute("disabled", true);
			
			var domtabletwo= document.getElementById("tabletwo");
			domtabletwo.style.display="";
			
			var domsubmitform= document.getElementById("submitform");
			domsubmitform.disabled = false;
			
			var domresetform= document.getElementById("resetform");
			domresetform.disabled = false;
			
			var domcheckAvailable= document.getElementById("checkAvailable");
			domcheckAvailable.setAttribute("disabled", true);
			
			var domreSearch = document.getElementById("reSearch");
			domreSearch.disabled = false;
			
			var domstatus = document.getElementById("reportid");
			domstatus.disabled = false;
						
			var disdescription = document.getElementById("disdescription");
			disdescription.disabled = false;

			var resdescription = document.getElementById("resdescription");
			resdescription.disabled = false;

			var desdescription = document.getElementById("desdescription");
			desdescription.disabled = false;

			var desattachment = document.getElementById("desattachment");
			desattachment.disabled = false;
			
			var disattachment = document.getElementById("disattachment");
			disattachment.disabled = false;
		}
		function initElement(){
			blockElement();
			var title = document.getElementById("title");
			var children = title.childNodes;	
			title.removeChild(children[0]);
			var investstatus = document.createElement("a");
			investstatus.innerHTML = "INVESTIGATION";
			title.appendChild(investstatus);
		
			var domreportid = document.getElementById("reportid");
			domreportid.value = "";

			var domdate = document.getElementById("date");
			domdate.value = "";

			var domstatus = document.getElementById("status");
			domstatus.value = "";
						
			var disdescription = document.getElementById("disdescription");
			disdescription.value = "";

			var resdescription = document.getElementById("resdescription");
			resdescription.value = "";

			var desdescription = document.getElementById("desdescription");
			desdescription.value = "";

			var desattachment = document.getElementById("desattachment");
			var decshow_del = document.getElementById("decshow");
			if(decshow_del!=null){
				desattachment.parentNode.removeChild(decshow_del);
			}
			
			var disattachment = document.getElementById("disattachment");
			var disshow_del = document.getElementById("disshow");
			if(disshow_del!=null){
				disattachment.parentNode.removeChild(disshow_del);
			}
		}
	</script>
	
  </head>
  
  <body>
  	<form action="jsp/NewInvestigationServlet" method="post" enctype="multipart/form-data" id="newinvestigation">
    	<table align = "left" border="1" id="tableone" style="border-collapse: collapse;">
    		<tr>
    			<td colspan="3" align = "center" id="title">INVESTIGATION</td>	
    		</tr>
    		<tr>
				<td colspan="3">
					PLN :<input type="text" name="publiclognumber" id="publiclognumber"/>		
					<input type="button" value="Check Available" onclick = "checkPLN()" id="checkAvailable"/>
					<input type="button" value="Reset" onclick ="initElement()" id="reSearch" disabled/>
					<br>
    				<label for="publiclognumber" class="error"></label>				
				</td>
			</tr>
		</table>
		<br><br><br><br>
		<table align = "left" border="1" id="tabletwo" style="border-collapse: collapse;display:none;">
    		<tr>
    			<td colspan="3" align = "center">Report</td> 
    		</tr>
    		<tr>
    			<td colspan="3" align = "left">
    			   	ReportID :<input type="text" value="" name="reportid" id="reportid" disabled>
    				Date :<input type="text" name="date" id="date" disabled>
    				Status :<input type="text" name="status" id="status" disabled>
    				<br>
    				<label for="reportid" class="error"></label>
    			</td> 
    		</tr>
    		<tr>
    			<td colspan="3" align = "center">DISPOSITION LETTER</td> 
    		</tr>
    		<tr style="display:none">
    			<td>
					DispositionID :
				</td> 
				<td colspan="2" align = "left">
					<input type="text" value="" name="dispositionid" id="dispositionid">
				</td> 
    		</tr>
    		<tr>
    			<td>
    				Description :			
    			</td> 	
    			<td colspan="2" align = "left">
    				<textarea style="width:100%;" name="disdescription" id="disdescription"></textarea>			
    			</td> 
			</tr>
			<tr>
				<td>
					Attachment :
				</td> 
				<td colspan="2" align = "left">
					<input type="file" name="disattachment" id="disattachment" disabled>
				</td>	
			</tr>
			<tr>
    			<td colspan="3" align = "center">AGENCY RESPONDS</td> 
    		</tr>
    		<tr style="display:none">
    			<td>
					RespondID :
				</td> 
				<td colspan="2" align = "left">
					<input type="text" value="" name="respondid" id="respondid">
				</td> 
    		</tr>
			<tr>
    			<td>
    				Description :			
    			</td> 	
    			<td colspan="2" align = "left">
    				<textarea style="width:100%;" name="resdescription" id="resdescription" disabled></textarea>
    				<br>
    				<label for="resdescription" class="error"></label>			
    			</td> 
			</tr>
    		<tr>
    			<td colspan="3" align = "center">DECISION LETTER</td> 
    		</tr>
    		<tr style="display:none">
    			<td>
					DecisionID :
				</td> 
				<td colspan="2" align = "left">
					<input type="text" value="" name="decisionid" id="decisionid">
				</td> 
    		</tr>
    		<tr>
    			<td>
    				Description :			
    			</td> 	
    			<td colspan="2" align = "left">
    				<textarea style="width:100%;" name="desdescription" id="desdescription" disabled></textarea>			
    			</td>  	
			</tr>
			<tr>
				<td>
					Attachment :
				</td> 
				<td colspan="2" align = "left">
					<input type="file" name="desattachment" id="desattachment" disabled>
				</td>
			</tr>
			<tr>
				<td colspan="3" align = "right">
					<input type="submit" value="Submit" id="submitform" disabled/>
               		<input type="reset" value="Reset" id="resetform" onclick ="initElement()" disabled/>
               		<input type="button" value="Return" onclick="gopath('firstpage.jsp')"/>   
				</td>
			</tr>
    	</table>
    </form>
  </body>
</html>
