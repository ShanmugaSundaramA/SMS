
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentDao {

	private final String SAVE_STUDENT ="insert into student(rollnumber,name,gender,course,email,passout) values(?,?,?,?,?)";
	private final String DELETE_STUDENT="delete from student where rollnumber=?";
	private final String SEARCH_STUDENT ="select rollnumber,name,gender,course,email from student where rollnumber=?";
	private final String UPDATE_STUDENT="update student set name=?,gender=?,course=?,email=? where rollnumber=?";
	
	public int	addStudent(StudentBo studentBo){
	   int i=0;
	   try {
		
		   Connection con=DbConnection.getConn();
		   PreparedStatement ps=con.prepareStatement(SAVE_STUDENT);
		   
	       ps.setInt(1, studentBo.getRollNumber());
	       ps.setString(2, studentBo.getStudentName());
	       ps.setString(3, studentBo.getGender());
	       ps.setString(4, studentBo.getCourse());
	   	   ps.setString(5, studentBo.getEmail());     
	   	   ps.setInt(6, studentBo.getPassOut());
		   i=ps.executeUpdate();
	       
	   }catch (SQLException e){
		e.printStackTrace();
		}
	   
	   return i;
	}
	
	public boolean delete(int rollNumber) {
		 boolean status= true;
		  try {
			  Connection con=DbConnection.getConn();
			  PreparedStatement ps=con.prepareStatement(DELETE_STUDENT);
			  ps.setInt(1, rollNumber);
			  status = ps.execute();
			  System.out.println("status::"+status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;  
	}
	
	public StudentDto getStudentDetails(int rollnumber) {
		StudentDto dto=null;
		String msg="Student Does not exist";
		try {
			Connection con=DbConnection.getConn();
			PreparedStatement ps= con.prepareStatement(SEARCH_STUDENT);
			ps.setInt(1,rollnumber);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				dto=new StudentDto();
				dto.setRollNumber(rs.getInt(1));
				dto.setStudentName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setCourse(rs.getString(4));
				dto.setEmail(rs.getString(5));
			}else {
				dto=new StudentDto();
				dto.setMsg(msg);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int  updateStudent(StudentBo studentBo) {
		int i=0;
		try {
			Connection con=DbConnection.getConn();
			PreparedStatement ps=con.prepareStatement(UPDATE_STUDENT);
			ps.setString(1, studentBo.getStudentName());
			ps.setString(2, studentBo.getGender());
			ps.setString(3, studentBo.getCourse());
			ps.setString(4, studentBo.getEmail());
			ps.setInt(5, studentBo.getRollNumber());
			i=ps.executeUpdate();
			System.out.println(i);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
