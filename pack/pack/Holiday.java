package pack;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class Holiday {
    private Date date;

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

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
