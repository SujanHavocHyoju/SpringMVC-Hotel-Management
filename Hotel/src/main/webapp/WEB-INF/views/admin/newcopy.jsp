<%@include file="../header.jsp" %>

<title>Admin Login</title>
</head>
<%@include file="../navbar.jsp" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<%@include file="../footer.jsp" %>