/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.StagingPatientHospitalRecordDao;
import com.prag.hms.hibernate.pojo.StagingPatientHospitalRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class StagingPatientHospitalRecordDaoImpl implements StagingPatientHospitalRecordDao {

    private SessionFactory fact;

    public SessionFactory getFact() {
        return fact;
    }

    public void setFact(SessionFactory fact) {
        this.fact = fact;
    }

   
    public boolean addPatientHospitalRecord(StagingPatientHospitalRecord hospitalRecord) {
        boolean isHospitalRecordAdded = false;
        Session session = null;
        Transaction tx = null;
        try {
            if (fact != null) {
                session = fact.getCurrentSession();
            }
            if (session != null) {
                tx = session.beginTransaction();
                session.save(hospitalRecord);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);

        }
        if (tx != null && tx.wasCommitted()) {
            isHospitalRecordAdded = true;
        }
        return isHospitalRecordAdded;
    }
}
