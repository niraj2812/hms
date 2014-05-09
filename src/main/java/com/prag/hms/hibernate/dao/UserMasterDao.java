/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao;

import com.prag.hms.hibernate.pojo.UserMaster;

/**
 *
 * @author Admin
 */
public interface UserMasterDao {
    void addUserMaster(UserMaster user);
    void editUserMaster(UserMaster user);
}
