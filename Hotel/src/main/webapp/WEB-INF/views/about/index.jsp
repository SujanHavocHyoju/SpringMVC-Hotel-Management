<%-- 
    Document   : index
    Created on : Mar 17, 2017, 5:50:33 AM
    Author     : HYOJU
--%>
<%@include file="../header.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<title>About Us</title>
</head>
<%@include file="../navbar.jsp" %>

<div class="container-fluid" >
    
    <c:forEach items="${Comments}" var="comments" >
        <div class="wrapper">
            
        <div id="getComments">
            <label>Room Type:${comments}</label><br>
            <label>Room Description:${room.roomDescription}</label><br>
            <label>Room Number:${room.roomNumber}</label><br>
            <label>Room Price:${room.roomPrice}</label><br>
            <a href="${SITE_URL}/booking/add/${room.ro_id}"  class="btn btn-success" >
                        <span class="glyphicon glyphicon-pencil">Book now</span>
             </a>
        </div>
        </div>
    </c:forEach>
</div>

    <%@include file="../footer.jsp" %>
