/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.constants.HttpSessionNames;
import com.prag.hms.hibernate.pojo.UserMaster;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Admin
 */
public class PatientUtil {
      /**
     *
     * @return
     */
    public static String getPatientExchangeId() {
        return ((UserMaster) ServletActionContext.getRequest().getSession().getAttribute(HttpSessionNames.PATIENT_INFORMATION)).getPatientExchangeId();
    }
    
}
