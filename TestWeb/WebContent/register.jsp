RawBlameHistory 34 lines (33 sloc) 1017 Bytes
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
			<h2>
				ToDoList System <br> Welcome to join the ToDoList User Group
			</h2>
			<form class="form-inline" action="Register" method="post">
				<table class="table table-condensed">
					<tr>
						<td>
							<div class="form-group">
								<label class="sr-only" for="loginname">Login Name</label> <input
									type="text" class="form-control" id="loginname"
									placeholder="loginname" name="loginname" required="reguired">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="form-group">
								<label class="sr-only" for="email">Email</label> <input
									type="email" class="form-control" id="email"
									placeholder="email" name="email" required="reguired">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="form-group">
								<label class="sr-only" for="password">Password</label> <input
									type="password" class="form-control" id="password"
									placeholder="password" name="password">
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="checkbox">
								<label class="sr-only" for="admin">An Admin?</label> <input
									type="checkbox" class="form-control" id="admin"
									placeholder="admin" name="admin"> 
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<button type="submit" class="btn btn-success">Register</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
