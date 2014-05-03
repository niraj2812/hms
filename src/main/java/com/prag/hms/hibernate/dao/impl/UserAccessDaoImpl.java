/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.UserAccessDao;
import com.prag.hms.hibernate.pojo.UserAccess;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class UserAccessDaoImpl implements UserAccessDao {

    private SessionFactory fact;

    public SessionFactory getFact() {
        return fact;
    }

    public void setFact(SessionFactory fact) {
        this.fact = fact;
    }

    public void addUser(UserAccess user) {
        fact.getCurrentSession().save(user);
    }

    public void editUser(UserAccess user) {
        fact.getCurrentSession().update(user);
    }

//    public UserAccess findUser(int userId) {
//        return (UserAccess) fact.getCurrentSession().get(UserAccess.class, userId);
//    }
    public UserAccess findUserByName(String userName) {
       
        UserAccess ua = (UserAccess) fact.openSession().get(UserAccess.class, userName);
        return ua;
    }

    public boolean checkAvailabilityOfLoginName(String loginName) {
        boolean result = false;
        if (findUserByName(loginName) != null) {
            System.out.println("Ok present!!");
            result = true;
        }
        return result;
    }

    public List<UserAccess> getAllUsers() {
        List ls = null;
        try {
            Transaction tx = fact.getCurrentSession().beginTransaction();
            ls = fact.getCurrentSession().createQuery("from UserAccess").list();
            tx.commit();
        } catch (Exception e) {
        }
        return ls;
    }
}
