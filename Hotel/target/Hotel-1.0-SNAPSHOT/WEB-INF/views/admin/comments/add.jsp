<%@include file="../header.jsp" %>

<title>Add Comments</title>
</head>
<%@include file="../navbar.jsp" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <h1>Add Users</h1>
    <form:form modelAttribute="Comments" action="${SITE_URL}/admin/comments/save" method="post" role="form" id="commentsform">

        <div class="form-group">
            <label for="customerId">Customer</label>

            <form:select  name="Customer.customerId" path="Customer.customerId" class="form-control">
                <form:option value="0">Select Commentor</form:option>
                <c:forEach var="customer" items="${Customer}">
                    <form:option value="${customer.getCustomerId()}">${customer.getFirstName()}
                    </form:option>
                </c:forEach>
            </form:select>
        </div>     


        <div class="form-group">
            <label>Message</label>
            <form:input path ="message" name="message"  placeholder="Enter Message" required="required" class="form-control"/>
        </div>

        <!--<hidden path="commentsId"/>-->
        
        <form:hidden path="commentsId"/>
        <div class="form-group"> 
            <form:button type="submit" class="btn btn-success" >Save</form:button>
            <a href="${SITE_URL}/admin/comments"class="btn btn-danger">Cancel</a>
        </div>
    </form:form>
</div>
<%@include file="../footer.jsp" %>