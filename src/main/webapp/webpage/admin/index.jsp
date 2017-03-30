<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台首页</title>
<jsp:include page="/common/meta.jsp" />
<jsp:include page="/common/easyui.jsp" />
<jsp:include page="/common/layui.jsp" />
<style type="text/css">
.ui-login{float: right;padding: 10px}
	/*.ui-login a{color:red}*/
	.ui-login .ui-login-bar{text-align: right;}
	.menu-item{display:block;color:black;text-decoration: none;	border-bottom :1px dotted #D8D8D8;padding:5px 5px 5px 15px;}
    .menu-item:hover{background: #E0ECFF;}
    .ui-login-info {font-size:14px;}

    .top_area{
    	height:68px;
    	background-color: #244187;
    }
    .top_area .home_logo{
    	float: left;
    	margin-top: 10px;
    	margin-left: 20px;
    }
    .top_area .fr{
    	float: right;
    	line-height: 68px;
    	padding-right: 10px;
    	color: #fff;
    }
    .top_area .exit{
    	float: right;
    	color: #fff;
    	text-decoration: none;
		color: #fde805;
		padding: 14px 20px 14px 10px;
		cursor: pointer;
    }

	.exit span{
		display: block;
		text-align: center;
		margin-top: 5px;
	}
    .icon-exit{
		display: block;
		margin: 0 auto;
		width: 18px;
		height: 18px;
		background: url('${frontPath}/skin/img/icons.png') no-repeat 0 -72px;
    }

    .datagrid-toolbar{
    	padding: 15px;
    }
	

	.panel-header{
		border-bottom: 1px solid #e3e3e3
	}
	.layout-expand{
		background-color: #f1f1f1;
	}
	.layout-split-west{
		border-right: 1px solid #e3e3e3;
	}


    .accordion{
		border:none;
	}
	.accordion .accordion-header{
		color: #484848;
		background: #f1f1f1;
		border:none;
	}
	.menu-item{
		padding:15px ;
		background:#e3e3e3 ;
		color:#484848 ;
	}
	.menu-item.active{
		color:#168acc;
	}
	.menu-item:hover{
		background: #d5d5d5;
	}
	.accordion .accordion-header-selected .panel-title{
		color: #484848;
	}
	.panel-tool a:hover{
		background-color: transparent;
	}


</style>
</head>
<body class="easyui-layout">
<!-- head start -->
<div data-options="region:'north',border:false" style="height:60px;">
	<ul class="layui-nav" lay-filter="">
	  <li class="layui-nav-item"><a href="${frontPath}/manage/index">M系统</a></li>
	  <li class="layui-nav-item"><a href="">产品</a></li>
	  <li class="layui-nav-item"><a href="">大数据</a></li>
	  <li class="layui-nav-item" pc><a href="">社区</a></li>
	</ul>
</div>	
<!-- head end -->
<!-- left start -->
<div data-options="region:'west',split:true,title:'菜单栏'" style="width:250px;">
	<div id="accordion_left" class="easyui-accordion" data-options="fillSpace:true,fit: true,border: false,animate: true,selected:false"> 
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
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element();
});
layui.use('layer', function(){
	  var layer = layui.layer;
	  layer.msg('hello');
	});


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