<%@page import="prms.homeaxis.user.entities.User"%>
<%@page import="java.util.Map"%>
<%@page import="prms.homeaxis.tenant.entities.MaintenanceRequest"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Maintenance Request</title>
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
    <table>
        <thead>
        <caption><h1>Maintenance Requests</h1></caption>
            <tr>
                <th>S.NO</th>
                <th>Tenant Name</th>
                <th>Manager Name</th>
                <th>Type</th>
                <th>Description</th>
                <th>Status</th>
                <th>Created At</th>
                <th>Manage Status</th>
            </tr>
        </thead>
        <tbody>
            <%
                int sno = 0;
                List<Map<String, Object>> requests = (List<Map<String, Object>>) request.getAttribute("requests");
                if (requests != null) {
                    for (Map<String, Object> maintenanceRequest : requests) {
            %>
            <tr>
                <td><%= ++sno %></td>
                <td><%= maintenanceRequest.get("tenant_name") %></td>
                <td><%= maintenanceRequest.get("manager_name") %></td>
                <td><%= maintenanceRequest.get("request_type") %></td>
                <td><%= maintenanceRequest.get("description") %></td>
                <td><%= maintenanceRequest.get("status") %></td>
                <td style="color: red;"><%= maintenanceRequest.get("created_at") %></td>
                <td>
                    <div class="action-buttons">
                        <%
                            if ("open".equals(maintenanceRequest.get("status"))) {
                        %>
                            <form action="/maintenanceUpdateStatus" method="post">
                                <input type="hidden" name="maintenanceId" value="<%= maintenanceRequest.get("maintenance_id") %>">
                                <select name="status">
                                    <option value="">Select status</option>
                                    <option value="Completed">Accept</option>
                                    <option value="Cancelled">Decline</option>
                                </select>
                                <button type="submit">Submit</button>
                            </form>
                        <%
                            }
                        %>
                    </div>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="9" class="text-center">No maintenance requests available.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
<br><br><br><br><br>
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