<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/header.jsp"%>
<div align="center">
	<h1>角色列表</h1>
	<a href="${pageContext.request.contextPath}/manager/addRole.jsp">添加</a>
</div>
<c:if test="${empty allRole}" var="v">
	<div align="center">
		<span style="color: red">对不起，没有任何角色</span>
	</div>
</c:if>
<c:if test="${!empty allRole}" var="v">
	<table border="1" width="80%">
		<tr>
			<th>序号</th>
			<th>角色名称</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${allRole}" var="r" varStatus="vs">
			<tr bgcolor="${vs.index%2==0?'#749AA3':'#D4FC7E'}">
				<td>${vs.count}</td>
				<td>${r.name}</td>
				<td>${r.description}</td>
				<td><a href="#">修改</a>&nbsp;&nbsp;| <a href="#">删除</a>&nbsp;&nbsp;|
					<a href="${pageContext.request.contextPath}/MyController?operation=grantMenu2RoleUI&roleId=${r.id}">菜单分配</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>