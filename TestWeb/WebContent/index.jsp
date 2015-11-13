<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ToDoList Site</title>
	<jsp:include page="./header.jsp"/>
</head>
<body>
	<jsp:include page="./carousel.jsp"/>
 	<jsp:include page="./menu.jsp" />
 <div class="container">
  <div class="jumbotron">
    <h2>Login/register to use the ToDo List System.</h2>
    <p>You can only access your own ToDo List. <br>
    	 Only admin has the authority to see all Lists. </p>     
  </div>
</div></body>
</html>