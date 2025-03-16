<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="prms.homeaxis.user.entities.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
    <link rel="stylesheet" type="text/css" href="/css/tenant.css">
    <link rel="stylesheet" type="text/css" href="/css/profile.css"> <!-- Link your CSS file -->
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
            <h1>Edit Profile</h1>
            <form action="/updateProfile" method="post" enctype="multipart/form-data">
   				 <p>Photo<br><br><%= user != null ? "<img src='data:image/jpeg;base64," + base64Image + "' alt='Profile Image' />" : "N/A" %></p>
    			 <input type="file" name="profileImage">
    			 <p>Name: <input type="text" name="name" value="<%= user != null ? user.getName() : "" %>"></p>
  				 <p>Date of Birth: <input type="date" name="dob" value="<%= user != null ? user.getDateOfBirth().toString() : "" %>"></p>
   				 <p>Email: <input type="email" name="email" value="<%= user != null ? user.getEmailId() : "" %>"></p>
   				 <p>Mobile: <input type="text" name="mobile" value="<%= user != null ? user.getMobile() : "" %>"></p>
   				 <p>Address Proof<br><br><%= user != null ? "<img src='data:image/jpeg;base64," + addressImage + "' alt='Address Proof' />" : "N/A" %></p>
   				 <input type="file" name="idProof">
    			<br><br>
    			<button type="submit">Submit</button>
    			<a href="/viewProfile" class="button">Back</a>
			</form>
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