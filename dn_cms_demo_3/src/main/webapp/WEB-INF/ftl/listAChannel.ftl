<form id="pagerForm" method="post" action="${webRoot}management/listAChannel">
	<!--<input type="hidden" name="status" value="1">
	<input type="hidden" name="keywords" value="1" />-->
	<input type="hidden" name="channel_id" value="${articlePgn.channel_id}" />
	<input type="hidden" name="orderField" value="${articlePgn.orderField}" />
	<input type="hidden" name="orderDirection" value="${articlePgn.orderDirection}" />
	<input type="hidden" name="pageNum" value="${articlePgn.pageNum}" /> 
	<input type="hidden" name="numPerPage" value="${articlePgn.numPerPage}" />

</form>
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<br />..
			<br />
		</table>
		<div class="subBar"></div>
	</div>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${webRoot}management/add"
				target="navTab"><span>添加</span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="${webRoot}management/deleteAjax"
				target="selectedTodo" postType="String" title="确定要删除吗?"><span>删除</span></a>
			<#-- 删除（批量）是自己实现的方式：table里的checkbox列。 -->
			</li>
			<li class="line">line</li>
			<li><a class="edit"
				href="${webRoot}management/modify?id={id_update}"
				target="navTab"><span>修改</span></a>
			<#-- 修改是dwz的方式：通过<tr target="id_update" rel="${a.id}">来完成的 -->	
			</li>
			<!--<li class="line">line</li>
			<li><a class="icon" href="javascript:;" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span></span></a></li>-->
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th><input type="checkbox" group="ids" class="checkboxCtrl" ></th>
				<th orderField="id" class="${articlePgn.orderDirection}">标识ID</th>
				<th orderField="name" class="${articlePgn.orderDirection}">文章名</th>
				<th orderField="author" class="${articlePgn.orderDirection}">作者</th>
				<th orderField="overview" class="${articlePgn.orderDirection}">摘要</th>
				<th orderField="channel_id" class="${articlePgn.orderDirection}">所属栏目</th>
				<th orderField="crt_datetime" class="${articlePgn.orderDirection}">创建时间</th>
				<th orderField="upd_timestamp" class="${articlePgn.orderDirection}">最近修改时间</th>
			</tr>
		</thead>
		<tbody>
			<#list articlePgn.articles as a>
			<tr target="id_update" rel="${a.id}" checked="false" class="trOne">
				<td width="2%">
					<input name="ids" type="checkbox" value="${a.id}" />
				</td>
				<td align="center" width="5%">${a.id}</td>
				<td width="20%">${a.name}</td>
				<td width="6%">${a.author?default('')}</td>
				<td class="tmp">${a.overview?default('')}</td>
				<td align="center" width="5%">${a.channel.name}</td>
				<td align="center" width="12%">${a.updTimestamp}</td>
				<td align="center" width="12%">${a.crtDatetime}</td>
			</tr>
			</#list>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span> <select class="combox" name="numPerPage"
				onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="25">25</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select> <span>条，共${articlePgn.totalCount}条</span>
		</div>

		<div class="pagination" targetType="navTab"
			totalCount="${articlePgn.totalCount}" numPerPage="${articlePgn.numPerPage}"
			pageNumShown="25" currentPage="${articlePgn.pageNum}"></div>

	</div>
</div>
