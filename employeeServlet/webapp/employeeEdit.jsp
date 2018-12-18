<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<body>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Edit Employee information </h3>
<form action="updateEmployeeServlet" method="post">  
	<input type="hidden" name="id" value="${employee.id}" >
	<input type="text" name="empid" value="${employee.empId}" /><br/>  <br/>
	<input type="text" name="ename"  value="${employee.name}"/><br/>  <br/>
	<input type="text" name="eemail"  value="${employee.email}"/><br/>  <br/>
	<input type="text" name="edesignation"  value="${employee.designation}" /><br/> <br/> 
	<input type="submit" value="Update"/>  
</form>
</body>
</html>