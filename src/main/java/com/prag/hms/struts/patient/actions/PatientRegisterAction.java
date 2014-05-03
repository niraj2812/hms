/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.struts.patient.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.prag.hms.hibernate.pojo.AddressMaster;
import com.prag.hms.hibernate.pojo.ContactMaster;
import com.prag.hms.hibernate.pojo.UserAccess;
import com.prag.hms.hibernate.pojo.UserMaster;

/**
 *
 * @author Admin
 */
public class PatientRegisterAction extends ActionSupport {

    private UserAccess userAccess;
    private UserMaster userMaster;
    private ContactMaster contactMaster;
    private AddressMaster addressMaster;
    private String confirmPassword;

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
//    private String loginName;
//    private String password;
//    private String firstName;
//    private String middleName;
//    private String lastName;
//    private Date dob;
//    private char gender;
//    private String fatherFirstName;
//    private String fatherLastName;
//    private String motherFirstName;
//    private String motherLastName;
//    private String firstLanguage;
//    private String secondLanguage;
//    private String thirdLanguage;
//    private String nationality;
//    private String homeAddress1;
//    private String homeAddress2;
//    private String homeCity;
//    private String homeState;
//    private String homePinCode;
//    private String homeCountry ;
//    private String officeAddress1;
//    private String officeAddress2;
//    private String officeCity;
//    private String officeState;
    //Office Pin Code Office Country Email Home Phone Office phone Mobile No Energency Contact No Relation with contact number
