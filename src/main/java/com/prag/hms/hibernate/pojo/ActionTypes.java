package com.prag.hms.hibernate.pojo;
// Generated 1 May, 2014 5:57:32 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ActionTypes generated by hbm2java
 */
public class ActionTypes  implements java.io.Serializable {


     private String actionId;
     private String actionType;
     private String actionDesc;
     private String entityStatus;
     private String dataSource;
     private String createdBy;
     private Date createdDate;
     private String modifiedBy;
     private Date modifiedDate;
     private Set roleses = new HashSet(0);

    public ActionTypes() {
    }

	
    public ActionTypes(String actionId) {
        this.actionId = actionId;
    }
    public ActionTypes(String actionId, String actionType, String actionDesc, String entityStatus, String dataSource, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate, Set roleses) {
       this.actionId = actionId;
       this.actionType = actionType;
       this.actionDesc = actionDesc;
       this.entityStatus = entityStatus;
       this.dataSource = dataSource;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.modifiedBy = modifiedBy;
       this.modifiedDate = modifiedDate;
       this.roleses = roleses;
    }
   
    public String getActionId() {
        return this.actionId;
    }
    
    public void setActionId(String actionId) {
        this.actionId = actionId;
    }
    public String getActionType() {
        return this.actionType;
    }
    
    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
    public String getActionDesc() {
        return this.actionDesc;
    }
    
    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }
    public String getEntityStatus() {
        return this.entityStatus;
    }
    
    public void setEntityStatus(String entityStatus) {
        this.entityStatus = entityStatus;
    }
    public String getDataSource() {
        return this.dataSource;
    }
    
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
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
    public Set getRoleses() {
        return this.roleses;
    }
    
    public void setRoleses(Set roleses) {
        this.roleses = roleses;
    }




}


