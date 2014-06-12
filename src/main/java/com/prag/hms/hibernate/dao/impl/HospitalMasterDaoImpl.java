/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.constants.Status;
import com.prag.hms.hibernate.dao.HospitalMasterDao;
import com.prag.hms.hibernate.pojo.AddressMaster;
import com.prag.hms.hibernate.pojo.HospitalMaster;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class HospitalMasterDaoImpl implements HospitalMasterDao {

    private SessionFactory fact;

    public SessionFactory getFact() {
        return fact;
    }

    public void setFact(SessionFactory fact) {
        this.fact = fact;
    }

    public List<HospitalMaster> getAllHospitals() {
        List<HospitalMaster> hospitals = null;
        try {
            Transaction tx = fact.getCurrentSession().beginTransaction();
            hospitals = fact.getCurrentSession().createQuery("from HospitalMaster").list();
            for (HospitalMaster hospital : hospitals) {
                Hibernate.initialize(hospital.getContactMaster());
                Hibernate.initialize(hospital.getAddressMaster());
            }
            System.out.println("Hospitals:" + hospitals);
            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return hospitals;
    }

    public Map<String, String> showSelectedHospitalDetails(AddressMaster address) {
        Map<String, String> hospitals = new HashMap<String, String>(0);
        for (HospitalMaster hospital : getAllHospitalsByCity(address)) {
            StringBuffer hospitalDetails = new StringBuffer(3)
                    .append(hospital.getHospitalName())
                    .append(", ")
                    .append(hospital.getAddressMaster().getOfficeAddress1())
                    .append(", ")
                    .append(hospital.getAddressMaster().getOfficeAddress2());
                    
            hospitals.put(hospital.getHospitalId(), hospitalDetails.toString());
        }
        return hospitals;
    }

    public List<HospitalMaster> getAllHospitalsByCity(AddressMaster address) {
        List<HospitalMaster> hospitals = null;
        try {
            Transaction tx = fact.getCurrentSession().beginTransaction();
            String query = "select distinct hm from HospitalMaster hm  inner join fetch hm.addressMaster address  where hm.entityStatus=:status and address.officeCity=:city and address.officeState=:state and address.officeCountry=:country and address.entityType=:type and address.entityStatus=:addressStatus";
            hospitals = fact.getCurrentSession().createQuery(query)
                    .setString("city", address.getOfficeCity())
                    .setString("status", Status.ACTIVE)
                    .setString("state", address.getOfficeState())
                    .setString("country", address.getOfficeCountry())
                    .setString("type", address.getEntityType())
                    .setString("addressStatus", Status.ACTIVE)
                    .list();

            tx.commit();

        } catch (Exception e) {
            System.out.println(e);
        }
        return hospitals;
    }
}
