package com.prag.hms.hibernate.pojo;
// Generated 22 Apr, 2014 5:49:36 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ContactMaster generated by hbm2java
 */
public class ContactMaster  implements java.io.Serializable {


     private String id;
     private String email;
     private String homePhone;
     private String officePhone;
     private String mobileNo;
     private String emergencyContactNo;
     private String relationWithContactPerson;
     private String createdBy;
     private Date creationDate;
     private String modifiedBy;
     private Date modifiedDate;
     private String dataSource;
     private String entityStatus;
     private String entityType;
     private Set userMasters = new HashSet(0);

    public ContactMaster() {
    }

	
    public ContactMaster(String id) {
        this.id = id;
    }
    public ContactMaster(String id, String email, String homePhone, String officePhone, String mobileNo, String emergencyContactNo, String relationWithContactPerson, String createdBy, Date creationDate, String modifiedBy, Date modifiedDate, String dataSource, String entityStatus, String entityType, Set userMasters) {
       this.id = id;
       this.email = email;
       this.homePhone = homePhone;
       this.officePhone = officePhone;
       this.mobileNo = mobileNo;
       this.emergencyContactNo = emergencyContactNo;
       this.relationWithContactPerson = relationWithContactPerson;
       this.createdBy = createdBy;
       this.creationDate = creationDate;
       this.modifiedBy = modifiedBy;
       this.modifiedDate = modifiedDate;
       this.dataSource = dataSource;
       this.entityStatus = entityStatus;
       this.entityType = entityType;
       this.userMasters = userMasters;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHomePhone() {
        return this.homePhone;
    }
    
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
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
    public String getEmergencyContactNo() {
        return this.emergencyContactNo;
    }
    
    public void setEmergencyContactNo(String emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
    }
    public String getRelationWithContactPerson() {
        return this.relationWithContactPerson;
    }
    
    public void setRelationWithContactPerson(String relationWithContactPerson) {
        this.relationWithContactPerson = relationWithContactPerson;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
    public String getEntityStatus() {
        return this.entityStatus;
    }
    
    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus;
    }
    public String getEntityType() {
        return this.entityType;
    }
    
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }
    public Set getUserMasters() {
        return this.userMasters;
    }
    
    public void setUserMasters(Set userMasters) {
        this.userMasters = userMasters;
    }




}


