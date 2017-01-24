<%@ page language="java" pageEncoding="utf-8" %>
<!-- 加载公用标签库 -->
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.liudw.cn/front" prefix="frontTag" %>  

<c:set value="${pageContext.request.contextPath}" var="basePath" scope="request"/>

<c:set value="${basePath}/static/bootstrap" var="bootstrapPath" scope="request"/>
<c:set value="${basePath}/static/hplus4" var="hplus4Path" scope="request"/>
<c:set value="${basePath}/static/common" var="commonPath" scope="request" />