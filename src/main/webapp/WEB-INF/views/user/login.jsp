<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Here</title>
<link rel="stylesheet" type="text/css" href="/css/login.css"> 
<script>
function validateForm() {
    var username = document.forms["loginForm"]["username"].value;
    var password = document.forms["loginForm"]["password"].value;
    if (username == "" || password == "") {
        alert("Username and Password must be filled out");
        return false;
    }
    return true;
}
</script>
</head>
<body>
    <div class="container">
        <form name="loginForm" action="/login" method="post" onsubmit="return validateForm()">
        <h1>Login Here</h1>

            <input type="text" name="username" placeholder="Enter username" /><br >

            <input type="password" name="password" placeholder="Enter password" /><br><br>
            <input type="submit" value="Login" /><br />

        </form>
        <p>
        	Forgot Password<a href="forgotPassword "> Click Here</a><br><br>
            Register as Manager <a href="/ManagerRegistrationPage">Click Here</a><br><br>
            Register as Tenant <a href="/TenantRegistrationPage">Click Here</a><br><br>
            <a href="/">Home</a>

        </p>
        <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
        %>
            <div class="warning"><%= message %></div>
        <%
        }
        %>
    </div>
</body>
</html>