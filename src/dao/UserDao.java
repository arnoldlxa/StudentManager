package dao;

import java.sql.SQLException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import domain.User;

public interface UserDao {

	/**
	 * 这是UserDao接口
	 */

	/**
	 * 这是针对用户登录管理界面的登录验证
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	User login(User user) throws SQLException;
}
