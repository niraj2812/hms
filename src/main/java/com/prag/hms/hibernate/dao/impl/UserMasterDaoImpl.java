/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.UserMasterDao;
import com.prag.hms.hibernate.pojo.UserMaster;
import org.hibernate.SessionFactory;

/**
 *
 * @author Admin
 */
public class UserMasterDaoImpl implements UserMasterDao {

    private SessionFactory fact;

    public SessionFactory getFact() {
        return fact;
    }

    public void setFact(SessionFactory fact) {
        this.fact = fact;
    }

    public void addUserMaster(UserMaster user) {
        fact.getCurrentSession().save(user);
    }

    public void editUserMaster(UserMaster user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
