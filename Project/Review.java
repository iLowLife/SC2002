import java.util.*;
public class Review {

	private String reviewText;
	private int Rating;
	private String MovieName;
	private String userID;

    public Review(String reviewText, int Rating, String MovieName, String userID) {
        this.reviewText = reviewText;
        this.Rating = Rating;
        this.MovieName = MovieName;
		this.userID = userID;
	}
	public void getCustomer() {
		// TODO - implement Review.getCustomer
		return this.Customer;
	}
    public int getRating() {
		// TODO - implement Movie.getRating
        return this.Rating;	
	}
    public String getReview() {
		// TODO - implement Movie.getReview
        return this.reviewText;
	}
    public String getMovieName() {      
        return this.MovieName;
    }
	public void rottenTomatoes(){
		System.out.println("Enter your name: ");
		Scanner scanner = new Scanner(System.in);
		String userID = scanner.nextLine();

		System.out.println("Enter your rating: ");
		Scanner scanner1 = new Scanner(System.in);
		int Rating = scanner1.nextInt();
		
		System.out.println("Enter your review: ");
		Scanner scanner2 = new Scanner(System.in);
		String reviewText = scanner2.nextLine();
	}
