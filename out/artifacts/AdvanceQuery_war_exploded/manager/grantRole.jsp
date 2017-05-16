<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/header.jsp"%>
<div align="center">

	<h1>分配菜单</h1>
	<form
		action="${pageContext.request.contextPath}/permission/MyController?operation=grantMenu2Role"
		method="post" id="formId">
		<input type="hidden" name="roleId" value="${role.id}" />
		<table border="1" width="80%">
			<tr>
				<td colspan="2">角色名称：${role.name}</td>
			</tr>

			<tr>
				<td>已有菜单：</td>
				<td><c:forEach items="${role.menus}" var="m" varStatus="vs">
						${m.name}<br />
					</c:forEach></td>
			</tr>

			<tr>
				<td>所有菜单:</td>
				<td>
					<c:forEach items="${allMenu}" var="m">
						<input type="checkbox" name="mId" value="${m.id}" > ${m.name}<br/>
					
					</c:forEach>
				</td>
			</tr>
			
			<tr align="center">
				<td colspan="2">
					<input type="button" value="提交" onclick="toSubmit()">
				</td>
			</tr>
		</table>
	</form>
</div>

	<script>
		function toSubmit(){
			var list = document.getElementsByName("mId");
			var selected = false;
			for(var i=0;i<list.length;i++){
				if(list[i].checkek){
					selected = true;
				}
			}
			if(!selected){
				alert("请选择要为用户分配的菜单");
			}else{
				var form = document.getElementById("formiD");
				form.submit();
			}
		}
	</script>
</body>
</html>