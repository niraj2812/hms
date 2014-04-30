/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.struts.patient.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Admin
 */
public class LoginAction extends ActionSupport {

    private String uname;
    private String pass;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String execute() {
        String result = "failure";
        if (uname.equals("niraj") && pass.equals("1234")) {
            result="success";
        }
        return result;
    }
}
