/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms;

import org.hibernate.SessionFactory;
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
                System.out.println("Connected!!");
            } else {
                System.out.println("Not Connected!!!");
            }
        } finally {
            
        }
    }
}