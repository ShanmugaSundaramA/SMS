<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Student</title>
<style type="text/css">
input[type="submit"]{
color: white;
padding: 5px;
background-color: red;
border: none;
}
input[type="submit"]:hover{
background-color: darkred;
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
<div><%@ include file="Header.html" %></div>
<div>
<center>
<h1>Delete Student</h1>
<h4 style="color:green"><%=msg %></h4>

<form action="DeleteStudentController" method="post">
<p>
Student RollNumber: <input type="text" name="rollNumber" required="required">
</p>
<p>
<input type="submit" value="Delete">
</p>
</form>
</center>
</div>
<div><%@ include file="Footer.html" %></div>

</body>
</html>
