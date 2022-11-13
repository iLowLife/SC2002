package pack;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class Holiday {
    private Date date;

    /** 
    * @param date
	*/

    public Holiday(String date) {
        //convert String into Date
        try{    
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
            //System.out.println(date1);
            this.date = date1;
        }
        catch (Exception e) {
            System.out.println("Invalid date");
        }
        //this.date = formatter.parse(date);
    }

    
    /** 
     * @return Date
     */
    public Date getDate() {
        return this.date;
    }

    
    /** 
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    
    /** 
     * @return String
     */
    public String getHoliday(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(this.date);
        return strDate;
    }

    
    /** 
     * @return String
     */
    public String getDate2(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String strDate = dateFormat.format(this.date);
        return strDate;
    }

}
