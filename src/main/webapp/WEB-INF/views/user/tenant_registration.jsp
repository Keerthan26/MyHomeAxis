<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tenant Register Here</title>
<link href="/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<h1>Tenant Registration Page</h1>

		<form action="/tenantRegister" method="post" enctype="multipart/form-data">
			<input type="text" name="name" placeholder="Enter Name" required /><br>
			<input type="text" name="emailId" placeholder="Enter Email Id" required /><br> 
			<input type="text" name="mobile" placeholder="Enter Mobile No" required /><br> 
			<input type="date" name="dateOfBirth" required /><br> 
			Tenant Type:
			<input type="text" name="tenantType" placeholder="family ,bachelor" requried/>			
  			<input type="number" name="noOfPerson" placeholder="No. of Persons" required/><br>
			
			<input type="text" name="username" placeholder="Enter username" required /><br> 
			<input type="password" id="password" name="password" placeholder="Enter password" required /><br>
			<p>
				Upload Profile Image 
				<input type="file" name="profileImage" accept=".jpg, .jpeg, .png" required>
			</p>
			<p>
				Upload Id Proof 
				<input type="file" name="idProof" accept=".jpg, .jpeg, .png" required>
			</p>

			<input type="submit" value="Create Account" />

		</form>


		<p>
			Already signed up! <a href="/openLoginPage">Login Here</a>
		</p>

		<p>
			<a href="/">Home</a>
		</p>
	</div>
	
	<%
        String message = (String) request.getAttribute("message");
        if (message != null) {
        %>
            <div class="warning"><%= message %></div>
        <%
        }
        %>
</body>
</html>