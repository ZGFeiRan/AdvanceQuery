<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
<br/>
<br/>
	  <div style="background-color: #CFCFCF">
    	<a href="${pageContext.request.contextPath}/MyController?operation=listAllMenu">菜单管理</a>&nbsp;&nbsp;
    	<a href="${pageContext.request.contextPath}/MyController?operation=listAllRole">角色管理</a>&nbsp;&nbsp;
    	<a href="${pageContext.request.contextPath}/MyController?operation=listAllUser">用户管理</a>&nbsp;&nbsp;
     </div>
	<hr/>
