import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/SearchStudentController")
public class SearchStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService service=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int rollnumber=Integer.parseInt(request.getParameter("rollnumber"));
	service =new StudentService();
	StudentDto dto = service.searchStudent(rollnumber);
	request.setAttribute("dtoRoll", dto.getRollNumber());
	request.setAttribute("dtoName", dto.getStudentName());
	request.setAttribute("dtoGender", dto.getGender());
	request.setAttribute("dtoCourse", dto.getCourse());
	request.setAttribute("dtoEmail", dto.getEmail());
	request.setAttribute("dtoMsg", dto.getMsg());
	request.getRequestDispatcher("update_student.jsp").forward(request, response);
	}
	
}
