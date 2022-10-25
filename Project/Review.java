
public class Review {

	private string reviewText;
	private int Rating;
	private string MovieName;

    public Review(string reviewText, int Rating, string MovieName) {
        this.reviewText = reviewText;
        this.Rating = Rating;
        this.MovieName = MovieName;
    }

    

	public void getCustomer() {
		// TODO - implement Review.getCustomer
		throw new UnsupportedOperationException();
	}

    public int getRating() {
		// TODO - implement Movie.getRating
        return this.Rating;
		
	}

    public string getReview() {
		// TODO - implement Movie.getReview
        return this.reviewText;
	}
    
    public string getMovieName() {
           
        return this.MovieName;
    }

}
