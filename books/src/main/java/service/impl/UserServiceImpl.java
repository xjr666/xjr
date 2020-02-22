package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.UserMapper;
import pojo.PageInfo;
import pojo.User;
import service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	public User login(String name,String password){
		return userMapper.login(name, password);
	}
	@Override
	public PageInfo show(int access,int pageNumberStr,int pageSizeStr) {
		// TODO Auto-generated method stub
	
		
		if (access==1) {
			
			int pageNumber = 1;
			if(pageNumberStr!=0){
				pageNumber = pageNumberStr;
			}
			int pageSize = 5;
			if(pageSizeStr!=0){
				pageSize =pageSizeStr;
			}
			PageInfo pageInfo=new PageInfo();
			pageInfo.setPageNumber(pageNumber);
			pageInfo.setPageSize(pageSize);
			pageInfo.setPageStart((pageNumber-1)*pageSize);
			List<User> list=userMapper.showUser(pageInfo);
			pageInfo.setList(list);
			long count=userMapper.selCountByPageInfo();
			pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return pageInfo;
		}else {
			System.out.println("权限不足不能访问");
			return null;
		}
		
	}
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return userMapper.insUser(user);
	}
	@Override
	public int updName(String name, String newpassword) {
		// TODO Auto-generated method stub
		return userMapper.updName(name, newpassword);
	}
	@Override
	public int delete(String name) {
		// TODO Auto-generated method stub
		return userMapper.detName(name);
	}
	@Override
	public int insertroot(User user) {
		// TODO Auto-generated method stub
		return userMapper.insRoot(user);
	}
	@Override
	public int updfwaccess(String name, int fwaccess) {
		// TODO Auto-generated method stub
		return userMapper.updfwAccess(name, fwaccess);
	}
}
