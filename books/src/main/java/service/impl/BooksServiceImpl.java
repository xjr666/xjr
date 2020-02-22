package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.BooksMapper;
import pojo.Books;
import pojo.PageInfo;
import service.BooksService;
@Service
public class BooksServiceImpl implements BooksService {
	@Resource
	private BooksMapper booksMapper;
	@Override
	public PageInfo showUser(int fwaccess,String pageNumberStr,String pageSizeStr) {
		// TODO Auto-generated method stub
		int pageSize = 5;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNumber(pageNumber);
		pageInfo.setPageSize(pageSize);
		pageInfo.setPageStart((pageNumber-1)*pageSize);
		if (fwaccess==1) {
			List<Books> books=booksMapper.showBoss(pageInfo);
			pageInfo.setList(books);
			long count=booksMapper.showBosscount();
			pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return pageInfo;
		}else if (fwaccess==2) {
			
			List<Books> books=booksMapper.showfwUser(fwaccess,pageInfo);
			pageInfo.setList(books);
			long count=booksMapper.showfwUsercount(fwaccess);
			pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return pageInfo;
					
		}else if (fwaccess==3) {
			List<Books> books=booksMapper.showfwUser(fwaccess,pageInfo);
			pageInfo.setList(books);
			long count=booksMapper.showfwUsercount(fwaccess);
			pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return pageInfo;
		}else {
			return null;
		}
		
	}
	public PageInfo showBooks(int fwaccess,String in_b_name,String pageNumberStr,String pageSizeStr) {
		// TODO Auto-generated method stub
		int pageSize = 5;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNumber(pageNumber);
		pageInfo.setPageSize(pageSize);
		pageInfo.setPageStart((pageNumber-1)*pageSize);
		if (fwaccess==1) {
			List<Books> books=booksMapper.showBoss(pageInfo);
			pageInfo.setList(books);
			long count=booksMapper.showBosscount();
			pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return pageInfo;
		}else if (fwaccess==2) {
			List<Books> books=booksMapper.showRoots(in_b_name,pageInfo);
			pageInfo.setList(books);
			long count=booksMapper.showRootscount(in_b_name);
			pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return pageInfo;
		}else if (fwaccess==3) {
			List<Books> books=booksMapper.showUsers(pageInfo);
			pageInfo.setList(books);
			long count=booksMapper.showUserscount();
			pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return pageInfo;
		}else {
			return null;
		}
		
	}
	@Override
	public PageInfo sousuo(String b_name,String pageNumberStr,String pageSizeStr) {
		// TODO Auto-generated method stub
		int pageSize = 5;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNumber(pageNumber);
		pageInfo.setPageSize(pageSize);
		pageInfo.setPageStart((pageNumber-1)*pageSize);
		List<Books> books=booksMapper.showlikeName(b_name,pageInfo);
		pageInfo.setList(books);
		long count=booksMapper.showlikeNamecount(b_name);
		pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pageInfo;
	}
	@Override
	public int insbook(Books books) {
		// TODO Auto-generated method stub
		return booksMapper.insBoss(books);
	}
	@Override
	public PageInfo showdeletebook(int access,String name,String pageNumberStr,String pageSizeStr) {
		// TODO Auto-generated method stub
		int pageSize = 5;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		PageInfo pageInfo=new PageInfo();
		pageInfo.setPageNumber(pageNumber);
		pageInfo.setPageSize(pageSize);
		pageInfo.setPageStart((pageNumber-1)*pageSize);
		if (access==1) {
			List<Books> books=booksMapper.showBoss(pageInfo);
			pageInfo.setList(books);
			long count=booksMapper.showBosscount();
			pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return pageInfo;
		}else {
			List<Books> books=booksMapper.showRootss(name,pageInfo);
			pageInfo.setList(books);
			long count=booksMapper.showRootsscount(name);
			pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return pageInfo;
		}
		
	}
	@Override
	public int deletebook(int b_id) {
		// TODO Auto-generated method stub
		return booksMapper.delId(b_id);
	}
	
}
