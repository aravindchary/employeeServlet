<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="loginServlet" method="post">
	
	<div align="center">
		<fieldset>	
				<c:if test= "${msg != null}">	
					<h4 style='color:red;font-style: italic;'>${requestScope.msg}</h4>
				</c:if>
				<h2> Login </h2>
			<input type="text" name="userName" placeholder="User Name" ></br> <br /> 
			<input type="password" name="userPass" placeholder="Password"></br> <br> 
			<input type="submit" value="Login">
		</fieldset>
		</div>	
	</form>
</body>
</html>
