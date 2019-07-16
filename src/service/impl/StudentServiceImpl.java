package service.impl;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.PageBean;
import domain.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		dao.delete(id);
	}

	@Override
	public Student findStudentById(int id) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(id);

	}

	@Override
	public void update(Student student) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		dao.update(student);
	}

	@Override
	public PageBean<Student> findStudentByPage(int currentPage) throws SQLException {
		// TODO Auto-generated method stub

		// 封装分页的该页数据
		PageBean<Student> pageBean = new PageBean<Student>();

		int pageSize = StudentDao.PAGE_SIZE;
		pageBean.setCurrentPage(currentPage); // 设置当前页
		pageBean.setPageSize(pageSize); // 每页的记录数

		List<Student> list = new StudentDaoImpl().findStudentByPage(currentPage);
		pageBean.setList(list); // 设置这一页的学生数量

		// 总记录数
		StudentDao dao = new StudentDaoImpl();
		int count = dao.findCount();
		pageBean.setTotalSize(count); // 设置总的记录数
		pageBean.setTotalPage(count % pageSize == 0 ? (count / pageSize) : (count / pageSize + 1));

		return pageBean;

	}

}
