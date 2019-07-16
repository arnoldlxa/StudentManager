package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
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
import org.apache.commons.beanutils.converters.DateConverter;

import com.sun.org.apache.bcel.internal.generic.NEW;

import domain.Student;
import javafx.scene.Parent;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

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

			System.out.println(student.toString());
			BeanUtils.populate(student, map);

			// 2. 添加到数据库
			StudentService service = new StudentServiceImpl();
			service.insert(student);

			// 跳转
			// 再查一次数据库，然后再装到作用域中 ，然后再跳转。
			// 这里是直接跳转到页面上， 那么这个页面会重新翻译一次，上面的那个request的请求存放的数据是没有了。
//			request.getRequestDispatcher("StudentListPageServlet").forward(request, response);
			response.sendRedirect("StudentListPageServlet?currentPage=1");
			
			//java.lang.NumberFormatException: null，。刚开始还一直以为我类型转换错误呢。
			//原来，不够细心，在传递url值的时候忘了传递参数，或者传递错误，这样当然获取到的值为null。

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
