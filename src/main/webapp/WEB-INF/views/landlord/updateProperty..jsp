<%@page import="prms.homeaxis.landlord.entities.Property"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Properties</title>
</head>
<body>

<%
    Property property = (Property) request.getAttribute("property");
%>

<% if (property != null) { %>
    <form action="/property/updateProperty" method="post" enctype="multipart/form-data">
    <input type="hidden" name="property_id" value="${property.propertyId}" />
        <label>Title: </label><input type="text" name="title" value="<%= property.getTitle() %>" /><br/>
        <label>Description: </label><input type="text" name="description" value="<%= property.getDescription() %>" /><br/>
  <label>Location:</label>
    <textarea name="location" required>${property.location}</textarea><br/>
        <label>Price: </label><input type="text" name="price" value="<%= property.getPrice() %>" /><br/>

        <label>Amenities: </label><br/>
        <input type="checkbox" name="swimming_pool" <%= property.isSwimmingPool() ? "checked" : "" %> /> Swimming Pool<br/>
        <input type="checkbox" name="gym" <%= property.isGym() ? "checked" : "" %> /> Gym<br/>
        <input type="checkbox" name="garden" <%= property.isGarden() ? "checked" : "" %> /> Garden<br/>
        <input type="checkbox" name="parking" <%= property.isParking() ? "checked" : "" %> /> Parking<br/>
        <input type="checkbox" name="air_conditioning" <%= property.isAc() ? "checked" : "" %> /> AC<br/>
        <input type="checkbox" name="elevator" <%= property.isLift() ? "checked" : "" %> /> Lift<br/>
        <input type="checkbox" name="security_system" <%= property.isCctv() ? "checked" : "" %> /> CCTV<br/>
        <input type="checkbox" name="internet" <%= property.isWifi() ? "checked" : "" %> /> Wifi<br/>
        <input type="checkbox" name="furnished" <%= property.isFurnished() ? "checked" : "" %> /> Furnished<br/>
        
         <label>Type:</label>
        <select name="type_id">
          <%--   <option value="1" ${property.type_id == '1' ? 'selected' : ''}>Society</option>
            <option value="2" ${property.type_id == '2' ? 'selected' : ''}>Villas</option>
            <option value="3" ${property.type == '3' ? 'selected' : ''}>Independent House</option> --%>
        </select><br/>

        <label>Status:</label>
        <select name="status">
            <option value="Vacant" ${property.status == 'Vacant' ? 'selected' : ''}>Vacant</option>
            <option value="Occupied" ${property.status == 'Occupied' ? 'selected' : ''}>Occupied</option>
            <option value="Under Maintenance" ${property.status == 'Under Maintenance' ? 'selected' : ''}>Under Maintenance</option>
        </select><br/>

        <label>Current Image:</label><br/>
    <% if (property.getImage() != null) { %>
        <img src="data:image/jpeg;base64,<%= Base64.getEncoder().encodeToString(property.getImage().getBytes()) %>" alt="Property Image" width="200" height="200" /><br/>
    <% } else { %>
        <p>No image available.</p>
    <% } %>
    
    <!-- File input for uploading a new image -->
    <label>Upload New Image:</label>
    <input type="file" name="image" /><br/>
    
        <button type="submit">Update</button>
    </form>
<% } else { %>
    <p>Property not found.</p>
<% } %>

</body>
</html>