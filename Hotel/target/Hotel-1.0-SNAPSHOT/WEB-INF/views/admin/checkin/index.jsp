<%@include file="../header.jsp" %>

<title>Check In</title>
</head>
<%@include file="../navbar.jsp" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<div class="container">
    <h1>Check in</h1>
    <div class="pull-right">

    </div>
    <table class="table table-bordered table-hover table-striped">
        <tr>
            <td>Id</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Room Price</td>
            <td>Room Number</td>
            <td>Check In</td>
            <td>Total Nights</td>
            <td>Check outDate</td>
            <td>Total Price</td>
            <td>Action</td>
        </tr>
        <c:forEach var="checkin" items="${Checkin}">    
            <tr>
                <td>${checkin.checkinId}</td>
                <td>${checkin.getBooking().getFirstName()}</td>
                <td>${checkin.getBooking().getLastName()}</td>
                <td>${checkin.getBooking().getRoom().getRoomPrice()}</td>
                <td>${checkin.getBooking().getRoom().getRoomNumber()}</td>
                <td>${checkin.getBooking().getCheckinDate()}</td>
                <td>${checkin.getBooking().getTotalNights()}</td>
                <td>${checkin.getBooking().getCheckoutDate()}</td>
                <td>${checkin.getBooking().getTotalPrice()}</td>
                <td>
                    </a>
                    <a href="${SITE_URL}/admin/checkout/"  class="btn btn-success" onclick=" return confirm('Are you sure to checkout')">
                        <span class="glyphicon glyphicon-tower"></span>
                    </a>
                    <a href="${SITE_URL}/admin/booking/delete/${booking.bookingId}" class="btn btn-danger"  onclick=" return confirm('Are you sure to Delete')">
                        <span class="glyphicon glyphicon-trash">Delete</span>
                    </a>

                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<%@include file="../footer.jsp" %>