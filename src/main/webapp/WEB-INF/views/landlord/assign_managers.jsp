<%@page import="prms.homeaxis.user.entities.User"%>
<%@page import="java.util.Map"%>
<%@ page import="java.util.List" %>
<%@ page import="prms.homeaxis.landlord.entities.Property" %>
<%@ page import="prms.homeaxis.manager.entities.Manager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    List<Map<String, Object>> approvedManagers = (List<Map<String, Object>>) request.getAttribute("approvedManagers");
    List<Property> properties = (List<Property>) request.getAttribute("properties");
    List<Manager> assignedManagers = (List<Manager>) request.getAttribute("assignedManagers");

    String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assign/Remove Manager to Property</title>
<link rel="stylesheet" type="text/css" href="/css/tenant.css"> <!-- Link your CSS file -->
<link rel="stylesheet" type="text/css" href="/css/assign.css">
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
<div class="container form-container">
<h1>Assign/Remove Manager to Property</h1>

<%
    if (message != null && !message.isEmpty()) {
%>
<div class="message">
    <%= message %>
</div>
<%
    }
%>

<form action="<%= "/manager/assignManager" %>" method="POST">
    <label for="managerId">Select Approved Manager:</label>
	
    <table class="table table-bordered table-striped">
    <thead class="thead-light">
        <tr>
            <th class="white-column">Name</th>
            <th class="white-column">Mobile No</th>
            <th class="white-column">Email</th>
            <th class="white-column">Experience</th>
            <th class="white-column">Action</th>
        </tr>
        <%
            if (approvedManagers != null && !approvedManagers.isEmpty()) {
                for (Map<String,Object> manager : approvedManagers) {
        %>
        <tr>
            <td><%= manager.get("name") %></td>
            <td><%= manager.get("mobile_no") %></td>
            <td><%= manager.get("email_id") %></td>
            <td><%= manager.get("experience") %></td>
            <td>
                <input type="radio" name="managerId" value="<%= manager.get("manager_id") %>" required/>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6" class="text-center">No approved managers available</td>
        </tr>
        <%
            }
        %>
    </table>

    <label for="propertyId">Select Property:</label>
    <select name="propertyId" id="propertyId">
        <%
            if (properties != null && !properties.isEmpty()) {
                for (Property property : properties) {
        %>
            <option value="<%= property.getPropertyId() %>"><%= property.getTitle() %></option>
        <%
                }
            } else {
        %>
            <option value="">No properties available</option>
        <%
            }
        %>
    </select>

    <button type="submit">Assign Manager</button>
</form>

<form action="/manager/viewAssignManagers" method="GET">
    <button type="submit">View Assigned Managers</button>
</form>

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