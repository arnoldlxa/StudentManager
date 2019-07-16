package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.regexp.internal.recompile;

import dao.StudentDao;
import domain.Student;
import util.JDBCUtil02;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());

		return runner.query("select * from student", new BeanListHandler<Student>(Student.class));
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Student student) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("insert into student values(null , ?,?,?,?,?,?)", student.getStudentID(), student.getName(),
				student.getAge(), student.getSex(), student.getBirthday(), student.getInfo());
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("delete from student where id=?", id);
	}

	@Override
	public Student findStudentById(int id) throws SQLException {
		// TODO Auto-generated method stub

		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from student where id = ?", new BeanHandler<Student>(Student.class), id);

	}

	@Override
	public void update(Student student) throws SQLException {
		// TODO Auto-generated method stub

		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update student set studentID=? , name=? , age=? , sex=? , birthday=? , info=? where id = ?",
				student.getStudentID(), student.getName(), student.getAge(), student.getSex(), student.getBirthday(),
				student.getInfo(), student.getId());
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		// 第一个问号，代表一页返回多少条记录 ， 第二个问号， 跳过前面的多少条记录。
		// 5 0 --- 第一页 (1-1)*5
		// 5 5 --- 第二页 (2-1)*5
		// 5 10 --- 第三页
		return runner.query("select * from student limit ? offset ? ", new BeanListHandler<Student>(Student.class),
				PAGE_SIZE, (currentPage - 1) * PAGE_SIZE);
	}

	@Override
	public int findCount() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		Long result = (Long) runner.query("select count(*) from student ", new ScalarHandler());
		return result.intValue();
	}

}
