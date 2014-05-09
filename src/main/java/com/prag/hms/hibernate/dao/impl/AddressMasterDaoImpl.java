/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.AddressMasterDao;
import com.prag.hms.hibernate.pojo.AddressMaster;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
public class AddressMasterDaoImpl implements AddressMasterDao {

    private SessionFactory fact;

    public SessionFactory getFact() {
        return fact;
    }

    public void setFact(SessionFactory fact) {
        this.fact = fact;
    }

    public void addAddress(AddressMaster address) {
        fact.getCurrentSession().save(address);
    }

    public void editAddress(AddressMaster address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
