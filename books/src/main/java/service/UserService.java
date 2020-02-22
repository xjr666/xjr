package service;

import java.util.List;

import pojo.PageInfo;
import pojo.User;
public interface UserService {
	public User login(String name,String password);
	PageInfo show(int access,int pageNumber,int pageSize);
	int insert(User user);
	int updName(String name,String newpassword);
	int delete(String name);
	int insertroot(User user);
	int updfwaccess(String name,int fwaccess);
}
