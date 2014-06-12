/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms;

import com.prag.hms.hibernate.pojo.CountryMaster;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Admin
 */
public class TestCon {
 
    public static void main(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.configure("hibernate.cfg.xml");
            SessionFactory sf = conf.buildSessionFactory();
            if (sf != null) {
                System.out.println("connected");
            } else {
                System.out.println("Not Connected!!!");
            }
        } finally {
        }
    }
}
