<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	 <base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>Basic ValidateBox - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="添加图书" style="width:400px;padding:10px 60px 20px 60px;">
	<form action="insbook" method="post">
		${sessionScope.ins}
		<c:remove var="ins" scope="session" />
		<input type="hidden" name="oper" value="reg" />
		<table cellpadding="5">
			<tr>
				<td>图书名字：</td>
				<td><input name="b_name" type="text" class="easyui-validatebox textbox" data-options="required:true"  missingMessage="用户名必填"></td>
			</tr>
			<tr>
				<td>作者:</td>
				<td><input name="b_Author" type="text" class="easyui-validatebox textbox"  missingMessage="密码必填"></td>
			</tr>
			
			<tr>
				<td>内容：:</td>
				<td>
					<input name="b_main" type="text" class="easyui-validatebox textbox"  missingMessage="密码必填"></td>
				</td>
			</tr>
			<tr>
				<td>出版社:</td>
				<td><input name="b_PublishingHouse" class="easyui-validatebox textbox" value=""></td>
			</tr>
			<tr>
				<td>类别:</td>
				<td><input name="b_Categories" class="easyui-validatebox textbox" value=""></td>
			</tr>
			<tr>
				<td>出版时间:</td>
				<td><input name="b_time" class="easyui-datebox textbox" value=""></td>
			</tr>
			<tr>
				<td>访问权限:</td>
				<td><input name="b_access" class="easyui-validatebox textbox" value=""></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="确认添加 "/>
				</td>
			</tr>
		</table>
	</form>
	</div>
	<style scoped="scoped">
		.textbox{
			height:20px;
			margin:0;
			padding:0 2px;
			box-sizing:content-box;
		}
	</style>

</body>
</html>