package service;

import java.sql.SQLException;
import java.util.List;

import domain.PageBean;
import domain.Student;

public interface StudentService {
	/**
	 * 查询当页的学生数据
	 * 
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<Student> findAll() throws SQLException;

	/**
	 * 添加学生
	 * 
	 * @param student 需要添加到数据库的学生对象
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException;

	/**
	 * 根据id删除学生
	 * 
	 * @param sid
	 * @throws SQLException
	 */
	void delete(int id) throws SQLException;

	/**
	 * 根据ID查询单个学生对象
	 * 
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	Student findStudentById(int id) throws SQLException;

	/**
	 * 更新学生信息
	 * 
	 * @param student 需要更新的学生数据
	 * @throws SQLException
	 */
	void update(Student student) throws SQLException;

	/**
	 * 查询当页的数据
	 * 
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	PageBean<Student> findStudentByPage(int currentPage) throws SQLException;

}
