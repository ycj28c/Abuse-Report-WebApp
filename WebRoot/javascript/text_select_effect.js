function init() {
if (arrList.constructor!=Array){alert('smanPromptList初始化失败:第一个参数非数组!');return ;}
    arrList.sort( function(a, b) {
    if(a.length>b.length)return 1;
    else if(a.length==b.length)return a.localeCompare(b);
    else return -1;
        }
    ); 
}

function smanPromptList(arrList,objInputId){
        var objouter=document.getElementById("__smanDisp") //显示的DIV对象
        var objInput = document.getElementById(objInputId); //文本框对象
        var selectedIndex=-1;
        var intTmp; //循环用的:)

        if (objInput==null) {alert('smanPromptList初始化失败:没有找到"'+objInputId+'"文本框');return ;}
            //文本框失去焦点
            objInput.onblur=function(){
                objouter.style.display='none';
            }
            //文本框按键抬起
            objInput.onkeyup=checkKeyCode;
            //文本框得到焦点
            objInput.onfocus=checkAndShow;
            function checkKeyCode(){
                var ie = (document.all)? true:false
                if (ie){
                    var keyCode=event.keyCode
                    if (keyCode==40||keyCode==38){ //下上
                        var isUp=false
                        if(keyCode==40) isUp=true ;
                        chageSelection(isUp)
                    }else if (keyCode==13){//回车
                        outSelection(selectedIndex);
                    }else{
                        checkAndShow()
                    }
                }else{
                    checkAndShow()
                }
                divPosition()
            }

            function checkAndShow(){
                        var strInput = objInput.value
                        if (strInput!=""){
                            divPosition();
                            selectedIndex=-1;
                            objouter.innerHTML ="";
                            for (intTmp=0;intTmp<arrList.length;intTmp++){

                               //这个循环控制如果是匹配的就模糊显示出来，如果要全部显示则去掉这个if即可全部显示！
                                if (arrList[intTmp].substr(0, strInput.length).toUpperCase()==strInput.toUpperCase()){
                                    addOption(arrList[intTmp]);
                                }
                            }
                            objouter.style.display='';
                        }else{
                            objouter.style.display='none';
                    }
                    function addOption(value){
                        objouter.innerHTML +="<div onmouseover=\"this.className='sman_selectedStyle'\" onmouseout=\"this.className=''\" onmousedown=\"document.getElementById('"+objInputId+"').value='" + value + "'\">" + value + "</div>"    
                    }
            }
            function chageSelection(isUp){
                if (objouter.style.display=='none'){
                    objouter.style.display='';
                }else{
                    if (isUp)
                        selectedIndex++
                    else
                        selectedIndex--
                }
                var maxIndex = objouter.children.length-1;
                if (selectedIndex<0){selectedIndex=0}
                if (selectedIndex>maxIndex) {selectedIndex=maxIndex}
                for (intTmp=0;intTmp<=maxIndex;intTmp++){

                    if (intTmp==selectedIndex){
                        objouter.children[intTmp].className="sman_selectedStyle";
                    }else{
                        objouter.children[intTmp].className="";
                    }
                }
            }
            function outSelection(Index){
                objInput.value = objouter.children[Index].innerText;
                objouter.style.display='none';
            }
            function divPosition(){
                objouter.style.top    =getAbsoluteHeight(objInput)+getAbsoluteTop(objInput);
                objouter.style.left    =getAbsoluteLeft(objInput); 
                objouter.style.width=getAbsoluteWidth(objInput)
            }
    }
    document.write("<div id='__smanDisp' style='position:absolute;display:none;background:#E8F7EB;border: 1px solid #CCCCCC;font-size:14px;cursor: default;' onbulr> </div>");
    document.write("<style>.sman_selectedStyle{background-Color:#102681;color:#FFFFFF}</style>");
    function getAbsoluteHeight(ob){
        return ob.offsetHeight
    }
    function getAbsoluteWidth(ob){
        return ob.offsetWidth
    }
    function getAbsoluteLeft(ob){
        var mendingLeft = ob .offsetLeft;

                  mendingLeft += ob .offsetParent.offsetLeft;
            mendingOb = ob.offsetParent;
              return mendingLeft ;
    }
    function getAbsoluteTop(ob){
        var mendingTop = ob.offsetTop;
                    mendingTop += ob .offsetParent.offsetTop;
            ob = ob .offsetParent;
             return mendingTop ;
    }

/* the useage
<script language="javascript">
var intIndex=0;arrList = new Array();
arrList[intIndex++] = "www.flyso.net";
arrList[intIndex++] = "flyso@163.com";
arrList[intIndex++] = "b22dsafsdf";
arrList[intIndex++] = "c333asdfsadf";
arrList[intIndex++] = "4444dsafasdf";
arrList[intIndex++] = "dddsfddsafdsaf";
arrList[intIndex++] = "121213dsafsdaf";
arrList[intIndex++] = "43213asdfadsf";
arrList[intIndex++] = "www.flyso.net";
arrList[intIndex++] = "a213";
arrList[intIndex++] = "323313";
arrList[intIndex++] = "3213";
arrList[intIndex++] = "32213";
arrList[intIndex++] = "dsfsdddd";
arrList[intIndex++] = "ds11dfsfd";
arrList[intIndex++] = "ffdafd";
arrList[intIndex++] = "afdfd";
arrList[intIndex++] = "afd";
arrList[intIndex++] = "baffad";
arrList[intIndex++] = "2fda2fd";
arrList[intIndex++] = "dasd";

function test() {
    init();
    smanPromptList(arrList,"aspx")
    smanPromptList(arrList,"aspx2")
    smanPromptList(arrList,"inputer")
}
</script>
<body onload="test()">
</body>
请输入内容：
<input type="text" id="inputer"> 如 a 
<br>
<font color="red">
一个文本框的下拉提示
</font>

多个文本框的下拉提示<br>
<input type="text" id="aspx"><br>

<input type="text" id="aspx2"><br>*/