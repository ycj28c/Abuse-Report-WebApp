/**
 * browsercompatible
 * @param   beginYear           2014
 * @param   endYear             2014
 * @version 1.0 build 2014-03-08
 * @author  Yang (ycj@gmail.com)
 * --------------------------------------------------------
 */

function gopath(path){
	var Sys = {};
	var ua = navigator.userAgent.toLowerCase();
	if (window.ActiveXObject)
		Sys.ie = ua.match(/msie ([\d.]+)/)[1]
	else if (document.getBoxObjectFor)
		Sys.firefox = ua.match(/firefox\/([\d.]+)/)[1]
	else if (window.MessageEvent && !document.getBoxObjectFor)
		Sys.chrome = ua.match(/chrome\/([\d.]+)/)[1]
	else if (window.opera)
		Sys.opera = ua.match(/opera.([\d.]+)/)[1]
	else if (window.openDatabase)
		Sys.safari = ua.match(/version\/([\d.]+)/)[1];
	        
	//test
	if(Sys.ie) location.href(path);
	if(Sys.firefox) location.href(path);
	if(Sys.chrome) window.location.href="jsp/"+ path;
	if(Sys.opera) location.href(path);
	if(Sys.safari) location.href(path);
}