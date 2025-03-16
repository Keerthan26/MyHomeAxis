<%@page import="prms.homeaxis.user.entities.User"%>
<%@page import="prms.homeaxis.landlord.entities.Payments"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Management</title>
<link rel="stylesheet" type="text/css" href="/css/tenant.css">
<!-- Link your CSS file -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<!-- For icons -->
 

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
				<button class="dropdown-button"><%=((User) session.getAttribute("loggedInUser")).getName() %></button>
				<div class="dropdown-content">
					<a href="/manager/dashboard">Dashboard</a> <a href="/view_profile">View
						Profile</a> <a href="/logout">Logout</a>
				</div>
			</div>
		</nav>
	</header>
 <br>
	<h1 class="center">Payment Management</h1>
	<%
	List<Map<String, Object>> payments = (List<Map<String, Object>>) request.getAttribute("payments");
 
	if (payments == null) {
		out.println("<p>No payment information available.</p>");
	} else {
	%>
	<table>
		<tr>
			<th>S.No</th>
 
			<th>Name</th>
			<th>Payment ID</th>
			<th>Property ID</th>
			<th>Payment Method</th>
			<th>Rental Price</th>
			<th>Payment Date</th>
 
			<th>Status</th>
			<th>Action</th>
		</tr>
		<%
		int sNo = 0;
		for (Map<String, Object> payment : payments) {
			 boolean status = (payment.get("status") == "Approved" ? true : false);
		%>
		<tr>
			<td><%=++sNo%></td>
			<td><%=payment.get("name")%></td>
			<td><%=payment.get("property_id")%></td>
			<td><%=payment.get("property_id")%></td>
			<td><%=payment.get("payment_method")%></td>
			<td><%=payment.get("rental_price")%></td>
			<td><%=payment.get("payment_date")%></td>
			<td><%=payment.get("status")%></td>
            <td><a href="/paymentStatusToggle/<%=payment.get("payment_id") %>?status=<%= payment.get("status") %>&manager_id=<%=payment.get("manager_id") %>">
			<%="Approved".equals(payment.get("status"))? "Pending":"Approved" %></a></td>
			
					</tr>
				
		<%
		}
		%>
 
 
	</table>
	<%
	}
	%>
 
 
</body>
</html>