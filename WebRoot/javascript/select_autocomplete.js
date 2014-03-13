/*fix version
 *  ʵ�����ı����������ܣ��������ݽ�������
 */
function select_autocomplete(){
    this.pop_len = 10;
    this.pop_cn = 'autoDis';
    this.hover_cn = 'cur';
    this.source = '';
    //source:'13612345564|13825646464|13412236054|13012348564|13012345564|13012365564|��С|����|���๫|�ܻ���'.split('|'),

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
            if(e.keyCode == 38){                                        //����up��������
                if(self.pop.style.display != 'none'){
                    for(var i=0;i<lens;i++){                            //����������ݣ��ж��Ƿ�ѡ��
                        if(lis[i].className)
                            temp = i;
                        else
                            n--;
                    }
                    if(n==0){                                                //���û�б�ѡ�е�liԪ�أ���ѡ�����һ��
                        lis[lens-1].className = self.hover_cn;
                        this.value = lis[lens-1].innerHTML;
                    }else{                                                    //����б�ѡ�е�Ԫ�أ���ѡ����һ��Ԫ�ز���ֵ��input
                        if(lis[temp] == lis[0]){                        //���ѡ�е�Ԫ���ǵ�һ�����ӽڵ����������һ��ѡ��
                            lis[lens-1].className = self.hover_cn;
                            this.value = lis[lens-1].innerHTML;
                            lis[temp].className = '';
                        }else{                                                
                            lis[temp-1].className = self.hover_cn;
                            this.value = lis[temp-1].innerHTML;
                            lis[temp].className = '';
                        }
                    }
                }else                                                //���������û����ʾ��ִ�в������������ʾ������
                    self.insert(this);
            }else if(e.keyCode == 40){                     //down�������£�ԭ��ͬup��
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
            }else                                    //������µļ��Ȳ���up�ֲ���down��ôֱ��ȥƥ�����ݲ�����
                self.insert(this);
        };
        x.onblur = function(){                //����ӳٴ�������Ϊ���ʧȥ�����ʱ���ǵ��ѡ�����ݵ�ʱ��ᷢ�����޷���������¼�
            setTimeout(function(){self.pop.style.display='none';},300);
        };
        return this;
    };
    
    this.setDom=function(){
        var self = this;
        var dom = document.createElement('div'),frame=document.createElement('iframe'),ul=document.createElement('ul');
        document.body.appendChild(dom);
        with(frame){                                    //������ie6����סselectԪ��
            setAttribute('frameborder','0');
            setAttribute('scrolling','no');
            style.cssText='z-index:-1;position:absolute;left:0;top:0;';
        }
        with(dom){                                        //�Ե�����liԪ�ذ�onmouseover��onmouseover
            //className = this.pop_cn;
            className = 'autoDis';   //ֱ����this�����ã�������ֱ����autoDis��ʽ
            appendChild(frame);
            appendChild(ul);
            onmouseover  = function(e){            //��liԪ�ػ�û�м��ص�ʱ��Ͱ����������ͨ���ж�target�Ƿ���liԪ�ؽ��д���
                e = e || window.event;
                var target = e.srcElement || e.target;
                if(target.tagName == 'LI'){            //�����ʽǰ�Ȱ����е�li��ʽȥ���������õ���һ��͵���ķ�ʽ��û�е���дremoveClass����
                    for(var i=0,lis=self.pop.getElementsByTagName('li');i<lis.length;i++)
                        lis[i].className = '';
                    target.className=self.hover_cn;        //Ҳû��дaddClass������ֱ�Ӹ�ֵ��
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
        for(var i=0,leng=this.source.length;i<leng;i++){         //�ж�input�������Ƿ�������Դ�������һ��
            if(!!val&&val.length<=this.source[i].length&& this.source[i].substr(0,val.length) == val){
                bak.push(this.source[i]);
            }
        }
        if(bak.length == 0){                                                    //���û��ƥ������������ص�����
            this.pop.style.display='none';
            return false;
        }//��������㶨λ����֮ǰҲ����ѭ��offsetParent��������ie��ff�²��ܴ󣨿�����ʹ�÷�ʽ�����������Ը������getBoundingClientRect
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
	<p>��ʾ���������롰1����ͷ��</p>
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
    //source:'13612345564|13825646464|13412236054|13012348564|13012345564|13012365564|��С|����|���๫|�ܻ���'.split('|'),
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
            if(e.keyCode == 38){                                        //����up��������
                if(self.pop.style.display != 'none'){
                    for(var i=0;i<lens;i++){                            //����������ݣ��ж��Ƿ�ѡ��
                        if(lis[i].className)
                            temp = i;
                        else
                            n--;
                    }
                    if(n==0){                                                //���û�б�ѡ�е�liԪ�أ���ѡ�����һ��
                        lis[lens-1].className = self.hover_cn;
                        this.value = lis[lens-1].innerHTML;
                    }else{                                                    //����б�ѡ�е�Ԫ�أ���ѡ����һ��Ԫ�ز���ֵ��input
                        if(lis[temp] == lis[0]){                        //���ѡ�е�Ԫ���ǵ�һ�����ӽڵ����������һ��ѡ��
                            lis[lens-1].className = self.hover_cn;
                            this.value = lis[lens-1].innerHTML;
                            lis[temp].className = '';
                        }else{                                                
                            lis[temp-1].className = self.hover_cn;
                            this.value = lis[temp-1].innerHTML;
                            lis[temp].className = '';
                        }
                    }
                }else                                                //���������û����ʾ��ִ�в������������ʾ������
                    self.insert(this);
            }else if(e.keyCode == 40){                     //down�������£�ԭ��ͬup��
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
            }else                                    //������µļ��Ȳ���up�ֲ���down��ôֱ��ȥƥ�����ݲ�����
                self.insert(this);
        };
        x.onblur = function(){                //����ӳٴ�������Ϊ���ʧȥ�����ʱ���ǵ��ѡ�����ݵ�ʱ��ᷢ�����޷���������¼�
            setTimeout(function(){self.pop.style.display='none';},300);
        };
        return this;
    },
    setDom:function(){
        var self = this;
        var dom = document.createElement('div'),frame=document.createElement('iframe'),ul=document.createElement('ul');
        document.body.appendChild(dom);
        with(frame){                                    //������ie6����סselectԪ��
            setAttribute('frameborder','0');
            setAttribute('scrolling','no');
            style.cssText='z-index:-1;position:absolute;left:0;top:0;'
        }
        with(dom){                                        //�Ե�����liԪ�ذ�onmouseover��onmouseover
            className = this.pop_cn;
            appendChild(frame);
            appendChild(ul);
            onmouseover  = function(e){            //��liԪ�ػ�û�м��ص�ʱ��Ͱ����������ͨ���ж�target�Ƿ���liԪ�ؽ��д���
                e = e || window.event;
                var target = e.srcElement || e.target;
                if(target.tagName == 'LI'){            //�����ʽǰ�Ȱ����е�li��ʽȥ���������õ���һ��͵���ķ�ʽ��û�е���дremoveClass����
                    for(var i=0,lis=self.pop.getElementsByTagName('li');i<lis.length;i++)
                        lis[i].className = '';
                    target.className=self.hover_cn;        //Ҳû��дaddClass������ֱ�Ӹ�ֵ��
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
        for(var i=0,leng=this.source.length;i<leng;i++){         //�ж�input�������Ƿ�������Դ�������һ��
            if(!!val&&val.length<=this.source[i].length&& this.source[i].substr(0,val.length) == val){
                bak.push(this.source[i]);
            }
        }
        if(bak.length == 0){                                                    //���û��ƥ������������ص�����
            this.pop.style.display='none';
            return false;
        }//��������㶨λ����֮ǰҲ����ѭ��offsetParent��������ie��ff�²��ܴ󣨿�����ʹ�÷�ʽ�����������Ը������getBoundingClientRect
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

function deepCopy(p, c) {          // �ݹ����"ǳ����"
	var c = c || {};
	for (var i in p) { 
		if (typeof p[i]==='object') {  // ��ȵݹ鸴�Ƹ�����
			c[i] = (p[i].constructor === Array) ? [] : {};
			deepCopy(p[i], c[i]);
		} else c[i] = p[i];            // ��������ǳ����
	}
	return c;
}
//o = deepCopy(p);                   // ĿǰjQuery��ʹ�õļ̳з�����
//o.k = v;
// o.pk;                           // �����������Ѽ̳У��ɷ���
// old version useage
var ss = deepCopy(autoComplete);
ss.source ='eee|33333|cccccc|13012348564|13012345564|13012365564|ddd33232'.split('|');
ss.init().bind(document.getElementById('autoC'));
autoComplete.source ='222ssfd|13825646464|13412236054|13012348564|13012345564|13012365564|ddd33232'.split('|');
autoComplete.init().bind(document.getElementById('autoCom'));
*/