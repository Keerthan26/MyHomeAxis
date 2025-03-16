<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<link href="/css/login.css" rel="stylesheet" type="text/css" />
<script>
function validateForm() {
    var newPassword = document.forms["resetForm"]["newPassword"].value;
    var confirmPassword = document.forms["resetForm"]["confirmPassword"].value;
    if (newPassword !== confirmPassword) {
        document.getElementById("error-message").innerText = "Passwords do not match";
        return false;
    }
    return true;
}
</script>
</head>
<body>
    <div class="container">
        <form name="resetForm" action="/resetPassword" method="post" onsubmit="return validateForm()">
            <h1>Forgot Password</h1>
            <input type="text" name="username" placeholder="Enter username" aria-label="Username" required /><br />
            <input type="password" name="newPassword" placeholder="Enter new password" aria-label="New Password" required /><br />
            <input type="password" name="confirmPassword" placeholder="Confirm new password" aria-label="Confirm Password" required /><br />
            <input type="submit" value="Reset Password" /><br />
        </form>
        <p id="error-message" style="color: red;"></p>
        <p>
            <a href="/openLoginPage">Back to Login</a><br><br>
            <a href="/">Home</a>
        </p>
        <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
            out.print("<p style='color: red;'>" + message + "</p>");
        }
        %>
    </div>
</body>
</html>  