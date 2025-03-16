<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List, prms.homeaxis.user.entities.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Maintenance Requests</title>
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
	            <button class="dropdown-button"><%= ((User) session.getAttribute("loggedInUser")).getName()  %></button>
	            <div class="dropdown-content">
	                <a href="/manager/dashboard">Dashboard</a>
	                <a href="/view_profile">View Profile</a>
	                <a href="/logout">Logout</a>
	            </div>
	        </div>
	    </nav>
	</header>

	
	<%
	    List<Map<String, Object>> requests = (List<Map<String, Object>>) request.getAttribute("requests");

	    if (requests == null) {
	        out.println("<p>No request information available.</p>");
	    } else {
	%>
	<table>
		<tr>
		<caption><h3>Maintenance Requests</h3></caption>
			<th>S.No</th>
			<th>Tenant Name</th>
			<th>Request Type</th>
			<th>Description</th>
			<th>Requested Date</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<%
	        int sNo = 0;
	        for (Map<String, Object> req : requests) {
	        	 boolean status = (req.get("status") == "open" ? true : false);
	        %>
		<tr>
			<td><%= ++sNo %></td>
			<td><%= req.get("name") %></td>
			<td><%= req.get("request_type") %></td>
			<td><%= req.get("description") %></td>
			<td><%= req.get("requested_date") %></td>
			<td><%= req.get("status") %></td>
			<td><a href="/requestStatusToggle/<%=req.get("maintenance_id") %>?status=<%= req.get("status") %>&manager_id=<%=req.get("manager_id") %>">
			<%="open".equals(req.get("status"))? "completed":"open" %></a></td>
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