package com.prag.hms.hibernate.pojo;
// Generated 1 May, 2014 5:57:32 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserAccess generated by hbm2java
 */
public class UserAccess  implements java.io.Serializable {


     private String loginName;
     private UserMaster userMaster;
     private UserAccess userAccessByCreatedBy;
     private UserAccess userAccessByModifiedBy;
     private String entityStatus="ACTIVE";
     private String password;
     private Date passwordExpDate;
     private String dataSource;
     private String designation;
     private String managerId;
     private String deptId;
     private String hospitalId;
     private Date creationDate;
     private Date modifiedDate;
     private Set questionUserMapsForLoginId = new HashSet(0);
     private Set questionUserMapsForModifiedBy = new HashSet(0);
     private Set userAccessesForCreatedBy = new HashSet(0);
     private Set addressMastersForCreatedBy = new HashSet(0);
     private Set<Roles> roleses = new HashSet<Roles>(0);
     private Set userMastersForModifiedBy = new HashSet(0);
     private Set addressMastersForModifiedBy = new HashSet(0);
     private Set questionUserMapsForCreatedBy = new HashSet(0);
     private Set contactMastersForModifiedBy = new HashSet(0);
     private Set securityQuestionMastersForModifiedBy = new HashSet(0);
     private Set userAccessesForModifiedBy = new HashSet(0);
     private Set contactMastersForCreatedBy = new HashSet(0);
     private Set userMastersForCreatedBy = new HashSet(0);
     private Set aclSids = new HashSet(0);
     private Set securityQuestionMastersForCreatedBy = new HashSet(0);

    public UserAccess() {
    }

	
    public UserAccess(String loginName, UserMaster userMaster, String entityStatus, String password, Date passwordExpDate, String dataSource) {
        this.loginName = loginName;
        this.userMaster = userMaster;
        this.entityStatus = entityStatus;
        this.password = password;
        this.passwordExpDate = passwordExpDate;
        this.dataSource = dataSource;
    }
    public UserAccess(String loginName, UserMaster userMaster, UserAccess userAccessByCreatedBy, UserAccess userAccessByModifiedBy, String entityStatus, String password, Date passwordExpDate, String dataSource, String designation, String managerId, String deptId, String hospitalId, Date creationDate, Date modifiedDate, Set questionUserMapsForLoginId, Set questionUserMapsForModifiedBy, Set userAccessesForCreatedBy, Set addressMastersForCreatedBy, Set<Roles> roleses, Set userMastersForModifiedBy, Set addressMastersForModifiedBy, Set questionUserMapsForCreatedBy, Set contactMastersForModifiedBy, Set securityQuestionMastersForModifiedBy, Set userAccessesForModifiedBy, Set contactMastersForCreatedBy, Set roleses_1, Set userMastersForCreatedBy, Set aclSids, Set securityQuestionMastersForCreatedBy) {
       this.loginName = loginName;
       this.userMaster = userMaster;
       this.userAccessByCreatedBy = userAccessByCreatedBy;
       this.userAccessByModifiedBy = userAccessByModifiedBy;
       this.entityStatus = entityStatus;
       this.password = password;
       this.passwordExpDate = passwordExpDate;
       this.dataSource = dataSource;
       this.designation = designation;
       this.managerId = managerId;
       this.deptId = deptId;
       this.hospitalId = hospitalId;
       this.creationDate = creationDate;
       this.modifiedDate = modifiedDate;
       this.questionUserMapsForLoginId = questionUserMapsForLoginId;
       this.questionUserMapsForModifiedBy = questionUserMapsForModifiedBy;
       this.userAccessesForCreatedBy = userAccessesForCreatedBy;
       this.addressMastersForCreatedBy = addressMastersForCreatedBy;
       this.roleses = roleses;
       this.userMastersForModifiedBy = userMastersForModifiedBy;
       this.addressMastersForModifiedBy = addressMastersForModifiedBy;
       this.questionUserMapsForCreatedBy = questionUserMapsForCreatedBy;
       this.contactMastersForModifiedBy = contactMastersForModifiedBy;
       this.securityQuestionMastersForModifiedBy = securityQuestionMastersForModifiedBy;
       this.userAccessesForModifiedBy = userAccessesForModifiedBy;
       this.contactMastersForCreatedBy = contactMastersForCreatedBy;
       this.userMastersForCreatedBy = userMastersForCreatedBy;
       this.aclSids = aclSids;
       this.securityQuestionMastersForCreatedBy = securityQuestionMastersForCreatedBy;
    }
   
    public String getLoginName() {
        return this.loginName;
    }
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public UserMaster getUserMaster() {
        return this.userMaster;
    }
    
    public void setUserMaster(UserMaster userMaster) {
        this.userMaster = userMaster;
    }
    public UserAccess getUserAccessByCreatedBy() {
        return this.userAccessByCreatedBy;
    }
    
    public void setUserAccessByCreatedBy(UserAccess userAccessByCreatedBy) {
        this.userAccessByCreatedBy = userAccessByCreatedBy;
    }
    public UserAccess getUserAccessByModifiedBy() {
        return this.userAccessByModifiedBy;
    }
    
    public void setUserAccessByModifiedBy(UserAccess userAccessByModifiedBy) {
        this.userAccessByModifiedBy = userAccessByModifiedBy;
    }
    public String getEntityStatus() {
        return this.entityStatus;
    }
    
    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getPasswordExpDate() {
        return this.passwordExpDate;
    }
    
    public void setPasswordExpDate(Date passwordExpDate) {
        this.passwordExpDate = passwordExpDate;
    }
    public String getDataSource() {
        return this.dataSource;
    }
    
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getManagerId() {
        return this.managerId;
    }
    
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    public String getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    public String getHospitalId() {
        return this.hospitalId;
    }
    
    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }
    public Date getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public Date getModifiedDate() {
        return this.modifiedDate;
    }
    
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    public Set getQuestionUserMapsForLoginId() {
        return this.questionUserMapsForLoginId;
    }
    
    public void setQuestionUserMapsForLoginId(Set questionUserMapsForLoginId) {
        this.questionUserMapsForLoginId = questionUserMapsForLoginId;
    }
    public Set getQuestionUserMapsForModifiedBy() {
        return this.questionUserMapsForModifiedBy;
    }
    
    public void setQuestionUserMapsForModifiedBy(Set questionUserMapsForModifiedBy) {
        this.questionUserMapsForModifiedBy = questionUserMapsForModifiedBy;
    }
    public Set getUserAccessesForCreatedBy() {
        return this.userAccessesForCreatedBy;
    }
    
    public void setUserAccessesForCreatedBy(Set userAccessesForCreatedBy) {
        this.userAccessesForCreatedBy = userAccessesForCreatedBy;
    }
    public Set getAddressMastersForCreatedBy() {
        return this.addressMastersForCreatedBy;
    }
    
    public void setAddressMastersForCreatedBy(Set addressMastersForCreatedBy) {
        this.addressMastersForCreatedBy = addressMastersForCreatedBy;
    }
    public Set<Roles> getRoleses() {
        return this.roleses;
    }
    
    public void setRoleses(Set roleses) {
        this.roleses = roleses;
    }
    public Set getUserMastersForModifiedBy() {
        return this.userMastersForModifiedBy;
    }
    
    public void setUserMastersForModifiedBy(Set userMastersForModifiedBy) {
        this.userMastersForModifiedBy = userMastersForModifiedBy;
    }
    public Set getAddressMastersForModifiedBy() {
        return this.addressMastersForModifiedBy;
    }
    
    public void setAddressMastersForModifiedBy(Set addressMastersForModifiedBy) {
        this.addressMastersForModifiedBy = addressMastersForModifiedBy;
    }
    public Set getQuestionUserMapsForCreatedBy() {
        return this.questionUserMapsForCreatedBy;
    }
    
    public void setQuestionUserMapsForCreatedBy(Set questionUserMapsForCreatedBy) {
        this.questionUserMapsForCreatedBy = questionUserMapsForCreatedBy;
    }
    public Set getContactMastersForModifiedBy() {
        return this.contactMastersForModifiedBy;
    }
    
    public void setContactMastersForModifiedBy(Set contactMastersForModifiedBy) {
        this.contactMastersForModifiedBy = contactMastersForModifiedBy;
    }
    public Set getSecurityQuestionMastersForModifiedBy() {
        return this.securityQuestionMastersForModifiedBy;
    }
    
    public void setSecurityQuestionMastersForModifiedBy(Set securityQuestionMastersForModifiedBy) {
        this.securityQuestionMastersForModifiedBy = securityQuestionMastersForModifiedBy;
    }
    public Set getUserAccessesForModifiedBy() {
        return this.userAccessesForModifiedBy;
    }
    
    public void setUserAccessesForModifiedBy(Set userAccessesForModifiedBy) {
        this.userAccessesForModifiedBy = userAccessesForModifiedBy;
    }
    public Set getContactMastersForCreatedBy() {
        return this.contactMastersForCreatedBy;
    }
    
    public void setContactMastersForCreatedBy(Set contactMastersForCreatedBy) {
        this.contactMastersForCreatedBy = contactMastersForCreatedBy;
    }
  
    public Set getUserMastersForCreatedBy() {
        return this.userMastersForCreatedBy;
    }
    
    public void setUserMastersForCreatedBy(Set userMastersForCreatedBy) {
        this.userMastersForCreatedBy = userMastersForCreatedBy;
    }
    public Set getAclSids() {
        return this.aclSids;
    }
    
    public void setAclSids(Set aclSids) {
        this.aclSids = aclSids;
    }
    public Set getSecurityQuestionMastersForCreatedBy() {
        return this.securityQuestionMastersForCreatedBy;
    }
    
    public void setSecurityQuestionMastersForCreatedBy(Set securityQuestionMastersForCreatedBy) {
        this.securityQuestionMastersForCreatedBy = securityQuestionMastersForCreatedBy;
    }




}


