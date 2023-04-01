<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Add_Student</title>

<style type="text/css">
.content{
padding:10px;
}
table{
background-color:#f2f2f2;
padding:10px;
border: 2px solid black;
border-radius: 5px;
}

input[type="text"] , [type="email"] , select , radio {
width:100%;
padding:5px 10px;
margin:8px 0px; 
box-sizing: border-box;
}
input[type="submit"],[type="reset"]{
width:100%;
color: white;
background-color: #4CAF50;
border: none;
margin:8px 0px;
padding:8px;
box-sizing: border-box;
}
input[type="submit"]:hover,[type="reset"]:hover{
background-color: #45a049;
}
</style>

<script type="text/javascript">
function doCheck(){
	var x=document.forms["student_form"]["roll_number"].value;
	if(isNaN(x)){
		alert("Must Be Number...");
		return false;
	}
	var y=document.forms["student_form"]["student_name"].value;
}
</script>
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
if(msg == null){
	msg = "";
}
%>
 <div><%@ include file="Header.html" %></div>
<div class="content">
<center>
<h1>Add Student</h1>

<h4 style="color:green"><%= msg %></h4>

<form action="AddStudentController" 
name="student_form" method="post" onsubmit="return doCheck()">
<table>

<tr>
<td><label for="roll_number">Student Roll Number</label></td>
<td><input type="text" id="roll_number" name="roll_number" required="required"></td>
</tr>

<tr>
<td><label for="student_name">Student Name</label></td>
<td><input type="text" id="student_name" name="student_name" required="required"></td>
</tr>

<tr>
<td>Gender</td>
<td>
<input type="radio" id="male" name="gender" value="male"><label for="male">Male</label>
&nbsp;&nbsp;
<input type="radio" id="female" name="gender" value="female"><label for="female">Female</label>
</td>
</tr>

<tr>
<td>
<label for="course">Course</label></td>
<td><select id="course" name="course" required="required">
<option value="">--select--</option>
<option value="Front_end">Front End</option>
<option value="Back_end">Back End</option>
<option value="Full_stack">Full_Stack</option>
<option value="Java">Java</option>
<option value="Python">Python</option>

</select>
</td>
</tr>

<tr>
<td><label for="email">Email</label></td>
<td><input type="email" id="email" name="email" ></td>
</tr>
<tr>
<td><label for= "passedOut">PassOut</label></td>
<td><input type="number" id="passedOut" name="passedOut"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Add Student"></td>
</tr>
<tr>
<td colspan="2"><input type="reset" value="Cancel"></td>
</tr>

</table>
</form>
</center>
</div>

<div><%@ include file="Footer.html" %></div>
</body>
</html>
