package com.prag.hms.hibernate.pojo;
// Generated 1 May, 2014 5:57:32 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * QuestionUserMap generated by hbm2java
 */
public class QuestionUserMap  implements java.io.Serializable {


     private QuestionUserMapId id;
     private UserAccess userAccessByLoginId;
     private SecurityQuestionMaster securityQuestionMaster;
     private UserAccess userAccessByCreatedBy;
     private UserAccess userAccessByModifiedBy;
     private String answer;
     private String entityStatus;
     private Date creationDate;
     private Date modifiedDate;
     private String dataSource;

    public QuestionUserMap() {
    }

	
    public QuestionUserMap(QuestionUserMapId id, UserAccess userAccessByLoginId, SecurityQuestionMaster securityQuestionMaster, UserAccess userAccessByCreatedBy, String answer, String entityStatus, Date creationDate, String dataSource) {
        this.id = id;
        this.userAccessByLoginId = userAccessByLoginId;
        this.securityQuestionMaster = securityQuestionMaster;
        this.userAccessByCreatedBy = userAccessByCreatedBy;
        this.answer = answer;
        this.entityStatus = entityStatus;
        this.creationDate = creationDate;
        this.dataSource = dataSource;
    }
    public QuestionUserMap(QuestionUserMapId id, UserAccess userAccessByLoginId, SecurityQuestionMaster securityQuestionMaster, UserAccess userAccessByCreatedBy, UserAccess userAccessByModifiedBy, String answer, String entityStatus, Date creationDate, Date modifiedDate, String dataSource) {
       this.id = id;
       this.userAccessByLoginId = userAccessByLoginId;
       this.securityQuestionMaster = securityQuestionMaster;
       this.userAccessByCreatedBy = userAccessByCreatedBy;
       this.userAccessByModifiedBy = userAccessByModifiedBy;
       this.answer = answer;
       this.entityStatus = entityStatus;
       this.creationDate = creationDate;
       this.modifiedDate = modifiedDate;
       this.dataSource = dataSource;
    }
   
    public QuestionUserMapId getId() {
        return this.id;
    }
    
    public void setId(QuestionUserMapId id) {
        this.id = id;
    }
    public UserAccess getUserAccessByLoginId() {
        return this.userAccessByLoginId;
    }
    
    public void setUserAccessByLoginId(UserAccess userAccessByLoginId) {
        this.userAccessByLoginId = userAccessByLoginId;
    }
    public SecurityQuestionMaster getSecurityQuestionMaster() {
        return this.securityQuestionMaster;
    }
    
    public void setSecurityQuestionMaster(SecurityQuestionMaster securityQuestionMaster) {
        this.securityQuestionMaster = securityQuestionMaster;
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
    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getEntityStatus() {
        return this.entityStatus;
    }
    
    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus;
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
    public String getDataSource() {
        return this.dataSource;
    }
    
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }




}


