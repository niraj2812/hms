/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.struts.patient.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.prag.hms.constants.DataSource;
import com.prag.hms.constants.Status;
import com.prag.hms.hibernate.dao.HospitalNumbersMasterDao;
import com.prag.hms.hibernate.dao.StagingPatientHospitalRecordDao;
import com.prag.hms.hibernate.dao.impl.PatientUtil;
import com.prag.hms.hibernate.pojo.HospitalNumbersMaster;
import com.prag.hms.hibernate.pojo.HospitalNumbersMasterId;
import com.prag.hms.hibernate.pojo.StagingPatientHospitalRecord;

/**
 *
 * @author Admin
 */
public class PatientHospitalRecordAction extends ActionSupport {
    
    private HospitalNumbersMasterId hospitalNumbersMasterId;
    private HospitalNumbersMaster hospitalNumbersMaster;
    private HospitalNumbersMasterDao hospitalNumbersMasterDao;
    private StagingPatientHospitalRecord stagingHospitalRecord;
    private StagingPatientHospitalRecordDao stagingHospitalRecordDao;
    
   
    public void setHospitalNumbersMasterDao(HospitalNumbersMasterDao hospitalNumbersMasterDao) {
        this.hospitalNumbersMasterDao = hospitalNumbersMasterDao;
    }
    
    public void setStagingHospitalRecordDao(StagingPatientHospitalRecordDao stagingHospitalRecordDao) {
        this.stagingHospitalRecordDao = stagingHospitalRecordDao;
    }
    
    public StagingPatientHospitalRecord getStagingHospitalRecord() {
        return stagingHospitalRecord;
    }
    
    public void setStagingHospitalRecord(StagingPatientHospitalRecord stagingHospitalRecord) {
        this.stagingHospitalRecord = stagingHospitalRecord;
    }
    
    public HospitalNumbersMasterId getHospitalNumbersMasterId() {
        return hospitalNumbersMasterId;
    }
    
    public void setHospitalNumbersMasterId(HospitalNumbersMasterId hospitalNumbersMasterId) {
        this.hospitalNumbersMasterId = hospitalNumbersMasterId;
    }
    
    public HospitalNumbersMaster getHospitalNumbersMaster() {
        return hospitalNumbersMaster;
    }
    
    public void setHospitalNumbersMaster(HospitalNumbersMaster hospitalNumbersMaster) {
        this.hospitalNumbersMaster = hospitalNumbersMaster;
    }
    
    public String naviagateHospitalMaster() {
        return "success";
    }
    
    public String addStagingHospialRecord() {
        String result = "failure";
        try {
            stagingHospitalRecord.setPatientExchangeId(PatientUtil.getPatientExchangeId());
            stagingHospitalRecord.setCreatedBy(PatientUtil.getPatientExchangeId());
            stagingHospitalRecord.setCreatedDate(new java.util.Date());
            stagingHospitalRecord.setDataSource(DataSource.UI);
            //to change
            stagingHospitalRecord.setHospitalRegistrationDate(new java.util.Date());
            if (stagingHospitalRecordDao.addPatientHospitalRecord(stagingHospitalRecord)) {
                result = "success";
            }
        } catch (Exception e) {
        }
        return result;
    }
    
    public String addHospitalNumberMaster() {
        hospitalNumbersMasterId.setPatientExchangeId(PatientUtil.getPatientExchangeId());
        hospitalNumbersMaster.setId(hospitalNumbersMasterId);
        hospitalNumbersMaster.setCreatedBy(PatientUtil.getPatientExchangeId());
        hospitalNumbersMaster.setCreationDate(new java.util.Date());
        hospitalNumbersMaster.setDataSource(DataSource.UI);
        hospitalNumbersMaster.setHospitalRegistrationDate(new java.util.Date());
        hospitalNumbersMaster.setEntityStatus(Status.ACTIVE);
        hospitalNumbersMasterDao.addHospitalNumberToPatientRecord(hospitalNumbersMaster);
        return Action.SUCCESS;
    }
}
