package pack;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Ticket{

	private int TicketID;
	private String Price;
	private boolean Concession;
	private boolean Used;
	private String MovieTitle;
	private String MovieShowTime;
	private String MovieLocation;
	private String CName;
	private String CEmail;
	//private double basePrice = 10;
	private int TicketCount=0;

	public Ticket(MovieSchedule MS, Customer customer) {
			this.TicketID = ++TicketCount; //auto increment ticket id
			
			this.MovieTitle = MS.getMovie();
			this.MovieShowTime = MS.getShowTime();
			this.MovieLocation = MS.getCinemaID();

			this.Used = false;
			this.CName = customer.getName();
			this.CEmail = customer.getEmail();
	}

	public int getTicketID() {
		return TicketID;
	}

	public void setTicketID(int ticketID) {
		TicketID = ticketID;
	}

	public boolean isUsed() {
		return Used;
	}

	public void setUsed(boolean used) {
		Used = used;
	}

	public String getCEmail(){
		return this.CEmail;
	}

	public String getCName(){
		return this.CName;
	}

	public String getMovieTitle(){
		return this.MovieTitle;
	}

	public String getMovieShowTime(){
		return this.MovieShowTime;
	}

	public String getMovieLocation(){
		return this.MovieLocation;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public double calPrice(MovieSchedule MS, int C, ArrayList<Holiday> H) {
		double price = 10; //base Price
		String dateTime = MS.getDate2();
		System.out.println(dateTime + " " + H.get(0).getDate2());
		//Concession stuff
		if (C == 1)
			price = price - 2; //Minus 2 dollar if concession
		else
			price = price + 0;// no change;
		//Loop holidays
		for (int i = 0; i < H.size(); i++) {
			if (H.get(i).getDate2().equals(dateTime)) { //Compare Movie Date to Holiday Date
				price = price + 2;
			}
		}
		//Check if its a weekend
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = df.parse(MS.getDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1 || dayOfWeek == 7) {
			price = price + 2;
		}
		return price;
	}

}