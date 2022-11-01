
public class Customer extends User {

	private String UserID;
	private String typeOfCustomer;
	private ArrayList<Ticket> Ticket=new ArrayList<Ticket>();//Creating arraylist
	private MovieSchedule Movie = getMovie();
	private Movie MovieTitle = getMovieTitle();
	
	
	


	public Customer(String Name, String Email, String Password, String typeOfCustomer) {
		super(Name, Email, Password);
		this.UserID=Email;
		this.typeOfCustomer=typeOfCustomer;
	}

	public String getUserID() {
		return this.UserID;
	}
	
	public String getType() {
		return this.typeOfCustomer;
	}
	

	public MovieSchedule getMovie() {
		return getMovie();
	}

	public Movie getMovieTitle() {
		return getMovieTitle();
	}


	public void bookingHistory() {
		System.out.println("You have previuosly watched: " );
	
		for (int i = 0; i < Ticket.size(); i++) {
			System.out.println(i + 1 + ". " + Ticket.get(i).getMovieTitle());
		} 
	}
	
	

}

