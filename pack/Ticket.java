package pack;
import pack.MovieSchedule;
import java.util.ArrayList;
import pack.Movie;
public class Ticket {

	private int TicketID;
	private String Price;
	private boolean Concession;
	private boolean Used;
	private String MovieTitle;
	private String MovieShowTime;
	private String MovieLocation;
	private String CName;
	private String CEmail;
	private double basePrice = 10;
	private int TicketCount=0;

	public Ticket(MovieSchedule MS, String Concession,
			 Customer customer, double Price) {
			this.TicketID = TicketCount; //auto increment ticket id
			this.Price = Price; 
			this.Concession = Concession;
			
			this.MovieTitle = MS.getMovie();
			this.MovieShowTime = MS.getShowTime();
			this.MovieLocation = MS.getCinemaID();

			this.Used = false;
			this.CName = customer.getName();
			this.CEmail = customer.getEmail();

			TicketCount++; //increment ticket count
	}

	public int getTicketID() {
		return TicketID;
	}

	public void setTicketID(int ticketID) {
		TicketID = ticketID;
	}

	public String getWeeklyDayPricing() {
		return WeeklyDayPricing;
	}

	public void setWeeklyDayPricing(String weeklyDayPricing) {
		WeeklyDayPricing = weeklyDayPricing;
	}

	public String getConcessionPrice() {
		return ConcessionPrice;
	}

	public void setConcessionPrice(String concessionPrice) {
		ConcessionPrice = concessionPrice;
	}

	public MovieSchedule getMovieSchedule() {
		return movieSchedule;
	}

	public void setMovieSchedule(MovieSchedule movieSchedule) {
		this.movieSchedule = movieSchedule;
	}

	public boolean isUsed() {
		return Used;
	}

	public void setUsed(boolean used) {
		Used = used;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double calPrice(MovieSchedule MS, boolean Concession) {
		double price = 0;
		String dateTime = MS.getShowTime();
		//Concession stuff
		if (Concession == true)
			price = basePrice - 2; //Minus 2 dollar if concession
		else
			price = basePrice;
		//Loop holidays
		for (int i = 0; i < holidays.size(); i++) {
			if (MS.getDate() == holidays.get(i)) {
				price = price + 2; //Add 2 dollar if holiday
			}
		}
		//Loop Weekends
		for (int i = 0; i < weekends.size(); i++) {
			if (MS.getDate() == weekends.get(i)) {
				price = price + 2; //Add 2 dollar if weekend
			}
		}
		return price;
	}

}