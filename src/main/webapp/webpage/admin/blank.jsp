<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<jsp:include page="/common/meta.jsp" />
<%-- <jsp:include page="/common/easyui.jsp" />

<link rel="stylesheet" type="text/css" href="${commonPath}/uploadify/uploadify.css" />
<script type="text/javascript" src="${commonPath}/uploadify/jquery.uploadify.min.js"></script> --%>
</head>
<body>
<h2>欢迎使用粤西后台管理系统</h2>
<!-- <div id="panel_new_news" class="easyui-panel" title="My Panel" style="width:500px;height:150px;padding:10px;"   
	data-options="iconCls:'icon-save',closable:true, collapsible:true,minimizable:true,maximizable:true">   
    <p>panel content.</p>   
    <p>panel content.</p>   
</div>  -->
<!-- <div>
	<table>
		<tr>
			<td><label>上传课件：</td>
            <td><label><input type="file" name="demo_file" id="uploadify"/></label>&nbsp;&nbsp;</td>
            <td><div id="fileQueue"></div></td>
		</tr>
	</table>
</div> -->
</body>
<!-- <script type="text/javascript">
$(function(){
	$("#uploadify").uploadify({
        'uploader': '${basePath}/common/upload/demo',
        'swf':"${commonPath}/uploadify/uploadify.swf",
        'cancelImg': '${commonPath}/uploadify/cancel.png',
        'queueID': 'fileQueue',
        'auto': true,
        'multi':false,
        'buttonText': '选择文件',
        'fileSizeLimit':'100MB',
        'simUploadLimit' : 1,
        'queueSizeLimit' : 1,
        'fileExt': '*.xls',
        'method':'post'
        /* onComplete: function(event, queueID, fileObj, response, data) {
            
        },
        onSelect:function(){
        	
        },
        onError: function(event, queueID, fileObj) {
            alert("文件:" + fileObj.name + "上传失败");
        } */
    });
});
</script> -->
</html>