<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台首页</title>
<jsp:include page="/common/meta.jsp" />
<jsp:include page="/common/easyui.jsp" />
<style type="text/css">
	.ui-login{float: right;padding: 10px}
	/*.ui-login a{color:red}*/
	.ui-login .ui-login-bar{text-align: right;}
	.menu-item{display:block;color:black;text-decoration: none;	border-bottom :1px dotted #D8D8D8;padding:5px 5px 5px 15px;}
    .menu-item:hover{background: #E0ECFF;}
    .ui-login-info {font-size:14px;}
</style>
</head>
<body class="easyui-layout">
<!-- head start -->
<div data-options="region:'north',border:false" style="height:60px;">
后台管理系统
</div>	
<!-- head end -->
<!-- right start -->
<div data-options="region:'east',split:true,title:'East'" style="width:250px;">
<div id="cc" class="easyui-calendar" style="width:230px;height:180px;"></div> 
</div>
<!-- right end -->
<!-- left start -->
<div data-options="region:'west',split:true,title:'系统菜单栏'" style="width:250px;">
	<div id="accordion_left" class="easyui-accordion" fit=true> 
		<c:forEach var="menu" items="${menus}">
			<div title="${menu.name}">
				<c:forEach var="child" items="${menu.childs}">
					<a class="menu-item" href="#" onclick="addTab('${child.name}','${basePath}${child.url}');">${child.name}</a>
				</c:forEach>
			</div>
		</c:forEach>  
	</div>
</div>
<!-- left end -->
<!-- center start -->
<div data-options="region:'center'">
	<div id="tt" class="easyui-tabs" fit="true" border="false" plain="true">
		<div title="欢迎页" href="${basePath}/manage/blank"></div>
	</div>
</div>
<!-- center end -->
</body>
<script type="text/javascript">
$(function(){
	$('#tt').tabs({
		onLoad : function(panel) {
			var plugin = panel.panel('options').title;
			panel.find('textarea[name="code-' + plugin + '"]').each(function() {
				var data = $(this).val();
				data = data.replace(/(\r\n|\r|\n)/g,'\n');
				if (data.indexOf('\t') == 0) {
					data = data.replace(/^\t/, '');
					data = data.replace(/\n\t/g, '\n');
				}
				data = data.replace(/\t/g,'    ');
				var pre = $('<pre name="code" class="prettyprint linenums"></pre>').insertAfter(this);
				pre.text(data);
				$(this).remove();
			});
		}
	});
});

/*打开tab*/
function addTab(name, plugin) {
	if ($('#tt').tabs('exists', name)) {
		$('#tt').tabs('select', name);
	} else {
		var content = '<iframe scrolling="auto" frameborder="0"  src="' + plugin + '" style="width:100%;height:100%;"></iframe>';
		
		$('#tt').tabs('add', {
			title : name,
			content : content,
			closable : true
		});
	}
}

</script>
</html>