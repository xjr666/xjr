package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sun.istack.internal.Interned;

import pojo.Books;
import pojo.PageInfo;

public interface BooksMapper {
	
	
	@Insert("insert into books values(default,#{b_name},#{b_Author},#{b_main},#{b_PublishingHouse},#{b_Categories},#{b_time},#{b_access},#{in_b_name})")
	int insBoss(Books books);
	@Delete("delete from books where b_name=#{0}")
	int delName(String b_name);
	@Delete("delete from books where b_id=#{0}")
	int delId(int b_id);
	
	@Select("select count(*) from books")
	long showBosscount();
	@Select("select * from books limit #{pageStart},#{pageSize}")
	List<Books> showBoss(PageInfo pageInfo);
	
	@Select("select * from books where b_Categories is not null and b_access=#{0}")
	List<Books> showUser(int access);
	
	@Select("select count(*) from books where b_Categories is not null")
	long showUserscount();
	@Select("select * from books where b_Categories is not null limit #{pageStart},#{pageSize}")
	List<Books> showUsers(PageInfo pageInfo);
	
	@Select("select * from books where b_access=#{0}")
	List<Books> showRoot(int b_access);
	
	@Select("select count(*) from books where b_Categories is not null || in_b_name=#{in_b_name}")
	long showRootscount(String in_b_name);//管理员可见书籍
	@Select("select * from books where b_Categories is not null || in_b_name=#{in_b_name} limit #{pageInfo.pageStart},#{pageInfo.pageSize}")
	List<Books> showRoots(@Param("in_b_name")String in_b_name,@Param("pageInfo")PageInfo pageInfo);//管理员可见书籍
	
	@Select("select count(*) from books where in_b_name=#{0}")
	long showRootsscount(String in_b_name);//管理员发布的书籍
	@Select("select * from books where in_b_name=#{in_b_name} limit #{pageInfo.pageStart},#{pageInfo.pageSize}")
	List<Books> showRootss(@Param("in_b_name")String in_b_name,@Param("pageInfo")PageInfo pageInfo);//管理员发布的书籍
	
	@Select("select * from books where b_name=#{0}")
	List<Books> showBooksName(String b_name);//精确查找书名
	
	@Select("select count(*) from books where books.b_name like concat('%',#{0},'%')")
	long showlikeNamecount(String b_name);//模糊查找书名(重点)
	@Select("select * from books where books.b_name like concat('%',#{0},'%' limit #{pageInfo.pageStart},#{pageInfo.pageSize})")
	List<Books> showlikeName(@Param("b_name")String b_name,@Param("pageInfo")PageInfo pageInfo);//模糊查找书名(重点)
	
	@Select("select * from books where b_Author like '%#{0}%'")
	List<Books> showlikeAuthor(String b_Author);//查找作者
	//-----------------------------------------
	@Select("select count(*) from books where b_access>=#{0}")
	long showfwUsercount(int fwaccess);
	@Select("select * from books where b_access>=#{fwaccess} limit #{pageInfo.pageStart},#{pageInfo.pageSize}")
	List<Books> showfwUser(@Param("fwaccess")int fwaccess,@Param("pageInfo")PageInfo pageInfo);//查询可以阅读的书籍
	
	
	
}