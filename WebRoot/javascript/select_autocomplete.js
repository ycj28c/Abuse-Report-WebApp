/*fix version
 *  实现了文本的下拉框功能，根据内容进行搜索
 */
function select_autocomplete(){
    this.pop_len = 10;
    this.pop_cn = 'autoDis';
    this.hover_cn = 'cur';
    this.source = '';
    //source:'13612345564|13825646464|13412236054|13012348564|13012345564|13012365564|彭小|王达|李相公|周欢欢'.split('|'),

    this.init = function(){
        this.setDom();
        return this;
    };
    
    this.bind=function(x){
        if(x.getAttribute('type') != 'text' || x.nodeName != 'INPUT')
            return null;
        var self = this;
        x.onkeyup = function(e){
            e = e || window.event;
            var lis = self.pop.getElementsByTagName('li'),lens = self.pop.getElementsByTagName('li').length,n=lens,temp;
            if(e.keyCode == 38){                                        //键盘up键被按下
                if(self.pop.style.display != 'none'){
                    for(var i=0;i<lens;i++){                            //遍历结果数据，判断是否被选中
                        if(lis[i].className)
                            temp = i;
                        else
                            n--;
                    }
                    if(n==0){                                                //如果没有被选中的li元素，则选中最后一个
                        lis[lens-1].className = self.hover_cn;
                        this.value = lis[lens-1].innerHTML;
                    }else{                                                    //如果有被选中的元素，则选择上一个元素并赋值给input
                        if(lis[temp] == lis[0]){                        //如果选中的元素是第一个孩子节点则跳到最后一个选中
                            lis[lens-1].className = self.hover_cn;
                            this.value = lis[lens-1].innerHTML;
                            lis[temp].className = '';
                        }else{                                                
                            lis[temp-1].className = self.hover_cn;
                            this.value = lis[temp-1].innerHTML;
                            lis[temp].className = '';
                        }
                    }
                }else                                                //如果弹出层没有显示则执行插入操作，并显示弹出层
                    self.insert(this);
            }else if(e.keyCode == 40){                     //down键被按下，原理同up键
                if(self.pop.style.display != 'none'){
                    for(var i=0;i<lens;i++){
                        if(lis[i].className)
                            temp = i;
                        else
                            n--;
                    }
                    if(n==0){
                        lis[0].className = self.hover_cn;
                        this.value = lis[0].innerHTML;
                    }else{
                        if(lis[temp] == lis[lens-1]){
                            lis[0].className = self.hover_cn;
                            this.value = lis[0].innerHTML;
                            lis[temp].className = '';
                        }else{
                            lis[temp+1].className = self.hover_cn;
                            this.value = lis[temp+1].innerHTML;
                            lis[temp].className = '';
                        }
                    }
                }else
                    self.insert(this);
            }else                                    //如果按下的键既不是up又不是down那么直接去匹配数据并插入
                self.insert(this);
        };
        x.onblur = function(){                //这个延迟处理是因为如果失去焦点的时候是点击选中数据的时候会发现先无法触发点击事件
            setTimeout(function(){self.pop.style.display='none';},300);
        };
        return this;
    };
    
    this.setDom=function(){
        var self = this;
        var dom = document.createElement('div'),frame=document.createElement('iframe'),ul=document.createElement('ul');
        document.body.appendChild(dom);
        with(frame){                                    //用来在ie6下遮住select元素
            setAttribute('frameborder','0');
            setAttribute('scrolling','no');
            style.cssText='z-index:-1;position:absolute;left:0;top:0;';
        }
        with(dom){                                        //对弹出层li元素绑定onmouseover，onmouseover
            //className = this.pop_cn;
            className = 'autoDis';   //直接用this不好用，这里先直接用autoDis样式
            appendChild(frame);
            appendChild(ul);
            onmouseover  = function(e){            //在li元素还没有加载的时候就绑定这个方法，通过判断target是否是li元素进行处理
                e = e || window.event;
                var target = e.srcElement || e.target;
                if(target.tagName == 'LI'){            //添加样式前先把所有的li样式去掉，这里用的是一种偷懒的方式，没有单独写removeClass方法
                    for(var i=0,lis=self.pop.getElementsByTagName('li');i<lis.length;i++)
                        lis[i].className = '';
                    target.className=self.hover_cn;        //也没有写addClass方法，直接赋值了
                }
            };
            onmouseout = function(e){
                e = e || window.event;
                var target = e.srcElement || e.target;
                if(target.tagName == 'LI')
                    target.className='';
            };
        }
        this.pop = dom;
    };
    
    this.insert=function(self){
        var bak = [],s,li=[],left=0,top=0,val=self.value;
        for(var i=0,leng=this.source.length;i<leng;i++){         //判断input的数据是否与数据源里的数据一致
            if(!!val&&val.length<=this.source[i].length&& this.source[i].substr(0,val.length) == val){
                bak.push(this.source[i]);
            }
        }
        if(bak.length == 0){                                                    //如果没有匹配的数据则隐藏弹出层
            this.pop.style.display='none';
            return false;
        }//这个弹出层定位方法之前也是用循环offsetParent，但发现ie跟ff下差别很大（可能是使用方式不当），所以改用这个getBoundingClientRect
        left=self.getBoundingClientRect().left+document.documentElement.scrollLeft;
        top=self.getBoundingClientRect().top+document.documentElement.scrollTop+self.offsetHeight;
        with(this.pop){
            style.cssText = 'width:'+self.offsetWidth+'px;'+'position:absolute;left:'+left+'px;top:'+top+'px;display:none;';
            getElementsByTagName('iframe')[0].setAttribute('width',self.offsetWidth);
            getElementsByTagName('iframe')[0].setAttribute('height',self.offsetHeight);
            onclick = function(e){
                e = e || window.event;
                var target = e.srcElement || e.target;
                if(target.tagName == 'LI')
                    self.value = target.innerHTML;
                this.style.display='none';
            };
        }
        s = bak.length>this.pop_len?this.pop_len:bak.length;
        for(var i=0;i<s;i++)
            li.push( '<li>' + bak[i] +'</li>');
        this.pop.getElementsByTagName('ul')[0].innerHTML = li.join('');
        this.pop.style.display='block';
    };
};

/*fix version usage
function start(){
	//var ss = deepCopy(autoComplete);
	//ss.source ='eee|33333|cccccc|13012348564|13012345564|13012365564|ddd33232'.split('|');
	//ss.init().bind(document.getElementById('autoC'));
	autoComplete.source ='222ssfd|13825646464|13412236054|13012348564|13012345564|13012365564|ddd33232'.split('|');
	autoComplete.init().bind(document.getElementById('autoCom'));
}
</script>
</head>
<body onload = "start()">
<div id="wrap">
	<p>提示：可以输入“1”开头的</p>
	<input id="autoCom" type="text" class="txt">
	<input id="autoC" type="text" class="txt">
</div>
<input id="autoccc" type="text" onfocus="init();">

</body>
</html>
*/



/*old version
autoComplete={
    pop_len:10,
    pop_cn:'autoDis',
    hover_cn:'cur',
    source:'',
    //source:'13612345564|13825646464|13412236054|13012348564|13012345564|13012365564|彭小|王达|李相公|周欢欢'.split('|'),
    init:function(){
        this.setDom();
        return this;
    },
    bind:function(x){
        if(x.getAttribute('type') != 'text' || x.nodeName != 'INPUT')
            return null;
        var self = this;
        x.onkeyup = function(e){
            e = e || window.event;
            var lis = self.pop.getElementsByTagName('li'),lens = self.pop.getElementsByTagName('li').length,n=lens,temp;
            if(e.keyCode == 38){                                        //键盘up键被按下
                if(self.pop.style.display != 'none'){
                    for(var i=0;i<lens;i++){                            //遍历结果数据，判断是否被选中
                        if(lis[i].className)
                            temp = i;
                        else
                            n--;
                    }
                    if(n==0){                                                //如果没有被选中的li元素，则选中最后一个
                        lis[lens-1].className = self.hover_cn;
                        this.value = lis[lens-1].innerHTML;
                    }else{                                                    //如果有被选中的元素，则选择上一个元素并赋值给input
                        if(lis[temp] == lis[0]){                        //如果选中的元素是第一个孩子节点则跳到最后一个选中
                            lis[lens-1].className = self.hover_cn;
                            this.value = lis[lens-1].innerHTML;
                            lis[temp].className = '';
                        }else{                                                
                            lis[temp-1].className = self.hover_cn;
                            this.value = lis[temp-1].innerHTML;
                            lis[temp].className = '';
                        }
                    }
                }else                                                //如果弹出层没有显示则执行插入操作，并显示弹出层
                    self.insert(this);
            }else if(e.keyCode == 40){                     //down键被按下，原理同up键
                if(self.pop.style.display != 'none'){
                    for(var i=0;i<lens;i++){
                        if(lis[i].className)
                            temp = i;
                        else
                            n--;
                    }
                    if(n==0){
                        lis[0].className = self.hover_cn;
                        this.value = lis[0].innerHTML;
                    }else{
                        if(lis[temp] == lis[lens-1]){
                            lis[0].className = self.hover_cn;
                            this.value = lis[0].innerHTML;
                            lis[temp].className = '';
                        }else{
                            lis[temp+1].className = self.hover_cn;
                            this.value = lis[temp+1].innerHTML;
                            lis[temp].className = '';
                        }
                    }
                }else
                    self.insert(this);
            }else                                    //如果按下的键既不是up又不是down那么直接去匹配数据并插入
                self.insert(this);
        };
        x.onblur = function(){                //这个延迟处理是因为如果失去焦点的时候是点击选中数据的时候会发现先无法触发点击事件
            setTimeout(function(){self.pop.style.display='none';},300);
        };
        return this;
    },
    setDom:function(){
        var self = this;
        var dom = document.createElement('div'),frame=document.createElement('iframe'),ul=document.createElement('ul');
        document.body.appendChild(dom);
        with(frame){                                    //用来在ie6下遮住select元素
            setAttribute('frameborder','0');
            setAttribute('scrolling','no');
            style.cssText='z-index:-1;position:absolute;left:0;top:0;'
        }
        with(dom){                                        //对弹出层li元素绑定onmouseover，onmouseover
            className = this.pop_cn;
            appendChild(frame);
            appendChild(ul);
            onmouseover  = function(e){            //在li元素还没有加载的时候就绑定这个方法，通过判断target是否是li元素进行处理
                e = e || window.event;
                var target = e.srcElement || e.target;
                if(target.tagName == 'LI'){            //添加样式前先把所有的li样式去掉，这里用的是一种偷懒的方式，没有单独写removeClass方法
                    for(var i=0,lis=self.pop.getElementsByTagName('li');i<lis.length;i++)
                        lis[i].className = '';
                    target.className=self.hover_cn;        //也没有写addClass方法，直接赋值了
                }
            };
            onmouseout = function(e){
                e = e || window.event;
                var target = e.srcElement || e.target;
                if(target.tagName == 'LI')
                    target.className='';
            };
        }
        this.pop = dom;
    },
    insert:function(self){
        var bak = [],s,li=[],left=0,top=0,val=self.value;
        for(var i=0,leng=this.source.length;i<leng;i++){         //判断input的数据是否与数据源里的数据一致
            if(!!val&&val.length<=this.source[i].length&& this.source[i].substr(0,val.length) == val){
                bak.push(this.source[i]);
            }
        }
        if(bak.length == 0){                                                    //如果没有匹配的数据则隐藏弹出层
            this.pop.style.display='none';
            return false;
        }//这个弹出层定位方法之前也是用循环offsetParent，但发现ie跟ff下差别很大（可能是使用方式不当），所以改用这个getBoundingClientRect
        left=self.getBoundingClientRect().left+document.documentElement.scrollLeft;
        top=self.getBoundingClientRect().top+document.documentElement.scrollTop+self.offsetHeight;
        with(this.pop){
            style.cssText = 'width:'+self.offsetWidth+'px;'+'position:absolute;left:'+left+'px;top:'+top+'px;display:none;';
            getElementsByTagName('iframe')[0].setAttribute('width',self.offsetWidth);
            getElementsByTagName('iframe')[0].setAttribute('height',self.offsetHeight);
            onclick = function(e){
                e = e || window.event;
                var target = e.srcElement || e.target;
                if(target.tagName == 'LI')
                    self.value = target.innerHTML;
                this.style.display='none';
            };
        }
        s = bak.length>this.pop_len?this.pop_len:bak.length;
        for(var i=0;i<s;i++)
            li.push( '<li>' + bak[i] +'</li>');
        this.pop.getElementsByTagName('ul')[0].innerHTML = li.join('');
        this.pop.style.display='block';
    }
}

function deepCopy(p, c) {          // 递归调用"浅拷贝"
	var c = c || {};
	for (var i in p) { 
		if (typeof p[i]==='object') {  // 深度递归复制各属性
			c[i] = (p[i].constructor === Array) ? [] : {};
			deepCopy(p[i], c[i]);
		} else c[i] = p[i];            // 基本数据浅拷贝
	}
	return c;
}
//o = deepCopy(p);                   // 目前jQuery库使用的继承方法。
//o.k = v;
// o.pk;                           // 父对象属性已继承，可访问
// old version useage
var ss = deepCopy(autoComplete);
ss.source ='eee|33333|cccccc|13012348564|13012345564|13012365564|ddd33232'.split('|');
ss.init().bind(document.getElementById('autoC'));
autoComplete.source ='222ssfd|13825646464|13412236054|13012348564|13012345564|13012365564|ddd33232'.split('|');
autoComplete.init().bind(document.getElementById('autoCom'));
*/