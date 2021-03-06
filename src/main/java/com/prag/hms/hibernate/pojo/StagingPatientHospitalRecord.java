package com.prag.hms.hibernate.pojo;
// Generated 28 May, 2014 6:57:44 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * StagingPatientHospitalRecord generated by hbm2java
 */
public class StagingPatientHospitalRecord  implements java.io.Serializable {


     private String stagingHospitalId;
     private String patientExchangeId;
     private String hospitalName;
     private String hospitalPatientId;
     private Date hospitalRegistrationDate;
     private String hospitalEmail;
     private String officePhone;
     private String mobileNo;
     private String officeAddress1;
     private String officeAddress2;
     private String officeCity;
     private String officeState;
     private String officePinCode;
     private String officeCountry;
     private String createdBy;
     private Date createdDate;
     private String modifiedBy;
     private Date modifiedDate;
     private String dataSource;
     private Set stagingPatientDoctorRecords = new HashSet(0);

    public StagingPatientHospitalRecord() {
    }

	
    public StagingPatientHospitalRecord(String stagingHospitalId, Date createdDate, Date modifiedDate) {
        this.stagingHospitalId = stagingHospitalId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
    public StagingPatientHospitalRecord(String stagingHospitalId, String patientExchangeId, String hospitalName, String hospitalPatientId, Date hospitalRegistrationDate, String hospitalEmail, String officePhone, String mobileNo, String officeAddress1, String officeAddress2, String officeCity, String officeState, String officePinCode, String officeCountry, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, String dataSource, Set stagingPatientDoctorRecords) {
       this.stagingHospitalId = stagingHospitalId;
       this.patientExchangeId = patientExchangeId;
       this.hospitalName = hospitalName;
       this.hospitalPatientId = hospitalPatientId;
       this.hospitalRegistrationDate = hospitalRegistrationDate;
       this.hospitalEmail = hospitalEmail;
       this.officePhone = officePhone;
       this.mobileNo = mobileNo;
       this.officeAddress1 = officeAddress1;
       this.officeAddress2 = officeAddress2;
       this.officeCity = officeCity;
       this.officeState = officeState;
       this.officePinCode = officePinCode;
       this.officeCountry = officeCountry;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.modifiedBy = modifiedBy;
       this.modifiedDate = modifiedDate;
       this.dataSource = dataSource;
       this.stagingPatientDoctorRecords = stagingPatientDoctorRecords;
    }
   
    public String getStagingHospitalId() {
        return this.stagingHospitalId;
    }
    
    public void setStagingHospitalId(String stagingHospitalId) {
        this.stagingHospitalId = stagingHospitalId;
    }
    public String getPatientExchangeId() {
        return this.patientExchangeId;
    }
    
    public void setPatientExchangeId(String patientExchangeId) {
        this.patientExchangeId = patientExchangeId;
    }
    public String getHospitalName() {
        return this.hospitalName;
    }
    
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    public String getHospitalPatientId() {
        return this.hospitalPatientId;
    }
    
    public void setHospitalPatientId(String hospitalPatientId) {
        this.hospitalPatientId = hospitalPatientId;
    }
    public Date getHospitalRegistrationDate() {
        return this.hospitalRegistrationDate;
    }
    
    public void setHospitalRegistrationDate(Date hospitalRegistrationDate) {
        this.hospitalRegistrationDate = hospitalRegistrationDate;
    }
    public String getHospitalEmail() {
        return this.hospitalEmail;
    }
    
    public void setHospitalEmail(String hospitalEmail) {
        this.hospitalEmail = hospitalEmail;
    }
    public String getOfficePhone() {
        return this.officePhone;
    }
    
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }
    public String getMobileNo() {
        return this.mobileNo;
    }
    
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getOfficeAddress1() {
        return this.officeAddress1;
    }
    
    public void setOfficeAddress1(String officeAddress1) {
        this.officeAddress1 = officeAddress1;
    }
    public String getOfficeAddress2() {
        return this.officeAddress2;
    }
    
    public void setOfficeAddress2(String officeAddress2) {
        this.officeAddress2 = officeAddress2;
    }
    public String getOfficeCity() {
        return this.officeCity;
    }
    
    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity;
    }
    public String getOfficeState() {
        return this.officeState;
    }
    
    public void setOfficeState(String officeState) {
        this.officeState = officeState;
    }
    public String getOfficePinCode() {
        return this.officePinCode;
    }
    
    public void setOfficePinCode(String officePinCode) {
        this.officePinCode = officePinCode;
    }
    public String getOfficeCountry() {
        return this.officeCountry;
    }
    
    public void setOfficeCountry(String officeCountry) {
        this.officeCountry = officeCountry;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getModifiedBy() {
        return this.modifiedBy;
    }
    
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    public Date getModifiedDate() {
        return this.modifiedDate;
    }
    
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    public String getDataSource() {
        return this.dataSource;
    }
    
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    public Set getStagingPatientDoctorRecords() {
        return this.stagingPatientDoctorRecords;
    }
    
    public void setStagingPatientDoctorRecords(Set stagingPatientDoctorRecords) {
        this.stagingPatientDoctorRecords = stagingPatientDoctorRecords;
    }




}


