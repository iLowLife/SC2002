import java.util.*;

public class Movie {

	private String MovieTitle;
	//private String Record;
	private String ShowingStatus;
	private String Synopsis;
	private String Director;
	private String[] Cast;
	//private ArrayList<Review> Review;// = new <ArrayList>Review();
	private ArrayList<Review> Review=new ArrayList<Review>();//Creating arraylist       
	private int NumReview;
	private double Ratings;

	public Movie(String MovieTitle, String ShowingStatus, String Synopsis, String Director, String[] Cast) {
		this.MovieTitle = MovieTitle;
		//this.Record = Record;
		this.ShowingStatus = ShowingStatus;
		this.Synopsis = Synopsis;
		this.Director = Director;
		this.Cast = Cast;
		//this.NumOfMovies++;
		//this.NoOfReview=0;
		this.NumReview=0;
		this.Ratings=-1;

	}

	public double getRating() {
		// TODO - implement Movie.getRating
		//throw new UnsupportedOperationException();
		return this.Ratings;
	}

	public void calRating() {
		// TODO - implement Movie.calRating
		throw new UnsupportedOperationException();
	}

	public void ticketSales() {
		// TODO - implement Movie.ticketSales
		throw new UnsupportedOperationException();
	}

	public String getMovieTitle() {
		// TODO - implement Movie.getMovieTitle
		return this.MovieTitle;
	}

	public String getShowingStatus() {
		// TODO - implement Movie.getShowingStatus
		return this.ShowingStatus;
	}

	public String getSynopsis() {
		// TODO - implement Movie.getSynopsis
		return this.Synopsis;
	}

	public String getDirector() {
		// TODO - implement Movie.getDirector
		return this.Director;
	}

	public String[] getCast() {
		// TODO - implement Movie.getCast
		return this.Cast;
	}

	public ArrayList<Review> getReview() {
		// TODO - implement Movie.getReview
		return this.Review;
	}

	public Movie getMovie(){
		return this;
	}

	public void setMovieTitle(String MovieTitle) {
		this.MovieTitle = MovieTitle;
	}

	public void setShowingStatus(String ShowingStatus) {
		this.ShowingStatus = ShowingStatus;
	}

	public void setSynopsis(String Synopsis) {
		this.Synopsis = Synopsis;
	}

	public void setDirector(String Director) {
		this.Director = Director;
	}

	public void setCast(String[] Cast) {
		this.Cast = Cast;
	}

	/*public void setReview(String[] Review) {
		this.Review = Review;
	}*/

	public int getNumbOfReview() {
		// TODO - implement Movie.getNumbOfReview
		return this.NoOfReview;
	}
	
	public void addMovie(){
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter Movie Title: ");
		String MovieTitle = sc.nextLine();
		System.out.println("Enter Showing Status: ");
		String ShowingStatus = sc.nextLine();
		System.out.println("Enter Synopsis: ");
		String Synopsis = sc.nextLine();
		System.out.println("Enter Director: ");
		String Director = sc.nextLine();
		System.out.println("Enter Cast: ");
		String[] Cast = new String[5];
		for(int i=0;i<5;i++){
			Cast[i] = sc.nextLine();
		}
		Movie m = new Movie(MovieTitle,ShowingStatus,Synopsis,Director,Cast);
		//NumOfMovies++;*/
	}

	public void addReview(String review,int Rating){
	//System.out.println("UwU");
	this.Review.add(new Review(review,Rating,this.MovieTitle));
	//this.NoOfReview++;
	this.NumReview++;
	
	double sum=0;
	double avg=0;
	
	for(int y=0; y<Review.size();y++)
	{
		sum= sum+ this.Review.get(y).getRating();

	}
	avg=sum/Review.size();
	System.out.println(avg);
	this.Ratings=avg;
    }
}
