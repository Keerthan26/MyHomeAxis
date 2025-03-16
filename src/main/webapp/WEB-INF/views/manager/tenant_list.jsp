<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List, prms.homeaxis.user.entities.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tenant Management</title>
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
        <a href="/home">Home</a>

        <!-- Dropdown Menu for Manager -->
        <div class="dropdown">
            <%
                User loggedInUser = (User) session.getAttribute("loggedInUser");
                String userName = loggedInUser != null ? loggedInUser.getName() : "Manager";
            %>
            <button class="dropdown-button"><%= userName %></button>
            <div class="dropdown-content">
                <a href="/manager/dashboard">Dashboard</a>
                <a href="/view_profile">View Profile</a>
                <a href="/logout">Logout</a>
            </div>
        </div>
    </nav>
</header>

<h1 class="center">Tenant Management</h1>

<%
    List<Map<String, Object>> tenants = (List<Map<String, Object>>) request.getAttribute("tenants");

    if (tenants == null) {
        out.println("<p>No tenant information available.</p>");
    } else {
%>
    <table>
        <tr>
            <th>S. No</th>
            <th>Tenant Name</th>
            <th>Mobile No</th>
            <th>Tenant Type</th>
            <th>No. of Persons</th>
            <th>Property Title</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <%
        int sNo = 0;
        for (Map<String, Object> tenant : tenants) {
            boolean status = "active".equals(tenant.get("tenant_status"));
        %>
            <tr>
                <td><%= ++sNo %></td>
                <td><%= tenant.get("name") %></td>
                <td><%= tenant.get("mobile_no") %></td>
                <td><%= tenant.get("tenant_type") %></td>
                <td><%= tenant.get("no_of_person") %></td>
                <td><%= tenant.get("title") %></td>
                <td><%= tenant.get("tenant_status") %></td>
                <td><a href="/tenant/tenantStatusToggle/<%= tenant.get("tenant_id") %>?tenant_status=<%= tenant.get("tenant_status") %>&manager_id=<%= tenant.get("manager_id") %>">
                <%="active".equals(tenant.get("tenant_status")) ? "inactive" : "active"%></a></td>
            </tr>
        <%
        }
        %>
    </table>
<%
    }
%>
<br><br><br><br><br><br><br><br><br>
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