package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Books;
import pojo.PageInfo;
import pojo.User;
import service.BooksService;

@Controller
public class BooksController {
	@Resource
	private BooksService booksServiceImpl;
	@RequestMapping("showuser")
	String showuser(String bs,HttpSession session,HttpServletRequest request,String pageNumber,String pageSize) {
		System.out.println(bs);
		HttpSession hs=request.getSession();
		User user=(User)hs.getAttribute("user");
		int fwaccess=user.getFwaccess();
		PageInfo books=booksServiceImpl.showUser(fwaccess,pageNumber,pageSize);
		request.setAttribute("books", books);
		request.setAttribute("bs", bs);
		return "forward:books/books.jsp";
	}
	@RequestMapping("showbooks")
	String showBooks(String bs,HttpSession session,HttpServletRequest request,String pageNumber,String pageSize) {
		System.out.println(bs);
		HttpSession hs=request.getSession();
		User user=(User)hs.getAttribute("user");
		int fwaccess=user.getFwaccess();
		String in_b_name=user.getName();
		PageInfo books=booksServiceImpl.showBooks(fwaccess,in_b_name,pageNumber,pageSize);
		request.setAttribute("books", books);
		request.setAttribute("bs", bs);
		return "forward:books/books.jsp";
	}
	@RequestMapping("booksmain")
	String booksmain(String b_main,HttpServletRequest request,String b_access) {
		System.out.println(b_main);
		HttpSession hs=request.getSession();
		User user=(User)hs.getAttribute("user");
		int fwaccess=user.getFwaccess();
		if (fwaccess<=Integer.parseInt(b_access)) {
			request.setAttribute("booksmain", b_main);
			return "forward:books/booksmain.jsp";
		}else {
			System.out.println("权限不够");
			return "redirect:showbooks";
		}

	}
	@RequestMapping("sousuo")
	String sousuo(String b_name,HttpServletRequest request,String pageNumber,String pageSize) {
		System.out.println(b_name);
		PageInfo books=booksServiceImpl.sousuo(b_name,pageNumber,pageSize);
		System.out.println(books);
		if (books!=null) {
			request.setAttribute("books", books);
			System.out.println("成功");
			return "forward:books/books.jsp";
		}else {
			System.out.println("没有");
			return "redirect:books/books.jsp";
		}
		
	}
	@RequestMapping("insbook")
	String insbook(Books books,HttpServletRequest request) {
		HttpSession hs=request.getSession();
		User user=(User)hs.getAttribute("user");
		String name=user.getName();
		books.setIn_b_name(name);
		System.out.println(books);
		int index=booksServiceImpl.insbook(books);
		if (index>0) {
			hs.setAttribute("ins","添加成功");
			return "redirect:books/insbook.jsp";
		}else {
			hs.setAttribute("ins","添加失败");
			return "redirect:books/insbook.jsp";
		}
		
	}
	@RequestMapping("showdeletebook")
	String showdeletebook(HttpServletRequest request,String pageNumber,String pageSize) {
		HttpSession hs=request.getSession();
		User user=(User)hs.getAttribute("user");
		int access=user.getAccess();
		String name=user.getName();
		PageInfo showdeletebooks=booksServiceImpl.showdeletebook(access,name,pageNumber,pageSize);
		request.setAttribute("showdeletebooks",showdeletebooks);
		return "forward:books/showdeletebook.jsp";
	}
	@RequestMapping("deletebook")
	String deletebook(int b_id) {
		System.out.println(b_id);
		int index=booksServiceImpl.deletebook(b_id);
		if (index>0) {
			System.out.println("删除成功");
			return "showdeletebook";
			
		}else {
			System.out.println("删除失败");
			return "showdeletebook";
		}
		
	}
	@RequestMapping(value="ceshi",produces="text/html;charset=utf-8")
	@ResponseBody
	String ceshi(String pageNumber,String pagesize,HttpServletRequest request,HttpServletResponse response) throws IIOException{
		System.out.println(pageNumber+pagesize);
		//设置响应流中文件进行下载
		
		return "测试";
	}
	
}
