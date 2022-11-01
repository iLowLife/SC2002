package pack;
import java.util.*;
import pack.Movie;
import pack.MovieSchedule;
import pack.Ticket;
public class Customer extends User {

	private String UserID;
	private String typeOfCustomer;
	private ArrayList<Ticket> Ticket=new ArrayList<Ticket>();//Creating arraylist
	// private MovieSchedule Movie = getMovie();
	// private Movie MovieTitle = getMovieTitle();
	private ArrayList<bookingHistory> bookingHistory=new ArrayList<bookingHistory>();//Creating arraylist

	public Customer(String Name, String Email, String Password, String typeOfCustomer) {
		super(Name, Email, Password);
		this.UserID=Email;
		this.typeOfCustomer=typeOfCustomer;
	}

	public String getName() {
		return super.getName();
	}
	public String getEmail() {
		return super.getEmail();
	}
	public String getPassword() {
		return super.getPassword();
	}

	public String getUserID() {
		return this.UserID;
	}
	
	public String getType() {
		return this.typeOfCustomer;
	}

	public void setName(String Name) {
		super.setName(Name);
	}
	public void setEmail(String Email) {
		super.setEmail(Email);
	}
	public void setPassword(String Password) {
		super.setPassword(Password);
	}

	public void setUserID(String UserID) {
		this.UserID = UserID;
	}

	public void setType(String typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}

	public void addTicket(Ticket ticket) {
		Ticket.add(ticket);
	}

	public void removeTicket(Ticket ticket) {
		Ticket.remove(ticket);
	}

	// public void bookingHistory() {
	// 	System.out.println("You have previuosly watched: " );
	
	// 	for (int i = 0; i < Ticket.size(); i++) {
	// 		//System.out.println(i + 1 + ". " + Ticket.get(i).getMovieTitle());
	// 	} 
	// }
	
}