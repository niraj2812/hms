/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.struts.patient.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.I18nInterceptor;
import com.prag.hms.constants.DataSource;
import com.prag.hms.constants.EntityType;
import com.prag.hms.constants.Status;
import com.prag.hms.hibernate.dao.RegisterUserDao;
import com.prag.hms.hibernate.dao.UserAccessDao;
import com.prag.hms.hibernate.dao.impl.PasswordEncryption;
import com.prag.hms.hibernate.pojo.AddressMaster;
import com.prag.hms.hibernate.pojo.ContactMaster;
import com.prag.hms.hibernate.pojo.UserAccess;
import com.prag.hms.hibernate.pojo.UserMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
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
    private static final String DEFAULT_LOCALE = "en";
    private static final String REQUEST_LOCALE = "request_locale";
    
    public PatientRegisterAction() {
        String selectedLocale = ServletActionContext.getRequest().getParameter(REQUEST_LOCALE);
        if (selectedLocale == null) {
            selectedLocale = DEFAULT_LOCALE;
        }
        configureLocale(selectedLocale);
        initializeBloodGroupList();
        initializeGenderGroup();
    }

    /**
     *
     */
    public final void configureLocale(final String selectedLocale) {
        Locale locale = new Locale(selectedLocale);
        ActionContext.getContext().setLocale(locale);
        ActionContext.getContext().getSession().put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, locale);
        
    }

    /**
     *
     */
    public final void initializeGenderGroup() {
        genderGroup = new HashMap<String, String>();
        genderGroup.put("M", getText("gender.male"));
        genderGroup.put("F", getText("gender.female"));
        genderGroup.put("O", getText("gender.other"));
    }

    /**
     *
     */
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

    /**
     *
     */
    public Map<String, String> getGenderGroup() {
        return genderGroup;
    }

    /**
     *
     */
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

    /**
     *
     */
    @SkipValidation
    @Override
    public String execute() {
        
        return "success";
    }

    /**
     *
     */
    @SkipValidation
    public String localizeApplication() {
        Locale locale = new Locale(ServletActionContext.getRequest().getParameter("request_locale"));
        ActionContext.getContext().setLocale(locale);
        ActionContext.getContext().getSession().put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, locale);
        
        return "success";
    }

    /**
     *
     */
    @SkipValidation
    public String checkAvailibilityOfLoginName() {
        boolean isLoginNameAvailable = false;
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/json");
        PrintWriter out = null;
        if (!(userAccess.getLoginName().equals("") || userAccess.getLoginName() == null)) {
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
        }
        return null;
    }

    /**
     *
     */
    public String registerUser() {
        String result = "failure";
        
        addressMaster.setEntityType(EntityType.USER);
        addressMaster.setEntityStatus(Status.ACTIVE);
        addressMaster.setDataSource(DataSource.UI);
        addressMaster.setCreationDate(new java.util.Date());
        
        contactMaster.setEntityType(EntityType.USER);
        contactMaster.setEntityStatus(Status.ACTIVE);
        contactMaster.setDataSource(DataSource.UI);
        contactMaster.setCreationDate(new java.util.Date());
        
        userMaster.setEntityStatus(Status.ACTIVE);
        userMaster.setDataSource(DataSource.UI);
        userMaster.setCreationDate(new java.util.Date());
        //required from UI
        userMaster.setDob(new java.util.Date());
        userMaster.setAddressMaster(addressMaster);
        userMaster.setContactMaster(contactMaster);
        
        userAccess.setDataSource(DataSource.UI);
        userAccess.setEntityStatus(Status.ACTIVE);
        userAccess.setUserMaster(userMaster);
        userAccess.setCreationDate(new java.util.Date());
        userAccess.setPassword(PasswordEncryption.get_SHA_512_SecurePassword(userAccess.getPassword()));
        userAccess.setPasswordExpDate(new java.util.Date());

        addressMaster.setUserAccessByCreatedBy(userAccess);
        contactMaster.setUserAccessByCreatedBy(userAccess);
        userMaster.setUserAccessByCreatedBy(userAccess);
        userAccess.setUserAccessByCreatedBy(userAccess);
        if (registerUserDao.registerUser(addressMaster, contactMaster, userMaster, userAccess)) {
            result = "success";
        }
        return result;
    }
}
