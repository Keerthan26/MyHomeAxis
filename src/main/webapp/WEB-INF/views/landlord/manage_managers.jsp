<%@page import="java.util.Map"%>
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
    <%
    List<Map<String,Object>> listOfManagers = (List<Map<String,Object>>) request.getAttribute("listOfManagers");
	%>
	<table>
		<tr>
		<caption><h2>Manage Managers</h2></caption>
			<th>S. No</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Email Id</th>
			<th>Experience</th>
			<th>Current Status</th>
			<th>Authorize/Revoke</th>
		</tr>
		<%
		int Sno = 0;
		for (Map<String,Object> manager : listOfManagers) {
			boolean status=(Boolean) manager.get("status");
		%>

		<tr>
			<td><%=++Sno%></td>
			<td><%=manager.get("name")%></td>
			<td><%=manager.get("mobile_no")%></td>
			<td><%=manager.get("email_id")%></td>
			<td><%=manager.get("experience")%></td>
			
			<td><%=status ? "Manger is authorized" : "Authorization Pending"%></td>
			<td><a href="/manager/toogleAuthority/<%=manager.get("user_id") %>"><%=status ? "Revoke" : "Authorize"%></a></td>
		</tr>

		<%
		}
		%>
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