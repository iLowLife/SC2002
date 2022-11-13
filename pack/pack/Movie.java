package pack;
import java.util.*;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
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
	private String MovieType;
	
	/** 
	 * @param MovieTitle 
	 * @param ShowingStatus
	 * @param Synopsis
	 * @param Director
	 * @param Cast
	 */
	public Movie(String MovieTitle, String ShowingStatus, String Synopsis, String Director, String[] Cast) {
		this.MovieTitle = MovieTitle;
		//this.Record = Record;
		this.ShowingStatus = ShowingStatus;
		this.Synopsis = Synopsis;
		this.Director = Director;
		this.Cast = Cast;
		this.NumReview=0;
		this.Ratings=-1;

	}

	
	/** 
	 * @return double
	 */
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

	
	/** 
	 * @return String
	 */
	public String getMovieTitle() {
		// TODO - implement Movie.getMovieTitle
		return this.MovieTitle;
	}

	
	/** 
	 * @return String
	 */
	public String getShowingStatus() {
		// TODO - implement Movie.getShowingStatus
		return this.ShowingStatus;
	}

	
	/** 
	 * @return String
	 */
	public String getSynopsis() {
		// TODO - implement Movie.getSynopsis
		return this.Synopsis;
	}

	
	/** 
	 * @return String
	 */
	public String getDirector() {
		// TODO - implement Movie.getDirector
		return this.Director;
	}

	
	/** 
	 * @return String[]
	 */
	public String[] getCast() {
		// TODO - implement Movie.getCast
		return this.Cast;
	}

	
	/** 
	 * @return ArrayList<Review>
	 */
	public ArrayList<Review> getReview() {
		// TODO - implement Movie.getReview
		return this.Review;
	}

	
	/** 
	 * @return Movie
	 */
	public Movie getMovie(){
		return this;
	}

	
	/** 
	 * @param MovieTitle
	 */
	public void setMovieTitle(String MovieTitle) {
		this.MovieTitle = MovieTitle;
	}

	
	/** 
	 * @param ShowingStatus
	 */
	public void setShowingStatus(String ShowingStatus) {
		this.ShowingStatus = ShowingStatus;
	}

	
	/** 
	 * @param Synopsis
	 */
	public void setSynopsis(String Synopsis) {
		this.Synopsis = Synopsis;
	}

	
	/** 
	 * @param Director
	 */
	public void setDirector(String Director) {
		this.Director = Director;
	}

	
	/** 
	 * @param Cast
	 */
	public void setCast(String[] Cast) {
		this.Cast = Cast;
	}

	// public int getNumbOfReview() {
	// 	// TODO - implement Movie.getNumbOfReview
	// 	return this.NoOfReview;
	// }
	
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

	
	/** 
	 * @param review
	 * @param Rating
	 */
	public void addReview(String review,int Rating){
	//System.out.println("UwU");
	this.Review.add(new Review(review,Rating,this.MovieTitle));
	this.NumReview++;
	
	double sum=0;
	double avg=0;
	
	for(int y=0; y<Review.size();y++)
	{
		sum= sum+ this.Review.get(y).getRating();
	}
	avg=sum/Review.size();
	//System.out.println(avg);
	this.Ratings=avg;
    }

	public void printMovie(){
		//print movie
		System.out.println("Movie Title : " + this.MovieTitle);
		System.out.println("Movie Status : " + this.ShowingStatus);
		System.out.println("Movie Synopsis : " + this.Synopsis);
		System.out.println("Movie Director : " + this.Director);
		System.out.print("Movie Cast : [");
		for(int i =0; i< 5; i++) {
			System.out.print(this.Cast[i] + ",");
		}
		System.out.println("]");
		//print movie rating
		System.out.println("Movie Rating : " + this.Ratings);
		//print reviews
		System.out.println("Movie Reviews :");
		for(int i =0; i< this.Review.size(); i++) {
			System.out.println("Review: " + this.getReview().get(i).getReviewText() + ", Rating: " + this.getReview().get(i).getRating());
		}
		
	}
}