package pojo;

public class User {
private int id;
private String name;
private String password;
private String sex;
private int age;
private int access;	//权限
private int fwaccess;//访问权限
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getAccess() {
	return access;
}
public void setAccess(int access) {
	this.access = access;
}
public int getFwaccess() {
	return fwaccess;
}
public void setFwaccess(int fwaccess) {
	this.fwaccess = fwaccess;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", age=" + age
			+ ", access=" + access + ", fwaccess=" + fwaccess + "]";
}

}
