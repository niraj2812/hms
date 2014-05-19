/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao;

import com.prag.hms.hibernate.pojo.SecurityQuestionMaster;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface SecurityQuestionMasterDao {

    void addSecurityQuestion(SecurityQuestionMaster question);

    void editSecurityQuestion(SecurityQuestionMaster question);

    // UserAccess findUser(String loginName);
    List<SecurityQuestionMaster> getAllSecurityQuestion();
}
