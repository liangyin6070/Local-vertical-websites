<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/init.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>粤西后台管理系统-登录</title>
<jsp:include page="/common/meta.jsp" />
<link href="${basePath}/static/login/res/ui/css/screen.css?v=3.9" media="screen, projection" rel="stylesheet" type="text/css" >
<link rel="stylesheet" type="text/css" href="${basePath}/static/login/res/ui/css/base.css?v=3.9">
<link rel="stylesheet" type="text/css" href="${basePath}/static/login/res/passport/css/login.css?v=3.9">
</head>
<body>
<div class="logina-logo" style="height: 55px">
    <a href="${basePath}/manage/index" style="font: 35px bold;">粤西后台管理系统</a>
</div>
<div class="logina-main main clearfix">
    <div class="tab-con" style="padding-left: 200px;">
        <form id="form-login" method="post" action="${basePath}/manage/login">
            <div id='login-error' class="error-tip">${message_login}</div>
            <table border="0" cellspacing="0" cellpadding="0">
                <tbody>
                    <tr>
                        <th>账户</th>
                        <td width="245">
                            <input id="email" type="text" name="username" placeholder="电子邮箱/手机号" autocomplete="off" value=""/>
                         </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>密码</th>
                        <td width="245">
                            <input id="password" type="password" name="password" placeholder="请输入密码" autocomplete="off"/>
                        </td>
                        <td></td>
                    </tr>
                   <%--  <tr id="tr-vcode">
                        <th>验证码</th>
                        <td width="245">
                            <div class="valid">
                                <input type="text" name="verifiCode" />
                                <img class="vcode" src="${basePath}/manage/getVerifyCodeImage" width="85" height="35" alt="" />
                            </div>
                        </td>
                        <td></td>
                    </tr> --%>
                    <tr class="find">
                        <th></th>
                        <td>
                            <div>
                                <label class="checkbox" for="chk11">
                                	<input style="height: auto;" id="chk11" type="checkbox" name="isRememberMe" value="true" />记住我
                                </label>
                                <a href="${basePath}/manage/forgetPassword">忘记密码？</a>
                            </div>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td width="245"><input class="confirm" type="submit" value="登  录"></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="refer" value="${refer}" />
        </form>
    </div>
    <%-- <div class="reg">
        <p>还没有账号？<br>赶快免费注册一个吧！</p>
        <a class="reg-btn" href="${basePath}/manage/toRegister">立即免费注册</a>
    </div> --%>
</div>
<div id="footer">
    <div class="copyright">Copyright © 2017 www.liudw2.cn. All Rights Reserved. liudw 版权所有</div>
</div>       
</body>
</html>
