
import com.prag.hms.hibernate.pojo.AddressMaster;
import com.prag.hms.hibernate.pojo.ContactMaster;
import com.prag.hms.hibernate.pojo.NewHibernateUtil;
import com.prag.hms.hibernate.pojo.UserAccess;
import com.prag.hms.hibernate.pojo.UserMaster;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Test {
    
    public static void main(String[] args) {
        
        ContactMaster cm = new ContactMaster();
        
        cm.setEmail("niraj.singh2812@gmail.com");
        cm.setEmergencyContactNo("89345834345");
        cm.setRelationWithContactPerson("brother");
        cm.setEntityStatus("ACTIVE");
        cm.setDataSource("UI");
        cm.setEntityType("USER");
        cm.setHomePhone("8576894576");
        cm.setCreationDate(new java.util.Date());
        
        AddressMaster am = new AddressMaster();
        am.setEntityStatus("ACTIVE");
        am.setDataSource("UI");
        am.setHomeAddress1("jdfjlsldf");
        am.setHomeCity("Varanasi");
        am.setHomePinCode("79879");
        am.setHomeState("UP");
        am.setHomeCountry("India");
        am.setCreationDate(new java.util.Date());
        am.setEntityType("USER");
        
        UserMaster um = new UserMaster();
        um.setAddressMaster(am);
        um.setContactMaster(cm);
        um.setDataSource("UI");
        um.setFirstName("NIraj");
        um.setMiddleName(null);
        um.setLastName("Singh");        
        um.setFatherFirstName("Sadanand");
        um.setFatherLastName("Singh");
        um.setEntityStatus("ACTIVE");
        um.setBloodGroup("B+");
        um.setFirstLanguage("Hindi");
        um.setGender('M');
        um.setMotherFirstName("Asha");
        um.setMotherLastName("Devi");
        um.setDob(new java.util.Date());
        um.setNationality("INDIAN");
        um.setDataSource("UI");
        
        UserAccess ua = new UserAccess();
        ua.setLoginName("atul2812");
        ua.setPassword("1234");
        ua.setEntityStatus("ACTIVE");
        ua.setDataSource("UI");
        ua.setPasswordExpDate(new java.util.Date());
        ua.setUserMaster(um);
        
        
        try {
            SessionFactory fact = NewHibernateUtil.getSessionFactory();
            Session sess = fact.openSession();
            if (sess != null) {
                System.out.println("Connected");
            } else {
                System.out.println("Not connected!!!");
            }
            Transaction tx = sess.beginTransaction();
            sess.save(cm);
            sess.save(am);
            sess.save(um);
            sess.save(ua);
            
            cm.setUserAccessByCreatedBy(ua);
//            //created by updation;
//
//
////
////
            tx.commit();
            sess.refresh(cm);
//            
            // System.out.println(cm.getId());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
