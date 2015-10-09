<style type="text/css">
	label{
		font-family:SimHei;
	}
</style>
<div class="pageContent">
	<form method="post" action="${webRoot}management/addAjax"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="68" >
			<p>
				<label>标识ID号：</label> <input name="id" type="text" size="30"
					value="${newid}" readonly="readonly" />
			</p>
			<p>
				<label>所属栏目：</label> <select name="channel_id"
					class="required combox"> <#list channels as c>
					<option value="${c.id}">${c.name}</option> </#list>
				</select>
			</p>
			<p>
				<label>文章名 ：</label> <input type="text" name="name" size="30"
					alt="请输入文章名" />
			</p>
			<p>
				<label>作   者 ：</label> <input type="text" name="author" size="30"
					alt="请输入作者" />
			</p>
			<p>
				<label>摘   要：</lable><br/>
				<textarea name="overview" cols="90" rows="3"></textarea>
			</p>
			<div class="unit">
			<br/><br/><br/><hr/>
				<textarea class="editor" name="mainBody" rows="100" cols="120">
					<!--upLinkUrl="upload.php" upLinkExt="zip,rar,txt" 
					upImgUrl="upload.php" upImgExt="jpg,jpeg,gif,png" 
					upFlashUrl="upload.php" upFlashExt="swf"
					upMediaUrl="upload.php" upMediaExt:"avi">-->
				</textarea>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>

	</form>
</div>
