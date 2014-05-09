/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.struts.patient.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.prag.hms.hibernate.dao.RegisterUserDao;
import com.prag.hms.hibernate.dao.UserAccessDao;
import com.prag.hms.hibernate.pojo.AddressMaster;
import com.prag.hms.hibernate.pojo.ContactMaster;
import com.prag.hms.hibernate.pojo.UserAccess;
import com.prag.hms.hibernate.pojo.UserMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

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
    private RegisterUserDao registerUserDao;
    private Map<String, String> genderGroup;
    private Map<String, String> bloodGroupList;

    public PatientRegisterAction() {
        initializeBloodGroupList();
        initializeGenderGroup();
    }

    public final void initializeGenderGroup() {
        genderGroup = new HashMap<String, String>();
        genderGroup.put("M", getText("gender.male"));
        genderGroup.put("F", getText("gender.female"));
        genderGroup.put("O", getText("gender.other"));
    }

    public final void initializeBloodGroupList() {
        bloodGroupList = new HashMap<String, String>();
        bloodGroupList.put("B+", getText("bloodGroup.AP"));
        bloodGroupList.put("B-", getText("bloodGroup.AN"));
        bloodGroupList.put("AB+", getText("bloodGroup.BP"));
        bloodGroupList.put("AB-", getText("bloodGroup.BN"));
        bloodGroupList.put("A+", getText("bloodGroup.ABP"));
        bloodGroupList.put("A-", getText("bloodGroup.ABN"));
        bloodGroupList.put("O+", getText("bloodGroup.OP"));
        bloodGroupList.put("O-", getText("bloodGroup.ON"));
    }

    public Map<String, String> getGenderGroup() {
        return genderGroup;
    }

    public void setGenderGroup(Map<String, String> genderGroup) {
        this.genderGroup = genderGroup;
    }

    public Map<String, String> getBloodGroupList() {
        return bloodGroupList;
    }

    public void setBloodGroupList(Map<String, String> bloodGroupList) {
        this.bloodGroupList = bloodGroupList;
    }

    public RegisterUserDao getRegisterUserDao() {
        return registerUserDao;
    }

    public void setRegisterUserDao(RegisterUserDao registerUserDao) {
        this.registerUserDao = registerUserDao;
    }

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

    @SkipValidation
    @Override
    public String execute() {

        return "success";
    }

    @SkipValidation
    public String checkAvailibilityOfLoginName() {
        boolean isLoginNameAvailable = false;
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/json");
        PrintWriter out = null;
        System.out.println("loginName=" + userAccess.getLoginName());
        try {
            out = response.getWriter();
            if (userAccessDao.checkAvailabilityOfLoginName(userAccess.getLoginName())) {
                isLoginNameAvailable = true;
            }
            out.println(isLoginNameAvailable);
        } catch (IOException ex) {
            Logger.getLogger(PatientRegisterAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (out != null) {
                out.close();
            }
        }

        return null;
    }

    public String registerUser() {
        String result = "failure";

        addressMaster.setEntityType("USER");
        addressMaster.setDataSource("UI");
        contactMaster.setEntityType("USER");
        contactMaster.setDataSource("UI");
        userMaster.setDataSource("UI");
        userAccess.setDataSource("UI");
        userMaster.setAddressMaster(addressMaster);
        userMaster.setContactMaster(contactMaster);
        userAccess.setUserMaster(userMaster);
        //if (userAccess != null && userMaster != null && addressMaster != null && contactMaster != null) {
        if (registerUserDao.registerUser(addressMaster, contactMaster, userMaster, userAccess)) {
            result = "success";
        }
        System.out.println(userMaster.getUserId());
        System.out.println(contactMaster.getEmail());
        //}

        return result;
    }
}
