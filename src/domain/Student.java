package domain;

import java.util.Date;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class Student {
	private int id; // 在数据库中的ID
	private int studentID; // 学号，跟ID区分开为了方便数据库操作
	private String name; // 姓名
	private int age; // 年龄
	private String sex; // 性别
	private Date birthday; // 出生日期
	private String info; // 简介

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentID=" + studentID + ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", birthday=" + birthday + ", info=" + info + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Student(int id, int studentID, String name, int age, String sex, Date birthday, String info) {
		super();
		this.id = id;
		this.studentID = studentID;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.info = info;
	}

}
