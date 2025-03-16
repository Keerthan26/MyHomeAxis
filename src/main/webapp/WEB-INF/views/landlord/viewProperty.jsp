<%@page import="java.util.Base64"%>
<%@page import="prms.homeaxis.landlord.entities.Property"%>
<%@page import="prms.homeaxis.user.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Property Details</title>
<style>
body {
  font-family: Arial, sans-serif;
  background-image: url('https://img.freepik.com/premium-photo/blur-background-modern-office-interior-design-contemporary-workspace-creative-business_31965-74711.jpg');
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  margin: 0;
  padding: 0;
}

.container {
  width: 60%;
  margin: 50px auto;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
  border-radius: 10px;
}

.property-image {
  width: 100%;
  height: auto;
  border-radius: 10px;
}

.property-details {
  padding: 20px;
}

.property-details h2 {
  margin-top: 0;
  font-size: 2em;
  color: #2c3e50;
}

.property-details p {
  margin: 10px 0;
  line-height: 1.6;
}

.property-details .price {
  font-weight: bold;
  color: #e74c3c;
  font-size: 1.5em;
}

.property-details .location {
  color: #7f8c8d;
  font-size: 1.2em;
}

.property-details .amenities {
  margin-top: 20px;
}

.property-details .amenities p {
  margin: 5px 0;
}

.property-details .amenities span {
  font-weight: bold;
  color: #2c3e50;
}

.buttons {
  margin-top: 20px;
  display: flex;
  justify-content: space-between;
}

.buttons form {
  display: inline-block;
}

.buttons button, .buttons .button {
  padding: 10px 20px;
  font-size: 1em;
  color: #fff;
  background-color: #3498db;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
  text-decoration: none;
}

.buttons button:hover, .buttons .button:hover {
  background-color: #2980b9;
}

.buttons .delete {
  background-color: #e74c3c;
}

.buttons .delete:hover {
  background-color: #c0392b;
}
</style>
</head>
<body>
<%
Property property = (Property) request.getAttribute("property");
User loggedInUser = (User) session.getAttribute("loggedInUser");
if (property != null && property.getImage() != null) {
    String base64Image = Base64.getEncoder().encodeToString(property.getImage().getBytes());
%>
<div class="container">
    <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Property Image" class="property-image">
    <div class="property-details">
        <h2><%= property.getTitle() %></h2>
        <p><%= property.getDescription() %></p>
        <p class="price">Price: ₹<%= property.getPrice() %></p>
        <p class="location">Location: <%= property.getAddress() %></p>
        <div class="amenities">
            <p>Swimming Pool: <span><%= property.isSwimmingPool() ? "Available" : "Not Available" %></span></p>
            <p>Gym: <span><%= property.isGym() ? "Available" : "Not Available" %></span></p>
            <p>Parking: <span><%= property.isParking() ? "Available" : "Not Available" %></span></p>
            <p>Garden: <span><%= property.isGarden() ? "Available" : "Not Available" %></span></p>
            <p>AC: <span><%= property.isAc() ? "Available" : "Not Available" %></span></p>
            <p>Lift: <span><%= property.isLift() ? "Available" : "Not Available" %></span></p>
            <p>CCTV: <span><%= property.isCctv() ? "Available" : "Not Available" %></span></p>
            <p>Wifi: <span><%= property.isWifi() ? "Available" : "Not Available" %></span></p>
            <p>Furnished: <span><%= property.isFurnished() ? "Yes" : "No" %></span></p>
        </div>
        <div class="buttons">
            <%
            if (loggedInUser != null && loggedInUser.getRole_id() == 1 ) {
            %>
            <form action="/property/updateProperty" method="get">
                <input type="hidden" name="propertyId" value="<%= property.getPropertyId() %>">
                <button type="submit">Update</button>
            </form>
            <form action="/property/deleteProperty" method="post" onsubmit="return confirm('Are you sure you want to delete this property?');">
                <input type="hidden" name="propertyId" value="<%= property.getPropertyId() %>">
                <button type="submit" class="delete">Delete</button>
            </form>
            <%
            } else if (loggedInUser != null && loggedInUser.getRole_id() == 2) {
                %>
                <form action="/property/updateProperty" method="get">
                    <input type="hidden" name="propertyId" value="<%= property.getPropertyId() %>">
                    <button type="submit">Update</button>
                    <a href="/" class="button">Back</a>
                </form>
               
                <%
                } 
            else if (loggedInUser != null &&  loggedInUser.getRole_id() == 3) {
            %>
            <a href="/rentProperty?propertyId=<%= property.getPropertyId() %>" class="button">Continue to Rent</a>
            <%
            }
            else {
            %>
            <a href="/openLoginPage" class="button">Login</a>
            <a href="/" class="button">Back</a>
            <%
            }
            %>
            
        </div>
    </div>
</div>
<%
} else {
%>
<p>Property or property image not found.</p>
<%
}
%>
</body>
</html>