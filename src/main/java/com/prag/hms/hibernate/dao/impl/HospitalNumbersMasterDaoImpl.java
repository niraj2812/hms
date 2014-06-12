/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.HospitalNumbersMasterDao;
import com.prag.hms.hibernate.pojo.HospitalNumbersMaster;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class HospitalNumbersMasterDaoImpl implements HospitalNumbersMasterDao {

    private SessionFactory fact;

    public SessionFactory getFact() {
        return fact;
    }

    public void setFact(SessionFactory fact) {
        this.fact = fact;
    }

    public boolean addHospitalNumberToPatientRecord(HospitalNumbersMaster hospitalNumber) {
        boolean isHospitalNumberAdded = false;
        Transaction tx = null;
        try {
            if (fact != null) {
                tx = fact.getCurrentSession().beginTransaction();
                fact.getCurrentSession().save(hospitalNumber);
                tx.commit();
            }
        } catch (Exception e) {
            System.out.println(e);
            if (tx != null) {
                tx.rollback();
            }
        }
        if (tx != null) {
            if (tx.wasCommitted()) {
                isHospitalNumberAdded = true;
            }
        }
        return isHospitalNumberAdded;
    }
}
