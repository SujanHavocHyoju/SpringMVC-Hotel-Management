<%@include file="../header.jsp" %>

<title>Customer Details</title>
</head>
<%@include file="../navbar.jsp" %>

<% 
    
if(session.getAttribute("username")==null) 
{

response.sendRedirect("login.jsp");
}
%>
        <h1>Customer</h1>
        
        <table class="table table-bordered table-hover table-striped">
            <tr>
            <td>Id</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>E-mail</td>
            <td>Contact no.</td>
            <td>Username</td>
            <td>Password</td>
       
            <td>Action</td>
            </tr>
        
                <tr>
                <td>${customer.customerId}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td>${customer.contactNo}</td>
                <td>${customer.username}</td>
                <td>${customer.password}</td>
                <td>
                    <a href="${SITE_URL}/admin/customer/edit/${customer.customerId}" class="btn btn-success" title="Edit">
                        <span class="glyphicon glyphicon-pencil">Edit</span>
                    </a>
                   
                </td>
                </tr>
            
        </table>
                    
<%@include file="../footer.jsp" %>