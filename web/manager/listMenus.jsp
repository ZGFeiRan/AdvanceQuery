<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/header.jsp"%>
<div align="center">
	<h1>菜单列表</h1>
<a href="${pageContext.request.contextPath}/manager/addMenu.jsp">添加</a>
</div>
<c:if test="${empty menus}" var="v">
	<div align="center"><span style="color: red">对不起，没有任何菜单</span></div>
</c:if>
<c:if test="${!empty menus}" var="v">
	<table border="1" width="80%">
		<tr>
			<th>序号</th>
			<th>菜单名称</th>
			<th>URI</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${menus}" var="m" varStatus="vs">
			<tr bgcolor="${vs.index%2==0?'#749AA3':'#D4FC7E'}">
				<td>${vs.count}</td>
				<td>${m.name}</td>
				<td>${m.uri}</td>
				<td>${m.description}</td>
				<td><a href="#">修改</a>&nbsp;&nbsp; <a href="#">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>