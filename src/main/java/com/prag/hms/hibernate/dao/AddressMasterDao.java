/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao;

import com.prag.hms.hibernate.pojo.AddressMaster;

/**
 *
 * @author Admin
 */
public interface AddressMasterDao {
    void addAddress(AddressMaster address);
    void editAddress(AddressMaster address);
}
