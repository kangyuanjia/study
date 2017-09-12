//记录窗口中间内容展示区的高度，便于后面所欲iframe的统一控制
var centerHeight = 0;
var centerWidth = 0;
var isTreeChanged = false;
//进入首页默认初始化tab
$(function(){
	centerHeight = $("#welcomeTab").parent().height()-4;
	centerWidth = $("#welcomeTab").parent().width()-4;
	$('#centerTab').tabs({
		cache:false,
		onLoad:function(panel){
			panel.panel('options').title;
		},
		onBeforeClose:function(title,index) {
			if(title=="菜单管理"){
				if(isTreeChanged){
					$$.showJcdfMessager('提示消息','当前应用菜单结构已改变,请确认是否保存','warning');
					return false;
				}
			}
			return true;
		},
		onSelect:function(title,index) {
			if(title!="菜单管理"){
				if(isTreeChanged){
					var tab = $('#centerTab').tabs('getTab', title);
					var tbId = tab.attr("id");
					var tbIframe = $("#"+tbId+" iframe:first-child"); 
					var frameName = tbIframe.attr("name");
/*					$$.showJcdfConfirm("提示消息", "当前应用菜单结构已改变，是否保存?", 'window.frames["'+frameName+'"].saveMenuTree()');
*/					$('#centerTab').tabs('select', "菜单管理");
					$$.showJcdfMessager('提示消息','当前应用菜单结构已改变,请确认是否保存','warning');
				}
			}
		},		
		onUnselect:function(title,index){			
			
		},
	});
	
	bindTabEvent();  
    bindTabMenuEvent(); 
    
	getUserInfo();
	$("#sysMenu").accordion("add",{
		title:"基础图形 ",
		content:"<ul class='easyui-tree'>" +
					"<li>" +
						"<span>折线（面积）图</span>" +
						"<ul>" +
							"<li><a id='zhe1' link='getPage.action?page_name=echart/echart3' onclick=openNewTab('zhe1','折线图1') >折线图1</a></li>" +
							"<li><a id='zhe2' link='getPage.action?page_name=echart/echart5' onclick=openNewTab('zhe2','折线图2') >折线图2</a></li>"	+			
							"<li><a id='zhe3' link='getPage.action?page_name=echart/echart12' onclick=openNewTab('zhe3','折线图3') >折线图3</a></li>" +				
							"<li><a id='zhe4' link='getPage.action?page_name=echart/echart13' onclick=openNewTab('zhe4','折线图4') >折线图4</a></li>" +					
							"<li><a id='zhe5' link='getPage.action?page_name=echart/echart14' onclick=openNewTab('zhe5','堆积图1') >堆积图1</a></li>" +				
							"<li><a id='zhe6' link='getPage.action?page_name=echart/echart15' onclick=openNewTab('zhe6','堆积图2') >堆积图2</a></li>" +				
							"<li><a id='zhe7' link='getPage.action?page_name=echart/echart16' onclick=openNewTab('zhe7','不等距折线图1') >不等距折线图1</a></li>" +				
							"<li><a id='zhe8' link='getPage.action?page_name=echart/echart17' onclick=openNewTab('zhe8','不等距折线图2') >不等距折线图2</a></li>" +				
							"<li><a id='zhe9' link='getPage.action?page_name=echart/echart18' onclick=openNewTab('zhe9','面积图') >面积图</a></li>" +				
							"<li><a id='zhe10' link='getPage.action?page_name=echart/echart19' onclick=openNewTab('zhe10','自定义折线图') >自定义折线图</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>柱状（条形）图</span>" +
						"<ul>" +
							"<li><a id='zhu1' link='getPage.action?page_name=echart/echart1' onclick=openNewTab('zhu1','柱状图1') >柱状图1</a></li>" +
							"<li><a id='zhu2' link='getPage.action?page_name=echart/echart2' onclick=openNewTab('zhu2','柱状图2') >柱状图2</a></li>" +
							"<li><a id='zhu3' link='getPage.action?page_name=echart/echart20' onclick=openNewTab('zhu3','柱状图3') >柱状图3</a></li>" +
							"<li><a id='zhu4' link='getPage.action?page_name=echart/echart21' onclick=openNewTab('zhu4','堆积柱状图') >堆积柱状图</a></li>" +
							"<li><a id='zhu5' link='getPage.action?page_name=echart/echart22' onclick=openNewTab('zhu5','温度计式图表') >温度计式图表</a></li>" +
							"<li><a id='zhu6' link='getPage.action?page_name=echart/echart23' onclick=openNewTab('zhu6','瀑布图') >瀑布图</a></li>" +
							"<li><a id='zhu7' link='getPage.action?page_name=echart/echart24' onclick=openNewTab('zhu7','阶梯瀑布图') >阶梯瀑布图</a></li>" +
							"<li><a id='zhu8' link='getPage.action?page_name=echart/echart25' onclick=openNewTab('zhu8','多系列层叠') >多系列层叠</a></li>" +
							"<li><a id='zhu9' link='getPage.action?page_name=echart/echart26' onclick=openNewTab('zhu9','堆积条形图') >堆积条形图</a></li>" +
							"<li><a id='zhu10' link='getPage.action?page_name=echart/echart27' onclick=openNewTab('zhu10','多维条形图') >多维条形图</a></li>" +
							"<li><a id='zhu11' link='getPage.action?page_name=echart/echart28' onclick=openNewTab('zhu11','旋风条形图') >旋风条形图</a></li>" +
							"<li><a id='zhu12' link='getPage.action?page_name=echart/echart29' onclick=openNewTab('zhu12','旋风条形图2') >旋风条形图2</a></li>" +
							"<li><a id='zhu13' link='getPage.action?page_name=echart/echart30' onclick=openNewTab('zhu13','不等距柱形图') >不等距柱形图</a></li>" +
							"<li><a id='zhu14' link='getPage.action?page_name=echart/echart31' onclick=openNewTab('zhu14','搭配时间轴') >搭配时间轴</a></li>" +
							"<li><a id='zhu15' link='getPage.action?page_name=echart/echart32' onclick=openNewTab('zhu15','彩虹柱形图') >彩虹柱形图</a></li>" +
							"<li><a id='zhu16' link='getPage.action?page_name=echart/echart33' onclick=openNewTab('zhu16','多系列彩虹柱') >多系列彩虹柱</a></li>" +
							"<li><a id='zhu17' link='getPage.action?page_name=echart/echart34' onclick=openNewTab('zhu17','个性化柱状图') >个性化柱状图</a></li>"+
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>散点（气泡）图</span>" +
						"<ul>" +
							"<li><a id='san1' link='getPage.action?page_name=echart/echart35' onclick=openNewTab('san1','标准散点图') >标准散点图</a></li>" +
							"<li><a id='san2' link='getPage.action?page_name=echart/echart36' onclick=openNewTab('san2','标准气泡图') >标准气泡图</a></li>" +
							"<li><a id='san3' link='getPage.action?page_name=echart/echart37' onclick=openNewTab('san3','大规模散点图') >大规模散点图</a></li>" +
							"<li><a id='san4' link='getPage.action?page_name=echart/echart38' onclick=openNewTab('san4','类目散点图') >类目散点图</a></li>" +
							"<li><a id='san5' link='getPage.action?page_name=echart/echart39' onclick=openNewTab('san5','时间坐标') >时间坐标</a></li>" +
							"<li><a id='san6' link='getPage.action?page_name=echart/echart40' onclick=openNewTab('san6','搭配时间轴') >搭配时间轴</a></li>" +
							"<li><a id='san7' link='getPage.action?page_name=echart/echart41' onclick=openNewTab('san7','搭配值域漫游') >搭配值域漫游</a></li>" +
							"<li><a id='san8' link='getPage.action?page_name=echart/echart42' onclick=openNewTab('san8','个性化散点图') >个性化散点图</a></li>"+
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>K线图</span>" +
						"<ul>" +
							"<li><a id='K1' link='getPage.action?page_name=echart/echart43' onclick=openNewTab('K1','标准K线图') >标准K线图</a></li>" +
							"<li><a id='K2' link='getPage.action?page_name=echart/echart44' onclick=openNewTab('K2','个性化K线图') >个性化K线图</a></li>"+
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>饼（圆环）图</span>" +
						"<ul>" +
							"<li><a id='bing1' link='getPage.action?page_name=echart/echart45' onclick=openNewTab('bing1','标准饼图') >标准饼图</a></li>" +
							"<li><a id='bing2' link='getPage.action?page_name=echart/echart46' onclick=openNewTab('bing2','标准环形图') >标准环形图</a></li>" +
							"<li><a id='bing3' link='getPage.action?page_name=echart/echart47' onclick=openNewTab('bing3','嵌套饼图') >嵌套饼图</a></li>" +
							"<li><a id='bing4' link='getPage.action?page_name=echart/echart48' onclick=openNewTab('bing4','南丁格尔玫瑰图') >南丁格尔玫瑰图</a></li>" +
							"<li><a id='bing5' link='getPage.action?page_name=echart/echart49' onclick=openNewTab('bing5','环形饼图1') >环形饼图1</a></li>" +
							"<li><a id='bing6' link='getPage.action?page_name=echart/echart4' onclick=openNewTab('bing6','环形饼图2') >环形饼图2</a></li>" +
							"<li><a id='bing7' link='getPage.action?page_name=echart/echart50' onclick=openNewTab('bing7','搭配时间轴') >搭配时间轴</a></li>" +
							"<li><a id='bing8' link='getPage.action?page_name=echart/echart51' onclick=openNewTab('bing8','千层饼') >千层饼</a></li>" +
							"<li><a id='bing9' link='getPage.action?page_name=echart/echart52' onclick=openNewTab('bing9','个性化填充') >个性化填充</a></li>"+
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>雷达（面积）图</span>" +
						"<ul>" +
							"<li><a id='lei1' link='getPage.action?page_name=echart/echart53' onclick=openNewTab('lei1','标准雷达图') >标准雷达图</a></li>" +
							"<li><a id='lei2' link='getPage.action?page_name=echart/echart54' onclick=openNewTab('lei2','填充雷达图') >填充雷达图</a></li>" +
							"<li><a id='lei3' link='getPage.action?page_name=echart/echart55' onclick=openNewTab('lei3','多雷达图') >多雷达图</a></li>" +
							"<li><a id='lei4' link='getPage.action?page_name=echart/echart56' onclick=openNewTab('lei4','虫洞') >虫洞</a></li>" +
							"<li><a id='lei5' link='getPage.action?page_name=echart/echart57' onclick=openNewTab('lei5','个性化雷达图') >个性化雷达图</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>和弦图</span>" +
						"<ul>" +
							"<li><a id='he1' link='getPage.action?page_name=echart/echart58' onclick=openNewTab('he1','标准和弦图') >标准和弦图</a></li>" +
							"<li><a id='he2' link='getPage.action?page_name=echart/echart59' onclick=openNewTab('he2','多系列和弦图') >多系列和弦图</a></li>" +
							"<li><a id='he3' link='getPage.action?page_name=echart/echart60' onclick=openNewTab('he3','标准和弦图2') >标准和弦图2</a></li>" +
							"<li><a id='he4' link='getPage.action?page_name=echart/echart61' onclick=openNewTab('he4','非缎带和弦图') >非缎带和弦图</a></li>" +
							"<li><a id='he5' link='getPage.action?page_name=echart/echart62' onclick=openNewTab('he5','复杂关系网络') >复杂关系网络</a></li>" +
							"<li><a id='he6' link='getPage.action?page_name=echart/echart63' onclick=openNewTab('he6','个性化和弦图') >个性化和弦图</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>力导向布局图</span>" +
						"<ul>" +
							"<li><a id='li1' link='getPage.action?page_name=echart/echart64' onclick=openNewTab('li1','简单关系网络') >简单关系网络</a></li>" +
							"<li><a id='li2' link='getPage.action?page_name=echart/echart65' onclick=openNewTab('li2','树状关系网络') >树状关系网络</a></li>" +
							"<li><a id='li3' link='getPage.action?page_name=echart/echart66' onclick=openNewTab('li3','树状关系网络2') >树状关系网络2</a></li>" +
							"<li><a id='li4' link='getPage.action?page_name=echart/echart67' onclick=openNewTab('li4','复杂关系网络') >复杂关系网络</a></li>" +
							"<li><a id='li5' link='getPage.action?page_name=echart/echart68' onclick=openNewTab('li5','力导向布局') >力导向布局</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>仪表盘</span>" +
						"<ul>" +
							"<li><a id='yi1' link='getPage.action?page_name=echart/echart69' onclick=openNewTab('yi1','标准仪表盘1') >标准仪表盘1</a></li>" +
							"<li><a id='yi2' link='getPage.action?page_name=echart/echart70' onclick=openNewTab('yi2','标准仪表盘2') >标准仪表盘2</a></li>" +
							"<li><a id='yi3' link='getPage.action?page_name=echart/echart71' onclick=openNewTab('yi3','标准仪表盘3') >标准仪表盘3</a></li>" +
							"<li><a id='yi4' link='getPage.action?page_name=echart/echart72' onclick=openNewTab('yi4','多仪表盘1') >多仪表盘1</a></li>" +
							"<li><a id='yi5' link='getPage.action?page_name=echart/echart73' onclick=openNewTab('yi5','多仪表盘2') >多仪表盘2</a></li>" +
							"<li><a id='yi6' link='getPage.action?page_name=echart/echart74' onclick=openNewTab('yi6','个性化仪表盘') >个性化仪表盘</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>漏斗图</span>" +
						"<ul>" +
							"<li><a id='lou1' link='getPage.action?page_name=echart/echart75' onclick=openNewTab('lou1','标准漏斗图') >标准漏斗图</a></li>" +
							"<li><a id='lou2' link='getPage.action?page_name=echart/echart76' onclick=openNewTab('lou2','多漏斗图1') >多漏斗图1</a></li>" +
							"<li><a id='lou3' link='getPage.action?page_name=echart/echart77' onclick=openNewTab('lou3','多漏斗图2') >多漏斗图2</a></li>" +
							"<li><a id='lou4' link='getPage.action?page_name=echart/echart78' onclick=openNewTab('lou4','多漏斗图3') >多漏斗图3</a></li>" +
							"<li><a id='lou5' link='getPage.action?page_name=echart/echart79' onclick=openNewTab('lou5','个性化漏斗图') >个性化漏斗图</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>热力图</span>" +
						"<ul>" +
							"<li><a id='re1' link='getPage.action?page_name=echart/echart80' onclick=openNewTab('re1','热力图1') >热力图1</a></li>" +
							"<li><a id='re2' link='getPage.action?page_name=echart/echart81' onclick=openNewTab('re2','热力图2') >热力图2</a></li>" +
							"<li><a id='re3' link='getPage.action?page_name=echart/echart82' onclick=openNewTab('re3','热力图3') >热力图3</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>事件河流图</span>" +
						"<ul>" +
							"<li><a id='shi1' link='getPage.action?page_name=echart/echart83' onclick=openNewTab('shi1','事件河流图1') >事件河流图1</a></li>" +
							"<li><a id='shi2' link='getPage.action?page_name=echart/echart84' onclick=openNewTab('shi2','事件河流图2') >事件河流图2</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>韦恩图</span>" +
						"<ul>" +
							"<li><a id='wei1' link='getPage.action?page_name=echart/echart85' onclick=openNewTab('wei1','韦恩图') >韦恩图</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>矩形树图</span>" +
						"<ul>" +
							"<li><a id='ju1' link='getPage.action?page_name=echart/echart86' onclick=openNewTab('ju1','矩形树图1') >矩形树图1</a></li>" +
							"<li><a id='ju2' link='getPage.action?page_name=echart/echart87' onclick=openNewTab('ju2','矩形树图2') >矩形树图2</a></li>" +
							"<li><a id='ju3' link='getPage.action?page_name=echart/echart88' onclick=openNewTab('ju3','矩形树图3') >矩形树图3</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>树图</span>" +
						"<ul>" +
							"<li><a id='shu1' link='getPage.action?page_name=echart/echart89' onclick=openNewTab('shu1','树图1') >树图1</a></li>" +
							"<li><a id='shu2' link='getPage.action?page_name=echart/echart90' onclick=openNewTab('shu2','树图2') >树图2</a></li>" +
							"<li><a id='shu3' link='getPage.action?page_name=echart/echart91' onclick=openNewTab('shu3','个性化树图') >个性化树图</a></li>" +
						"</ul>" +
					"</li>" +
					"<li>" +
						"<span>字符云</span>" +
						"<ul>" +
							"<li><a id='zi1' link='getPage.action?page_name=echart/echart92' onclick=openNewTab('zi1','字符云') >字符云</a></li>" +
						"</ul>" +
					"</li>" +
				"</ul>"
	});
	
	$("#sysMenu").accordion("add",{
		title:"地图",
		content:"<ul class='easyui-tree'>" +
					"<li><a id='map1' link='getPage.action?page_name=echart/echart6' onclick=openNewTab('map1','地图1') >地图1</a></li>" +
					"<li><a id='map2' link='getPage.action?page_name=echart/echart7' onclick=openNewTab('map2','地图2') >地图2</a></li>" +
					"<li><a id='map3' link='getPage.action?page_name=echart/echart8' onclick=openNewTab('map3','地图3') >地图3</a></li>" +
					"<li><a id='map4' link='getPage.action?page_name=echart/echart9' onclick=openNewTab('map4','地图4') >地图4</a></li>" +
					"<li><a id='map5' link='getPage.action?page_name=echart/echart10' onclick=openNewTab('map5','地图5') >地图5</a></li>" +
					"<li><a id='map6' link='getPage.action?page_name=echart/echart11' onclick=openNewTab('map6','地图6') >地图6</a></li>" +
					"<li><a id='map7' link='getPage.action?page_name=echart/echart115' onclick=openNewTab('map7','地域选择') >地域选择</a></li>" +
					"<li><a id='map8' link='getPage.action?page_name=echart/echart116' onclick=openNewTab('map8','世界地图值域漫游') >世界地图值域漫游</a></li>" +
					"<li><a id='map9' link='getPage.action?page_name=echart/echart117' onclick=openNewTab('map9','世界地域选择') >世界地域选择</a></li>" +
					"<li><a id='map10' link='getPage.action?page_name=echart/echart118' onclick=openNewTab('map10','区县地图') >区县地图</a></li>" +
					"<li><a id='map11' link='getPage.action?page_name=echart/echart119' onclick=openNewTab('map11','JSON扩展地图1') >JSON扩展地图1</a></li>" +
					"<li><a id='map12' link='getPage.action?page_name=echart/echart120' onclick=openNewTab('map12','JSON扩展地图2') >JSON扩展地图2</a></li>" +
					"<li><a id='map13' link='getPage.action?page_name=echart/echart121' onclick=openNewTab('map13','JSON扩展地图3') >JSON扩展地图3</a></li>" +
					"<li><a id='map14' link='getPage.action?page_name=echart/echart122' onclick=openNewTab('map14','地图标线') >地图标线</a></li>" +
					"<li><a id='map15' link='getPage.action?page_name=echart/echart123' onclick=openNewTab('map15','地图标注') >地图标注</a></li>" +
					"<li><a id='map16' link='getPage.action?page_name=echart/echart124' onclick=openNewTab('map16','子区域模式') >子区域模式</a></li>" +
					"<li><a id='map17' link='getPage.action?page_name=echart/echart125' onclick=openNewTab('map17','炫光弧线') >炫光弧线</a></li>" +
					"<li><a id='map18' link='getPage.action?page_name=echart/echart126' onclick=openNewTab('map18','炫光直线') >炫光直线</a></li>" +
					"<li><a id='map19' link='getPage.action?page_name=echart/echart127' onclick=openNewTab('map19','大规模线') >大规模线</a></li>" +
					"<li><a id='map20' link='getPage.action?page_name=echart/echart128' onclick=openNewTab('map20','大规炫光') >大规炫光</a></li>" +
					"<li><a id='map21' link='getPage.action?page_name=echart/echart129' onclick=openNewTab('map21','人体图') >人体图</a></li>" +
					"<li><a id='map22' link='getPage.action?page_name=echart/echart130' onclick=openNewTab('map22','足球场') >足球场</a></li>" +
					"<li><a id='map23' link='getPage.action?page_name=echart/echart131' onclick=openNewTab('map23','室内空间') >室内空间</a></li>" +
					"<li><a id='map24' link='getPage.action?page_name=echart/echart132' onclick=openNewTab('map24','时空维度扩展') >时空维度扩展</a></li>" +
					"<li><a id='map25' link='getPage.action?page_name=echart/echart133' onclick=openNewTab('map25','还原世界杯') >还原世界杯</a></li>" +
					"<li><a id='map26' link='getPage.action?page_name=echart/echart134' onclick=openNewTab('map26','个性化填充') >个性化填充</a></li>" +
					"<li><a id='map27' link='getPage.action?page_name=echart/echart135' onclick=openNewTab('map27','值域控件自定义') >值域控件自定义</a></li>" +
					"<li><a id='map28' link='getPage.action?page_name=echart/echart136' onclick=openNewTab('map28','百度地图扩展1') >百度地图扩展1</a></li>" +
					"<li><a id='map29' link='getPage.action?page_name=echart/echart137' onclick=openNewTab('map29','百度地图扩展2') >百度地图扩展2</a></li>" +
				"</ul>"
	});
	$("#sysMenu").accordion("add",{
		title:"混搭 ",
		content:"<ul class='easyui-tree'>" +
					"<li><a id='hun1' link='getPage.action?page_name=echart/echart93' onclick=openNewTab('hun1','折柱混搭1') >折柱混搭1</a></li>" +
					"<li><a id='hun2' link='getPage.action?page_name=echart/echart94' onclick=openNewTab('hun2','折柱混搭2') >折柱混搭2</a></li>" +
					"<li><a id='hun3' link='getPage.action?page_name=echart/echart95' onclick=openNewTab('hun3','柱状饼混搭') >柱状饼混搭</a></li>" +
					"<li><a id='hun4' link='getPage.action?page_name=echart/echart96' onclick=openNewTab('hun4','折线散点混搭') >折线散点混搭</a></li>" +
					"<li><a id='hun5' link='getPage.action?page_name=echart/echart97' onclick=openNewTab('hun5','散饼图') >散饼图</a></li>" +
					"<li><a id='hun6' link='getPage.action?page_name=echart/echart98' onclick=openNewTab('hun6','折线K线混搭') >折线K线混搭</a></li>" +
					"<li><a id='hun7' link='getPage.action?page_name=echart/echart99' onclick=openNewTab('hun7','折线饼图混搭') >折线饼图混搭</a></li>" +
					"<li><a id='hun8' link='getPage.action?page_name=echart/echart100' onclick=openNewTab('hun8','地图饼图混搭') >地图饼图混搭</a></li>" +
					"<li><a id='hun9' link='getPage.action?page_name=echart/echart101' onclick=openNewTab('hun9','多图联动1') >多图联动1</a></li>" +
					"<li><a id='hun10' link='getPage.action?page_name=echart/echart102' onclick=openNewTab('hun10','多图联动2') >多图联动2</a></li>" +
					"<li><a id='hun11' link='getPage.action?page_name=echart/echart103' onclick=openNewTab('hun11','仪表漏斗图') >仪表漏斗图</a></li>" +
				"</ul>"
	});
	$("#sysMenu").accordion("add",{
		title:"组件定制 ",
		content:"<ul class='easyui-tree'>" +
		"<li><a id='zu1' link='getPage.action?page_name=echart/echart104' onclick=openNewTab('zu1','坐标系') >坐标系</a></li>" +
		"<li><a id='zu2' link='getPage.action?page_name=echart/echart105' onclick=openNewTab('zu2','图例') >图例</a></li>" +
		"<li><a id='zu3' link='getPage.action?page_name=echart/echart106' onclick=openNewTab('zu3','数据区域缩放') >数据区域缩放</a></li>" +
		"<li><a id='zu4' link='getPage.action?page_name=echart/echart107' onclick=openNewTab('zu4','数据区域控件') >数据区域控件</a></li>" +
		"<li><a id='zu5' link='getPage.action?page_name=echart/echart108' onclick=openNewTab('zu5','提示框') >提示框</a></li>" +
		"<li><a id='zu6' link='getPage.action?page_name=echart/echart109' onclick=openNewTab('zu6','值域控件') >值域控件</a></li>" +
		"</ul>"
	});
	$("#sysMenu").accordion("add",{
		title:"其他 ",
		content:"<ul class='easyui-tree'>" +
		"<li><a id='qi1' link='getPage.action?page_name=echart/echart110' onclick=openNewTab('qi1','动态数据1') >动态数据1</a></li>" +
		"<li><a id='qi2' link='getPage.action?page_name=echart/echart111' onclick=openNewTab('qi2','动态数据2') >动态数据2</a></li>" +
		"<li><a id='qi3' link='getPage.action?page_name=echart/echart112' onclick=openNewTab('qi3','动态数据3') >动态数据3</a></li>" +
		"<li><a id='qi4' link='getPage.action?page_name=echart/echart113' onclick=openNewTab('qi4','过渡动画') >过渡动画</a></li>" +
		"<li><a id='qi5' link='getPage.action?page_name=echart/echart114' onclick=openNewTab('qi5','事件交互') >事件交互</a></li>" +
		"</ul>"
	});
	/*$("#sysMenu").accordion("add",{
		title:"3D地图 ",
		content:"<ul class='easyui-tree'>" +
		"<li><a id='3D1' link='getPage.action?page_name=echart/echart138' onclick=openNewTab('3D1','3D地图') >3D地图</a></li>" +
		"</ul>"
	});*/
});

function generateMenu(menus){
	var lis="";
	for(var i=0;i<menus.length;i++){
		if(menus[i].type=="F"&&menus[i].level==0){
			var iconCls = "";
			if(menus[i].name=="应用与职位"){
				iconCls = "icon-app";
			}else if(menus[i].name=="用户与授权"){
				iconCls = "icon-group-key";
			}else if(menus[i].name=="批量导入"){
				iconCls = "icon-upload";
			}else if(menus[i].name=="统计查询"){
				iconCls = "icon-report";
			}else if(menus[i].name=="接口管理"){
				iconCls = "icon-it";
			}else if(menus[i].name=="日志查询"){
				iconCls = "icon-log";
			}else if(menus[i].name=="系统管理"){
				iconCls = "icon-set";
			}else if(menus[i].name=="帮助"){
				iconCls = "icon-help";
			}
			$("#sysMenu").accordion("add",{
				title:menus[i].name,
				iconCls:iconCls,
				content:"<ul class='easyui-tree'>"+
				generateMenu(menus[i].menus)+
				"</ul></div>"
			});
		} else if(menus[i].type=="F"){
			lis+="<span>"+menus[i].name+"</span><ul>"+generateMenu(menus[i].menus)+"</ul>";
		}else if(menus[i].type=="A"){
			lis+="<li>"+
			"<a id="+menus[i].id+" link="+menus[i].url+" onclick=openNewTab('"+menus[i].id+"','"+menus[i].name+"') >"+menus[i].name+"</a>"+
		    "</li>";
		}
	}
	return lis;
};

//绑定tab的双击事件、右键事件  
function bindTabEvent(){  
    $(".tabs-inner").live('dblclick',function(){  
        var subtitle = $(this).children("span").text();  
        if($(this).next().is('.tabs-close')){  
            $('#centerTab').tabs('close',subtitle);  
        }  
    });  
    $(".tabs-inner").live('contextmenu',function(e){  
        $('#mm').menu('show', {  
            left: e.pageX,  
            top: e.pageY  
     });  
     var subtitle =$(this).children("span").text();  
     $('#mm').data("currtab",subtitle);  
     $('#centerTab').tabs('select', subtitle);
     return false;  
    });  
 } 

//绑定tab右键菜单事件  
function bindTabMenuEvent() {  
    //关闭当前  
    $('#mm-tabclose').click(function() {  
        var currtab_title = $('#mm').data("currtab");  
        if (currtab_title!="欢迎页面") {  
            $('#centerTab').tabs('close', currtab_title);  
        }  
    });  
    //全部关闭  
    $('#mm-tabcloseall').click(function() {  
        $('.tabs-inner span').each(function(i, n) {  
            if ($(this).parent().next().is('.tabs-close')) {  
                var t = $(n).text();  
                $('#centerTab').tabs('close', t);  
            }  
        });  
    });  
    //关闭除当前之外的TAB  
    $('#mm-tabcloseother').click(function() {  
        var currtab_title = $('#mm').data("currtab");  
        $('.tabs-inner span').each(function(i, n) {  
            if ($(this).parent().next().is('.tabs-close')) {  
                var t = $(n).text();  
                if (t != currtab_title)  
                    $('#centerTab').tabs('close', t);  
            }  
        });  
    });  
    //关闭当前右侧的TAB  
    $('#mm-tabcloseright').click(function() {  
        var nextall = $('.tabs-selected').nextAll();  
        if (nextall.length == 0) {  
            alert('已经是最后一个了');  
            return false;  
        }  
        nextall.each(function(i, n) {  
            if ($('a.tabs-close', $(n)).length > 0) {  
                var t = $('a:eq(0) span', $(n)).text();  
                $('#centerTab').tabs('close', t);  
            }  
        });  
        return false;  
    });  
    //关闭当前左侧的TAB  
    $('#mm-tabcloseleft').click(function() {  
        var prevall = $('.tabs-selected').prevAll();  
        if (prevall.length == 1) {  
            alert('已经是第一个了');  
            return false;  
        }  
        prevall.each(function(i, n) {  
            if ($('a.tabs-close', $(n)).length > 0) {  
                var t = $('a:eq(0) span', $(n)).text();  
                $('#centerTab').tabs('close', t);  
            }  
        });  
        return false;  
    });  
}  

//以tab的形式打开一个模块
var index = 0;
function openNewTab(id, title){
	if(isTreeChanged){
		$$.showJcdfMessager('提示消息','当前应用菜单结构已改变,请确认是否保存','warning');
	}else{
		index = index+1;
//		var title = $("#"+id).text();
		var href = $("#"+id).attr("link");
		if ($('#centerTab').tabs('exists',title)){
			$('#centerTab').tabs('select', title);
		} else {
			$('#centerTab').tabs('add',{
				id:id,
				title:title,
				content:'<iframe id="" name="'+title+'" width="100%" height="'+centerHeight+'" src="'+href+'" frameborder="0" scrolling="auto" marginheight="0" marginwidth="0"></iframe>',
				closable:true,
			});
		}
	}
}

function openNewTab2(id,title,href){
	index = index+1;
	if ($('#centerTab').tabs('exists',title)){
		var tab = $('#centerTab').tabs('getTab',title);
		$('#centerTab').tabs('update',{
			tab: tab,
			options:{
				content:'<iframe id="" name="'+title+'" width="100%" height="'+centerHeight+'" src="'+href+'" frameborder="0" scrolling="auto" marginheight="0" marginwidth="0"></iframe>',
				selected:true,
			}
		});
		$('#centerTab').tabs('select',title);
	} else {
		$('#centerTab').tabs('add',{
			id:id,
			title:title,
			content:'<iframe id="" name="'+title+'" width="100%" height="'+centerHeight+'" src="'+href+'" frameborder="0" scrolling="auto" marginheight="0" marginwidth="0"></iframe>',
			closable:true,
		});
	}
}
//打开对话框
var sonFrameName = null;
function jcdfDialog(frameName, href, title, maxHeight, maxWidth, widthRate) {
	sonFrameName = frameName;
	var dialogDiv = $("#jcdfDiglogDiv");
	if(!dialogDiv || dialogDiv.length <= 0) {
		var html = '<div id="jcdfDiglogDiv" style="display: none;">'+
			'<iframe id="jcdfDiglogDivIframe" name="jcdfDiglogDivIframe" width="100%" height="200" src="" frameborder="0" scrolling="auto" marginheight="0" marginwidth="0"></iframe>'+
			'</div>';
		$("body").append(html);
	}
	$("#jcdfDiglogDivIframe").attr('src', href);
	$('#jcdfDiglogDiv').css('display','');
	$('#jcdfDiglogDiv').dialog({
		title:title,
		modal:true,
		maximizable:true,
		resizable:true,
		closed: false,
		cache: false,
		onOpen:function() {
			$$.fillDialogWidthAndHeight("jcdfDiglogDiv", widthRate, maxHeight, maxWidth);
			$("#jcdfDiglogDivIframe").height($("#jcdfDiglogDivIframe").parent().height()-4);
		},
		onResize:function() {
			$("#jcdfDiglogDivIframe").height($("#jcdfDiglogDivIframe").parent().height()-4);
		},
		onClose:function() {
			window.frames["jcdfDiglogDivIframe"].document.body.innerHtml=""; 
			$("#jcdfDiglogDivIframe").attr('src', 'about:blank');
		}
	});
}
//刷新
function refreshJcdfDatagrid(datagridId, type){
	window.frames[sonFrameName].$$.refreshJcdfDatagrid(datagridId);
}
//关闭窗口
function closeJcdfDialog() {
	$('#jcdfDiglogDiv').dialog('close');
}
//弹出消息提示框
function showJcdfMessager(frameName, title, msg, icon, fn) {
	title = !title ? "提示消息" : title;
	msg = !msg ? "?":msg;
	icon = !icon ? "info":icon;
	$.messager.alert(title, msg, icon, function(){
		if(fn)eval('window.frames["'+frameName+'"].'+fn);
	});	
}
//弹出确认消息框
function showJcdfConfirm(frameName, title, msg, fn, fnCanel) {
	title = !title ? "确认" : title;
	msg = !msg ? "?" : msg;
	$.messager.confirm(title, msg, function(r){
		if (r && fn){
			eval('window.frames["'+frameName+'"].'+fn);
		}else if(fnCanel){
			eval('window.frames["'+frameName+'"].'+fnCanel);
		}
	});
}
//回调函数
function invokeParentMethod(fn, args) {
	var argsStr = "";
	var methodStr = "";
	if (arguments.length > 1) {
		for (var i = 1; i < arguments.length; i=i+1) {
			argsStr = argsStr ? argsStr+',"'+arguments[i]+'"' : '"'+arguments[i]+'"';
		}
		if (argsStr) {
			methodStr = arguments[0]+"("+argsStr+")";
		} else {
			methodStr = methodStr[0];
		}
		eval('window.frames["'+sonFrameName+'"].'+methodStr);
	}
}

/**
 *	系统密码修改和退出功能控制
 */	
$(function(){
	//退出系统
	$("#logout").bind('click', function(){
		if(isTreeChanged){
			$$.showJcdfMessager('提示消息','当前应用菜单结构已改变,请确认是否保存','warning');
		}else{
			window.top.$.messager.confirm('提示消息', "确定退出?", function(r){
				if (r) {
					$.ajax({
					   type: "POST",
					   url: "logout.action",
					   dataType:"json",
					   success: function(data){
					     if (data!=null && data.errorCode==0) {
							window.location = "index.action";
						 } else {
							$$.showJcdfMessager('提示消息',data.msg,'warning');
						 }
					   },
					});
				}
			});
		}
	});
	
	//修改密码
	$("#changePass").bind('click', function(){
		openChangePassDialog();
	});
	
});

/**
 *	弹出密码修改窗口
 */
function openChangePassDialog() {
	$('#changePassDialog').css('display','');
	$$.resetContent("changePassForm");
	$('#changePassDialog').dialog({
		title:'修改密码',
		modal:true,
		width:480,
		height:280,
		buttons:[{
			text:'修改',
			iconCls:'icon-ok',
			handler:function() {
				submitChangePass();
			}
		},{ 
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){
				$('#changePassDialog').dialog('close');
			}
		}]
	});
}

/**
 * 保存新密码
 */
function submitChangePass() {
	if(!$("#changePassForm").form('validate')){
      return false;
    }
	var pass = $$.serializeToJson("#changePassForm");
	if (!pass)return false;
	pass['oldPass'] = encodeURIComponent(b64_md5(pass['oldPass']));
	pass['newPass'] = encodeURIComponent(b64_md5(pass['newPass']));
	pass['confirmNewPass'] = encodeURIComponent(b64_md5(pass['confirmNewPass']));
	//如果数据验证通过(即数据合法)
	$$.openProcessingDialog();
	//ajax提交数据
	$.ajax({type: "POST",url: "auth/user.do?method=changePass",cache:false,dataType:"json",data:pass,
	   success: function(data){
	   	 $$.closeProcessingDialog();
	     if (null != data && data.result) {
	     	$('#changePassDialog').dialog('close');
	     	alert(data.msg);
			window.location = basePath+"/login.do?method=loginOut";
		 } else {
			$.messager.alert('提示消息',data.msg,'warning');
		 }
	   }
	});
}

function getUserInfo() {
	/*$.ajax({
		type : "POST",
		url : "actions/inner/user/getUser.action",
		cache : false,
		dataType : "json",
		success : function(data) {
			if (null != data && data.result && data.userData!=null) {
				var userData = data.userData;
				sessionStorage.setItem("userData",JSON.stringify(userData)); 
				$("#userName").html(userData.userName);
				$("#loginTime").html(data.loginTime);
				$("#userAdminNames").html("|"+userData.userAdminNames);		
				generateMenu(userData.menus);
			    $('#sysMenu').accordion('select', 0);
			} 
		}
	});*/
	$.ajax({
		type : "POST",
		url : "getUser.action",
		cache : false,
		dataType : "json",
		success : function(data) {
			if (null != data && data.errorCode == 0) {
				var userData = data.data;
				sessionStorage.setItem("userData",JSON.stringify(userData)); 
				$("#userName").html(userData.userName);
				$("#loginTime").html(userData.userPwd);
				/*$("#userAdminNames").html("|"+userData.userAdminNames);		
				generateMenu(userData.menus);*/
				$('#sysMenu').accordion('select', 0);
			} 
		}
	});
}