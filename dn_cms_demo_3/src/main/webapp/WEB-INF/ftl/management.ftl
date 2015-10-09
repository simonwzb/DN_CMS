<html>
<head>
<title>DNCMS网站后台管理系统</title>
	<link href="${webRoot}styles/dwz/themes/default/style.css" rel="stylesheet" type="text/css">
	<link href="${webRoot}styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css">
	<link href="${webRoot}styles/dn_cms/css/misc.css" rel="stylesheet" type="text/css">
	<!--[if IE]>
	<link href="${webRoot}styles/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
	<![endif]-->

	<!--[if lte IE 9]>
	<script src="${webRoot}styles/dwz/js/speedup.js" type="text/javascript"></script>
	<![endif]-->

	<script src="${webRoot}styles/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/jquery.cookie.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
	
	<script src="${webRoot}styles/dwz/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.core.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.util.date.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.validate.method.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.barDrag.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.drag.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.tree.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.accordion.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.ui.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.theme.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.navTab.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.tab.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.resize.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.dialog.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.cssTable.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.stable.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.taskBar.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.ajax.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.pagination.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.database.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.datepicker.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.effects.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.panel.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.checkbox.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.history.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.combox.js" type="text/javascript"></script>
	<script src="${webRoot}styles/dwz/js/dwz.print.js" type="text/javascript"></script>

	<!-- 上线后用dwz.min.js替换前面全部dwz.*.js (注意：替换是下面dwz.regional.zh.js还需要引入)
	<script src="${webRoot}styles/dwz/bin/dwz.min.js" type="text/javascript"></script>
	-->
	<script src="${webRoot}styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		DWZ.init("${webRoot}styles/dwz/dwz.frag.xml", {
			loginUrl : "${webRoot}",
			loginTitle : "登录", // 弹出登录对话框
			//loginUrl:"login.html",	// 跳到登录页面
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",
				orderDirection : "orderDirection"
			}, //【可选】
			keys : {
				statusCode : "statusCode",
				message : "message"
			}, //【可选】
			ui : {
				hideMode : 'offsets'
			}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "${webRoot}styles/dwz/themes"
				}); // themeBase 相对于index页面的主题base路径
			}
		});
	});
	$.ajaxSetup({
		//用于清空浏览器临时缓存
		cache : false
	//设置成false将不会从浏览器缓存读取信息
	});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="javascript:;">标志</a>
				<ul class="nav">
					<li>管理员：<font color="red">${admin.loginId}</font></li>
					<li><a href="${webRoot}logout">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">blue</div></li>
					<li theme="green"><div>..</div></li>
					<li theme="purple"><div>..</div></li>
					<li theme="silver"><div>..</div></li>
					<li theme="azure"><div>..</div></li>
				</ul>
			</div>

			<!-- navMenu -->

		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>主菜单</h2>
					<div>收缩</div>
				</div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2>
							<span>Folder</span>内容管理
						</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="${webRoot}management/listAll" target="navTab"
								rel="repositery">文章库</a></li>
						</ul>
						<ul class="tree treeFolder">
							<li><a href="${webRoot}management/listAll" target="navTab">栏目</a>
								<ul>
									<li><a
										href="${webRoot}management/listAChannel?channel_id=0"
										target="navTab" rel="bbs">0.留言板</a></li>
									<li><a
										href="${webRoot}management/listAChannel?channel_id=1"
										target="navTab" rel="news">1.资讯</a></li>
									<li><a
										href="${webRoot}management/listAChannel?channel_id=2"
										target="navTab" rel="sport">2.体育</a></li>
									<li><a
										href="${webRoot}management/listAChannel?channel_id=3"
										target="navTab" rel="entertainment">3.娱乐</a></li>
									<li><a
										href="${webRoot}management/listAChannel?channel_id=4"
										target="navTab" rel="tech">4.科技</a></li>
									<li><a
										href="${webRoot}management/listAChannel?channel_id=5"
										target="navTab" rel="military">5.军事</a></li>
									<li><a
										href="${webRoot}management/listAChannel?channel_id=6"
										target="navTab" rel="vidio">6.视频</a></li>
									<li><a
										href="${webRoot}management/listAChannel?channel_id=7"
										target="navTab" rel="society">7.社会</a></li>
									<li><a
										href="${webRoot}management/listAChannel?channel_id=8"
										target="navTab" rel="car">8.汽车</a></li>
									<!--<li><a href="demo/common/ajaxTimeout.html" target="dialog">dialog会话超时</a></li>-->
									<li><a
										href="${webRoot}management/listAChannel?channel_id=9"
										target="navTab" rel="blog">9.博客</a></li>
								</ul></li>
					</div>
				</div>
			</div>
		</div>

		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span
										class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<p>
									<span>....</span>
								</p>
								<p>....</p>
							</div>
							<p>
								<span>DNCMS网站后台管理系统</span>
							</p>
							<p>By simonw &nbsp;simon.wei@live.cn</p>
						</div>
						<div class="pageFormContent" layoutH="80"
							style="margin-right: 230px">
							<p>..</p>


						</div>

						<!--<div style="width:230px;position: absolute;top:60px;right:0" layoutH="80">
							<iframe width="100%" height="430" class="share_self"  frameborder="0" scrolling="no" src="${webRoot}styles/dwz/http://widget.weibo.com/weiboshow/index.php?width=0&height=430&fansRow=2&ptype=1&skin=1&isTitle=0&noborder=1&isWeibo=1&isFans=0&uid=1739071261&verifier=c683dfe7"></iframe>
						</div>-->
					</div>

				</div>
			</div>
		</div>

	</div>

	<div id="footer">@ 2014 DNCMS网站后台管理系统. Work By simonw</div>


</body>
</html>