<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="prms.homeaxis.user.entities.User" %>
<!DOCTYPE html>
<html>
<head>
  <title>HomeAxis - Manager Dashboard</title>
  <link rel="stylesheet" type="text/css" href="/css/tenant.css"> <!-- Link your CSS file -->
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
        <%
          User loggedInUser = (User) session.getAttribute("loggedInUser");
          String userName = loggedInUser != null ? loggedInUser.getName() : "Manager";
        %>
        <button class="dropdown-button"><%= userName %></button>
        <div class="dropdown-content">
          <a href="/view_profile">View Profile</a>
          <a href="/logout">Logout</a>
        </div>
      </div>
    </nav>
  </header>

  <!-- Dashboard Section -->
  <div class="dashboard-container">
    <h1>Manager Dashboard</h1>
    <%
      if (loggedInUser == null) {
        response.sendRedirect("/openLoginPage");
        return;
      }
      int managerId = loggedInUser.getUserId();
    %>
    <div class="dashboard-buttons">
    <a href="/tenant/viewAllTenants" class="button">Approve/Reject Tenants</a>
      <a href="/tenant/openTenantPage/<%= managerId %>" class="button">Manage Tenants</a>
      <a href="/openRequestPage/<%= managerId %>" class="button">Manage Requests</a>
      <a href="/openPaymentPage/<%= managerId %>" class="button">Manage Payments</a>
      
    </div>
  </div>
<br><br><br><br><br><br><br>
  <!-- Footer -->
  <footer>
    <p>Property Management &copy; 2024</p>
    <a href="#"><i class="fab fa-facebook"></i></a>
    <a href="#"><i class="fab fa-twitter"></i></a>
    <a href="#"><i class="fab fa-instagram"></i></a>
    <a href="#"><i class="fab fa-linkedin"></i></a>
  </footer>
</body>
</html>