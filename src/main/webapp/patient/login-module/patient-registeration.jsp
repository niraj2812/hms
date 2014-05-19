
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="product" content="Metro UI CSS Framework">
        <meta name="description" content="Simple responsive css framework">
        <meta name="author" content="Sergey S. Pimenov, Ukraine, Kiev">

        <link href="../../css/metro-bootstrap.css" rel="stylesheet">

        <!-- Load JavaScript Libraries -->
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

        <script>
            $(document).ready(function() {
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

        <title>Metro UI CSS : Metro Bootstrap CSS Library</title>
    </head>
    <body class="metro">


        <!--start header-->


        <!--end header-->


        <div class="tile-area tile-area-darkBlue ">



            <s:fielderror/>


            <s:url id="localeEN" namespace="/patient" action="localizeApplication" >
                <s:param name="request_locale" >en</s:param>
            </s:url>

            <s:url id="localeHI" namespace="/patient" action="localizeApplication" >
                <s:param name="request_locale" >hi</s:param>
            </s:url>

            <s:a href="%{localeEN}" >English</s:a>
            <s:a href="%{localeHI}" >Hindi</s:a>

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
                <s:select key="user.bloodGroup" name="userMaster.bloodGroup" headerKey="-1" headerValue="%{getText('bloodGroup.selectBloodGroup')}" list="bloodGroupList" />
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