/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.AddressMasterDao;
import com.prag.hms.hibernate.dao.ContactMasterDao;
import com.prag.hms.hibernate.dao.RegisterUserDao;
import com.prag.hms.hibernate.dao.UserAccessDao;
import com.prag.hms.hibernate.dao.UserMasterDao;
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
        AddressMasterDao addressMasterDao = new AddressMasterDaoImpl();
        ContactMasterDao contactMasterDao = new ContactMasterDaoImpl();
        UserMasterDao userMasterDao = new UserMasterDaoImpl();
        UserAccessDao userAccessDao = new UserAccessDaoImpl();
        contact.setEntityStatus("ACTIVE");
        contact.setCreationDate(new java.util.Date());
        contact.setDataSource("UI");
        contact.setEntityType("USER");
        address.setEntityStatus("ACTIVE");
        address.setCreationDate(new java.util.Date());
        address.setDataSource("UI");
        address.setEntityType("USER");
        userMaster.setEntityStatus("ACTIVE");
        userMaster.setDob(new java.util.Date());
        userAccess.setEntityStatus("ACTIVE");
        userAccess.setPassword(PasswordEncryption.get_SHA_512_SecurePassword(userAccess.getPassword()));
        userAccess.setPasswordExpDate(new java.util.Date());
        try {
            if (fact.getCurrentSession() != null) {
                
                System.out.println("Connected!!");
            } else {
                System.out.println("Not Connected");
            }
            tx = fact.getCurrentSession().beginTransaction();

            //addressMasterDao.addAddress(address);
            //contactMasterDao.addContact(contact);
            //userMasterDao.addUserMaster(userMaster);
            //userAccessDao.addUser(userAccess);
            fact.getCurrentSession().save(address);
            fact.getCurrentSession().save(contact);
            fact.getCurrentSession().save(userMaster);
            fact.getCurrentSession().save(userAccess);
            
            System.out.println("private String id;" + address.getId());
            System.out.println("private UserAccess userAccessByCreatedBy;");
            System.out.println("private UserAccess userAccessByModifiedBy;");
            System.out.println("private String homeAddress1;" + address.getHomeAddress1());
            System.out.println("private String homeAddress2;" + address.getHomeAddress2());
            System.out.println("private String homeCity;" + address.getHomeCity());
            System.out.println("private String homeState;" + address.getHomeState());
            System.out.println("private String homePinCode;" + address.getHomePinCode());
            System.out.println("private String homeCountry;" + address.getHomeCountry());
            System.out.println("private String officeAddress1;" + address.getOfficeAddress1());
            System.out.println("private String officeAddress2;" + address.getOfficeAddress2());
            System.out.println("private String officeCity;" + address.getOfficeCity());
            System.out.println("private String officeState;" + address.getOfficeState());
            System.out.println("private String officePinCode;" + address.getOfficePinCode());
            System.out.println("private String officeCountry;" + address.getOfficeCountry());
            System.out.println("private Date creationDate;" + address.getCreationDate());
            System.out.println("private Date modifiedDate;" + address.getModifiedDate());
            System.out.println("private String dataSource;" + address.getDataSource());
            System.out.println("private String entityStatus;" + address.getEntityStatus());
            System.out.println("private String entityType;" + address.getEntityType());
            
            tx.commit();
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
        System.out.println("isUserregistered=" + isUserRegistered);
        return isUserRegistered;
    }
}
