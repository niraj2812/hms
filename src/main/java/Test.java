
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        int monthsToAdd = 4;

        int monthsToSubtract = 10;
        SimpleDateFormat dt1 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date dt = new Date();
        try {
            System.out.println("date=" + dt1.parse(dt1.format(dt)));
        } catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.MONTH, monthsToAdd);
        System.out.println("cal=" + c.getTime());

        System.out.println("Current date : " + (c.get(Calendar.MONTH) + 1)
                + "-" + c.get(Calendar.DATE) + "-" + c.get(Calendar.YEAR));



        // add months to current date

        c.add(Calendar.MONTH, monthsToAdd);



        System.out.println("Date (after): " + (c.get(Calendar.MONTH) + 1)
                + "-" + c.get(Calendar.DATE) + "-" + c.get(Calendar.YEAR));



        c = Calendar.getInstance();



        c.add(Calendar.MONTH, -monthsToSubtract);



        System.out.println("Date (before): " + (c.get(Calendar.MONTH) + 1)
                + "-" + c.get(Calendar.DATE) + "-" + c.get(Calendar.YEAR));



    }
}
