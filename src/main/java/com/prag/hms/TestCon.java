/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms;

import com.prag.hms.hibernate.pojo.UserAccess;
import com.prag.hms.hibernate.util.UniqueKeyGenerator;
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
                UniqueKeyGenerator generator = new UniqueKeyGenerator("pat", "hms", "USER_MASTER", "PATIENT_EXCHANGE_ID");
                System.out.println("Key=" + generator.generate(sf.openSession()));
//                System.out.println("Connected!!");
//                UserAccess userAccess = (UserAccess) sf.openSession().get(UserAccess.class, "niraj2812");
//                System.out.println(userAccess.getLoginName());
//                System.out.println(userAccess.getEntityStatus());
            } else {
                System.out.println("Not Connected!!!");
            }
        } finally {
        }
    }
}
