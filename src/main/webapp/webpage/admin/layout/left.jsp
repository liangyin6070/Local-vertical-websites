<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div data-options="region:'west',split:true,title:'系统菜单栏'" style="width:250px;">
	<div id="accordion_left" class="easyui-accordion" fit=true>   
		<div title="数据管理">
			<a class="menu-item" href="#" onclick="addTab('企事业单位管理','${pageContext.request.contextPath}/admin/data/organ.jsp');">企事业单位管理</a>
			<a class="menu-item" href="#" onclick="addTab('港口管理','${pageContext.request.contextPath}/admin/data/port.jsp');">港口管理</a>
		</div>
		<div title="地图管理">
			<a class="menu-item" href="#" onclick="addTab('地图配置管理','${pageContext.request.contextPath}/admin/map/mapservice.jsp');">地图配置管理</a>
		</div>
		<div title="系统管理">
			<a class="menu-item" href="#" onclick="addTab('用户管理','${basePath}/manage/admin/user/toList');">用户管理</a>
			<a class="menu-item" href="#" onclick="addTab('角色管理','${pageContext.request.contextPath}/admin/user/role.jsp');">角色管理</a>
			<a class="menu-item" href="#" onclick="addTab('模块管理','${pageContext.request.contextPath}/admin/user/module.jsp');">模块管理</a>
		</div> 
	</div>
</div>