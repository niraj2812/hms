/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.struts.patient.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.prag.hms.constants.EntityType;
import com.prag.hms.constants.HttpSessionNames;
import com.prag.hms.hibernate.dao.HospitalMasterDao;
import com.prag.hms.hibernate.pojo.AddressMaster;
import java.util.Map;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Admin
 */
public class HospitalMasterRecordAction extends ActionSupport {

    private HospitalMasterDao hospitalMasterDao;
    private Map<String, String> hospitalMasters;
   
    public Map<String, String> getHospitalMasters() {
        return hospitalMasters;
    }

    public void setHospitalMasters(Map<String, String> hospitalMasters) {
        this.hospitalMasters = hospitalMasters;
    }

    public void setHospitalMasterDao(HospitalMasterDao hospitalMasterDao) {
        this.hospitalMasterDao = hospitalMasterDao;
    }

   
    public void updateCityInSession() {
        ActionContext.getContext().getSession().put(HttpSessionNames.PATIENT_CITY_NAME, (String) ServletActionContext.getRequest().getParameter("cityName"));

    }

    /**
     *
     * @return
     */
    @Override
    public String execute() {
        return Action.SUCCESS;
    }

    public String populateHospitalRecords() {
        updateCityInSession();
        AddressMaster address = new AddressMaster();
        address.setOfficeCity((String) ActionContext.getContext().getSession().get(HttpSessionNames.PATIENT_CITY_NAME));
        address.setOfficeState((String) ActionContext.getContext().getSession().get(HttpSessionNames.PATIENT_STATE_NAME));
        address.setOfficeCountry((String) ActionContext.getContext().getSession().get(HttpSessionNames.PATIENT_COUNTRY_NAME));
        address.setEntityType(EntityType.ADDRESS_ENTITY_TYPE_HOSPITAL);
        hospitalMasters = hospitalMasterDao.showSelectedHospitalDetails(address);
        return null;
    }
}
