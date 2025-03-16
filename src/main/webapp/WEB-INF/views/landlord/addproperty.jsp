<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="prms.homeaxis.user.entities.User" %>
<!DOCTYPE html>
<html>
<head>
  <title>HomeAxis - Add Property</title>
   <!-- Link your CSS file -->
  <link rel="stylesheet" type="text/css" href="/css/pform.css">
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
        <button class="dropdown-button"><%= ((User) session.getAttribute("loggedInUser")).getName() +"    ...."%></button>
        <div class="dropdown-content">
          <a href="/viewProfile">View Profile</a>
          <a href="/landlord/dashboard">Dashboard</a>
          <a href="/logout">Logout</a>
        </div>
      </div>
    </nav>
  </header>
<br><br>
  <!-- Main Content -->
  <div class="form-container">
    <form:form method="POST" action="/property/addProperty" modelAttribute="property" enctype="multipart/form-data">
     <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
        %>
            <div class="warning"><%= message %></div>
        <%
        }
        %>
      <h2>Add Property</h2>
      <table>
        <tr>
          <td>Property Title:</td>
          <td><form:input path="title" placeholder="Enter property title" /></td>
        </tr>
        <tr>
          <td>Property Description:</td>
          <td><form:input path="description" placeholder="Enter property description" /></td>
        </tr>
        <tr>
          <td>Property Type:</td>
          <td><form:select path="typeId">
              <form:option value="1">Apartment</form:option>
              <form:option value="2">Villa</form:option>
              <form:option value="3">Studio</form:option>
              <form:option value="4">Penthouse</form:option>
              <form:option value="5">Duplex</form:option>
            </form:select></td>
        </tr>
        <tr>
          <td>Price:</td>
          <td><form:input path="price" type="number" step="100" placeholder="Enter price" /></td>
        </tr>
        <tr>
          <td>Address:</td>
          <td><form:input path="address" placeholder="Enter address" /></td>
        </tr>
        <!-- Facilities -->
        <tr>
          <td>Swimming Pool:</td>
          <td><form:checkbox path="swimmingPool" /> </td>
        </tr>
        <tr>
          <td>Gym:</td>
          <td><form:checkbox path="gym" /> </td>
        </tr>
        <tr>
          <td>Parking:</td>
          <td><form:checkbox path="parking" /> </td>
        </tr>
        <tr>
          <td>Garden:</td>
          <td><form:checkbox path="garden" /> </td>
        </tr>
        <tr>
          <td>Air Conditioning:</td>
          <td><form:checkbox path="ac" /> </td>
        </tr>
        <tr>
          <td>Lift:</td>
          <td><form:checkbox path="lift" /> </td>
        </tr>
        <tr>
          <td>CCTV Cameras:</td>
          <td><form:checkbox path="cctv" /> </td>
        </tr>
        <tr>
          <td>Wifi:</td>
          <td><form:checkbox path="wifi" /> </td>
        </tr>
        <tr>
          <td>Furnished:</td>
          <td><form:checkbox path="furnished" /> </td>
        </tr>
        <!-- Image Upload -->
        <tr>
          <td>Property Image:</td>
          <td><input type="file" name="image" id="image" /></td>
        </tr>
      </table>
      <button type="submit">Add Property</button>
    </form:form>
  </div>
 
  
  <!-- Footer -->
  <footer>
    <p>Property Management &copy; 2024</p>
    <a href="#"><i class="fab fafacebook"></i></a>
    <a href="#"><i class="fab fa-twitter"></i></a>
    <a href="#"><i class="fab fa-instagram"></i></a>
    <a href="#"><i class="fab fa-linkedin"></i></a>
    <p>Contact us at support@homeaxis.com or call us at (123) 456-7890</p>
  </footer>
</body>
</html>