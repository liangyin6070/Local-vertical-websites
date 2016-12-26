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
	Date From: <input class="easyui-datebox" style="width:110px" />
	To: <input class="easyui-datebox" style="width:110px" />
	<a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
</div>

</body>
<script type="text/javascript">
$(function(){
	$('#dataGrid').datagrid({    
		title:"用户列表",
		method:'post',
	    url:'${basePath}/manage/admin/user/ajaxList',
	    rownumbers:true,
	    singleSelect:true,
	    pagination:true,
	    fitColumns:true,
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
	        {field:'headImg',title:'头像',width:100,align:'center'},
	        {field:'registerTime',title:'注册时间',width:100,align:'center'},
	        {field:'lastLoginTime',title:'最后登录时间',width:100,align:'center'},
	        {field:'loginNum',title:'登录次数',width:100,align:'center'},
	        {field:'isLocked',title:'是否锁定',width:100,align:'center'},    
	        {field:'isAdmin',title:'是否管理员',width:100,align:'center'},
	        {field:'remoteAddr',title:'最后登陆IP',width:100,align:'center'},
	        {field:'publishStatus',title:'是否可用',width:100,align:'center'}   
	    ]],
	    toolbar:'#tb'
	}); 
});

function search() {
	$('#dataGrid').datagrid('load', {    
	    name: 'easyui',    
	    address: 'ho'   
	});  
}

//对Date的扩展，将 Date 转化为指定格式的String
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
//例子： 
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function (fmt) { //author: meizz 
 var o = {
     "M+": this.getMonth() + 1, //月份 
     "d+": this.getDate(), //日 
     "H+": this.getHours(), //小时 
     "m+": this.getMinutes(), //分 
     "s+": this.getSeconds(), //秒 
     "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
     "S": this.getMilliseconds() //毫秒 
 };
 if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
 for (var k in o)
 if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
 return fmt;
}
</script>
</html>