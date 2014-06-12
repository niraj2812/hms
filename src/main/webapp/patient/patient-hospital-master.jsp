
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags"%>
<%@taglib  prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <sj:head jqueryui="true"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>



    </head>

    <body>
        <s:url var="fetchCountryStateCity" action="fetchCountryStateCity" namespace="/patient/record"/>
        <s:url var="getHospitalRecords" action="refreshHospitalRecords" namespace="/patient/record"/>

        <s:form action="addHospitalNumberMaster" id="mainform" namespace="/patient/record">

            <sj:select 
                href="%{fetchCountryStateCity}"
                id="countryName"
                name="countryMaster.countryName"
                list="countryMasterList"
                listKey="countryName"
                listValue="countryName"
                label="Country"
                emptyOption="false" 
                headerKey="-1"
                headerValue="---Please Select Country---"
                onChangeTopics="reloadStateList,reloadCityList" 
                onCompleteTopics="reloadStateList,reloadCityList" />

            <sj:select 
                href="%{fetchCountryStateCity}" 
                id="selectWithReloadTopicSecond"
                reloadTopics="reloadStateList" 
                onChangeTopics="reloadCityList" 
                onCompleteTopics="reloadCityList" 
                name="stateMaster.stateName"
                label="State"
                list="stateMasterList" 
                listKey="stateName"
                listValue="stateName"
                formIds="mainform"
                headerKey="-1"
                headerValue="---Please Select State---" />

            <sj:select 
                href="%{fetchCountryStateCity}" 
                id="city"
                reloadTopics="reloadCityList" 
                onChangeTopics="reloadHospital" 
                onCompleteTopics="reloadHospital" 
                value="%{cityMaster.cityName}"
                onselect="updateSession(this)"
                name="cityMaster.cityName"
                label="Country"
                list="cityMasterList" 
                listKey="cityName"
                listValue="cityName"
                formIds="mainform"
                headerKey="-1"
                headerValue="---Please Select City---" />

            <sj:select
                id="languages"
                href="%{getHospitalRecords}"
                list="hospitalMasters" 
                autocomplete="true"
                label="Hospital Name"
                name="hospitalNumbersMasterId.hospitalId"
                />
            <s:textfield label="Patient ID" name="hospitalNumbersMaster.hospitalPatientId"/>
            <s:textfield label="Registration Date" name="hospitalNumbersMaster.hospitalRegistrationDate"/>
            <s:submit value="Add record"/>
        </s:form>
    </body>
    <script>
        $(document).ready(function() {
            $("#city").change(function() {
                var cityName = $(this).val();
                $.ajax({
                    type: "post",
                    url: "patient/record/getHospitalRecords.action?cityName=" + cityName,
                    success: function(result) {
                    },
                    error: function(error) {
                    }
                });
            });
        });
    </script>

</html>
