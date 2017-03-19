<%@include file="../header.jsp" %>

<title>Add Booking</title>
</head>
<%@include file="../navbar.jsp" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <h1>Add Booking</h1>
    <form:form modelAttribute= "Booking" action="${SITE_URL}/admin/booking/save" method="post" role="form" id="bookingForm">
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
            <label>Room Number</label>
            <form:input path="room.roomNumber"  id="roomnumber"   name="room.roomNumber" placeholder="Enter Room Number" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Room Type</label>
            <form:input path="room.roomType" id="roomType" name="room.roomType" placeholder="Enter Room Type"  class="form-control"/>
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
            <form:checkbox path="status" name="status" placeholder="Accept" required="required" class="form-control"/>
        </div>
        <form:hidden path="bookingId" name="bookingId"/>
        <div class="form-group"> 
            <button type="submit" class="btn btn-success" >Save</button>
            <a href="${SITE_URL}/admin/booking"class="btn btn-danger">Cancel</a>
        </div>
    </form:form>
</div>
<script>
    $("#getRoomDetails").on("click", function () {
        console.log("here");
        $.get('${SITE_URL}/admin/room/' + $("#bookingRoomId").val(), function (data, status) {
            $("#roomprice").val(data.roomById.roomPrice);
            $("#roomType").val(data.roomById.roomType);
            $("#roomnumber").val(data.roomById.roomNumber);

        });

    });

    $.validator.setDefaults({
        submitHandler: function () {
            alert("submitted!");
        }
    });

    $(document).ready(function () {
        // validate the comment form when it is submitted
        //$("#customerForm").validate();

        // validate signup form on keyup and submit
        $("#bookingForm").validate({
            rules: {
                firstName: {
                    required: true,
                    lettersonly: true
                },
                lastName: {
                    required: true,
                    lettersonly: true
                },
                checkinDate: {
                    required: true,
                    checkinDate: true
                },
                checkoutDate: {
                    required: true,
                    checkoutDate: true


                }
//				confirm_password: {
//					required: true,
//					minlength: 5,
//					equalTo: "#password"
//				},

//				contactNo: {
//					required: true,
//                                        minlength:7,
//					maxlength: 10,
//                                        integer:true
//                                        
//				}
//				agree: "required"
            },
            messages: {
                firstName: {
                    firstName: "Please enter your firstname",
                    lettersonly: "only letters"

                },

                lastName: {
                    required: "Please enter your lastname",
                    lettersonly: "only letters"

                },
                checkinDate: {
                    required: "Please choose checkinDate"

                },
                checkoutDate: {
                    required: "Please choose checkoutDate",
                    minlength: "Your password must be at least 5 characters long"
                }
//				confirm_password: {
//					required: "Please provide a password",
//					minlength: "Your password must be at least 5 characters long",
//					equalTo: "Please enter the same password as above"
//				},

//				agree: "Please accept our policy",
//				topic: "Please select at least 2 topics"
//                                contactNo:{
//                                    integer:"Please enter only numbers"
//                                    minlength:"number should not be at least 10"
//                                }
            }
        });

    });

</script>
<%@include file="../footer2.jsp" %>