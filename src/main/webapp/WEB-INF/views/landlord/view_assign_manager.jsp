<%@page import="prms.homeaxis.user.entities.User"%>
<%@page import="java.util.Map"%>
<%@page import="prms.homeaxis.landlord.entities.Property"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assigned Managers</title>
<link rel="stylesheet" type="text/css" href="/css/tenant.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<style>

</style>
</head>
<body>
<!-- Navigation Bar -->
<header>
  <div>
    <h1>HomeAxis</h1>
  </div>
  <nav class="nav-links">
    <a href="/">Home</a>
    <% User loggedInUser = (User) session.getAttribute("loggedInUser"); if (loggedInUser != null) { %>
    <div class="dropdown">
      <button class="dropdown-button"><%= loggedInUser.getName() %></button>
      <div class="dropdown-content">
        <a href="/viewProfile">View Profile</a>
        <a href="/landlord/dashboard">Dashboard</a>
        <a href="/logout">Logout</a>
      </div>
    </div>
    <% } else { %>
    <a href="/openLoginPage" class="login-link">Login</a>
    <% } %>
  </nav>
</header>
<br>
<!-- Main Content -->
<div class="container">
  
  <table class="table table-bordered table-striped">
    <thead class="thead-light">
      <tr>
      <caption><h2 >Assigned Managers</h2></caption>
        <th class="white-column">S.No</th>
        <th class="white-column">Title</th>
        <th class="white-column">Manager </th>
        <th class="white-column">Mobile </th>
      </tr>
    </thead>
    <tbody>
      <%
      int sno=0;
      List<Map<String,Object>> viewListOfAssingManagers = (List<Map<String,Object>>) request.getAttribute("viewListOfAssingManagers");
      if (viewListOfAssingManagers != null) {
        for (Map<String,Object> property : viewListOfAssingManagers) {
      %>
      <tr>
        <td><%= ++sno %></td>
        <td><%= property.get("property_title") %></td>
        <td><%= property.get("manager_name") %></td>
        <td><%= property.get("mobile_no") %></td>
      </tr>
      <%
        }
      } else {
      %>
      <tr>
        <td colspan="3" class="text-center">No assigned managers found.</td>
      </tr>
      <%
      }
      %>
    </tbody>
  </table>
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