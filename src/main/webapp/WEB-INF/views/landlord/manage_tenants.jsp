<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="prms.homeaxis.user.entities.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>HomeAxis - Manage Tenants</title>
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
          if (loggedInUser != null) {
            String userName = loggedInUser.getName();
            int roleId = loggedInUser.getRole_id();
        %>
          <button class="dropdown-button"><%= userName %></button>
          <div class="dropdown-content">
            <a href="/viewProfile">View Profile</a>
            <%
              if (roleId == 1) {
            %>
              <a href="/landlord/dashboard">Dashboard</a>
            <%
              } else if (roleId == 2) {
            %>
              <a href="/manager/dashboard">Dashboard</a>
            <%
              }
            %>
            <a href="/logout">Logout</a>
          </div>
        <%
          } else {
            response.sendRedirect("/login");
            return;
          }
        %>
      </div>
    </nav>
  </header>
  <!-- Main Content -->
  <div class="content">
    <%
      List<User> listOfTenants = (List<User>) request.getAttribute("listOfTenants");
    %>
    <table>
      <tr>
      <caption><h2>Manage Tenants</h2></caption>
        <th>S. No</th>
        <th>Name</th>
        <th>Mobile</th>
        <th>Email Id</th>
        <th>Current Status</th>
        <th>Authorize/Revoke</th>
      </tr>
      <%
        int Sno = 0;
        for (User tenant : listOfTenants) {
          boolean status = tenant.isStatus();
      %>
      <tr>
        <td><%= ++Sno %></td>
        <td><%= tenant.getName() %></td>
        <td><%= tenant.getMobile() %></td>
        <td><%= tenant.getEmailId() %></td>
        <td><%= status ? "Tenant is authorized" : "Authorization Pending" %></td>
        <td><a href="/tenant/toogleAuthority/<%= tenant.getUserId() %>"><%= status ? "Revoke" : "Authorize" %></a></td>
      </tr>
      <%
        }
      %>
    </table>
    <br><br>
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