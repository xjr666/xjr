package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.PageInfo;
import pojo.User;
import service.UserService;
@Controller
public class UserController {
	@Resource
	private UserService userServiceImpl;
	@RequestMapping("login")
	String login(String name,String password,HttpServletRequest request,String oper) {
		System.out.println(oper);
		System.out.println(name+password);
		User user=userServiceImpl.login(name, password);
		System.out.println(user);
		if(user!=null) {
			HttpSession hs=request.getSession();
		
			hs.setAttribute("user", user);
			return "main/main.jsp";
		}else {
			request.setAttribute("passwordno","用户名或密码错误");
			return "forward:login.jsp";
		}
	}
	@RequestMapping("show")
	String show(HttpServletRequest request,String pageNumber,String pageSize) {
		int pageNumbertr=0;
		if (pageNumber!=null) {
			pageNumbertr=Integer.parseInt(pageNumber);
		}
		int pageSizetr=0;
		if(pageSize!=null&&!pageSize.equals("")){
			pageSizetr= Integer.parseInt(pageSize);
		}
		System.out.println(pageNumber+pageSize);
		 HttpSession hs=request.getSession();
		 User user=(User)hs.getAttribute("user");
		 int access=user.getAccess();
		PageInfo users=userServiceImpl.show(access,pageNumbertr,pageSizetr);
		System.out.println(users);
		request.setAttribute("users",users);
		return "forward:user/showUser.jsp";
	}
	@RequestMapping("deleteuser")
	String deleteuser(HttpServletRequest request,String pageNumber,String pageSize) {
		
		int pageNumbertr=0;
		if (pageNumber!=null) {
			pageNumbertr=Integer.parseInt(pageNumber);
		}
		int pageSizetr=0;
		if(pageSize!=null&&!pageSize.equals("")){
			pageSizetr= Integer.parseInt(pageSize);
		}
		System.out.println(pageNumber+pageSize);
		 HttpSession hs=request.getSession();
		 User user=(User)hs.getAttribute("user");
		 int access=user.getAccess();
		PageInfo users=userServiceImpl.show(access,pageNumbertr,pageSizetr);
		System.out.println(users);
		request.setAttribute("users",users);
		return "forward:user/deleteuser.jsp";
	}
	@RequestMapping("out")
	String out(HttpServletRequest request,String oper) {
		System.out.println(oper);
		HttpSession hs=request.getSession();
		//清除session
		hs.invalidate();
		return "redirect:login.jsp";
	}
	@RequestMapping("insert")
	String insert(User user,HttpServletRequest request) {
		System.out.println(user);
		int index=userServiceImpl.insert(user);
		if (index>0) {
			System.out.println("注册成功");
			HttpSession hs=request.getSession();
			hs.setAttribute("reg", "注册成功");
			return "redirect:login.jsp";
		}else {
			System.out.println("注册失败");
			HttpSession hs=request.getSession();
			hs.setAttribute("reg", "注册失败");
			return "redirect:login.jsp";
		}
		
	}
	@RequestMapping("insertroot")
	String insertroot(User user,HttpServletRequest request) {
		System.out.println(user);
		int index=userServiceImpl.insertroot(user);
		if (index>0) {
			System.out.println("管理员添加成功");
			HttpSession hs=request.getSession();
			hs.setAttribute("insroot", "管理员添加成功");
			return "redirect:user/insroot.jsp";
		}else {
			System.out.println("管理员添加失败");
			HttpSession hs=request.getSession();
			hs.setAttribute("insroot", "管理员添加失败");
			return "redirect:user/insroot.jsp";
		}
		
	}
	@RequestMapping("update")
	String update(String newpassword,HttpServletRequest request) {
		System.out.println(newpassword);
		HttpSession hs=request.getSession();
		User user=(User)hs.getAttribute("user");
		String name=user.getName();
		int index=userServiceImpl.updName(name, newpassword);
		if (index>0) {
			System.out.println("修改成功");
			hs=request.getSession();
			hs.setAttribute("pwd", "修改成功");
			return "redirect:login.jsp";
		}else {
			System.out.println("修改失败");
			hs=request.getSession();
			hs.setAttribute("pwd", "修改失败");
			return "redirect:login.jsp";
		}
	}
	@RequestMapping("delete")
	String delete(String name) {
		System.out.println(name);
		userServiceImpl.delete(name);
		return "redirect:deleteuser";
	}
	@RequestMapping("upaccess")
	String upaccess(HttpServletRequest request,String pageNumber,String pageSize) {
		
		int pageNumbertr=0;
		if (pageNumber!=null) {
			pageNumbertr=Integer.parseInt(pageNumber);
		}
		int pageSizetr=0;
		if(pageSize!=null&&!pageSize.equals("")){
			pageSizetr= Integer.parseInt(pageSize);
		}
		System.out.println(pageNumber+pageSize);
		 HttpSession hs=request.getSession();
		 User user=(User)hs.getAttribute("user");
		 int access=user.getAccess();
		PageInfo users=userServiceImpl.show(access,pageNumbertr,pageSizetr);
		System.out.println(users);
		request.setAttribute("users",users);
		return "forward:user/upaccess.jsp";
		
	}
	@RequestMapping("up")
	
	String up(String accessname,int fwaccess,HttpServletRequest request){
		System.out.println(accessname);
		int index=userServiceImpl.updfwaccess(accessname, fwaccess);
		
		if (index>0) {
			System.out.println("修改成功");
			return "upaccess";
		}else {
			System.out.println("修改失败");
			return "user/upaccess.jsp";
		}
		
	}
	
}

