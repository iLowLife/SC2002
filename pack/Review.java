package pack;
import java.util.*;
public class Review {

	private String reviewText;
	private int Rating;
	private String MovieName;

	public Review(String reviewText, int Rating, String MovieName) {
		this.reviewText = reviewText;
		this.Rating = Rating;
		this.MovieName = MovieName;
	}

	public String getReviewText() {
		return this.reviewText;
	}

	public int getRating() {
		return this.Rating;
	}

	public String getMovieName() {
		return this.MovieName;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public void setRating(int Rating) {
		this.Rating = Rating;
	}

	public void setMovieName(String MovieName) {
		this.MovieName = MovieName;
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
}
