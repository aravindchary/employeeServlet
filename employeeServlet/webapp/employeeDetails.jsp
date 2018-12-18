<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>	
<head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 <script src="${pageContext.request.contextPath}\js\jquery.min.js"></script>
 <script src="${pageContext.request.contextPath}\js\ajaxJs.js"></script>
 
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<c:if test= "${successMessage != null}">	
			<div class="alert_success">
			  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>  
			  	${successMessage}
			</div>
	</c:if>
	
	<c:if test= "${errorMessage != null}">	
			<div class="alert_error">
			  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>  
			  	${errorMessage}
			</div>
	</c:if>
<div id="SAVE_FORM">
	<h3> Save Employee information </h3>
	<form action="register" method="post">  
		<input type="text" name="empid"  placeholder="employee id..."/><br/>  <br/>
		<input type="text" name="ename"  placeholder="employee name..."/><br/>  <br/>
		<input type="text" name="eemail" placeholder="employee email..."/><br/>  <br/>
		<input type="text" name="edesignation"   placeholder="employee designation... "/><br/> <br/> 
		<input type="submit" value="Register"/>  
	</form>  
</div>

<br>
<div id="TABLE">
        <table border="1" cellpadding="5">
            <caption><h2>List of Employees</h2></caption>
            <tr>
            	<th>Emp Id </th>
                <th>Name</th>
                <th>Email</th>
                <th>Designation</th>
                <th>Action</th>
            </tr>
            <c:forEach var="emp" items="${listOfEmployes}">
                <tr>
                    <td><c:out value="${emp.empId}" /></td>
                    <td><c:out value="${emp.name}" /></td>
                    <td><c:out value="${emp.email}" /></td>
                    <td><c:out value="${emp.designation}" /></td>
                    <td>
                    	<a onClick="editEmployee(${emp.id});"  href="javaScript:void(0);" >Edit</a> &nbsp;&nbsp;
                    	<a onClick="deleteEmployee(${emp.id});"  href="javaScript:void(0);" >Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
  </div>      
        </body>
</html>