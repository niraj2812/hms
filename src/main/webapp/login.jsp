<%-- 
    Document   : login
    Created on : Mar 23, 2014, 4:53:12 PM
    Author     : niraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .errorblock {
                color: #ff0000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }
        </style>
    </head>
    <body>

    <c:if test="${not empty error}">
        <div class="errorblock">
            Your login attempt was not successful, try again.<br /> Caused :
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>
    <form method="post" action="<c:url value='j_spring_security_check' />">

        <table>  
            <tr>  
                <td align="right">My Username</td>  
                <td><input type="text" name="j_username" /></td>  
            </tr>  
            <tr>  
                <td align="right">My Password</td>  
                <td><input type="password" name="j_password" /></td>  
            </tr>  
            <tr>  
                <td colspan="2" align="right">  
                    <input type="submit" value="Login" />  
                </td>  
            </tr>  
        </table>  
    </form>
</body>
</html>
