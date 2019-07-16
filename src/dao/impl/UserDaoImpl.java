package dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.UserDao;
import domain.User;
import util.JDBCUtil02;

public class UserDaoImpl implements UserDao {

	@Override
	public User login(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());

		String sql = "select * from t_user where username=? and password=? ";
		return (User) runner.query(sql, new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());

	}

}
