<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/manager/header.jsp"%>

<div align="center">
	<h1>角色列表</h1>
	<a href="${pageContext.request.contextPath}/MyController?operation=listAllRole">【返回角色页】</a>
	<form action="${pageContext.request.contextPath}/MyController?operation=addRole" method="post">
		<table border="1" width="50%">
			<tr>
    			<td align="center"><span style="color: red">*</span>角色名称:</td>
    			<td>
    				<input width="100%" type="text" name="name" placeholder="请在此处输入角色名"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="center">描述:</td>
    			<td>
    				<textarea width="100%" rows="3" cols="38" name="description"></textarea>
    			</td>
    		</tr>
    		<tr align="center">
    			<td colspan="2">
    				<input type="submit" value="保存"/>
    			</td>
    		</tr>
		</table>
	</form>
</div>
</body>
</html>