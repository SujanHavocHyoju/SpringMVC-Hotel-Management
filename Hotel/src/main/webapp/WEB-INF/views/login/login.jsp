<%@include file="../header.jsp" %>

<title>Customer Login</title>
</head>
<%@include file="../navbar.jsp" %>

<body class="hold-transition login-page">
    <div class="login-box">
        <div class="login-logo">
            <br/><br/>
        </div> 

        <div class="login-box-body">
            <h3 class="text-center">Login to Continue</h3>
            <form action="${pageContext.request.contextPath}/login/checking" method="POST"> 
                <c:if test="${not empty error}">
                    <div class="error text-danger">${error}</div><br/>
                </c:if>

                <div class="row">
                    <div class="col-xs-4">
                    </div> 
                    <div class="col-xs-4">
                        <div class="form-group has-feedback">
                            <input type="text" class="form-control" name="username" placeholder="Username" required="required">  
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="password" class="form-control"  name="password" placeholder="Password" required="required">
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input id="remember-me" name="remember-me" type="checkbox" /> <b>Remember me</b>
                            </label>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <button type="submit" class="btn btn-primary btn-block btn-block">Log In</button>
                        <button type="reset" class="btn btn-default btn-block btn-block">Reset</button>

                    </div>
                    <div class="col-xs-4">
                    </div> 

                </div>
            </form>

        </div>
        <!--/.login-->
    </div> 



                               
    <%@include file="../footer.jsp" %>