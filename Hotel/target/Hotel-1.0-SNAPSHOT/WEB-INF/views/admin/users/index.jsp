<%@include file="../header.jsp" %>

<title>Users</title>
</head>
<%@include file="../navbar.jsp" %>
<%

    if (session.getAttribute("username") == null) {

        response.sendRedirect("admin/default/login");
    }
%>
<div class="container">
    <h1 style="text-align: center">welcome ${username}</h1>
    <h3>Users</h3>
    <div class="pull-right">
        <p>
            <a href="${SITE_URL}/admin/users/add" class="btn btn-primary" title="Add User"/>
            <span class="glyphicon glyphicon-plus"></span>
            </a>
        </p>
    </div>
    <table class="table table-bordered table-hover table-striped">
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>E-mail</th>
            <th>Username</th>
            <th>Password</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        <c:forEach var="users" items="${User}">
            <tr>
                <td>${users.userId}</td>
                <td>${users.firstName}</td>
                <td>${users.lastName}</td>
                <td>${users.email}</td>
                <td>${users.username}</td>
                <td>${users.password}</td>
                <td>${users.roleId}</td>
                <td>
                    <a href="${SITE_URL}/admin/users/edit/${users.userId}" class="btn btn-success" title="Edit">
                        <span class="glyphicon glyphicon-pencil">Edit</span>
                    </a>
                    <a href="${SITE_URL}/admin/users/delete/${users.userId}" class="btn btn-danger" title="Delete" onclick=" return confirm('Are you sure to Delete')">
                        <span class="glyphicon glyphicon-trash">Delete</span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>            

<%@include file="../footer.jsp" %>