package service;

import java.sql.SQLException;
import java.util.List;

import domain.User;

public interface UserService {

	/**
	 * 登录验证方法
	 */
	User login(User user) throws SQLException;

}
