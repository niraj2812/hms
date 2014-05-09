/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.ContactMasterDao;
import com.prag.hms.hibernate.pojo.ContactMaster;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
public class ContactMasterDaoImpl implements ContactMasterDao {

    private SessionFactory fact;

    public SessionFactory getFact() {
        return fact;
    }

    public void setFact(SessionFactory fact) {
        this.fact = fact;
    }

    public void addContact(ContactMaster contact) {
        fact.getCurrentSession().save(contact);
    }

    public void editContact(ContactMaster contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
