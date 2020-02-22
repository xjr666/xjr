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
<script type="text/javascript" src="js/jquery.js"></script>


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
  $("#sousuoan").click(function(){
	  var b_name=document.getElementsByName("b_name")[0].value;
	  window.location.href="sousuo?b_name="+b_name;
  });
});
</script>



</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">图书信息</a></li>
    <li><a href="#">查看所有可阅读图书</a></li>
    </ul>
    <span id="sousuo" style="position: relative;left:400px;top: 10px;">
    <input type="text" name="b_name" size="15px"  /><input type="button" name="sousuoan" id="sousuoan" value="搜索"/>
    </span>
    </div>
    
    
    
    <div class="rightinfo">
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>书籍编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>类别</th>
        <th>出版时间</th>
        <th>访问权限</th>
        <th>发布人</th>
        <th>查看</th>
        </tr>
        </thead>
        <tbody>
       <c:forEach items="${requestScope.books.list}" var="book">
	        <tr>
	        <td>${book.b_id}</td>
	        <td>${book.b_name}</td>
	        <td>${book.b_Author}</td>
	        <%--  <td>${book.b_main}</td> --%>
	          <td>${book.b_PublishingHouse}</td>
	           <td>${book.b_Categories}</td>
	            <td>${book.b_time}</td>
	            <td>${book.b_access}</td>
	            <td>${book.in_b_name}</td>
	            <td><a href="booksmain?b_main=${book.b_main}&b_access=${book.b_access}">点击阅读</a></td>
        </c:forEach>
        </tr>
        </tbody>
    </table>
    <c:if test="${requestScope.bs==1}">
     <a href="showbooks?pageSize=${requestScope.books.pageSize }&pageNumber=${requestScope.books.pageNumber-1}&bs=1" <c:if test="${requestScope.books.pageNumber<=1 }"> onclick="javascript:return false;"</c:if>>上一页</a>
		<a href="showbooks?pageSize=${requestScope.books.pageSize }&pageNumber=${requestScope.books.pageNumber+1}&bs=1" <c:if test="${requestScope.books.pageNumber>=requestScope.books.total }"> onclick="javascript:return false;"</c:if>>下一页</a>
    	<span>总页数${requestScope.books.total}</span>
    </c:if>
    <c:if test="${requestScope.bs==2}">
     <a href="showuser?pageSize=${requestScope.books.pageSize }&pageNumber=${requestScope.books.pageNumber-1}&bs=2" <c:if test="${requestScope.books.pageNumber<=1 }"> onclick="javascript:return false;"</c:if>>上一页</a>
		<a href="showuser?pageSize=${requestScope.books.pageSize }&pageNumber=${requestScope.books.pageNumber+1}&bs=2" <c:if test="${requestScope.books.pageNumber>=requestScope.books.total }"> onclick="javascript:return false;"</c:if>>下一页</a>
    	<span>总页数${requestScope.books.total}</span>
    </c:if>
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