<%@include file="../header.jsp" %>
<%@include file="../headeruser.jsp" %>
<% 
    
if(session.getAttribute("username")==null) 
{

response.sendRedirect("login.jsp");
}
%>
welcome ${username}
