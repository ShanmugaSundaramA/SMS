//this is my first comment.2

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddStudentController")
public class AddStudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	StudentVo studentVo=null;
	StudentService studentService=null;
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           int rollNumber =Integer.parseInt(request.getParameter("roll_number"));
           String studentName=request.getParameter("student_name");
           String gender=request.getParameter("gender");
           String course=request.getParameter("course");
           String email=request.getParameter("email");
           int passOut =Integer.parseInt(request.getParameter("passedOut"));
           
          if(email.isEmpty()) {
        	  email = "NA";
          }
           studentVo = new StudentVo();
           studentVo.setRollNumber(rollNumber);
           studentVo.setStudentName(studentName);
           studentVo.setGender(gender);
           studentVo.setCourse(course);
           studentVo.setEmail(email);
           studentVo.setPassOut(passOut);
           
           studentService =new StudentService();
           int i = studentService.saveStudent(studentVo);
           System.out.println(i);  
           if(i != 0) {
        	   String msg= "Successfully Added";
        	   request.setAttribute("msg", msg);
        	   request.getRequestDispatcher("add_student.jsp").forward(request, response);   
           }else {
        	   String msg= "already exist RollNumber";
        	   request.setAttribute("msg", msg);
        	   request.getRequestDispatcher("add_student.jsp").forward(request, response);
           }
		}

}
