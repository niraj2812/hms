<%-- 
    Document   : add-new-patient-hospita-record
    Created on : 6 Jun, 2014, 11:59:01 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form action="addHospitalRecord" namespace="/patient/record">
            <s:textfield label="Hospital name" name="stagingHospitalRecord.hospitalName"/>
            <s:textfield label="Patient ID" name="stagingHospitalRecord.hospitalPatientId"/>
            <s:textfield label="Registration Date" name="stagingHospitalRecord.hospitalRegistrationDate"/>
            <s:textfield label="Hospital Email" name="stagingHospitalRecord.hospitalEmail"/>
            <s:textfield label="Hospital Phone" name="stagingHospitalRecord.officePhone"/>
            <s:textfield label="Mobile No." name="stagingHospitalRecord.mobileNo"/>
            <s:textfield label="Hospital Address1" name="stagingHospitalRecord.officeAddress1"/>
            <s:textfield label="Hospital Address2" name="stagingHospitalRecord.officeAddress2"/>
            <s:textfield label="Hospital City" name="stagingHospitalRecord.officeCity"/>
            <s:textfield label="Hospital State" name="stagingHospitalRecord.officeState"/>
            <s:textfield label="Hospital Pin Code" name="stagingHospitalRecord.officePinCode"/>
            <s:textfield label="Hospital Country" name="stagingHospitalRecord.officeCountry"/>
            <s:submit value="Submit"/>
        </s:form>
    </body>
</html>
