<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ToDo List Site</title>
<jsp:include page="./header.jsp" />
</head>
<body>
	<jsp:include page="./carousel.jsp" />
	<jsp:include page="./menu.jsp" />
	<div class="container">
		<div class="jumbotron">
			<form role="form" action="Login" method="post">
			<h2>${loginname}'s ToDoList</h2><br><br>

			<table class="table table-bordered">
				<tr>
					<th>Description</th>
					<th>Status</th>
					<th>Create Time</th>
					<th>Due Date</th>
					<th>Priority</th>
				</tr>
				<c:forEach items="${todoList}" var="todos">
					<tr>
						<td>${todos.description}</td>
						<td>${todos.status_id}</td>
						<td>to_char(${todos.init_time}, 'MM/DD/YYYY HH:MI:SS AM')</td>
						<td>to_char(${todos.due_date}, 'mm-dd-yy')</td>
						<td>${todos.urgency}</td>
					</tr>
				</c:forEach>
			</table>
			</form>
		</div>
	</div>
</body>
</html>