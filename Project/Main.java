//package MovieBooking;

import java.util.Iterator;
import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
	private static ArrayList<Movie> Movie=new ArrayList<Movie>();//Creating arraylist
	private static ArrayList<Staff> Staff=new ArrayList<Staff>();//Creating arraylist
	private static ArrayList<Cineplex> Cineplex=new ArrayList<Cineplex>();//Creating arraylist
	private static ArrayList<Customer> Customer=new ArrayList<Customer>();//Creating arraylist
	private static ArrayList<MovieSchedule> MovieSchedule=new ArrayList<MovieSchedule>();//Creating arraylist
	private static ArrayList<Ticket> Ticket=new ArrayList<Ticket>();//Creating arraylist*/

	static String assign;
	public static void main(String[] args) throws ParseException {
		 
		Init();
		while(true){
			System.out.println("Welcome to MOBLIMA");
			int input = MainUI();
			if(input == 1){
				//Admin Stuff
				int a = 1;
				while (a > 0 && a < 3){
					a = AdminUI();
					if(a == 1){
						if (AdminUILogin()) { 
							int r = 1;
							while(r > 0 && r < 11){ //r should be within 1 to 10
								r = AdminUIMain();
								switch(r){			//11 to logout
									case 1:
										//Add Movie
										System.out.println("Add Movie");
										AdminUIAddMovie();
										break;
									case 2:	//case 1 to 3, Create, Update and Delete Movie
										//Update Movie
										System.out.println("Update Movie");
										AdminUIUpdateMovie();
										break;
									case 3:
										//Delete Movie
										System.out.println("Delete Movie");
										AdminUIRemoveMovie();
										break;
									case 4: //case 4 to 6 create, update and delete Movie Schedule
										//Create Movie Schedule
										System.out.println("Create Movie Schedule");
										AdminUICreateMovieSchedule();
										break;
									case 5:
										//Update Movie Schedule
										System.out.println("Update Movie Schedule");
										break;
									case 6:
										//Delete Movie Schedule
										//System.out.println("Delete Movie Schedule");
										System.out.println("Delete Movie Schedule");
										//AdminUIViewMovie();
										break;
									case 7:
										//View Movie
										System.out.println("View Movie");
										AdminUIViewMovie();
										break;
									case 8:
										//View Movie Schedule
										System.out.println("View Movie Schedule");
										AdminUIViewMovieSchedule();
										break;
									case 9:
										//View Top 5 Movies
										System.out.println("View Top 5 Movies");
										//AdminUIViewTop5Movies();
										break;
									case 10:
										//View Top 5 Movies
										System.out.println("View Top 5 Movies");
										//AdminUIViewTop5Movies();
										GetMovieRatings();
										break;
									case 11:
										//Logout
										System.out.println("Logging out...");
										break;
								}
								//Loop this function unless user logout
							}
						}
					}
					else if(a == 2){
						//add new employee
						System.out.println("Add new employee");
						AdminUIAddNewEmployee();
					}
					else if(a==3) {
						//remove employee
						System.out.println("Delete employee");
						AdminUIDelEmployee();
					}
				}
			}
			else if(input == 2){
				//Mover-goer Stuff
				int r = 1;	
				while(r > 0 && r < 4){ //r should be within 1 to 4
					r = MovieGoerUIStart();
					switch(r){			//4 to go back
					case 1:
						System.out.println("View Movie");
						MovieGoerUIViewMovie();
						break;
					case 2:
						System.out.println("Login");
						if(MovieGoerUILogin()){//On Login Success, move to Booking UI
							System.out.println("Login Success");
							int x = 1;
							while(x > 0 && x < 7){ //r should be within 1 to 7
								x = MovieGoerUIMain();
								switch(x){			//7 to logout
									case 1:
										// View Movie Schedule
										System.out.println("View Movie Schedule");
										//MovieGoerUIViewMovieSchedule();
										break;
									case 2:
										//View Movie Details
										System.out.println("View Movie Details");
										MovieGoerUIViewMovie();
										break;
									case 3:
										//Book Ticket
										System.out.println("Book Ticket");
										//MovieGoerUIBookTicket();
										break;
									case 4:
										//View Booking History
										System.out.println("View Booking History");
										//MovieGoerUIViewBookingHistory();
										break;
									case 5:
										//View Top 5 Movies by Ticket Sales
										System.out.println("View Top 5 Movies by Ticket Sales");
										break;
									case 6:
										//View Top 5 Movies by Rating
										System.out.println("View Top 5 Movies by Rating");
										break;
									case 7:
										//Logout
										System.out.println("Logging out...");
									break;
								}	
							}
						}
						else{
							System.out.println("Login Failed");
						}
						break;
					case 3:
						System.out.println("Create Account");
						//MovieGoerUICreateAccount();
						break;
					case 4:
						//Go Back
						System.out.println("Back to Main Menu");
						break;
					}
					//Loop this function unless user decide to go back
				}
								

			}
			else if(input == 3){
				//Exit
				System.out.println("Exiting...");
				break;
			}
		}
	}

	static void Init() {
		//Name, Number of Cinema
		//Create Cineplex Objects 						//Cinema Code
		Cineplex.add( new Cineplex("Golden Village", "GV"));			//GV
		Cineplex.add( new Cineplex("Shaws","SW"));				//SW
		Cineplex.add( new Cineplex("Cathay","CT"));				//CT
		
		//Create Cinema Objects and set Locations
		Cineplex.get(0).getCinema().get(0).setLocation("GV @ Bedok");	//GV1
		Cineplex.get(0).getCinema().get(1).setLocation("GV @ Jurong");	//GV2
		Cineplex.get(0).getCinema().get(2).setLocation("GV @ Yishun");	//GV3
		
		Cineplex.get(1).getCinema().get(0).setLocation("Shaws @ Seletar");
		Cineplex.get(1).getCinema().get(1).setLocation("Shaws @ NEX");
		Cineplex.get(1).getCinema().get(2).setLocation("Shaws @ Paya Lebar");
		
		Cineplex.get(2).getCinema().get(0).setLocation("Cathay @ West Mall");
		Cineplex.get(2).getCinema().get(1).setLocation("Cathay @ The Cathay");
		Cineplex.get(2).getCinema().get(2).setLocation("Cathay @ Funan");
		
		//Create Movie Objects
		Movie.add(new Movie("Avengers: Endgame", "Now Showing", "The grave course of events set in motion by Thanos that wiped out half the universe and fractured the Avengers ranks compels the remaining Avengers to take one final stand in Marvel Studios' grand conclusion to twenty-two films.", "Anthony Russo, Joe Russo", new String[] { "Robert Downey Jr.", "Chris Evans", "Mark Ruffalo", "Chris Hemsworth", "Scarlett Johansson" }));
		Movie.add(new Movie("Captain Marvel", "Now Showing", "Carol Danvers becomes one of the universe's most powerful heroes when Earth is caught in the middle of a galactic war between two alien", "Anna Boden, Ryan Fleck", new String[] { "Brie Larson", "Samuel L. Jackson", "Ben Mendelsohn", "Jude Law", "Annette Bening" }));
		Movie.add(new Movie("Alita: Battle Angel", "Now Showing", "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul", "Robert Rodriguez", new String[] { "Rosa Salazar", "Christoph Waltz", "Jennifer Connelly", "Mahershala Ali", "Ed Skrein" }));
		Movie.add(new Movie("How to Train Your Dragon: The Hidden World", "Now Showing", "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless' discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup's reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.", "Dean DeBlois", new String[] { "Jay Baruchel", "America Ferrera", "F. Murray Abraham", "Cate Blanchett", "Craig Ferguson" }));
		Movie.add(new Movie("Frozen", "Now Showing", "Frozen is a 2013 American computer-animated musical fantasy film produced by Walt Disney Animation Studios as their 53rd film. Loosely based on Hans Christian Andersen's fairy tale The Snow Queen (1844), it was directed by Chris Buck and Jennifer Lee, and written by Lee,[a] and Shane Morris.","Chris Buck, Jennifer Lee", new String[] { "Kristen Bell", "Idina Menzel", "Jonathan Groff", "Josh Gad", "Santino Fontana" }));
		Movie.add(new Movie("The Lion King", "End of Showing", "The Lion King is a 1994 American animated epic musical film produced by Walt Disney Feature Animation and released by Walt Disney Pictures. It is the 32nd Disney animated feature film, and the fifth animated film produced during a period known as the Disney Renaissance.","Roger Allers, Rob Minkoff", new String[] { "Matthew Broderick", "Jeremy Irons", "James Earl Jones", "Whoopi Goldberg", "Cheech Marin" }));
		Movie.add(new Movie("The Incredibles", "End of Showing", "The Incredibles is a 2004 American computer-animated superhero film produced by Pixar Animation Studios and released by Walt Disney Pictures. It is the fifth film produced by Pixar.","Brad Bird", new String[] { "Craig T. Nelson", "Holly Hunter", "Samuel L. Jackson", "Jason Lee", "Wallace Shawn" }));
		Movie.add(new Movie("Toy Story 4", "Coming Soon", "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called 'Forky' to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.","Josh Cooley", new String[] { "Tom Hanks", "Tim Allen", "Annie Potts", "Tony Hale", "Keegan-Michael Key" }));
		Movie.add(new Movie("Aladdin", "Coming Soon", "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.","Guy Ritchie", new String[] { "Will Smith", "Mena Massoud", "Naomi Scott", "Marwan Kenzari", "Navid Negahban" }));

		//Create Staff Objects
		Staff.add(new Staff("Manager", 0, false, "Chee Yong", "cy@gmail.com", "password"));
		Staff.add(new Staff("Employee", 1, false, "Wilfred", "wy@gmail.com", "password"));
		Staff.add(new Staff("Special", 0, false, "admin", "admin", "admin"));
		
		//Create Reviews Objects
		Movie.get(0).addReview("Test",10);
		Movie.get(0).addReview("Test",10);
		Movie.get(0).addReview("Test",9);
		Movie.get(0).addReview("Test",9);
		Movie.get(0).addReview("Test",10);

		Movie.get(1).addReview("Test",10);
		Movie.get(1).addReview("Test",4);
		Movie.get(1).addReview("Test",6);
		Movie.get(1).addReview("Test",8);
		Movie.get(1).addReview("Test",5);

		Movie.get(2).addReview("Test",2);
		Movie.get(2).addReview("Test",1);
		Movie.get(2).addReview("Test",1);
		Movie.get(2).addReview("Test",1);
		Movie.get(2).addReview("Test",1);

		Movie.get(3).addReview("Test",6);
		Movie.get(3).addReview("Test",6);
		Movie.get(3).addReview("Test",6);
		Movie.get(3).addReview("Test",5);
		Movie.get(3).addReview("Test",5);

		Movie.get(4).addReview("Test",4);
		Movie.get(4).addReview("Test",4);
		Movie.get(4).addReview("Test",4);
		Movie.get(4).addReview("Test",5);
		Movie.get(4).addReview("Test",5);

		//Create Customer Objects
		Customer.add(new Customer("Cust1", "1", "1", "elderly"));
		Customer.add(new Customer("Cust2", "2", "2", "adult"));
	}

	public static int MainUI(){
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Centralized Movie Booking App");
		System.out.println("Please select a cineplex:");
		System.out.println("1. Admin Module");
		System.out.println("2. Movie-goer Module");
		System.out.println("3. Exit System");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		while(input < 1 && input > 3) {	//input 1,2,3 will break the while loop
			if (input >= 1 && input <= 3) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}

/////////////////////////////   ADMIN UI STARTS HERE      /////////////////////////////
	public static int AdminUI(){
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Admin Module");
		System.out.println("Please select an option:");
		System.out.println("1. Login");
		System.out.println("2. Add New Employee");
		System.out.println("3. Remove Employee"); //include removing of account
		System.out.println("4. Back");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		while(input < 1 && input > 4) {	//input 1,2,3 will break the while loop
			if (input >= 1 && input <= 4) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}

	public static boolean AdminUILogin(){
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Admin Module Login");
		System.out.print("Email :");
		String email = sc.next();
		System.out.print("Password :");
		String password = sc.next();
		System.out.println("////////////////////////////////////////////////////");
		//compare email and password to staff object
		for(int i = 0; i < Staff.size(); i++){
			if(Staff.get(i).getEmail().toUpperCase().equals(email.toUpperCase()) && Staff.get(i).getPassword().equals(password)){
				return true;
			}
		}
		System.out.println("Invalid Email or Password");
		return false;
	}

	public static int AdminUIMain(){
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Admin Module");
		System.out.println("1. Add Movie");
		System.out.println("2. Update Movie");
		System.out.println("3. Remove Movie");
		System.out.println("4. Add Movie Show Time");
		System.out.println("5. Update Movie Show Time");
		System.out.println("6. Remove Movie Show Time");
		System.out.println("7. View Movies");
		System.out.println("8. View Movie Schedule");
		System.out.println("9. Top 5 Movies by Ticket Sold");
		System.out.println("10. Top 5 Movies by Ratings");
		System.out.println("11. Logout");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
		int input = sc.nextInt();
		while(input < 1 && input > 7) {	//input 1 to 7 will break the while loop
			if (input >= 1 && input <= 7) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}
	public static void AdminUIAddMovie(){
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Add Movie");
		System.out.print("Movie Title :");
		String title = sc.next();
		System.out.print("Movie Status :");
		String status = sc.next();
		System.out.print("Movie Synopsis :");
		String synopsis = sc.next();
		System.out.print("Movie Director :");
		String director = sc.next();
		System.out.print("Movie Cast :");
		String cast = sc.next();
		Movie.add(new Movie(title, status, synopsis, director, new String[] { cast }));
		System.out.println("Movie Added");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
	}

	public static void AdminUIUpdateMovie(){ //Can improve to change 1 by 1 instead of all
		//update movie
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Update Movie");
		System.out.println("Select Movie :");
		int input = DropDownMovie();
		System.out.println("Movie Title :");
		String title = sc.next();
		System.out.println("Movie Status :");
		String status = sc.next();
		System.out.println("Movie Synopsis :");
		String synopsis = sc.next();
		System.out.println("Movie Director :");
		String director = sc.next();
		System.out.println("Movie Cast :");
		String cast = sc.next();
		Movie.get(input-1).setMovieTitle(title);
		Movie.get(input-1).setShowingStatus(status);
		Movie.get(input-1).setSynopsis(synopsis);
		Movie.get(input-1).setDirector(director);
		Movie.get(input-1).setCast(new String[] { cast });
		System.out.println("Movie Updated");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
	}

	public static void AdminUIRemoveMovie(){
		//Remove Movie
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Remove Movie");
		System.out.println("Select Movie :");
		for (int i = 0; i < Movie.size(); i++) {
			System.out.println(i + 1 + ". " + Movie.get(i).getMovieTitle());
		}
		int input = sc.nextInt();
		while(input < 1 && input > Movie.size()) {	//input 1 to 7 will break the while loop
			if (input >= 1 && input <= Movie.size()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		Movie.remove(input-1);
		System.out.println("Movie Removed");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
	}

	public static void AdminUIViewMovie(){	//Reminder to add Try Catch for Index Out of Bounds
		//View Movie
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("View Movie");
		System.out.println("Select Movie :");
		for (int i = 0; i < Movie.size(); i++) {
			System.out.println(i + 1 + ". " + Movie.get(i).getMovieTitle());
		}
		int input = sc.nextInt();
		while(input < 1 && input > Movie.size()) {	//input 1 to 7 will break the while loop
			if (input >= 1 && input <= Movie.size()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		System.out.println("Movie Title : " + Movie.get(input-1).getMovieTitle());
		System.out.println("Movie Status : " + Movie.get(input-1).getShowingStatus());
		System.out.println("Movie Synopsis : " + Movie.get(input-1).getSynopsis());
		System.out.println("Movie Director : " + Movie.get(input-1).getDirector());
		System.out.print("Movie Cast : [");
		for(int i =0; i< Movie.get(input-1).getCast().length; i++) {
			System.out.print(Movie.get(input-1).getCast()[i] + ",");
		}
		System.out.println("]");
		//print movie rating
		System.out.println("Movie Rating : " + Movie.get(input-1).getRating());
		//print reviews
		System.out.println("Movie Reviews :");
		for(int i =0; i< Movie.get(input-1).getReview().size(); i++) {
			System.out.println("Review: " + Movie.get(input-1).getReview().get(i).getReviewText() + " \nRating: " + Movie.get(input-1).getReview().get(i).getRating());
		}

		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
	}

	public static void AdminUICreateMovieSchedule(){
		//create movie schedule object  
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Create Movie Schedule");
		System.out.println("Select Movie :");
		//Select movie only where status is "Now Showing" or "Coming Soon"
		for (int i = 0; i < Movie.size(); i++) {
			if(Movie.get(i).getShowingStatus().equals("Now Showing") || Movie.get(i).getShowingStatus().equals("Coming Soon")) {
				System.out.println(i + 1 + ". " + Movie.get(i).getMovieTitle()); //Movie ID : Movie Title
			}
		}
		int input = sc.nextInt();
		while(input < 1 && input > Movie.size()) {	//input 1 to 7 will break the while loop
			if (input >= 1 && input <= Movie.size()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		//Select Cineplex
		int cineplex = CineplexDropDown();
		//Select Cinema
		int cinema = CinemaDropDown(cineplex-1);
		//Select Room
		int room = RoomDropDown(cineplex-1, cinema-1);

		//get Date and Time
		System.out.println("Movie Date (YYYYMMDD):");
		String movieDate = sc.next();
		System.out.println("Movie Time (HHMM) :");
		String movieTime = sc.next();
		MovieSchedule.add(new MovieSchedule(Movie.get(input-1).getMovieTitle(), room-1 , Cineplex.get(cineplex-1).getCineplexCode() + (cinema-1) , movieDate + movieTime));
		System.out.println("Movie Schedule Created");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
	}

	public static void AdminUIAddNewEmployee(){
		//add new staff
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Add New Staff");
		System.out.print("Staff Name :");
		String name = sc.next();
		System.out.print("Staff Title :");
		String title = sc.next();
		int staffID = Staff.size() + 1;
		System.out.println("Staff ID :" + staffID);
		System.out.print("Staff Shift :");
		boolean shift = sc.nextBoolean();
		System.out.print("Staff Email :");
		String email = sc.next();
		System.out.print("Staff Password :");
		String password = sc.next();
		Staff.add(new Staff(title, staffID, shift, name, email, password));
		System.out.println("Staff Added");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
	}
	
	public static void AdminUIDelEmployee(){
		//add new staff
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Delete Staff"); //remove the staff if the staff left the company
		System.out.print("Staff email :");
		String staffEmail = sc.next();
		for(int i = 0; i < Staff.size(); i++){
			if(Staff.get(i).getEmail().toUpperCase().equals(staffEmail.toUpperCase())){
				Staff.remove(i);
			}
		}
		
		System.out.println("Staff Deleted");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
	}

	public static void AdminUIViewMovieSchedule() throws ParseException{
		//view movie schedule
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("View Movie Schedule");
		//Select movie only where status is "Now Showing" or "Coming Soon"
		for (int i = 0; i < MovieSchedule.size(); i++) {
			System.out.println(
			i + 1 + ". " + MovieSchedule.get(i).getMovie()
			+ " ,Date: " + MovieSchedule.get(i).getDate() 
			+ " ,Time: " + MovieSchedule.get(i).getTime() 
			+ " ,At: " + MovieSchedule.get(i).getCinemaID() 
			+ " ,Room: " + MovieSchedule.get(i).getRoom().getRoomNum()
			 );
		}
	}

/////////////////////////////    MOVIE GOER UI STARTS HERE      /////////////////////////////

	public static int MovieGoerUIStart(){
		//Customer can view movie schedule
		//Customer must create an account to book a ticket
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("MovieGoerUI1");
		System.out.println("1. View Movie Schedule");
		System.out.println("2. Login");
		System.out.println("3. Create Account");
		System.out.println("4. Back to Main Menu");
		System.out.println("////////////////////////////////////////////////////");
		int input = sc.nextInt();
		while(input < 1 && input > 4) {	//input 1 to 4 will break the while loop
			if (input >= 1 && input <= 4) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}

	public static void MovieGoerUIViewMovie(){
		//View Movie
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("View Movie");
		int input = DropDownMovie();
		System.out.println("Movie Title : " + Movie.get(input-1).getMovieTitle());
		System.out.println("Movie Status : " + Movie.get(input-1).getShowingStatus());
		System.out.println("Movie Synopsis : " + Movie.get(input-1).getSynopsis());
		System.out.println("Movie Director : " + Movie.get(input-1).getDirector());
		System.out.print("Movie Cast : [");
		for(int i =0; i< Movie.get(input-1).getCast().length; i++) {
			System.out.print(Movie.get(input-1).getCast()[i] + ",");
		}
		System.out.println("]");
		//print movie rating
		System.out.println("Movie Rating : " + Movie.get(input-1).getRating());
		//print reviews
		System.out.println("Movie Reviews :");
		for(int i =0; i< Movie.get(input-1).getReview().size(); i++) {
			System.out.println("Review: " + Movie.get(input-1).getReview().get(i).getReviewText() + " \nRating: " + Movie.get(input-1).getReview().get(i).getRating());
		}
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
	}
	
	public static boolean MovieGoerUILogin(){
		//Login
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Login");
		System.out.println("Username :");
		String email = sc.next();
		System.out.println("Password :");
		String password = sc.next();
		for (int i = 0; i < Customer.size(); i++) {
			if(Customer.get(i).getEmail().equals(email) && Customer.get(i).getPassword().equals(password)) {
				System.out.println("Login Successful");
				System.out.println("");
				System.out.println("////////////////////////////////////////////////////");
				return true;
			}
		}
		System.out.println("Invalid Email or Password");
		return false;
		
	}

	public static int MovieGoerUIMain(){
		//Main Menu
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("MovieGoerUIMain");
		System.out.println("1. View Movie Schedule");
		System.out.println("2. View Movie Details");
		System.out.println("3. Book Ticket");
		System.out.println("4. View Booking History");
		System.out.println("5. Top 5 Movies by Ticket Sold");
		System.out.println("6. Top 5 Movies by Ratings");
		System.out.println("7. Logout");
		System.out.println("////////////////////////////////////////////////////");
		int input = sc.nextInt();
		while(input < 1 && input > 7) {	//input 1 to 5 will break the while loop
			if (input >= 1 && input <= 7) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}
	
	public static int MovieGoerUIViewMovieSchedule(){
		//View All Movie Schedule
		for (int i=0; i < MovieSchedule.size(); i++) {
			System.out.println("Movie Title : " + MovieSchedule.get(i).getMovie());
			System.out.println("Cinema : " + MovieSchedule.get(i).getCinemaID());
			System.out.println("Date : " + MovieSchedule.get(i).getShowTime());
			System.out.println("");
		}
		return 0;
	}
	
	/////////////////////////////////     Drop Down Boxes    //////////////////////////////////////
	//drop down box for Movie
	public static int DropDownMovie(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Movie :");
		for (int i = 0; i < Movie.size(); i++) {
			System.out.println(i + 1 + ". " + Movie.get(i).getMovieTitle());
		}
		int input = sc.nextInt();
		while(input < 1 && input > Movie.size()) {
			if (input >= 1 && input <= Movie.size()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}

	public static int DropDownStaff(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Staff :");
		for (int i = 0; i < Staff.size(); i++) {
			System.out.println(i + 1 + ". " + Staff.get(i).getName());
		}
		int input = sc.nextInt();
		while(input < 1 && input > Staff.size()) {
			if (input >= 1 && input <= Staff.size()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}

	public static int DropDownMovieSchedule(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Movie Schedule :");
		for (int i = 0; i < MovieSchedule.size(); i++) {
			System.out.println(i + 1 + ". " + MovieSchedule.get(i).getMovie());
		}
		int input = sc.nextInt();
		while(input < 1 && input > MovieSchedule.size()) {
			if (input >= 1 && input <= MovieSchedule.size()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}

	public static int CineplexDropDown(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Cineplex :");
		for (int i = 0; i < Cineplex.size(); i++) {
			System.out.println(i + 1 + ". " + Cineplex.get(i).getName());
		}
		int input = sc.nextInt();
		while(input < 1 && input > Cineplex.size()) {
			if (input >= 1 && input <= Cineplex.size()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}

	public static int CinemaDropDown(int cineplex){
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Cinema :");
		for (int i = 0; i < Cineplex.get(cineplex).getCinema().size(); i++) {
			System.out.println(i + 1 + ". " + Cineplex.get(cineplex).getCinema().get(i).getLocation());
		}
		int input = sc.nextInt();
		while(input < 1 && input > Cineplex.get(cineplex).getCinema().size()) {
			if (input >= 1 && input <= Cineplex.get(cineplex).getCinema().size()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}

	public static int RoomDropDown(int cineplex,int cinema ){
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Room :");
		for (int i = 0; i < Cineplex.get(cineplex).getCinema().get(cinema).getRoom().size(); i++) {
			System.out.println(i + 1 + ". " + Cineplex.get(cineplex).getCinema().get(cinema).getRoom().get(i).getRoomNum());
		}
		int input = sc.nextInt();
		while(input < 1 && input > Cineplex.get(cineplex).getCinema().get(cinema).getRoom().size()) {
			if (input >= 1 && input <= Cineplex.get(cineplex).getCinema().get(cinema).getRoom().size()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}
	
	public static int GetMovieRatings() {
		System.out.println(Movie.get(1).getMovieTitle());
		System.out.println(Movie.get(1).getRating());
		return 1;
	}
}






		/* 
		switch (input) {
			case 1:
				System.out.println("Add Movie");
				System.out.println("Movie Title :");
				String title = sc.next();
				System.out.println("Movie Status :");
				String status = sc.next();
				System.out.println("Movie Synopsis :");
				String synopsis = sc.next();
				System.out.println("Movie Director :");
				String director = sc.next(); f 
				System.out.println("Movie Cast :");
				String cast = sc.next();
				Movie.add(new Movie(title, status, synopsis, director, new String[] { cast }));
				System.out.println("Movie Added");
				System.out.println("");
				break;
			case 2:
				//Update Movie
				System.out.println("Update Movie");
				System.out.println("Select Movie :");
				for (int i = 0; i < Movie.size(); i++) {
					System.out.println(i + 1 + ". " + Movie.get(i).getMovieTitle());
				}


				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				break;
		}
		return input;*/
		/*
		//Insert a new review
		Scanner sc = new Scanner(System.in);
		for (Movie m : Movie) {
			System.out.println(m.getMovieTitle());
		}
		//insert a new movie review
		System.out.println("Enter Review for" +Movie.get(1).getMovieTitle());
		//Scanner sc = new Scanner(System.in);
		System.out.println("Enter Review: ");
		String Review = sc.nextLine();
		System.out.println("Enter Rating: ");
		int Rating = sc.nextInt();
		Movie.get(1).addReview(Review,Rating);
		Movie.get(1).addReview(Review,Rating);

		for (Review r : Movie.get(1).getReview()) {
			System.out.println(r.getReviewText());
		}*/

		/* 
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Movie Booking App");
		System.out.println("Please select a cineplex:");
		System.out.println("1. Golden Village");
		System.out.println("2. Shaws");
		System.out.println("3. Cathay");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
		
		
		int CNPX = sc.nextInt()-1;
		
		System.out.println("////////////////////////////////////////////////////");
		System.out.println(Cineplex[CNPX].getName() + " Selected");
		System.out.println("Movie Show Time");
		System.out.println("1. Movie 1");
		System.out.println("2. Movie 2");
		System.out.println("3. Movie 3");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");

		*/
	
			
		/*
		//String Movie, int Room, String ShowTime
		MovieSchedule ms = new MovieSchedule("Avengers", 0 ,0,"25/10/2022 13:00");
		ms.getRoom().getSeat()[5].setAssigned(true);
		for(int i=0;i<25; i++){
			if (ms.getRoom().getSeat()[i].getAssigned() == false)
				assign = "O";
			else 
				assign = "X";
				System.out.print(ms.getRoom().getSeat()[i].getSeatID() + "(" + assign + ") ");

			if (i%5 == 4){
				System.out.println();
			}
		}
		for (int i=0;i<3;i++) {
			System.out.println(m[i].getMovieTitle() + " " +m[i].getSynopsis());
		}*/
		

		/*
		//insert a new movie review
		System.out.println("Enter Review for" + m[0].getMovieTitle());

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Review: ");
		String Review = sc.nextLine();
		System.out.println("Enter Rating: ");
		int Rating = sc.nextInt();
		m[0].addReview(Review,Rating);
		m[0].addReview(Review,Rating);

		for (Review r : m[0].getReview()) {
			System.out.println(r.getReviewText());
		}
		*/
