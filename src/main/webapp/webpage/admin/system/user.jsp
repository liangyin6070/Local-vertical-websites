<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<jsp:include page="/common/meta.jsp" />
<jsp:include page="/common/easyui.jsp" />
</head>
<body class="easyui-layout">
<table id="dataGrid"></table>
<div id="tb" style="padding:2px 5px;">
	<a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">删除</a>
</div>

</body>
<script type="text/javascript">
$(function(){
	$('#dataGrid').datagrid({    
		method:'post',
	    url:'${basePath}/manage/admin/user/ajaxList',
	    nowrap:false,
		pageSize:20,
		pageList:[20, 50, 100],
		pagination:true,
		loadMsg:"正在加载数据",
	    fit:true,
	    columns:[[ 
	        {field:'id',title:'序号',width:100,align:'center'},    
	        {field:'userName',title:'账号',width:100,align:'center'},
	        {field:'email',title:'电子邮件',width:100,align:'center'},
	        {field:'contact',title:'联系方式',width:100,align:'center'},
	        {field:'reailName',title:'真实姓名',width:100,align:'center'},
	        {field:'sex',title:'性别',width:100,align:'center'},
	        {field:'birthday',title:'出生日期',width:100,align:'center'},    
	        {field:'address',title:'地址',width:100,align:'center'},
	        {field:'registerTime',title:'注册时间',width:100,align:'center'},
	        {field:'lastLoginTime',title:'最后登录时间',width:100,align:'center'},
	        {field:'isLocked',title:'是否锁定',width:100,align:'center'},    
	        {field:'publishStatus',title:'是否可用',width:100,align:'center'}   
	    ]],
	    toolbar:'#tb'
	}); 
});

function search() {
	$('#dataGrid').datagrid('load', {});  
}
</script>
</html>