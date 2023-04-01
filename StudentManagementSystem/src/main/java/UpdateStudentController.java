import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateStudentController")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentVo studentVo=null;
	StudentService studentService=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rollNumber=Integer.parseInt(request.getParameter("roll_number")); 
		String studentName=request.getParameter("student_name");
        String gender=request.getParameter("gender");
        String course=request.getParameter("course");
        String email=request.getParameter("email");
        
        studentVo = new StudentVo();
        studentVo.setRollNumber(rollNumber);
        studentVo.setStudentName(studentName);
        studentVo.setGender(gender);
        studentVo.setCourse(course);
        studentVo.setEmail(email);
        
        studentService =new StudentService();
        int i=studentService.modifyStudent(studentVo);

        String msg="Student Updated successfully";
		response.sendRedirect("update_student.jsp?message="+msg);
        
        
	}
}
