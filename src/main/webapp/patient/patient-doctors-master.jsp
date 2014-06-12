<%-- 
    Document   : patient-doctors-master
    Created on : 26 May, 2014, 1:36:55 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        <sj:head jqueryui="true"/>

    </head>
    <body>
        <%--<s:url var="remoteurl" action="jsonlanguages"/>--%>

        <s:form action="addDoctorsRecord" namespace="/patient/record">
            <%-- <sj:datepicker id="date0" name="date0" label="With Button Panel" showButtonPanel="true"/>
            --%> 
            <sj:autocompleter 
                list="bloodGroupList"
                name="stagingHospitalId"
                selectBox="true"
                forceValidOption="true"
                onSelectTopics="autocompleteSelect"
                />

            <%--<s:textfield name="stagingHospitalId" label="Hospital Id"/>--%>
            <s:textfield name="doctorsFirstName" label="doctorsFirstName"/>
            <s:textfield name="doctorsLastName" label="doctorsLastName"/>
            <s:textfield name="specialization" label="specialization"/>
            <s:textfield name="doctorsEmail" label="doctorsEmail"/>
            <s:textfield name="officePhone" label="officePhone"/>
            <s:submit value="Submit"/>


        </s:form>
    </body>
</html>
