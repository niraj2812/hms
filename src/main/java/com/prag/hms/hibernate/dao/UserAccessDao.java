/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao;

import com.prag.hms.hibernate.pojo.UserAccess;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UserAccessDao {

    void addUser(UserAccess user);

    void editUser(UserAccess user);

    // UserAccess findUser(String loginName);
    UserAccess findUserByName(String userName);

    boolean checkAvailabilityOfLoginName(String loginName);

    List<UserAccess> getAllUsers();
}
