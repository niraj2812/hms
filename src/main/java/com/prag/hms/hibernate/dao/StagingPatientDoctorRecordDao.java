/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao;

import com.prag.hms.hibernate.pojo.StagingPatientDoctorRecord;

/**
 *
 * @author Admin
 */
public interface StagingPatientDoctorRecordDao {

    boolean addPatientDoctorRecord(StagingPatientDoctorRecord doctorRecord);
}
