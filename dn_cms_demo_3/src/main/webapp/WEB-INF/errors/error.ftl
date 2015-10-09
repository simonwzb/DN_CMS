<html>
<head>
	<title>错误页面</title>
</head>
<body>
	<h2 align="center"> <font>您的请求或操作遇到了错误.</font color="red"> </h2>
	<p>请联系管理员：simonw(E-mail:<font color="bulue">simon.wei@live.cn</font>)</p>
	<hr/>
	<p>错误信息：<br/>
		<!--默认异常||java.lang.Exception.<br/>-->
		<h5>
			${e.getClass().getName()}: ${e.getMessage()} <br/>
			<#list e.getStackTrace() as t>
				${t}
			</#list>
			
		</h5>
	
	
	</p>
<body>
<html>