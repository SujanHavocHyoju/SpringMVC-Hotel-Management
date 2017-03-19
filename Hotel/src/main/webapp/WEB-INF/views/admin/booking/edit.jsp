<%@include file="../header.jsp" %>

<title>Edit Booking</title>
</head>
<%@include file="../navbar.jsp" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <h1>Edit Booking</h1>
    <form:form modelAttribute= "Booking" action="${SITE_URL}/admin/booking/save" method="post" role="form">
        <div class="form-group">
            <label>First Name</label>
            <form:input path="firstName" placeholder="Enter First Name" required="required" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Last Name</label>
            <form:input path="lastName" placeholder="Enter Last Name" required="required" class="form-control"/>
        </div>

        <div class="form-group">
            <label>Room Id</label>
            <form:select id="bookingRoomId" name="Room.roomId" path="Room.roomId" class="form-control">
                <form:option value="0">Select Room</form:option>
                <c:forEach var="room" items="${Room}">
                    <form:option value="${room.getRoomId()}">${room.getRoomId()}</form:option>
                </c:forEach>

            </form:select>
        </div>  
        <div> 
            <button type="javascript(void);" id="getRoomDetails" class="btn btn-success" >ok</button> <button type="cancel" class="btn btn-danger" >cancel</button>
        </div>


        <div class="form-group">
            <label>Room Price</label>
            <form:input path="room.roomPrice"  id="roomprice"   name="room.roomPrice" placeholder="Enter Room Price" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Room Type</label>
            <form:input path="room.roomType" id="roomType" name="room.roomType"placeholder="Enter Room Type"  class="form-control"/>
        </div>
        <div class="form-group">
            <label>Check In Date</label>
            <form:input type="date"  path="checkinDate" name="checkinDate"  placeholder="yyyy-mm-dd" required="required" class="form-control"/>
        </div>

        <div class="form-group">
            <label>Check out Date</label>
            <form:input type="date" path="checkoutDate"  name="checkoutDate" placeholder="yyyy-mm-dd"  required="required" class="form-control"/>
        </div>
        <!--    <div class="form-group">
                <label>Total nights</label>
        <form:input path="totalNights"  name="totalNights"   required="required" class="form-control"/>
    </div>-->

        <div class="form-group">
            <label>Booked by</label>
            <form:select  name="Customer.customerId" path="Customer.customerId" class="form-control">
                <form:option value="0">Guest</form:option>
                <c:forEach var="customer" items="${Customer}">
                    <form:option value="${customer.getCustomerId()}">${customer.getFirstName()}
                    </form:option>
                </c:forEach>

            </form:select>
        </div>
        <!--        <div class="form-group">
                    <label>Total Price</label>
        <form:input path="totalPrice"  id="totalPrice" name="totalPrice" placeholder="Total Price"  class="form-control"/>
    </div>-->
        <div class="form-group">
            <label>Terms and Condition</label>
            <form:checkbox path="status" name="status" placeholder="Enter status" required="required" class="form-control"/>
        </div>
        <form:hidden path="bookingId" name="bookingId"/>
        <div class="form-group"> 
            <button type="submit" class="btn btn-success" >Save</button>
            <a href="${SITE_URL}/admin/booking"class="btn btn-danger">Cancel</a>
        </div>
    </form:form>
</div>
<script>
 $("#getRoomDetails").on("click",function(){
     console.log("here");
     $.get('${SITE_URL}/admin/room/'+$("#bookingRoomId").val(), function(data, status){
       $("#roomprice").val(data.roomById.roomPrice);
       $("#roomType").val(data.roomById.roomType);
       
    });         
   });  
</script>
<%@include file="../footer.jsp" %>