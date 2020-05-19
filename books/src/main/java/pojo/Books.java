package pojo;

public class Books {
	private int b_id;//书籍编号
	private String b_name;//书籍名字
	private String b_Author;//书籍作者
	private String b_main;//书籍内容介绍
	private String b_PublishingHouse;//书籍出版社
	private String b_Categories;//书籍类别
	private String b_time;//书籍出版时间
	private int b_access;//查看权限
	private String in_b_name;//添加书籍的管理员名字
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_Author() {
		return b_Author;
	}
	public void setB_Author(String b_Author) {
		this.b_Author = b_Author;
	}
	public String getB_main() {
		return b_main;
	}
	public void setB_main(String b_main) {
		this.b_main = b_main;
	}
	public String getB_PublishingHouse() {
		return b_PublishingHouse;
	}
	public void setB_PublishingHouse(String b_PublishingHouse) {
		this.b_PublishingHouse = b_PublishingHouse;
	}
	public String getB_Categories() {
		return b_Categories;
	}
	public void setB_Categories(String b_Categories) {
		this.b_Categories = b_Categories;
	}
	public String getB_time() {
		return b_time;
	}
	public void setB_time(String b_time) {
		this.b_time = b_time;
	}
	public int getB_access() {
		return b_access;
	}
	public void setB_access(int b_access) {
		this.b_access = b_access;
	}
	public String getIn_b_name() {
		return in_b_name;
	}
	public void setIn_b_name(String in_b_name) {
		this.in_b_name = in_b_name;
	}
	@Override
	public String toString() {
		return "Books [b_id=" + b_id + ", b_name=" + b_name + ", b_Author=" + b_Author + ", b_main=" + b_main
				+ ", b_PublishingHouse=" + b_PublishingHouse + ", b_Categories=" + b_Categories + ", b_time=" + b_time
				+ ", b_access=" + b_access + ", in_b_name=" + in_b_name + "]";
	}

	
}
