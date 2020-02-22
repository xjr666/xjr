<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#fff3e1;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>个人信息
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="user/userInfo.jsp" target="rightFrame">查看个人信息</a><i></i></li>
         <li><cite></cite><a href="user/pwd.jsp" target="rightFrame">修改密码</a><i></i></li>
        </ul>    
    </dd>
	   <dd>
	    <div class="title">
	    <span><img src="images/leftico01.png" /></span>管理信息
	    </div>
	    	<ul class="menuson">
	    	<c:if test="${sessionScope.user.access==1}">
	        <li><cite></cite><a href="show" target="rightFrame">查看所有用户信息</a><i></i></li>
	        <li><cite></cite><a href="user/insroot.jsp" target="rightFrame">添加管理员用户</a><i></i></li>
	        <li><cite></cite><a href="deleteuser" target="rightFrame">删除用户</a><i></i></li>
	        <li><cite></cite><a href="upaccess" target="rightFrame">给予用户访问权限</a><i></i></li>
	        </c:if>
	        </ul>    
	    </dd>
	     <dd>
	    <div class="title">
	    <span><img src="images/leftico01.png" /></span>图书信息
	    </div>
	    <ul class="menuson">
        <li><cite></cite><a href="showbooks?bs=1" target="rightFrame">查看所有图书信息</a><i></i></li>
         <li><cite></cite><a href="showuser?bs=2" target="rightFrame">查看可阅读图书</a><i></i></li>
         <c:if test="${sessionScope.user.access<=2}">
         <li><cite></cite><a href="books/insbook.jsp" target="rightFrame">添加图书</a><i></i></li>
         <li><cite></cite><a href="showdeletebook" target="rightFrame">查看我发布的图书</a><i></i></li>
         </c:if>
         
         
        </ul>  
	    </dd>
    </dl>
</body>
</html>
 