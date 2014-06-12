/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.CountryStateCityDao;
import com.prag.hms.hibernate.pojo.CityMaster;
import com.prag.hms.hibernate.pojo.CountryMaster;
import com.prag.hms.hibernate.pojo.StateMaster;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class CountryStateCityDaoImpl implements CountryStateCityDao {

    private SessionFactory fact;

    public SessionFactory getFact() {
        return fact;
    }

    public void setFact(SessionFactory fact) {
        this.fact = fact;
    }

    public List<CountryMaster> getCountries() {
        List<CountryMaster> countryList = null;
        Session session = null;
        Transaction tx = null;
        try {
            if (fact != null) {
                session = fact.getCurrentSession();

                if (session != null) {
                    tx = session.beginTransaction();
                    Query q1 = session.createQuery("from CountryMaster");
                    countryList = q1.list();
                    tx.commit();
                }
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);

        }
        return countryList;
    }

    public List<StateMaster> getStates(CountryMaster country) {
        List<StateMaster> stateList = null;
        Session session = null;
        Transaction tx = null;
        try {
            if (fact != null) {
                session = fact.getCurrentSession();
                if (session != null) {
                    tx = session.beginTransaction();
                    String query = "select sm from StateMaster as sm inner join fetch sm.countryMaster where sm.countryMaster = :cm";
                    stateList = session.createQuery(query).setParameter("cm", country).list();
                    tx.commit();
                }
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);

        }
        return stateList;
    }

    public List<CityMaster> getCities(StateMaster state) {
        List<CityMaster> cityList = null;
        Session session = null;
        Transaction tx = null;
        try {
            if (fact != null) {
                session = fact.getCurrentSession();
                if (session != null) {
                    tx = session.beginTransaction();
                    String query = "select cm from CityMaster as cm inner join fetch cm.stateMaster where cm.stateMaster = :sm";
                    cityList = session.createQuery(query).setParameter("sm", state).list();
                    tx.commit();
                }
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);

        }
        return cityList;
    }
}
