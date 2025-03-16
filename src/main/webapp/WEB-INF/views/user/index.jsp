<%@page import="prms.homeaxis.landlord.entities.Property"%>
<%@page import="prms.homeaxis.user.entities.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.stream.Collectors"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Base64"%>

<!DOCTYPE html>
<html>
<head>
<title>HomeAxis</title>
<link rel="stylesheet" type="text/css" href="css/dashboard.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

</head>
<body>
	<!-- Navigation Bar -->
	<header>
		<div>
			<h1>HomeAxis</h1>
		</div>
		<nav class="nav-links">
			<a href="/">Home</a>
			<%
			User loggedInUser = (User) session.getAttribute("loggedInUser");
			if (loggedInUser != null) {
			    String dashboardUrl = "/dashboard";
			    if (loggedInUser.getRole_id() == 2) {
			        dashboardUrl = "/manager/dashboard";
			    } else if (loggedInUser.getRole_id() == 3) {
			        dashboardUrl = "/tenant/dashboard";
			    }
			    else if (loggedInUser.getRole_id() == 1) {
			        dashboardUrl = "/landlord/dashboard";
			    }
			%>
			<div class="dropdown">
				<button class="dropdown-button"><%= loggedInUser.getName() +"          ...."%></button>
				<div class="dropdown-content">
					<a href="<%= dashboardUrl %>">Dashboard</a>
					<a href="/viewProfile">View Profile</a>
					<a href="/logout">Logout</a>
				</div>
			</div>
			<%
			} else {
			%>
			<a href="/openLoginPage" class="login-link">Login        .     ...</a>
			<%
			}
			%>
		</nav>
	</header>
	
	<!-- Search Bar -->
	<div class="search-bar">
	    <form method="get" action="">
	        <input type="text" name="location" placeholder="Search by location">
	        <button type="submit">Search</button>
	    </form>
	</div>
	
	<!-- Main Content -->
	<div class="dashboard-container">
		<div class="container">
			<%
			String searchLocation = request.getParameter("location");
			boolean showAll = "true".equals(request.getParameter("all"));
			List<Property> allProperties = (List<Property>) request.getAttribute("allproperties");

			if (allProperties != null && !allProperties.isEmpty()) {
			    List<Property> filteredProperties;

			    if (showAll) {
			        filteredProperties = allProperties;
			    } else {
			        filteredProperties = allProperties.stream()
			            .filter(property -> property.getAddress().toLowerCase().contains(searchLocation != null ? searchLocation.toLowerCase() : ""))
			            .collect(Collectors.toList());
			    }

			    if (filteredProperties.isEmpty()) {
			%>
			<p>No properties found.</p>
			<%
			    } else {
			        for(Property property : filteredProperties) {
			            String base64Image = Base64.getEncoder().encodeToString(property.getImage().getBytes());
			%>
			<a href="/property/viewProperty?propertyId=<%= property.getPropertyId() %>" class="card">
			    <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Property Image">
			    <div class="card-content">
			        <h4><b><%= property.getTitle() %></b></h4>
			        <p><%= property.getDescription() %></p>
			        <p class="price">Price: ₹<%= property.getPrice() %></p>
			        <p class="location">Location: <%= property.getAddress() %></p>
			    </div>
			</a>
			<%
			        }
			    }
			} else {
			%>
			<p>No properties available to display.</p>
			<%
			}
			%>
		</div>
	</div>
	<!-- Footer -->
	<footer>
		<p>Property Management &copy; 2024</p>
		<a href="#"><i class="fab fa-facebook"></i></a>
		<a href="#"><i class="fab fa-twitter"></i></a>
		<a href="#"><i class="fab fa-instagram"></i></a>
		<a href="#"><i class="fab fa-linkedin"></i></a>
		<p>Contact us at support@homeaxis or call us at +91 8897596820</p>
	</footer>
</body>
</html>