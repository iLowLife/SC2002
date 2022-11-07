package pack;
import java.util.*;
import pack.Movie;
import pack.MovieSchedule;
import pack.Ticket;
public class Customer extends User {

	private int UserID;
	private String typeOfCustomer;
	//private ArrayList<Ticket> Ticket=new ArrayList<Ticket>();//Creating arraylist
	// private MovieSchedule Movie = getMovie();
	// private Movie MovieTitle = getMovieTitle();
	//private ArrayList<bookingHistory> bookingHistory=new ArrayList<bookingHistory>();//Creating arraylist
	private int Count = 0;

	public Customer(String Name, String Email, String Password, String typeOfCustomer) {
		super(Name, Email, Password);
		this.UserID = Count++;
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

	public int getUserID() {
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

	public void setUserID(int UserID) {
		this.UserID = UserID;
	}

	public void setType(String typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}
/* 
	//use to create a duplicate ticket for customer object to store in bookingHistory
	public void addBookingHistory(Ticket t) {
		this.bookingHistory.add(new bookingHistory(...));
	}

	public void viewBookingHistory() {
		for (int i=0; i<bookingHistory.size(); i++) {
			System.out.println(bookingHistory.get(i));
		}
	}*/

	// public void bookingHistory() {
	// 	System.out.println("You have previuosly watched: " );
	
	// 	for (int i = 0; i < Ticket.size(); i++) {
	// 		//System.out.println(i + 1 + ". " + Ticket.get(i).getMovieTitle());
	// 	} 
	// }
	
}