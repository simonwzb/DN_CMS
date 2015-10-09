<HTML>
<HEAD>
<TITLE>DNCMS后台管理登录</TITLE>
<script src="${webRoot}styles/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<SCRIPT language=javascript type=text/javascript>
	$(document).ready(function() {
	
		$('#username').focus();
		$('btnLogin').click(function(){
			$('#adminlogin').submit();
			<#--
			$.ajax({
				type:"get",
				url:"/toLogin",
				data:"loginId" + $("#loginId").val() + "&password" + $("#password").val(),
				dataType:"text",
				success:function(loginFlag){
					if( loginFlag=="0" ) {
						$("#kaptchaImage").append("<font color="red">验证码错误</font>");
					}
					if( loginFlag=="1" ) {
						$("#loginId").append("<font color="red">用户名或密码错误</font>");
					}
					if( loginId=="2" ) {
					}
				}
			});-->
		});
	});
</SCRIPT>

<STYLE type=text/css>
BODY {
	TEXT-ALIGN: center;
	PADDING-BOTTOM: 0px;
	BACKGROUND-COLOR: #ddeef2;
	MARGIN: 0px;
	PADDING-LEFT: 0px;
	PADDING-RIGHT: 0px;
	PADDING-TOP: 0px
}

A:link {
	COLOR: #000000;
	TEXT-DECORATION: none
}

A:visited {
	COLOR: #000000;
	TEXT-DECORATION: none
}

A:hover {
	COLOR: #ff0000;
	TEXT-DECORATION: underline
}

A:active {
	TEXT-DECORATION: none
}

.input {
	BORDER-BOTTOM: #ccc 1px solid;
	BORDER-LEFT: #ccc 1px solid;
	LINE-HEIGHT: 20px;
	WIDTH: 182px;
	HEIGHT: 20px;
	BORDER-TOP: #ccc 1px solid;
	BORDER-RIGHT: #ccc 1px solid
}

.input1 {
	BORDER-BOTTOM: #ccc 1px solid;
	BORDER-LEFT: #ccc 1px solid;
	LINE-HEIGHT: 20px;
	WIDTH: 120px;
	HEIGHT: 20px;
	BORDER-TOP: #ccc 1px solid;
	BORDER-RIGHT: #ccc 1px solid
}
</STYLE>

<META name=GENERATOR content="MSHTML 8.00.6001.23486">
</HEAD>
<BODY>
	
	<FORM id="adminlogin" action="/toLogin" method="post">
		<TABLE style="MARGIN: auto; WIDTH: 100%; HEIGHT: 100%" border=0
			cellSpacing=0 cellPadding=0>
			<TBODY>
				<TR>
					<TD height=150>&nbsp;</TD>
				</TR>
				<TR style="HEIGHT: 254px">
					<TD>
						<DIV style="MARGIN: 0px auto; WIDTH: 936px">
						<div id="hintInfo" style="position:relative; top:56px; left:750px; color:red">
							<strong>${hintInfo?default('')}</strong>
						</div>
							<IMG style="DISPLAY: block" src="${webRoot}styles/dn_cms/images/body_03.jpg">
						</DIV>
						<DIV style="BACKGROUND-COLOR: #278296">
							<DIV style="MARGIN: 0px auto; WIDTH: 936px">
								<DIV style="BACKGROUND: url(${webRoot}styles/dn_cms/images/body_05.jpg) no-repeat; HEIGHT: 155px">
									<DIV style="TEXT-ALIGN: left; WIDTH: 265px; FLOAT: right; HEIGHT: 125px; _height: 95px">
										<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%">
											<TBODY>
												<TR>
													<TD style="HEIGHT: 43px">
														<input type="text" id="loginId" name="loginId" />
													</TD>
												</TR>
												<TR>
													<TD>
														<input type="password" id="password" name="password" />
													</TD>
												</TR>
												<TR>
													<!-- <TD style="HEIGHT: 50px"><INPUT id=checkcode class=yzm
														size=8 type=text name=checkcode> <IMG
														style="CURSOR: pointer"
														onclick="this.src='api/imcode/checkcode.php?id='+Math.random()*5;"
														alt=验证码,看不清楚?请点击刷新验证码 align=baseline
														src="${webRoot}styles/dn_cms/images/checkcode.png" width=65 height=25></TD> -->
													<TD style="HEIGHT: 50px">
														<input type="text" name="captcha" style="width: 60px;"  maxlength="4" /> 
														<img id="kaptchaImage"	src="${webRoot}getKaptchaImage" 
															 style="margin-bottom: -10px" />
														<br/>
														<script type="text/javascript">  
														    $('#kaptchaImage').click(function () {//生成验证码    
														          $(this).hide().attr('src', '${webRoot}getKaptchaImage?' + Math.floor(Math.random()*100) ).fadeIn();      
														    });  
														</script>
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</DIV>
									<DIV style="HEIGHT: 1px; CLEAR: both"></DIV>
									<DIV style="WIDTH: 380px; FLOAT: right; CLEAR: both">
										<TABLE border=0 cellSpacing=0 cellPadding=0 width=300>
											<TBODY>
												<TR>
													<TD width=100 align=right>
														<INPUT style="BORDER-RIGHT-WIDTH: 0px; BORDER-TOP-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px"
															id="btnLogin"  type="image" src="${webRoot}styles/dn_cms/images/btn1.jpg" />
													</TD>
													<TD width=100 align=middle>
														<INPUT style="BORDER-RIGHT-WIDTH: 0px; BORDER-TOP-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px"
															id="btnReset"  type="image" src="${webRoot}styles/dn_cms/images/btn2.jpg" />
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</DIV>
								</DIV>
							</DIV>
						</DIV>
						<DIV style="MARGIN: 0px auto; WIDTH: 936px">
							<IMG src="${webRoot}styles/dn_cms/images/body_06.jpg">
						</DIV>
					</TD>
				</TR>
				<TR style="HEIGHT: 30%">
					<TD>&nbsp;</TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
