package com.prag.hms.hibernate.pojo;
// Generated 9 Jun, 2014 10:40:03 AM by Hibernate Tools 3.2.1.GA


/**
 * StateMaster generated by hbm2java
 */
public class StateMaster implements java.io.Serializable {

    private String stateName;
    private CountryMaster countryMaster;

    public StateMaster() {
    }

    public StateMaster(String stateName) {
        this.stateName = stateName;
    }

    public StateMaster(String stateName, CountryMaster countryMaster) {
        this.stateName = stateName;
        this.countryMaster = countryMaster;

    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public CountryMaster getCountryMaster() {
        return this.countryMaster;
    }

    public void setCountryMaster(CountryMaster countryMaster) {
        this.countryMaster = countryMaster;
    }

    
}