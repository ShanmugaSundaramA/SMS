

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteStudentController")
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentService service =null;  
	
	
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int rollNumber =Integer.parseInt(request.getParameter("rollNumber"));
	service =new StudentService();
	boolean status=service.removeStudent(rollNumber);
	if(status == false) {
		String msg="Student deleted successfully";
		response.sendRedirect("delete_student.jsp?message="+msg);
	}
	
   	}

}
