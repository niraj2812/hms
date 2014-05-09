/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao;

import com.prag.hms.hibernate.pojo.ContactMaster;

/**
 *
 * @author Admin
 */
public interface ContactMasterDao {
    void addContact(ContactMaster contact);
    void editContact(ContactMaster contact);
}
