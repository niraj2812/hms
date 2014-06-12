/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao;

import com.prag.hms.hibernate.pojo.HospitalNumbersMaster;

/**
 *
 * @author Admin
 */
public interface HospitalNumbersMasterDao {

    boolean addHospitalNumberToPatientRecord(HospitalNumbersMaster hospitalNumber);
}
