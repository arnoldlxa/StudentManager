package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("sex"));

		// 1. 获取客户端提交上来的数据
		try {

			Map map = request.getParameterMap();
			Student student = new Student();

			// 这是转换date的
			ConvertUtils.register(new Converter() {
				@SuppressWarnings("rawtypes")
				@Override
				public Object convert(Class arg0, Object arg1) {
					System.out.println("注册字符串转换为date类型转换器");
					if (arg1 == null) {
						return null;
					}
					if (!(arg1 instanceof String)) {
						throw new ConversionException("只支持字符串转换 !");
					}

					String str = (String) arg1;
					if (str.trim().equals("")) {
						return null;
					}

					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

					try {
						return sd.parse(str);
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}

				}

			}, java.util.Date.class);

			BeanUtils.populate(student, map);

			// 2. 更新数据库
			StudentService service = new StudentServiceImpl();
			service.update(student);

			// 跳转
			// 再查一次数据库，然后再装到作用域中 ，然后再跳转。
			// 这里是直接跳转到页面上， 那么这个页面会重新翻译一次，上面的那个request的请求存放的数据是没有了。
			request.getRequestDispatcher("StudentListServlet?currentPage=1").forward(request, response);

		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

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
