/**
 * browsercompatible
 * @param   beginYear           2014
 * @param   endYear             2014
 * @version 1.0 build 2014-03-08
 * @author  Yang (ycj@gmail.com)
 * --------------------------------------------------------
 */

function gopath(path){
	var userAgent = navigator.userAgent.toLowerCase(), s, o = {};  
    var browser={
        version:(userAgent.match(/(?:firefox|opera|safari|chrome|msie)[\/: ]([\d.]+)/))[1],
        safari:/version.+safari/.test(userAgent),
        chrome:/chrome/.test(userAgent),
        firefox:/firefox/.test(userAgent),
        ie:/msie/.test(userAgent),
        opera: /opera/.test(userAgent )
    } /* 获得浏览器的名称及版本信息 */
    //if (browser.ie && browser.version > 6)
    //{
      /* 判断是否为IE 6以上版本，是则执行以下操作 */
    //  document.writeln("<p>您使用的是IE "+browser.version+"<\/p>");
    //};
	        
	//test
	if(browser.ie) location.href(path);
	if(browser.firefox) location.href(path);
	if(browser.chrome) window.location.href="jsp/"+ path;
	if(browser.opera) location.href(path);
	if(browser.safari) window.location.href="jsp/"+ path;
}