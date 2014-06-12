/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.struts.patient.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.prag.hms.constants.DataSource;
import com.prag.hms.hibernate.dao.StagingPatientDoctorRecordDao;
import com.prag.hms.hibernate.dao.impl.PatientUtil;
import com.prag.hms.hibernate.pojo.StagingPatientDoctorRecord;
import com.prag.hms.hibernate.pojo.StagingPatientHospitalRecord;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class PatientDoctorRecordAction extends ActionSupport {

    private String stagingHospitalId;
    private String doctorsFirstName;
    private String doctorsLastName;
    private String specialization;
    private String doctorsEmail;
    private String officePhone;
    private StagingPatientDoctorRecordDao stagingDoctorRecordDao;
    private Map<String, String> bloodGroupList;

    public Map<String, String> getBloodGroupList() {
        return bloodGroupList;
    }

    public void setBloodGroupList(Map<String, String> bloodGroupList) {
        this.bloodGroupList = bloodGroupList;
    }

    public StagingPatientDoctorRecordDao getStagingDoctorRecordDao() {
        return stagingDoctorRecordDao;
    }

    public void setStagingDoctorRecordDao(StagingPatientDoctorRecordDao stagingDoctorRecordDao) {
        this.stagingDoctorRecordDao = stagingDoctorRecordDao;
    }

    public String getStagingHospitalId() {
        return stagingHospitalId;
    }

    public void setStagingHospitalId(String stagingHospitalId) {
        this.stagingHospitalId = stagingHospitalId;
    }

    public String getDoctorsFirstName() {
        return doctorsFirstName;
    }

    public void setDoctorsFirstName(String doctorsFirstName) {
        this.doctorsFirstName = doctorsFirstName;
    }

    public String getDoctorsLastName() {
        return doctorsLastName;
    }

    public void setDoctorsLastName(String doctorsLastName) {
        this.doctorsLastName = doctorsLastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDoctorsEmail() {
        return doctorsEmail;
    }

    public void setDoctorsEmail(String doctorsEmail) {
        this.doctorsEmail = doctorsEmail;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public final void initializeBloodGroupList() {
        bloodGroupList = new HashMap<String, String>();
        bloodGroupList.put("B+", getText("bloodGroup.AP"));
        bloodGroupList.put("B-", getText("bloodGroup.AN"));
        bloodGroupList.put("AB+", getText("bloodGroup.BP"));
        bloodGroupList.put("AB-", getText("bloodGroup.BN"));
        bloodGroupList.put("A+", getText("bloodGroup.ABP"));
        bloodGroupList.put("A-", getText("bloodGroup.ABN"));
        bloodGroupList.put("O+", getText("bloodGroup.OP"));
        bloodGroupList.put("O-", getText("bloodGroup.ON"));
    }

    public StagingPatientDoctorRecord prepareStagingDoctorsRecord() {
        StagingPatientDoctorRecord stagingPatientDoctorRecord = new StagingPatientDoctorRecord();
        StagingPatientHospitalRecord stagingPatientHospitalRecord = new StagingPatientHospitalRecord();
        stagingPatientHospitalRecord.setStagingHospitalId(stagingHospitalId);
        stagingPatientDoctorRecord.setStagingPatientHospitalRecord(stagingPatientHospitalRecord);
        stagingPatientDoctorRecord.setDoctorsFirstName(doctorsFirstName);
        stagingPatientDoctorRecord.setDoctorsLastName(doctorsLastName);
        stagingPatientDoctorRecord.setDoctorsEmail(doctorsEmail);
        stagingPatientDoctorRecord.setOfficePhone(officePhone);
        stagingPatientDoctorRecord.setSpecialization(specialization);
        stagingPatientDoctorRecord.setPatientExchangeId(PatientUtil.getPatientExchangeId());
        stagingPatientDoctorRecord.setCreatedBy(PatientUtil.getPatientExchangeId());
        stagingPatientDoctorRecord.setCreatedDate(new java.util.Date());
        stagingPatientDoctorRecord.setDataSource(DataSource.UI);
        return stagingPatientDoctorRecord;
    }

    public String navigatePatientDoctorRecord() {
        initializeBloodGroupList();
        return "success";
    }

    public String addStagingDoctorRecord() {
        String result = "failure";
        try {
            if (stagingDoctorRecordDao.addPatientDoctorRecord(prepareStagingDoctorsRecord())) {
                result = "success";
            }
        } catch (Exception e) {
        }
        return result;
    }
}
