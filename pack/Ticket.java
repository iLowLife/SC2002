package pack;
import pack.MovieSchedule;
import java.util.ArrayList;
import pack.Movie;
public class Ticket {

	private int TicketID;
	private String WeeklyDayPricing;
	private String ConcessionPrice;
	private String MovieSchedule;
	private boolean Used;
	private MovieSchedule movieSchedule;
	private Customer customer;

	public Ticket(int ticketID, String weeklyDayPricing, String concessionPrice,
			MovieSchedule movieSchedule, Customer customer) {
			this.TicketID = ticketID;
			this.WeeklyDayPricing = weeklyDayPricing;
			this.ConcessionPrice = concessionPrice;
			this.movieSchedule = movieSchedule;
			this.Used = false;
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

}
