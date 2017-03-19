<%@include file="../header.jsp" %>

<title>Comments</title>
</head>
<%@include file="../navbar.jsp" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<div class="container">
    <h1>Comments</h1>
    <div class="pull-right">
        <p>
            <a href="${SITE_URL}/admin/comments/add" class="btn btn-primary" title="Add User"/>
            <span class="glyphicon glyphicon-plus"></span>
            </a>
        </p>
    </div>
    <table class="table table-bordered table-hover table-striped">
        <tr>
            <td>Id</td>
            <td>Customer Id</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Username</td>
            <td>Message</td>
            <td>Action</td>
        </tr>
        <c:forEach var="comments" items="${Comments}">
            <tr>
                <td>${comments.commentsId}</td>
                <td>${comments.getCustomer().getCustomerId()}</td>
                <td>${comments.getCustomer().getFirstName()}</td>
                <td>${comments.getCustomer().getLastName()}</td>
                <td>${comments.getCustomer().getUsername()}</td>
                <td>${comments.message}</td>

                <td>
                    <a href="${SITE_URL}/admin/comments/edit/${comments.commentsId}" class="btn btn-success" title="Edit">
                        <span class="glyphicon glyphicon-pencil">Edit</span>
                    </a>
                    <a href="${SITE_URL}/admin/comments/delete/${comments.commentsId}" class="btn btn-danger" title="Delete" onclick=" return confirm('Are you sure to Delete')">
                        <span class="glyphicon glyphicon-trash">Delete</span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="../footer.jsp" %>