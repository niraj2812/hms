<%-- 
    Document   : success
    Created on : 25 Apr, 2014, 12:12:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<c:url value='/j_spring_security_logout'/>">Logout</a><br/>  
        <sec:authorize ifAnyGranted="ROLE_USER">  
            <h1>Only admin can see this</h1><br/>  
            <a href="admin"> Admin Home </a>  
        </sec:authorize>  
        <h1>Welcome</h1>  
    </body>
</html>
