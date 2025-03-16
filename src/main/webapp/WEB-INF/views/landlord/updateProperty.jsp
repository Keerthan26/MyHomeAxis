<%@page import="java.util.Base64"%>
<%@page import="prms.homeaxis.landlord.entities.Property"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Property</title>
<style>
body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
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

h2 {
  text-align: center;
  color: #2c3e50;
}

form {
  display: flex;
  flex-direction: column;
}

form label {
  margin-top: 10px;
  font-weight: bold;
  color: #2c3e50;
}

form input, form textarea, form select {
  padding: 10px;
  margin-top: 5px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 1em;
}

form input[type="file"] {
  padding: 3px;
}

form button {
  margin-top: 20px;
  padding: 10px;
  font-size: 1em;
  color: #fff;
  background-color: #3498db;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

form button:hover {
  background-color: #2980b9;
}

.property-image {
  width: 100%;
  height: auto;
  border-radius: 10px;
}
.button {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 20px;
  font-size: 1em;
  color: #fff;
  background-color: #e74c3c;
  border: none;
  border-radius: 5px;
  text-align: center;
  text-decoration: none;
  cursor: pointer;
  transition: background-color 0.3s;
}

.button:hover {
  background-color: #c0392b;
}
</style>
</head>
<body>
<%
Property property = (Property) request.getAttribute("property");
String base64Image = Base64.getEncoder().encodeToString(property.getImage().getBytes());
%>
<div class="container">
    <h2>Update Property</h2>
    <form:form method="post" modelAttribute="property" enctype="multipart/form-data">
        <form:hidden path="propertyId"/>
        <label for="image">Image:<br><br><img src="data:image/jpeg;base64,<%= base64Image %>" alt="Property Image" class="property-image"></label>
        <input type="file" name="image" id="image"/>
        
        <label for="title">Title:</label>
        <form:input path="title" id="title"/>

        <label for="description">Description:</label>
        <form:textarea path="description" id="description"/>

        <label for="price">Price:</label>
        <form:input path="price" id="price"/>

        <label for="address">Address:</label>
        <form:input path="address" id="address"/>

        <label for="swimmingPool">Swimming Pool:</label>
        <form:checkbox path="swimmingPool" id="swimmingPool"/>

        <label for="gym">Gym:</label>
        <form:checkbox path="gym" id="gym"/>

        <label for="parking">Parking:</label>
        <form:checkbox path="parking" id="parking"/>

        <label for="garden">Garden:</label>
        <form:checkbox path="garden" id="garden"/>

        <label for="ac">AC:</label>
        <form:checkbox path="ac" id="ac"/>

        <label for="lift">Lift:</label>
        <form:checkbox path="lift" id="lift"/>

        <label for="cctv">CCTV:</label>
        <form:checkbox path="cctv" id="cctv"/>

        <label for="wifi">Wifi:</label>
        <form:checkbox path="wifi" id="wifi"/>

        <label for="furnished">Furnished:</label>
        <form:checkbox path="furnished" id="furnished"/>

        

        <button type="submit">Update Property</button>
        
        <a href="/" class="button">Back to Properties</a>
    </form:form>
</div>
</body>
</html>