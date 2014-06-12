/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.struts.patient.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.prag.hms.constants.HttpSessionNames;
import com.prag.hms.hibernate.dao.CountryStateCityDao;
import com.prag.hms.hibernate.pojo.CityMaster;
import com.prag.hms.hibernate.pojo.CountryMaster;
import com.prag.hms.hibernate.pojo.StateMaster;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Admin
 */
public class CountryStateCityAction extends ActionSupport {

    private List<CountryMaster> countryMasterList = new ArrayList<CountryMaster>(0);
    private List<StateMaster> stateMasterList = new ArrayList<StateMaster>(0);
    private List<CityMaster> cityMasterList = new ArrayList<CityMaster>(0);
    private CountryMaster countryMaster;
    private StateMaster stateMaster;
    private CityMaster cityMaster;
    private CountryStateCityDao countryStateCityDao;

    public void setCountryStateCityDao(CountryStateCityDao countryStateCityDao) {
        this.countryStateCityDao = countryStateCityDao;
    }

    public List<CountryMaster> getCountryMasterList() {
        return countryMasterList;
    }

    public void setCountryMasterList(List<CountryMaster> countryMasterList) {
        this.countryMasterList = countryMasterList;
    }

    public List<StateMaster> getStateMasterList() {
        return stateMasterList;
    }

    public void setStateMasterList(List<StateMaster> stateMasterList) {
        this.stateMasterList = stateMasterList;
    }

    public List<CityMaster> getCityMasterList() {
        return cityMasterList;
    }

    public void setCityMasterList(List<CityMaster> cityMasterList) {
        this.cityMasterList = cityMasterList;
    }

    public CountryMaster getCountryMaster() {
        return countryMaster;
    }

    public void setCountryMaster(CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
    }

    public StateMaster getStateMaster() {
        return stateMaster;
    }

    public void setStateMaster(StateMaster stateMaster) {
        this.stateMaster = stateMaster;
    }

    public CityMaster getCityMaster() {
        return cityMaster;
    }

    public void setCityMaster(CityMaster cityMaster) {
        this.cityMaster = cityMaster;
    }

    public void initializeCountry() {
        countryMasterList = countryStateCityDao.getCountries();

    }

    public void initializeState(CountryMaster country) {
        if (country != null && country.getCountryName() != null && !country.getCountryName().equals("")) {
            stateMasterList = countryStateCityDao.getStates(country);
            ActionContext.getContext().getSession().put(HttpSessionNames.PATIENT_COUNTRY_NAME, country.getCountryName());

        }
    }

    public void initializeCity(StateMaster state) {
        if (state != null && state.getStateName() != null && !state.getStateName().equals("")) {
            cityMasterList = countryStateCityDao.getCities(state);
            ActionContext.getContext().getSession().put(HttpSessionNames.PATIENT_STATE_NAME, state.getStateName());

        }
    }

   

    public String fetchCountryStateCity() {
        initializeCountry();
        initializeState(countryMaster);
        initializeCity(stateMaster);


        return "success";
    }
}
