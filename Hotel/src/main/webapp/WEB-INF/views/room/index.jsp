<%@include file="../header.jsp" %>

<title>Find Room</title>
</head>
<%@include file="../navbar.jsp" %>

<div class="container-fluid" >


    <c:forEach items="${Room}" var="room" >
        <div class="wrapper">
            <img src="<c:url value='/static/uploadedImages/${room.roomImage}'/>" alt=" our rooms"/>
            <div id="getRoomDetails">
                <label>Room Type: ${room.roomType}</label><br>
                <label>Room Description: ${room.roomDescription}</label><br>
                <label>Room Number: ${room.roomNumber}</label><br>
                <label>Room Price: Rs. ${room.roomPrice}/-</label><br>
                <a class="btn btn-success" href="${SITE_URL}/booking/add/${room.roomId}">

                    <span class="glyphicon glyphicon-pencil">Book now</span>
                </a>
            </div>
        </div><br/>
    </c:forEach>
</div>

<%@include file="../footer2.jsp" %>