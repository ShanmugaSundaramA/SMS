<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Students</title>
<style type="text/css">
.content{

padding : 15px;
}
.t{
border-collapse: collapse;
width: 60%;
}
.t th , td {
border : 1px solid #ddd;
padding :5px;
text-align: center;
}
.t tr: nth-child(even){
background-color: #f2f2f2; 
}
.t tr:hover{
background-color: #ddd;
}
.t th{
padding:12px;
text-align: center;
background-color: #04AA6D;
color: white;
}
</style>
</head>
<body>

<div><%@ include file="Header.html" %></div>

<div class="content">

<center>
<h1>Students List</h1>
<table class="t">

<tr> 
<th>No of Students</th>
<th>Name of Student</th>
<th>Roll Number</th>
<th>Gender</th>
<th>Course</th>
<th>Email</th>
</tr>

<%
    final String VIEW_STUDENT ="select noOfStudent,rollnumber,name,gender,course,email from student";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sundar","root","Sundar0129Sowmiya");
	    Statement ps = con.createStatement();
	    ResultSet rs=ps.executeQuery(VIEW_STUDENT);
	    while(rs.next()) { %>
	    	<tr>
	    	<td><%= rs.getInt(1) %></td>
	    	<td><%= rs.getString(3) %></td>
	    	<td><%= rs.getInt(2) %></td>
	    	<td><%= rs.getString(4) %> </td>
	    	<td><%= rs.getString(5) %></td>
	    	<td><%= rs.getString(6) %></td>
	    	</tr>
	   <% } 
	} catch (SQLException e) {
		e.printStackTrace();
	}  
%>
</table>
</center>

<div><%@ include file="Footer.html" %></div>

</div>
</body>
</html>
