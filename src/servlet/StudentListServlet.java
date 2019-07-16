package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PageBean;
import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentListServlet
 */
public class StudentListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		try {
//			StudentService service = new StudentServiceImpl();
//			List<Student> list = service.findAll();
//			
//			
//			request.setAttribute("list", list);
//			
//			request.getRequestDispatcher("list.jsp").forward(request, response);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		request.setCharacterEncoding("UTF-8");
		
		try {
			String string =request.getParameter("currentPage");
			int currentPage =Integer.parseInt(string);
			StudentService service = new StudentServiceImpl();
			
			List<Student> list = service.findAll();
			
			request.setAttribute("list", list);
			
			//2. 根据指定的页数，去获取该页的数据回来
			
			PageBean pageBean= service.findStudentByPage(currentPage);
			
			request.setAttribute("pageBean", pageBean);
			//3. 跳转界面。
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
