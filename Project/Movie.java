import java.util.*;
public class Movie {
	private String MovieTitle;
	private String Record;
	private String ShowingStatus;
	private String Synopsis;
	private String Director;
	private String ContentRating;
	private String[] Cast;
	private ArrayList<Review> Review=new ArrayList<Review>();//Creating arraylist  

	/*public void movieDetails(String MovieTitle, String Record, String ShowingStatus, String Synopsis, String Director, String ContentRating, String[] Cast, String[] Review) {
		this.MovieTitle = MovieTitle;
		this.Record = Record;
		this.ShowingStatus = ShowingStatus;
		this.Synopsis = Synopsis;
		this.Director = Director;
		this.ContentRating = ContentRating;
		this.Cast = Cast;
		//this.Review = Review;
	}*/
	
	public Movie(String MovieTitle, String ShowingStatus, String Synopsis, String Director, String[] Cast) {
		this.MovieTitle = MovieTitle;
		//this.Record = Record;
		this.ShowingStatus = ShowingStatus;
		this.Synopsis = Synopsis;
		this.Director = Director;
		this.Cast = Cast;
		//this.NumOfMovies++;
		this.NoOfReview=0;

	}

	public void getMovieDetails(){
		System.out.println("Movie Title: " + MovieTitle);
		//System.out.println("Record: " + Record); //WDYM
		System.out.println("Showing Status: " + ShowingStatus);
		System.out.println("Synopsis: " + Synopsis);
		System.out.println("Director: " + Director);
		System.out.println("Content Rating: " + ContentRating);
		System.out.println("Cast: " + Cast);
	}

	public void editDetails(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("What would you like to edit?");
		System.out.println("1. Movie Title");
		System.out.println("2. Showing Status");
		System.out.println("3. Synopsis");
		System.out.println("4. Director");
		System.out.println("5. Content Rating");
		System.out.println("6. Cast");
		System.out.println("7. Exit");
		
		int choice = scanner.nextInt();
		
		switch(choice){
			case 1:
				System.out.println("Enter new Movie Title: ");
				String newMovieTitle = scanner.nextLine();
				MovieTitle = newMovieTitle;
				break;
			case 2:
				System.out.println("Enter new Showing Status: ");
				String newShowingStatus = scanner.nextLine();
				ShowingStatus = newShowingStatus;
				break;
			case 3:
				System.out.println("Enter Synopsis: ");
				String newSynopsis = scanner.nextLine();
				Synopsis = newSynopsis;
				break;
			case 4:
				System.out.println("Enter Director: ");
				String newDirector = scanner.nextLine();
				Director = newDirector;
				break;
			case 5:
				System.out.println("Enter Content Rating: ");
				String newContentRating = scanner.nextLine();
				ContentRating = newContentRating;
				break;
			case 6:
				System.out.println("Enter total number of cast members: ");
				int count = 0;
				count = scanner.nextInt();
				for(int i = 0; i < count; i++){
					System.out.println("Enter cast member: ");
					String newCast = scanner.nextLine();
					Cast[i] = newCast;
				}
				break;
			case 7:
				break;
		}
	}
	
	public void getRating() {
		// TODO - implement Movie.getRating
		throw new UnsupportedOperationException();
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
	
	
	public void calRating() {
		// TODO - implement Movie.calRating
        int sum = 0;
        for(int i=0; i<Review.length; i++) {
			int sum1 = sum + getRating(); //?????
		}
		float average = sum/Review.length;
		//System.out.println("Average rating is: " + average);
        }

    public void ticketSales() {
		// TODO - implement Movie.ticketSales
		
	}
   public void addReview(String review,int Rating){
	System.out.println("UwU");
	this.Review.add(new Review(review,Rating,this.MovieTitle));
	this.NoOfReview++;
    }
    

}  
