package MovieBooking;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ConvertDateToDay {
	   public static void main(String[] args) throws ParseException {

		    //get String of the date and time
			String sDate1="23/10/2022 12:34:56";
			Date date1=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(sDate1);
			System.out.println(sDate1+"\n"+date1);
			
			//Convery Date to Day
			ConvertDateToDay obj = new ConvertDateToDay();
			Calendar calendar = obj.dateToCalendar(date1);
			
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			System.out.println("Day: " + day);		//1 for Sunday, 2 for Monday...
		   }
	   
		//Convert Date to Calendar
		private Calendar dateToCalendar(Date date) {

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
			
		}
	   
	    
	   

}
