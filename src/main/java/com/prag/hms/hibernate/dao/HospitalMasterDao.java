/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao;

import com.prag.hms.hibernate.pojo.AddressMaster;
import com.prag.hms.hibernate.pojo.HospitalMaster;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface HospitalMasterDao {

    List<HospitalMaster> getAllHospitals();

    List<HospitalMaster> getAllHospitalsByCity(AddressMaster address);

    Map<String, String> showSelectedHospitalDetails(AddressMaster address);
}
