<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
 <script src="${pageContext.request.contextPath}\js\jquery.min.js"></script>
 <script src="${pageContext.request.contextPath}\js\ajaxJs.js"></script>

<meta charset="ISO-8859-1">
<title>Ajax Example</title>
</head>
<body>
	<div id="FORM">
		<input type="text" class="input_txt" id="USER_NAME" name="userName" placeholder="enter data..">  
		<input type="button"  id="BUTTION" value="Submit Ajax">
	</div>
	<br>
	<h2>Ajax Response will come here...</h2>
	<div id="RESPONSE" style="color: red">
	</div>
</body>
</html>