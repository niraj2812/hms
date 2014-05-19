/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.RegisterUserDao;
import com.prag.hms.hibernate.pojo.AddressMaster;
import com.prag.hms.hibernate.pojo.ContactMaster;
import com.prag.hms.hibernate.pojo.UserAccess;
import com.prag.hms.hibernate.pojo.UserMaster;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class RegisterUserDaoImpl implements RegisterUserDao {

    private SessionFactory fact;

    public SessionFactory getFact() {
        return fact;
    }

    public void setFact(SessionFactory fact) {
        this.fact = fact;
    }

    public boolean registerUser(AddressMaster address, ContactMaster contact, UserMaster userMaster, UserAccess userAccess) {
        boolean isUserRegistered = false;
        Transaction tx = null;

        try {
            if (fact != null) {
                tx = fact.getCurrentSession().beginTransaction();
                fact.getCurrentSession().save(address);
                fact.getCurrentSession().save(contact);
                fact.getCurrentSession().save(userMaster);
                fact.getCurrentSession().save(userAccess);
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
                isUserRegistered = true;
            }
        }
        return isUserRegistered;
    }
}
