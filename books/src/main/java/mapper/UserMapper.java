package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pojo.PageInfo;
import pojo.User;

public interface UserMapper {
	@Select("select count(*) from user")
	long selCountByPageInfo();
	
	@Insert("insert into user values(default,#{name},#{password},#{sex},#{age},3,3)")
	int insUser(User user);
	@Insert("insert into user values(default,#{name},#{password},#{sex},#{age},2,2)")
	int insRoot(User user);
	@Insert("insert into user values(default,#{name},#{passwor},#{sex},#{age},1,1)")
	int insBoss(User user);
	@Delete("delete from user where name=#{0}")
	int detName(String name);
	@Delete("delete from user where id=#{0}")
	int detId(int id);
	@Select("select * from user limit #{pageStart},#{pageSize}")
	List<User> showUser(PageInfo pageInfo);
	@Select("select * from user where name=#{0}")
	User showName(String name);
	@Select("select * from user where id=#{0}")
	User showId(int id);
	@Select("select * from user where access=#{0}")
	List<User> showAccess(int access);//查询权限人数
	@Update("update user set password=#{1} where name=#{0}")
	int updName(String name,String password);//根据名字修改密码
	@Update("update user set password=#{1} where id=#{0}")
	int updId(int id,String password);//根据id修改密码
	@Update("update user set access=#{1} where name=#{0}")
	int updAccess(String name,int access);//根据名字修改权限
	@Update("update user set fwaccess=#{1} where name=#{0}")
	int updfwAccess(String name,int fwaccess);//根据名字修改访问权限
	@Select("select * from user where name=#{0} and password=#{1}")
	User login(String name,String password);
}