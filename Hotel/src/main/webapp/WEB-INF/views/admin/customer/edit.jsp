<%@include file="../header.jsp" %>

<title>Edit Customer</title>
</head>
<%@include file="../navbar.jsp" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <h1>Edit Customer</h1>
    <form:form modelAttribute="Customer" action="${SITE_URL}/admin/customer/save" method="post" role="form" id="customerEditForm">
        <div class="form-group">
            <label>First Name</label>
            <form:input path="firstName" placeholder="Enter First Name" required="required" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Last Name</label>
            <form:input path="lastName" placeholder="Enter Last Name" required="required" class="form-control"/>
        </div>

        <div class="form-group">
            <label>Email</label>
            <form:input path="email" placeholder="Enter email" required="required" class="form-control"/>
        </div>

        <div class="form-group">
            <label>Contact No</label>
            <form:input path="contactNo" placeholder="Enter Contact No" required="required" class="form-control"/>
        </div>


        <div class="form-group">
            <label>Username</label>
            <form:input path ="username" placeholder="Enter Username" required="required" class="form-control"/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <form:input path ="password" placeholder="Your Password" type="password"  required="required" class="form-control"/>
        </div>
        <form:hidden path="customerId"/>
        <div class="form-group"> 
            <button type="submit" class="btn btn-success" >Save</button>
            <a href="${SITE_URL}/admin/customer" class="btn btn-danger">Cancel</a>
        </div>
    </form:form>

</div>
<script>
    $.validator.setDefaults({
        submitHandler: function () {
            alert("submitted!");
        }
    });

    $(document).ready(function () {
        // validate the comment form when it is submitted
        //$("#customerForm").validate();

        // validate signup form on keyup and submit
        $("#customerEditForm").validate({
            rules: {
                firstName: {
                    required: true,
                    lettersonly: true
                },
                lastName: {
                    required: true,
                    lettersonly: true
                },
                username: {
                    required: true,
                    minlength: 5,
                    lettersonly: true
                },
                password: {
                    required: true,
                    minlength: 5,
                    maxlength: 20
                },
//				confirm_password: {
//					required: true,
//					minlength: 5,
//					equalTo: "#password"
//				},
                email: {
                    required: true,
                    email: true
                },
                contactNo: {
                    required: true,
                    minlength: 7,
                    maxlength: 10,
                    integer: true

                },
//				agree: "required"
            },
            messages: {
                firstname: {
                    required: "Please enter your firstname",
                    lettersonly: "only letters"

                },

                lastname: {
                    required: "Please enter your lastname",
                    lettersonly: "only letters"

                },
                username: {
                    required: "Please enter a username",
                    minlength: "Your username must consist of at least 5 characters",
                    lettersonly: "only letters"
                },
                password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 5 characters long"
                },
//				confirm_password: {
//					required: "Please provide a password",
//					minlength: "Your password must be at least 5 characters long",
//					equalTo: "Please enter the same password as above"
//				},
                email: {
                    email: "Please enter a valid email address"
                },
//				agree: "Please accept our policy",
//				topic: "Please select at least 2 topics"
                contactNo: {
                    integer: "Please enter only numbers",
                    minlength: "number should not be at least 10"
                }
            }
        });

    });

</script>

<%@include file="../footer.jsp" %>