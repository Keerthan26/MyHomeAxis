<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager register</title>
<link href="/css/login.css" rel="stylesheet" type="text/css"/>
<script src="/js/register.js"></script>
</head>
<body>
<div class="container">
<h1>Manager Registration </h1>
<%
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
    <div class="warning"><%= message %></div>
<%
    }
%>
<form action="/managerRegister" method="post" enctype="multipart/form-data">
    <input type="text" name="name" placeholder="Enter name" required /><br> 
    <input type="text" name="emailId" placeholder="Enter email id" required oninput="validateEmail(this)" /><br>
    <span id="emailSuggestion"></span>
    <input type="text" name="mobile" placeholder="Enter mobile no" required oninput="validatePhone(this)" /><br>
    <span id="phoneSuggestion"></span>
    <input type="date" name="dateOfBirth" required /><br> 
    <input type="number" name="experience" placeholder="Enter experience" required /> <br>
    <input type="text" name="username" placeholder="Enter username" required oninput="validateUsername(this)" /><br>
    <span id="usernameSuggestion"></span>
    <input type="password" id="password" name="password" placeholder="Enter password" required oninput="validatePassword(this)" /><br>
    <span id="passwordSuggestion"></span>
    
    <p>Upload profile image
    <input type="file" name="profileImage" accept=".jpg, .jpeg, .png" required>
    </p>
    <p>Upload id proof
    <input type="file" name="idProof" accept=".jpg, .jpeg, .png" required>
    </p>
    <p>Upload your latest resume
    <input type="file" name="resume" accept=".jpg, .jpeg, .png, .pdf" required>
    </p> 
    <input type="submit" value="Create account" />
</form>
            
<p>Already signed up? <a href="/openLoginPage">Login Here</a></p>
<p><a href="/">Home</a></p>
</div>

</body>
</html>