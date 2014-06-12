/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.StagingPatientDoctorRecordDao;
import com.prag.hms.hibernate.pojo.StagingPatientDoctorRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class StagingPatientDoctorRecordDaoImpl implements StagingPatientDoctorRecordDao {
    private SessionFactory fact;

    public SessionFactory getFact() {
        return fact;
    }

    public void setFact(SessionFactory fact) {
        this.fact = fact;
    }

    /**
     *
     * @param doctorRecord
     * @return
     */
    public boolean addPatientDoctorRecord(StagingPatientDoctorRecord doctorRecord) {
        boolean isDoctorRecordAdded = false;
        Session session = null;
        Transaction tx = null;
        try {
            if (fact != null) {
                session = fact.getCurrentSession();
            }
            if (session != null) {
                tx = session.beginTransaction();
                session.save(doctorRecord);
                tx.commit();
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);

        }
        if (tx != null && tx.wasCommitted()) {
            isDoctorRecordAdded = true;
        }
        return isDoctorRecordAdded;
    }
}
