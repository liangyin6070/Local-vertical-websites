<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>首页</title>
<jsp:include page="/common/meta.jsp" />
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${frontPath}/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${frontPath}/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${commonPath}/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${frontPath}/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="http://localhost:9000">ZJCMS</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#" >社区</a></li>
        <li><a href="#">Link</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="搜索" />
        </div>
        <button type="submit" class="btn btn-default">搜索</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/sceutry/login.html" th:href="@{/sceutry/toLogin}">登陆</a></li>
        <li><a href="/sceutry/register.html" th:href="@{/sceutry/toRegister}">注册</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="wrapper" style="margin-top:85px;">
	<div class="container" role="main">
		<div class="row">
			<div class="col-lg-9 col-md-9 col-sm-9">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-6">
						<ul>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
						</ul>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-6">
						<ul>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3">
				<div class="panel panel-primary">
					  <div class="panel-heading">今日日记</div>
					  <div class="panel-body">
						<ul>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
						</ul>
					  </div>
				</div>
				<div class="panel panel-success">
					  <div class="panel-heading">技术导读</div>
					  <div class="panel-body">
					    <ul>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
						</ul>
					  </div>
				</div>
				<div class="panel panel-info">
					  <div class="panel-heading"></div>
					  <div class="panel-body">
					    <ul>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
						</ul>
					  </div>				
				</div>
				<div class="panel panel-warning">
					  <div class="panel-heading"></div>
					  <div class="panel-body">
					    <ul>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
						</ul>
					  </div>				
				</div>
				<div class="panel panel-danger">
					  <div class="panel-heading">友情链接</div>
					  <div class="panel-body">
					    <ul>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
							<li>eqweqweqweqweqwe</li>
						</ul>
					  </div>				
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>
