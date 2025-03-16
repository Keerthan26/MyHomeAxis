<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="prms.homeaxis.user.entities.User" %>
<!DOCTYPE html>
<html>
<head>
  <title>HomeAxis - Manage Properties</title>
  <link rel="stylesheet" type="text/css" href="/css/manageproperty.css"> <!-- Link your CSS file -->
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
      <!-- Dropdown Menu for Manager -->
      <div class="dropdown">
        <button class="dropdown-button"><%= ((User) session.getAttribute("loggedInUser")).getName() %></button>
        <div class="dropdown-content">
          <a href="/viewProfile">View Profile</a>
          <a href="/landlord/dashboard">Dashboard</a>
          <a href="/logout">Logout</a>
        </div>
      </div>
    </nav>
  </header>
  
  <!-- Main Content -->
  <div class="content">
    <a href="/property/openAddProperty">Add Properties</a>
    <a href="/property/viewproperties">View Properties</a>
  </div>
  
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