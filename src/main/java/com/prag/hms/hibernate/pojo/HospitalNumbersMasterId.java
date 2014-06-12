package com.prag.hms.hibernate.pojo;
// Generated 7 Jun, 2014 10:43:59 AM by Hibernate Tools 3.2.1.GA



/**
 * HospitalNumbersMasterId generated by hbm2java
 */
public class HospitalNumbersMasterId  implements java.io.Serializable {


     private String patientExchangeId;
     private String hospitalId;

    public HospitalNumbersMasterId() {
    }

    public HospitalNumbersMasterId(String patientExchangeId, String hospitalId) {
       this.patientExchangeId = patientExchangeId;
       this.hospitalId = hospitalId;
    }
   
    public String getPatientExchangeId() {
        return this.patientExchangeId;
    }
    
    public void setPatientExchangeId(String patientExchangeId) {
        this.patientExchangeId = patientExchangeId;
    }
    public String getHospitalId() {
        return this.hospitalId;
    }
    
    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HospitalNumbersMasterId) ) return false;
		 HospitalNumbersMasterId castOther = ( HospitalNumbersMasterId ) other; 
         
		 return ( (this.getPatientExchangeId()==castOther.getPatientExchangeId()) || ( this.getPatientExchangeId()!=null && castOther.getPatientExchangeId()!=null && this.getPatientExchangeId().equals(castOther.getPatientExchangeId()) ) )
 && ( (this.getHospitalId()==castOther.getHospitalId()) || ( this.getHospitalId()!=null && castOther.getHospitalId()!=null && this.getHospitalId().equals(castOther.getHospitalId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPatientExchangeId() == null ? 0 : this.getPatientExchangeId().hashCode() );
         result = 37 * result + ( getHospitalId() == null ? 0 : this.getHospitalId().hashCode() );
         return result;
   }   


}

