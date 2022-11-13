package pack;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class Ticket{

	private int TicketID;
	private double Price;
	private boolean Concession;
	private boolean Used;
	private String MovieTitle;
	private String MovieShowTime;
	private String MovieLocation;
	private int SeatID;
	private String CName;
	private String CEmail;
	//private double basePrice = 10;
	private int TicketCount=0;

	/** 
	 * @param MS
	 * @param customer
	 * @param SeatID
	 */
	public Ticket(MovieSchedule MS, Customer customer, int SeatID) {
			this.TicketID = ++TicketCount; //auto increment ticket id
			
			this.MovieTitle = MS.getMovie();
			this.MovieShowTime = MS.getShowTime();
			this.MovieLocation = MS.getCinemaID();
			this.SeatID = SeatID;

			this.Used = false;
			this.CName = customer.getName();
			this.CEmail = customer.getEmail();
	}
	/** 
	 * @param TicketID 
	 * @param Price
	 * @param Concession
	 * @param Used
	 * @param MovieTitle
	 * @param MovieShowTime
	 * @param MovieLocation
	 * @param CName
	 * @param CEmail
	 */
	public Ticket(int TicketID, double Price, boolean Concession, boolean Used, String MovieTitle, String MovieShowTime, String MovieLocation, String CName, String CEmail) {
		this.TicketID = TicketID;
		this.Price = Price;
		this.Concession = Concession;

		this.MovieTitle = MovieTitle;
		this.MovieShowTime = MovieShowTime;
		this.MovieLocation = MovieLocation;

		this.Used = Used;
		this.CName = CName;
		this.CEmail = CEmail;
	}

	
	/** 
	 * @return int
	 */
	public int getTicketID() {
		return TicketID;
	}

	
	/** 
	 * @param ticketID
	 */
	public void setTicketID(int ticketID) {
		TicketID = ticketID;
	}

	
	/** 
	 * @return boolean
	 */
	public boolean isUsed() {
		return Used;
	}

	
	/** 
	 * @return boolean
	 */
	public boolean isConcession() {
		return Concession;
	}

	
	/** 
	 * @param used
	 */
	public void setUsed(boolean used) {
		Used = used;
	}

	
	/** 
	 * @return String
	 */
	public String getCEmail(){
		return this.CEmail;
	}

	
	/** 
	 * @return String
	 */
	public String getCName(){
		return this.CName;
	}

	
	/** 
	 * @return String
	 */
	public String getMovieTitle(){
		return this.MovieTitle;
	}

	
	/** 
	 * @return String
	 */
	public String getMovieShowTime(){
		return this.MovieShowTime;
	}

	
	/** 
	 * @return String
	 */
	public String getMovieLocation(){
		return this.MovieLocation;
	}

	
	/** 
	 * @return double
	 */
	public double getPrice() {
		return Price;
	}

	
	/** 
	 * @param price
	 */
	public void setPrice(double price) {
		Price = price;
	}

	
	/** 
	 * @param MS
	 * @param C
	 * @param H
	 * @return double
	 */
	public double calPrice(MovieSchedule MS, int C, ArrayList<Holiday> H) {
		double price = 10; //base Price
		String dateTime = MS.getDate2();
		//System.out.println(dateTime + " " + H.get(0).getDate2());
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