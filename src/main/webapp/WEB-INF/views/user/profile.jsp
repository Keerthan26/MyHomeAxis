<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="prms.homeaxis.user.entities.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" type="text/css" href="/css/tenant.css"> <!-- Link your CSS file -->
	<link rel="stylesheet" type="text/css" href="/css/profile.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"> <!-- For icons -->
</head>
<body>
    <!-- Navigation Bar -->
    <header>
        <div>
            <h1>HomeAxis</h1>
        </div>
        <nav>
            <a href="/">Home</a>
            <div class="dropdown">
                <button class="dropdown-button"><%= ((User) session.getAttribute("loggedInUser")).getName() %></button>
                <div class="dropdown-content">
                    <a href="/logout">Logout</a>
                </div>
            </div>
        </nav>
    </header>
    <br>
    <%
    User user = (User) session.getAttribute("loggedInUser");
    String base64Image = user != null ? Base64.getEncoder().encodeToString(user.getProfileImage().getBytes()) : "";
    String addressImage = user != null ? Base64.getEncoder().encodeToString(user.getIdProof().getBytes()) : "";
    %>
    
    <!-- Main Content -->
    <div class="profile-container">
        <div class="card">
            <h1>User Profile</h1>
            <p>Photo<br><br><%= !base64Image.isEmpty() ? "<img src='data:image/jpeg;base64," + base64Image + "' alt='Profile Image' class='profile-image' />" : "N/A" %></p>
            <p>Name: <%= user != null ? user.getName() : "N/A" %></p>
            <p>Date of Birth: <%= user != null ? user.getDateOfBirth() : "N/A" %></p>
            <p>Email: <%= user != null ? user.getEmailId() : "N/A" %></p>
            <p>Mobile: <%= user != null ? user.getMobile() : "N/A" %></p>
            <p>Address Proof<br><br><%= !addressImage.isEmpty() ? "<img src='data:image/jpeg;base64," + addressImage + "' alt='Address Proof' class='address-proof' />" : "N/A" %></p>
            <button class="button"><a href="/editProfile" class="button">Edit Profile</a></button>
        </div>
    </div>
    <br>
    <!-- Footer -->
    <footer>
        <p>Property Management &copy; 2024</p>
        <a href="#"><i class="fab fa-facebook"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
        <a href="#"><i class="fab fa-linkedin"></i></a>
        <p>Contact us at support@homeaxis.com or call us at (123) 456-7890</p>
    </footer>
</body>
</html>