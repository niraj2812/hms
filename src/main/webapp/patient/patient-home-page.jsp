<%-- 
    Document   : patient-home-page
    Created on : 27 May, 2014, 12:35:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
    <s:url id="hospitalRecords" namespace="/patient/record" action="navigatePatientHospitalRecord"/> 
    <s:url id="doctorRecords" namespace="/patient/record" action="navigatePatientDoctorRecord"/> 
    <s:url id="uploadDetailReports" namespace="/patient" action="localizeApplication"/> 
    <s:url id="manageReports" namespace="/patient" action="localizeApplication"/> 
    <s:url id="quickUpload" namespace="/patient" action="localizeApplication"/> 

    <a href="<c:url value='/j_spring_security_logout'/>">Logout</a><br/>  

    <h1>Hello <sec:authentication property="principal.Username"/></h1>
    <h1>Hello <s:property value="#session.patientInformation.firstName"/></h1>
    <h1>Hello <s:property value="#session.patientInformation.patientExchangeId"/></h1>
    

    Build Your Master Records<br/>
    <s:a href="%{hospitalRecords}" >Hospital Records</s:a><br/>
    <s:a href="%{doctorRecords}" >Doctor Records</s:a><br/>
    
    Report Details<br/>
    <s:a href="%{uploadDetailReports}" >Upload Your Detail Reports</s:a><br/>
    <s:a href="%{manageReports}" >Manage Your Reports</s:a><br/>
    <s:a href="%{quickUpload}" >Quick Upload/Update Later</s:a><br/>

</body>
</html>
