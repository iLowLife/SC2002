public class Movie {

	private String MovieTitle;
	private String Record;
	private String ShowingStatus;
	private String Synopsis;
	private String Director;
	private String[] Cast;
	private String[] Review;

	

	

	public void calRating() {
		// TODO - implement Movie.calRating
        int sum = 0;
        
        for(int i=0; i<Review.length; i++) {
			int sum = sum + getRating();
		}
		float average = sum/Review.length;
		System.out.println("Average rating is: " + average);
        }
        
		
	

	

    public void ticketSales() {
		// TODO - implement Movie.ticketSales
		throw new UnsupportedOperationException();
	}
    

}  
