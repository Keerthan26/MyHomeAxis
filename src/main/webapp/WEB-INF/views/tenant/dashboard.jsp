<%@page import="prms.homeaxis.user.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tenant Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/tenant.css"> <!-- Link your CSS file -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"> <!-- For icons -->
<style>

.dashboard {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  justify-content: space-around;
}

.card {
  background-color: #fff;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
  text-align: center;
  width: 30%;
}

.card h2 {
  color: #2c3e50;
  margin-bottom: 10px;
}

.card p {
  color: #7f8c8d;
  margin-bottom: 20px;
}

.card button {
  background-color: black;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.card button:hover {
  background-color: #2980b9;
}

.card button a {
  color: white;
  text-decoration: none;
}

footer {
  background: #222;
  color: #fff;
  text-align: center;
  padding: 20px 0;
  width: 100%;
  position: relative;
}

footer a {
  color: #ffcc00;
  margin: 0 10px;
  text-decoration: none;
}
</style>
</head>
<body>
<!-- Navigation Bar -->
<header>
  <div>
    <h1>HomeAxis</h1>
  </div>
  <nav class="nav-links">
    <a href="/">Home</a>
    <div class="dropdown">
      <%
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
      %>
      <button class="dropdown-button"><%= loggedInUser.getName() %></button>
      <div class="dropdown-content">
        <a href="/view_profile">View Profile</a>
        <a href="/logout">Logout</a>
      </div>
      <%
        } else {
      %>
      <button class="dropdown-button">Guest</button>
      <div class="dropdown-content">
        <a href="/login">Login</a>
      </div>
      <%
        }
      %>
    </div>
  </nav>
</header>
<br><br>
<!-- Main Content -->
<main class="content">
  <%
    if (loggedInUser == null) {
      response.sendRedirect("/openLoginPage");
      return;
    }
    int tenantId = loggedInUser.getUserId();
  %>
  <div class="dashboard">
    <div class="card">
      <h2>View My Property</h2>
      <p>Check the details of the property you're currently renting.</p>
      <button><a href="/property/properties/<%= tenantId %>">View Property</a></button>
    </div>
    <div class="card">
      <h2>Manage Lease</h2>
      <p>Access and review your lease agreement.</p>
      <button><a href="/leaseAgreement/leaseAgreements/<%= tenantId %>">View Lease Agreement</a></button>
    </div>
    <div class="card">
      <h2>Payments</h2>
      <p>Make rental payments and view status.</p>
      <button><a href="/payment/payments/<%= tenantId %>">Payment Details</a></button>
    </div>
    <div class="card">
      <h2>Request Maintenance</h2>
				<p>Submit a request for maintenance or repairs.</p>
				<button><a href="/request/{tenantId}<%=tenantId %>">Request Maintenance</a></button>
			</div>
  </div>
</main>
<br><br><br>
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