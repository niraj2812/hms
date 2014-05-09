/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao;

import com.prag.hms.hibernate.pojo.AddressMaster;
import com.prag.hms.hibernate.pojo.ContactMaster;
import com.prag.hms.hibernate.pojo.UserAccess;
import com.prag.hms.hibernate.pojo.UserMaster;

/**
 *
 * @author Admin
 */
public interface RegisterUserDao {
    boolean registerUser(AddressMaster address,ContactMaster contact,UserMaster userMaster,UserAccess userAccess);
}
