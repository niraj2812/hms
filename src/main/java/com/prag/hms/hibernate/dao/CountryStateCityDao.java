/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao;

import com.prag.hms.hibernate.pojo.CityMaster;
import com.prag.hms.hibernate.pojo.CountryMaster;
import com.prag.hms.hibernate.pojo.StateMaster;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CountryStateCityDao {

    List<CountryMaster> getCountries();

    List<StateMaster> getStates(CountryMaster country);

    List<CityMaster> getCities(StateMaster state);
    
}
