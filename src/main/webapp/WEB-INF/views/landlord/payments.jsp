<%@page import="java.util.Map"%>
<%@page import="prms.homeaxis.user.entities.User"%>
<%@page import="prms.homeaxis.landlord.entities.Payments"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Management</title>
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
    <table>
        <thead>
        <caption><h1>Payment Management</h1></caption>
            <tr>
                <th>S.NO</th>
                <th>Tenant Name</th>
                <th>Property</th>
                <th>Amount</th>
                <th>Payment Method</th>
                <th>Payment Date</th>
                <th>Status</th>
                <th>Manage Status</th>
            </tr>
        </thead>
        <tbody>
            <%
            int sno=0;
            List<Map<String,Object>> allPayments = (List<Map<String,Object>>) request.getAttribute("allPayments");
                if (allPayments != null) {
                    for (Map<String,Object> payment : allPayments) {
            %>
                <tr>
                    <td><%=++sno%></td>
                    <td><%=payment.get("tenant_name")%></td>
                    <td><%=payment.get("property_title")%></td>
                    <td><%=payment.get("amount")%></td>
                    <td><%=payment.get("payment_method")%></td>
                    <td><%=payment.get("payment_date")%></td>
                    <td><%=payment.get("status")%></td>
                    <td>
                        <div class="action-buttons">
                            <%
                                if ("Pending".equals(payment.get("status"))) {
                            %>
                                <form action="/landlord/updateStatus" method="post">
                                    <input type="hidden" name="paymentId" value="<%= payment.get("payment_id") %>">
                                    <select name="status">
                                        <option value="">Select Status</option>
										<option value="Approved" style="color: green;">Accept</option>
                                        <option value="Declined">Decline</option>
                                    </select>
                                    <button type="submit">Submit</button>
                                </form>
                            <%
                                }
                            %>
                        </div>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="8" class="text-center">No payments available.</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>
<br><br><br><br><br>
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