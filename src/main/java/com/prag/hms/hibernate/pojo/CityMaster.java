package com.prag.hms.hibernate.pojo;
// Generated 9 Jun, 2014 10:40:03 AM by Hibernate Tools 3.2.1.GA



/**
 * CityMaster generated by hbm2java
 */
public class CityMaster  implements java.io.Serializable {


     private String cityName;
     private StateMaster stateMaster;

    public CityMaster() {
    }

	
    public CityMaster(String cityName) {
        this.cityName = cityName;
    }
    public CityMaster(String cityName, StateMaster stateMaster) {
       this.cityName = cityName;
       this.stateMaster = stateMaster;
    }
   
    public String getCityName() {
        return this.cityName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public StateMaster getStateMaster() {
        return this.stateMaster;
    }
    
    public void setStateMaster(StateMaster stateMaster) {
        this.stateMaster = stateMaster;
    }




}

