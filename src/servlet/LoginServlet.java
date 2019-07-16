package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		/**
		 * 两种方法获取输入框的值
		 */

		// 第一种
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			String autoLogin= request.getParameter("auto_login");
//			User user = new User();
//			user.setUsername(username);
//			user.setPassword(password);

		try {

			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());

			// 1. 查询密码数据库中是否含有该用户
			UserService service = new UserServiceImpl();
			User userBean = service.login(user);

			if (userBean != null) {
				if ("on".equals(request.getParameter("auto_login"))) {

					// 发送cookie给客户端

					Cookie cookie = new Cookie("auto_login", user.getUsername() + "#" + user.getPassword());
					cookie.setMaxAge(60 * 60 * 24 * 7);// 7天有效期
					cookie.setPath("/AutoLoginDemo");
					// cookie.setPath(request.getContextPath());
					response.addCookie(cookie);

					// 成功了，进入首页
					request.getSession().setAttribute("user", user);
					request.getRequestDispatcher("StudentListServlet?currentPage=1").forward(request,
				    response);
					//response.sendRedirect("StudentListServlet?currentPage=1");
					
				}
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//		try {
//			String userName = request.getParameter("username");
//			String password = request.getParameter("password");
//			String autoLogin = request.getParameter("auto_login");
//			User user = new User();
//			user.setUsername(userName);
//			user.setPassword(password);
//			
//			UserDao dao = new UserDaoImpl();
//			User userBean = dao.login(user);
//			
//			if(userBean != null){
//				
//				//页面提交上来的时候，是否选择了自动登录
//				if("on".equals(autoLogin)){
//					
//					//发送cookie给客户端
//					
//					Cookie cookie = new Cookie("auto_login", userName+"#"+password);
//					cookie.setMaxAge(60*60*24*7);//7天有效期
//					cookie.setPath("/AutoLoginDemo");
//					//cookie.setPath(request.getContextPath());
//					response.addCookie(cookie);
//					
//				}
//				
//				
//				//成功了，进入首页
//				request.getSession().setAttribute("user", user);
//				response.sendRedirect("list.jsp");
//			}else{
//				//不成功...
//				request.getRequestDispatcher("login.jsp").forward(request, response);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
