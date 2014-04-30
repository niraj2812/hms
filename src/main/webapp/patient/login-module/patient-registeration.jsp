<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



    </head>

    <body>
        <s:form action="register">
            <s:textfield name="uname" key="patient.name"/>
            <s:password name="pass" key="patient.pass"/>
            <s:submit  value="Submit"/>

        </s:form>



    </body>
</html>
