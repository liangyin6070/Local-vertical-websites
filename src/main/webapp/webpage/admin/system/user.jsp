<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<jsp:include page="/common/meta.jsp" />
<jsp:include page="/common/easyui.jsp" />
<jsp:include page="/common/layui.jsp" />
</head>
<body class="easyui-layout">
<table id="dataGrid"></table>
<div id="tb" style="">
	<button class="layui-btn" onclick="appendData();">增加</button>
	<button class="layui-btn" onclick="">编辑</button>
	<button class="layui-btn" onclick="">删除</button>
</div>

</body>
<script type="text/javascript">
var layer = null;
layui.use(['element', 'layer'], function(){
  var element = layui.element();
  layer = layui.layer;
});

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



function appendData() {
	  layer.open({
		  area: ['500px', '300px'],
		    type: 2,
		    content: "1231111",
		    btn: ['确定', '取消'],
		    yes:function(index, layero) {
		    	layer.alert("1111");
		    	layer.close(index); //如果设定了yes回调，需进行手工关闭
		    },
		    btn1:function(index, layero){
		    	layer.close(index); 
		    },
		    cancel: function(){ 
		        //右上角关闭回调
		        //alert("123");
		        //return false 开启该代码可禁止点击该按钮关闭
		      }
		  });
}
</script>
</html>