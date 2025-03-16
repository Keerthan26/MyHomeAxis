<%@page import="prms.homeaxis.landlord.entities.Property"%>
<%@page import="java.util.List"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View properties</title>
<style>
body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
  margin: 0;
  padding: 0;
}

.container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  padding: 20px;
  margin-top: 120px; /* Added margin-top to avoid overlap with fixed search bar */
}

.card {
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
  transition: box-shadow 0.3s ease-in-out, transform 0.3s ease-in-out;
  width: 30%;
  height: 400px; /* Fixed height for uniform size */
  margin: 20px;
  text-decoration: none;
  color: inherit;
  background-color: #fff;
  border-radius: 10px;
  overflow: hidden;
  display: flex;
  flex-direction: column;
}

.card:hover {
  box-shadow: 0 8px 16px rgba(0,0,0,0.2);
  transform: translateY(-10px); /* Lift the card up */
}

.card img {
  width: 100%;
  height: 200px; /* Fixed height for images */
  object-fit: cover; /* Ensures the image covers the area without distortion */
}

.card-content {
  padding: 16px;
  flex-grow: 1;
}

.card-content h4 {
  margin: 0;
  font-size: 1.5em;
}

.card-content p {
  margin: 10px 0;
}

.card-content .price {
  font-weight: bold;
  color: #2c3e50;
}

.card-content .location {
  color: #7f8c8d;
}

.search-bar {
  width: 100%;
  padding: 20px;
  text-align: center;
  position: fixed; /* Make the search bar fixed */
  top: 0; /* Position it at the top */
  background-color: #fff; /* Background color to match the body */
  box-shadow: 0 2px 4px rgba(0,0,0,0.1); /* Add a subtle shadow */
}

.search-bar input[type="text"], .search-bar button {
  padding: 10px; /* Ensures the height is the same */
  font-size: 16px;
}

.search-bar input[type="text"] {
  width: calc(50% - 22px); /* Adjust width to be same for both input and button */
}

.search-bar button {
  cursor: pointer;
}

.all-properties-button {
    margin-top: 20px;
    padding: 10px;
    font-size: 16px;
    cursor: pointer;
}
</style>
</head>
<body>
<div class="search-bar">
    <form method="get" action="">
        <input type="text" name="location" placeholder="Search by location">
        <button type="submit">Search</button>
    </form>
</div>

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
%>
<div class="container">
<%
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
%>
</div>
<%
} else {
%>
<p>No properties available to display.</p>
<%
}
%>
</body>
</html>