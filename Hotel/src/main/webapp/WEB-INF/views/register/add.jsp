<%@include file="../header.jsp" %>

<title>Sign Up</title>
</head>
<%@include file="../navbar.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
<h1>Register Free Account</h1>
<form:form modelAttribute="Customer" action="${SITE_URL}/register/save" method="post" role="form" id="customerForm">
    <div class="form-group">
        <label>First Name</label>
        <form:input path="firstName" placeholder="" class="form-control" />
    </div>
    <div class="form-group">
        <label>Last Name</label>
        <form:input path="lastName" placeholder=""  class="form-control"/>
    </div>
    
    <div class="form-group">
        <label>Email</label>
        <form:input path="email" placeholder="Enter email" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Contact</label>
        <form:input path="contactNo" type="numbers"  required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>UserName</label>
        <form:input path="username" placeholder="Enter username" required="required" class="form-control"/>
    </div>
     <div class="form-group">
        <label>Password</label>
        <form:input path="password"  type="password" placeholder="Enter password" required="required" class="form-control"/>
    </div>
    
   <form:hidden path="customerId"/>
    <div class="form-group"> 
    <button type="submit" class="btn btn-success" >Save</button>
    </div>
   
</form:form>
</div>

<%@include file="../footer.jsp" %>