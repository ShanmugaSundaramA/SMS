<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
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

input[type="submit"]{
color: white;
padding: 5px;
background-color: #4CAF50;
border: none;
}
input[type="submit"]:hover{
background-color: #45a049;
}

</style>
</head>
<body>
<%
String msg=request.getParameter("message");
if(msg == null){
	msg ="";
}
%>
<%
String dtoMsg=(String)request.getAttribute("dtoMsg");
if(dtoMsg == null){
	dtoMsg ="";
}
%>

<div><%@ include file="Header.html" %></div>

<div class="content">
<center>
<div class="search">
<h4 style="color:green"><%=msg %></h4>
<h4 style="color:red"><%=dtoMsg %></h4>

    <h1>Update Student</h1>
<form action="SearchStudentController" method="post">
<p>
Student RollNumber: <input type="text" name="rollnumber" required="required">
</pre>
<p>
<input type="submit" value="Search Student">
</p>
</form>
</div>

<div class="update">

<form action="UpdateStudentController" name="student_form" method="post">
<table>

<tr>
<td><label for="roll_number">Student Roll Number</label></td>
<%
Integer  rollNumber=(Integer)request.getAttribute("dtoRoll");
	if(rollNumber == null){
		rollNumber=0;
	}
%>
<td><input type="text" id="roll_number" name="roll_number" value="<%=rollNumber%>"></td>
</tr>

<tr>
<td><label for="student_name">Student Name</label></td>
<%
String  name=(String)request.getAttribute("dtoName");
	if(name == null){
		name=" ";
	}
%>
<td><input type="text" id="student_name" name="student_name" value="<%=name %>"></td>
</tr>

<tr>
<td>Gender</td>
<%
String  gender=(String)request.getAttribute("dtoGender");
	if(gender == null){
		gender=" ";
	}
%>
<td>
<input type="text" name="gender" value="<%=gender%>"></td>
</tr>

<tr>
<td>
<label for="course">Course</label></td>
<%
String  course=(String)request.getAttribute("dtoCourse");
	if(course == null){
		course =" ";
	}
%>
<td>
<input type="text" name="course" value="<%=course%>">
</td>
</tr>

<tr>
<td><label for="email">Email</label></td>
<%
String  email=(String)request.getAttribute("dtoEmail");
	if(email == null){
		email =" ";
	}
%>
<td><input type="text" id="email" name="email" value="<%=email%>"></td>
</tr>

</table>
<p><input type="submit" value="update"></p>
</form>

</div>

</center>
</div>

<div><%@ include file="Footer.html" %></div>
</body>
</html>
