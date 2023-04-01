
public class StudentService {
	
	StudentDao studentDao=null;
	StudentBo studentBo=null;
	
	public int saveStudent(StudentVo studentVo){
		
		studentDao =new StudentDao();
		studentBo=new StudentBo();
		
		studentBo.setRollNumber(studentVo.getRollNumber());
		studentBo.setStudentName(studentVo.getStudentName());
		studentBo.setGender(studentVo.getGender());
		studentBo.setCourse(studentVo.getCourse());
		studentBo.setEmail(studentVo.getEmail());
		studentBo.setPassOut(studentVo.getPassOut());
		
		
		
		int i=studentDao.addStudent(studentBo);
		
		return i;
	}
	public boolean removeStudent(int rollNumber) {
		studentDao =new StudentDao();
		return studentDao.delete(rollNumber);
		
	}
	
	
	public StudentDto searchStudent(int rollnumber) {
		studentDao =new StudentDao();
		return studentDao.getStudentDetails(rollnumber);
	}
    
	public int modifyStudent(StudentVo studentVo) {
		studentDao =new StudentDao();
		studentBo=new StudentBo();
		
		studentBo.setRollNumber(studentVo.getRollNumber());
		studentBo.setStudentName(studentVo.getStudentName());
		studentBo.setGender(studentVo.getGender());
		studentBo.setCourse(studentVo.getCourse());
		studentBo.setEmail(studentVo.getEmail());
		
		return studentDao.updateStudent(studentBo);
	}
	 
}
