package service.impl;

import java.sql.SQLException;
import java.util.List;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User login(User user) throws SQLException {
		// TODO Auto-generated method stub
		UserDao dao = new UserDaoImpl();
		return dao.login(user);
	}

}
