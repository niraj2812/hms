<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>


<html>
    <head>
        <s:head/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../css/metro-bootstrap.css" rel="stylesheet">
        <link href="../../css/metro-bootstrap-responsive.css" rel="stylesheet">
        <link href="../../css/iconFont.css" rel="stylesheet">

        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

        <script src="../../js/metro.min.js"></script>
        <script src="../../js/metro/metro-calendar.js"></script>
        <script src="../../js/metro/metro-datepicker.js"></script>
        <script src="../../js/load-metro.js"></script>


        <!--<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>-->

        <!--<script src="../../js/jquery/jquery.js"></script>-->
        <!--<script src="../../js/jquery/ajax.js"></script>-->
        <script>
            $(document).ready(function() {

                $("#datepicker").datepicker();
                $('#register_userAccess_loginName').blur(function() {
                    $.ajax({
                        type: "post",
                        url: "<s:url action='patient/checkAvailability'/>",
                        data: "userAccess.loginName=" + this.value,
                        success: function(result) {
                            if (result === true) {
                                $('#register_userAccess_loginName').val("");
                                alert("Username already occupied!!");
                            }
                            alert("Success" + result);
                            //$('#div1').html(result);
                        },
                        error: function(error) {
                            alert("Error" + error);
                        }
                    });
                    return false;
                });
            });




        </script>
        <script>

        </script>
    </head>
    <body class="metro">
        <div class="container">

            <s:fielderror/>

            


            <s:form action="register" namespace="/patient"  >

                <s:textfield name="userAccess.loginName" key="user.loginName"  />
                <s:password name="userAccess.password" key="user.password"/>
                <s:password name="confirmPassword" key="user.confirmPassword"/>
                <s:textfield name="userMaster.firstName" key="user.firstName"/>
                <s:textfield name="userMaster.middleName" key="user.middleName"/>
                <s:textfield name="userMaster.lastName" key="user.lastName"/> 
                <%--<s:textfield name="userMaster.dob" key="user.dob"/>--%>
                <s:textfield name="userMaster.fatherFirstName" key="user.fatherFirstName"/> 
                <s:textfield name="userMaster.fatherLastName" key="user.fatherLastName"/> 
                <s:textfield name="userMaster.motherFirstName" key="user.motherFirstName"/> 
                <s:textfield name="userMaster.motherLastName" key="user.motherLastName"/> 
                <%--<s:textfield name="userMaster.gender" key="user.gender"/>--%> 
                <s:radio name="userMaster.gender" key="user.gender" list="genderGroup" />
                <s:select key="user.bloodGroup" name="userMaster.bloodGroup" headerKey="" headerValue="Select Blood Group" list="bloodGroupList" />
                <s:textfield name="userMaster.firstLanguage" key="user.firstLanguage"/> 
                <s:textfield name="userMaster.secondLanguage" key="user.secondLanguage"/> 
                <s:textfield name="userMaster.thirdLanguage" key="user.thirdLanguage"/> 
                <s:textfield name="userMaster.nationality" key="user.nationality"/> 
                <s:textfield name="addressMaster.homeAddress1" key="user.homeAddress1"/> 
                <s:textfield name="addressMaster.homeAddress2" key="user.homeAddress2"/> 
                <s:textfield name="addressMaster.homeCity" key="user.homeCity"/> 
                <s:textfield name="addressMaster.homeState" key="user.homeState"/> 
                <s:textfield name="addressMaster.homePinCode" key="user.homePinCode"/> 
                <s:textfield name="addressMaster.homeCountry" key="user.homeCountry"/> 
                <s:textfield name="addressMaster.officeAddress1" key="user.officeAddress1"/> 
                <s:textfield name="addressMaster.officeAddress2" key="user.officeAddress2"/> 
                <s:textfield name="addressMaster.officeCity" key="user.officeCity"/> 
                <s:textfield name="addressMaster.officeState" key="user.officeState"/> 
                <s:textfield name="addressMaster.officePinCode" key="user.officePinCode"/> 
                <s:textfield name="addressMaster.officeCountry" key="user.officeCountry"/> 

                <s:textfield name="contactMaster.email" key="user.email"/> 
                <s:textfield name="contactMaster.homePhone" key="user.homePhone"/> 
                <s:textfield name="contactMaster.officePhone" key="user.officePhone"/> 
                <s:textfield name="contactMaster.mobileNo" key="user.mobileNo"/> 
                <s:textfield name="contactMaster.emergencyContactNo" key="user.emergencyContactNo"/> 
                <s:textfield name="contactMaster.relationWithContactPerson" key="user.relationWithContactPerson"/> 

                <s:submit  value="Submit"/>
            </s:form>
        </div>
    </body>
</html>
