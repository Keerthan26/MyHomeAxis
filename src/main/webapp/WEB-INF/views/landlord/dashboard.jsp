<%@page import="prms.homeaxis.user.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <title>HomeAxis - Manager Dashboard</title>
  <link rel="stylesheet" type="text/css" href="/css/admin.css"> <!-- Link your CSS file -->
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
        <button class="dropdown-button"><%= ((User) session.getAttribute("loggedInUser")).getName()       +"               ....   ."%></button>
        <div class="dropdown-content">
          <a href="/viewProfile">View Profile</a>
          <a href="/logout">Logout</a>
        </div>
      </div>
    </nav>
  </header>
  
  <!-- Main Content -->
  <div class="dashboard-container">
    <h1>Welcome to HomeAxis Landlord Dashboard</h1>
    <div class="dashboard-buttons">
      <a href="/manager/viewAllMangers" class="button">Authorize / UnAuthorize Managers</a>
      <a href="/tenant/viewAllTenants" class="button">Authorize / UnAuthorize Tenants</a>
      <a href="/landlord/manageproperties" class="button">Manage Property</a>
      <a href="/manager/assignManagers" class="button">Assign Managers</a>
      <a href="/landlord/getAllPayments" class="button">Manage Payments</a>
      <a href="/viewMaintenanceRequest" class="button">View Maintenance Request</a>
    </div>
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