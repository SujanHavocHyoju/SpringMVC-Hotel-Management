<%@include file="../header.jsp" %>

<title>Book a Room</title>
</head>
<%@include file="../navbar.jsp" %>

<% 
    
if(session.getAttribute("username")==null) 
{

response.sendRedirect("login.jsp");
}
%>
<div class="container">
        <h1>Your Booking Detail</h1>
        
        <table class="table table-bordered table-hover table-striped">
            <tr>
            <td>Id</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Room Id</td>
            <td>Room Price</td>
            <td>Room Number</td>
            <td>Room Type</td>
            <td>CheckIn</td>
            <td>Total Nights</td>
            <td>Check outDate</td>
            <td>Booked By</td>
            <td>Total Price</td>
            <td>Status</td>
            <td>Action</td>
            </tr>
           <c:forEach var="booking" items="${Booking}">
                <tr>
                <td>${booking.bookingId}</td>
                <td>${booking.firstName}</td>
                <td>${booking.lastName}</td>
                <td>${booking.getRoom().getRoomId()}</td>
                <td>${booking.getRoom().getRoomPrice()}</td>
                <td>${booking.getRoom().getRoomNumber ()}</td>
                <td>${booking.getRoom().getRoomType()}</td>
                <td>${booking.checkinDate}</td>
                <td>${booking.totalNights}</td>
                <td>${booking.checkoutDate}</td>
                <td>${booking.getCustomer().getCustomerId()}</td>
                <td>${booking.totalPrice}</td>
                <td>${booking.status}</td>
                <td>
                 <a href="${SITE_URL}/admin/booking/delete/${booking.bookingId}" class="btn btn-danger"  onclick=" return confirm('Are you sure to Delete')">
                  <span class="glyphicon glyphicon-trash"></span>
                  </a>
                 </td>
                </tr>
           </c:forEach>
        </table>
</div>
<%@include file="../footer.jsp" %>