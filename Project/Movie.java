import java.util.*;
public class Movie {
	private String MovieTitle;
	private String Record;
	private String ShowingStatus;
	private String Synopsis;
	private String Director;
	private String ContentRating;
	private String[] Cast;
	private String[] Review;

	public void movieDetails(String MovieTitle, String Record, String ShowingStatus, String Synopsis, String Director, String ContentRating, String[] Cast, String[] Review) {
		this.MovieTitle = MovieTitle;
		this.Record = Record;
		this.ShowingStatus = ShowingStatus;
		this.Synopsis = Synopsis;
		this.Director = Director;
		this.ContentRating = ContentRating;
		this.Cast = Cast;
		this.Review = Review;
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
    

}  
