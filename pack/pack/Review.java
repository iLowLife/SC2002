package pack;
import java.util.*;
/*
 * @author SE1 Group 4
 * @version 13/11/2022
 * 
 */
public class Review {

	private String reviewText;
	private int Rating;
	private String MovieName;

	/** 
    * @param reviewText
    * @param Rating
    * @param MovieName
	*/

	public Review(String reviewText, int Rating, String MovieName) {
		this.reviewText = reviewText;
		this.Rating = Rating;
		this.MovieName = MovieName;
	}

	
	/** 
	 * @return String
	 */
	public String getReviewText() {
		return this.reviewText;
	}

	
	/** 
	 * @return int
	 */
	public int getRating() {
		return this.Rating;
	}

	
	/** 
	 * @return String
	 */
	public String getMovieName() {
		return this.MovieName;
	}

	
	/** 
	 * @param reviewText
	 */
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	
	/** 
	 * @param Rating
	 */
	public void setRating(int Rating) {
		this.Rating = Rating;
	}

	
	/** 
	 * @param MovieName
	 */
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
