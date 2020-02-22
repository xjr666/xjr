<%@ page language="java" import="java.util.*,pojo.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/books/js/jquery-1.7.2.js"></script>
<!-- <script type="text/javascript" src="js/jquery.js"></script> -->

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});
<%-- 
  $("#up").click(function(){
	  var b_name=document.getElementsByName("b_name")[0].value;
	  window.location.href="up?fwaccess="+b_name;
  });
--%> 
<%-- $("#up").live("click",function(){
	//获取当前td的行位置
	var row=$(this).parent().prevAll().length;
	//获取当前td的列位置
	var col=$(this).prevAll().length;           
	//获取所有的input值
	alert("第"+row+"行"+"	"+"第"+col+"列");  
	$("#table").find("tr").eq(hang).find("td").eq(1);
	var accessname=$(".tablelist").find("tr").eq(hang).find("td").eq(1).innerText;
	var accessinput=$(".tablelist").find("tr").eq(hang).find("td").eq(1).childNodes[0].value;
	alert(accessinput);
	alert(accessname);
}); --%>


});
 function up(temp) {
	
	var hang=$(temp.parentNode).parent().prevAll().length;
	var lie = $(temp.parentNode).prevAll().length;
	alert("第"+hang+"行"+"	"+"第"+lie+"列");  
	var td_content=$(temp).parents("tr").children("td");
	var content = td_content.eq(0).text(); 
	var content2 = td_content.eq(1).text(); 
	 
	//获取td下的input 值
	var fwaccess=$(td_content.eq(lie)).find("input").val()
	var accessname= td_content.eq(1).text();
	
	<%--$("#table").find("tr").eq(hang).find("td").eq(1);--%>
	
	<%--var accessname=$(".tablelist").find("tr").eq(hang).find("td").eq(1).innerText;--%>
	<%--var accessinput=$(".tablelist").find("tr").eq(hang).find("td").eq(1).getElementsByClassName("fwaccess")[2].value;--%>
	
	<%-- var accessinput=rows[hang].cells[lie].childNodes[0].value;--%>
	alert(fwaccess);
	alert(accessname);
	window.location.href="up?fwaccess="+fwaccess+"&accessname="+accessname;
}
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">管理信息</a></li>
    <li><a href="#">查看用户信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>用户ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>权限级别</th>
        <th>访问权限</th>
        <th>修改权限</th>
        </tr>
        </thead>
        <tbody>
       <c:forEach items="${requestScope.users.list}" var="user">
	        <tr>
	        <td>${user.id}</td>
	        <td>${user.name}</td>
	        <td>${user.password}</td>
	         <td>${user.sex}</td>
	          <td>${user.age}</td>
	           <td>${user.access}</td>
	            <td>${user.fwaccess}</td>
	            <td><input type="text" class="fwaccess" name="fwaccess" value="" /><input type="button" value="点击修改"  id="up" onclick="up(this)" /></td>
	            </tr>
        </c:forEach>
               
        </tbody>
    </table>
     <a href="upaccess?pageSize=${requestScope.users.pageSize }&pageNumber=${requestScope.users.pageNumber-1}" <c:if test="${requestScope.users.pageNumber<=1 }"> onclick="javascript:return false;"</c:if>>上一页</a>
		<a href="upaccess?pageSize=${requestScope.users.pageSize }&pageNumber=${requestScope.users.pageNumber+1}" <c:if test="${requestScope.users.pageNumber>=requestScope.users.total }"> onclick="javascript:return false;"</c:if>>下一页</a>
 
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>