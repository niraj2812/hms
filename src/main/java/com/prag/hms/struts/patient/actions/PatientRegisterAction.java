/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.struts.patient.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.prag.hms.hibernate.dao.UserAccessDao;
import com.prag.hms.hibernate.pojo.AddressMaster;
import com.prag.hms.hibernate.pojo.ContactMaster;
import com.prag.hms.hibernate.pojo.UserAccess;
import com.prag.hms.hibernate.pojo.UserMaster;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Admin
 */
public class PatientRegisterAction extends ActionSupport {

    private UserAccessDao userAccessDao;
    private UserAccess userAccess;
    private UserMaster userMaster;
    private ContactMaster contactMaster;
    private AddressMaster addressMaster;
    private String confirmPassword;

    public UserAccessDao getUserAccessDao() {
        return userAccessDao;
    }

    public void setUserAccessDao(UserAccessDao userAccessDao) {
        this.userAccessDao = userAccessDao;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserAccess getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(UserAccess userAccess) {
        this.userAccess = userAccess;
    }

    public UserMaster getUserMaster() {
        return userMaster;
    }

    public void setUserMaster(UserMaster userMaster) {
        this.userMaster = userMaster;
    }

    public ContactMaster getContactMaster() {
        return contactMaster;
    }

    public void setContactMaster(ContactMaster contactMaster) {
        this.contactMaster = contactMaster;
    }

    public AddressMaster getAddressMaster() {
        return addressMaster;
    }

    public void setAddressMaster(AddressMaster addressMaster) {
        this.addressMaster = addressMaster;
    }

    public String checkAvailibilityOfLoginName() {
        String result = "failure";
        // HttpServletResponse response = ServletActionContext.getResponse();
        System.out.println("loginName=" + userAccess.getLoginName());
        try {
            boolean available = userAccessDao.checkAvailabilityOfLoginName(userAccess.getLoginName());
            System.out.println("available status=" + available);
            if (available) {
                result = "success";
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return result;
    }

    public String registerUser() {
        String result = "failure";

        //if (userAccess != null && userMaster != null && addressMaster != null && contactMaster != null) {
        result = "success";
        System.out.println(userMaster.getUserId());
        System.out.println(contactMaster.getEmail());
        //}

        return result;
    }
}
