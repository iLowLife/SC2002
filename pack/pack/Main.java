package pack;
import java.io.* ;
import java.util.*;
import java.util.Iterator;
import java.util.Scanner;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;


public class Main {
	private static ArrayList<Movie> Movie=new ArrayList<Movie>();
	private static ArrayList<Staff> Staff=new ArrayList<Staff>();
	private static ArrayList<Cineplex> Cineplex=new ArrayList<Cineplex>();
	private static ArrayList<Customer> Customer=new ArrayList<Customer>();
	private static ArrayList<MovieSchedule> MovieSchedule=new ArrayList<MovieSchedule>();
	private static ArrayList<Ticket> Ticket=new ArrayList<Ticket>();
	private static ArrayList<Holiday> HolidayDate=new ArrayList<Holiday>();//add into Github
	
	static Customer currentCustomer;

	static String assign;
	public static void main(String[] args) throws ParseException {
		Init();
		//exportHoliday();
		//exportMovieSchedule();	
		//exportCustomer();
		//exportStaff();
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
							while(r > 0 && r < 11){ //r should be within 1 to 11
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
										AdminUIUpdateMovieSchedule();
										System.out.println("Update Movie Schedule");
										break;
									case 6:
										//Delete Movie Schedule
										//System.out.println("Delete Movie Schedule");
										System.out.println("Delete Movie Schedule");
										AdminUIRemoveMovieSchedule();
										break;
									case 7:
										//View Movie
										System.out.println("View Movie");
										UIViewMovie();
										break;
									case 8:
										//View Movie Schedule
										System.out.println("View Movie Schedule");
										UIViewMovieSchedule();
										break;
									case 9:
										//Add new Holiday
										System.out.println("Add New Holiday");
										AdminUIAddHoliday();
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
						UIViewMovieSchedule();
						break;
					case 2:
						System.out.println("Login");
						if(MovieGoerUILogin()){//On Login Success, move to Booking UI
							System.out.println("Login Success");
							int x = 1;
							while(x > 0 && x < 7){ //r should be within 1 to 6
								x = MovieGoerUIMain();
								switch(x){			//7 to logout
									case 1:
										// View Movie Schedule
										System.out.println("View Movie Schedule");
										UIViewMovieSchedule();
										break;
									case 2:
										//View Movie Details
										System.out.println("View Movie Details");
										UIViewMovie();
										break;
									case 3:
										//Book Ticket
										System.out.println("Book Ticket");
										MovieGoerUIBookTicket();
										break;
									case 4:
										//View Booking History
										System.out.println("View Booking History");
										MovieGoerUIViewBookingHistory();
										break;
									case 5:
										//View Top 5 Movies by Rating
										System.out.println("View Top 5 Movies by Rating");
										GetMovieRatings();
										break;
									case 6:
										//add review
										System.out.println("Add Review");
										MovieGoerUIAddReview();
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
						MovieGoerUICreateAccount();
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
		//import Cineplex
		try {
			FileReader     frStream = new FileReader("Cineplex.txt" );
			BufferedReader brStream = new BufferedReader( frStream  );
			String         line     = null;
			//loop each line in file
			while ( ( line = brStream.readLine() ) != null ) {
			  //split line into array of String
			  String[] tokens = line.split(",");
			  //create new User object
			  Cineplex c = new Cineplex(tokens[0], tokens[1]);
			  Cineplex.add(c);
			  //add location to cineplex
			  String[] cinema = tokens[2].split(";");
			  for(int i = 0; i < cinema.length; i++){
				  String[] location = cinema[i].split(",");
				  Cineplex.get(Cineplex.size()-1).getCinema().get(i).setLocation(location[0]);
			  }
			}
			frStream.close();
			brStream.close();
		}
		catch ( IOException e ) {
			System.out.println( "IO Error!" + e.getMessage() );
		}

		//import movie.txt
		try {
			FileReader     frStream = new FileReader("Movie.txt" );
			BufferedReader brStream = new BufferedReader( frStream  );
			String         line     = null;

			while ( ( line = brStream.readLine() ) != null ) {
				String[] movie = line.split("\\|");
				String[] cast = movie[4].split(",");
				//System.out.println(movie[0] + movie[1] + movie[2] + movie[3] + movie[4]);
				Movie.add(new Movie(movie[0], movie[1], movie[2], movie[3], cast));
				//if no review
				try{
					String[] review = movie[5].split(",");
					for(int i = 0; i < review.length; i++){
						String[] reviewDetail = review[i].split(";");
						Movie.get(Movie.size()-1).addReview(reviewDetail[0], Integer.parseInt(reviewDetail[1]));
					}
				}
				catch(Exception e){
					//System.out.println("No review");
				}
			}
			frStream.close();
			brStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//import Holiday.txt
		try {
			FileReader     frStream = new FileReader("Holiday.txt" );
			BufferedReader brStream = new BufferedReader( frStream  );
			String         line     = null;

			while ( ( line = brStream.readLine() ) != null ) {
				String[] holiday = line.split(",");
				HolidayDate.add(new Holiday(holiday[0]));
			}
			frStream.close();
			brStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		//import MovieSchedule.txt
		try {
			FileReader     frStream = new FileReader("MovieSchedule.txt" );
			BufferedReader brStream = new BufferedReader( frStream  );
			String         line     = null;

			while ( ( line = brStream.readLine() ) != null ) {
				String[] movieSchedule = line.split("\\|");
				MovieSchedule.add(new MovieSchedule(movieSchedule[0], Integer.parseInt(movieSchedule[1]), movieSchedule[2], movieSchedule[3]));
				//System.out.println(movieSchedule[0]);
				//update seats
				String[] seats = movieSchedule[4].split(",");
				for(int i = 0; i < seats.length; i++){
					MovieSchedule.get(MovieSchedule.size()-1).getRoom().getSeat()[i].setAssigned(Boolean.parseBoolean(seats[i]));
				}
			}
			frStream.close();
			brStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Import Staff
		try {
			FileReader     frStream = new FileReader("Staff.txt" );
			BufferedReader brStream = new BufferedReader( frStream  );
			String         line     = null;

			while ( ( line = brStream.readLine() ) != null ) {
				String[] staff = line.split(",");
				Staff.add(new Staff(staff[0], Boolean.parseBoolean(staff[1]), staff[2], staff[3], staff[4]));
			}
			frStream.close();
			brStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Import Customer
		try {
			FileReader     frStream = new FileReader("Customer.txt" );
			BufferedReader brStream = new BufferedReader( frStream  );
			String         line     = null;

			while ( ( line = brStream.readLine() ) != null ) {
				String[] customer = line.split(",");
				Customer.add(new Customer(customer[0], customer[1], customer[2], customer[3]));
			}
			frStream.close();
			brStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int MainUI(){
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Centralized Movie Booking App");
		System.out.println("Please select a module:");
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
		System.out.println("4. Add Movie Schedule");
		System.out.println("5. Update Movie Schedule");
		System.out.println("6. Remove Movie Schedule");
		System.out.println("7. View Movies");
		System.out.println("8. View Movie Schedule");
		System.out.println("9. Add Holiday Date");
		System.out.println("10. Top 5 Movies by Ratings");
		System.out.println("11. Logout");
		System.out.println("////////////////////////////////////////////////////");
		int input = sc.nextInt();
		while(input < 1 && input > 11) {	//input 1 to 11 will break the while loop
			if (input >= 1 && input <= 11) {
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
		String title = sc.nextLine();
		System.out.println("Movie Status :");
		System.out.println("1. Preview");
		System.out.println("2. Coming Soon");
		System.out.println("3. Now Showing");
		System.out.println("4. End of Showing");
		String status = "";
		int choice = sc.nextInt();
		if (choice == 1)
			status = "Preview";
		else if (choice == 2)
			status = "Coming Soon";
		else if (choice == 3)
			status = "Now Showing";
		else if (choice == 4)
			status = "End of Showing";
		else 
			status = "";
		System.out.print("Movie Synopsis :");
		String synopsis = sc.next();
		String dummy = sc.nextLine();
		System.out.print("Movie Director :");
		String director = sc.nextLine();
		String[] cast = new String[5];
		System.out.print("Movie Cast (At Least 5):");
		for (int i=0 ; i<5 ; i++){
			cast[i] = sc.nextLine();
		}
		
		Movie.add(new Movie(title, status, synopsis, director, cast ));
		System.out.println("Movie Added");
		System.out.println("////////////////////////////////////////////////////");
		exportMovie();
	}

	public static void AdminUIUpdateMovie(){ //Can improve to change 1 by 1 instead of all
		//update movie
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Update Movie");
		System.out.println("Select Movie :");
		int input = (DropDownMovie()-1);

		// Select section of movie to update
		System.out.println(	"1. Title \n" +			
							"2. Status \n" +
							"3. Synopsis\n" +
							"4. Director \n" +
							"5. Cast ");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				System.out.println("Movie Title :");
				String title = sc.next();
				//String dum = sc.nextLine();
				//title = sc.nextLine();
				Movie.get(input).setMovieTitle(title);
				break;
			case 2:
				System.out.println("Movie Status :");
				System.out.println("1. Preview");
				System.out.println("2. Coming Soon");
				System.out.println("3. Now Showing");
				System.out.println("4. End of Showing");
				String status = "";
				int c = sc.nextInt();
				if (c == 1)
					status = "Preview";
				else if (c == 2)
					status = "Coming Soon";
				else if (c == 3)
					status = "Now Showing";
				else if (c == 4)
					status = "End of Showing";
				else 
					status = "";
				Movie.get(input).setShowingStatus(status);
				break;
			case 3:
				System.out.println("Movie Synopsis :");
				String synopsis = sc.next();
				Movie.get(input).setSynopsis(synopsis);
				break;
			case 4:
				System.out.println("Movie Director :");
				String director = sc.next();
				Movie.get(input).setDirector(director);
				break;
			case 5:
				System.out.println("Movie Cast (Please include at least 5):");
				String[] cast = new String[5];
				for (int i=0;i<5;i++){
					 cast[i] = sc.next();
				}
				Movie.get(input).setCast(cast);
				break;
		}
		System.out.println("Movie Updated");
		System.out.println("////////////////////////////////////////////////////");
		exportMovie();
	}

	public static void AdminUIRemoveMovie(){
		//Remove Movie
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Remove Movie");
		System.out.println("Select Movie :");
		int input = DropDownMovie();
		Movie.remove(input-1);
		System.out.println("Movie Removed");
		System.out.println("////////////////////////////////////////////////////");
		exportMovie();
	}

	public static void AdminUICreateMovieSchedule(){
		//create movie schedule object  
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Create Movie Schedule");
		System.out.println("Select Movie :");
		//Select movie only where status is "Now Showing" or "Coming Soon" or "Preview"
		for (int i = 0; i < Movie.size(); i++) {
			if(Movie.get(i).getShowingStatus().equals("Now Showing") || Movie.get(i).getShowingStatus().equals("Coming Soon") || Movie.get(i).getShowingStatus().equals("Preview")) {
				System.out.println(i + 1 + ". " + Movie.get(i).getMovieTitle() + " (" +   Movie.get(i).getShowingStatus() + ")"); //Movie ID : Movie Title
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
		//Movie Schedule require movie object, cineplex object, cinema object, room object, date, time
		MovieSchedule.add(new MovieSchedule(Movie.get(input-1).getMovieTitle(), room-1 , Cineplex.get(cineplex-1).getCineplexCode() + (cinema-1) , movieDate + movieTime));
		//print out added stuff
		System.out.println(Cineplex.get(cineplex-1).getCineplexCode() + (cinema-1));
		System.out.println("Movie Schedule Created");
		System.out.println("////////////////////////////////////////////////////");
		exportMovieSchedule();
	}

	public static void AdminUIUpdateMovieSchedule(){
		//update movie schedule
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Update Movie Schedule");
		System.out.println("Select Movie Schedule :");
		MovieSchedule ms = DropDownMovieSchedule();
		// Select section of movie schedule to update
		System.out.println(	"1. Movie \n" +			
							"2. Date \n" +
							"3. Time ");
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				System.out.println("Select Movie :");
				int movie = DropDownMovie();
				ms.setMovie(Movie.get(movie-1).getMovieTitle());
				break;
			case 2:
				System.out.println("Movie Date (YYYYMMDD):");
				String movieDate = sc.next();
				ms.setShowTime(movieDate + ms.getTime());
				break;
			case 3:
				System.out.println("Movie Time (HHMM) :");
				String movieTime = sc.next();
				ms.setShowTime((ms.getDate2() + movieTime));
				break;
			default:
				System.out.println("Invalid Input");
				break;
		}
		System.out.println("Movie Schedule Updated");
		System.out.println("////////////////////////////////////////////////////");
		exportMovieSchedule();
	}

	public static void AdminUIRemoveMovieSchedule(){
		//remove movie schedule
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Remove Movie Schedule");
		System.out.println("Select Movie Schedule :");
		MovieSchedule ms = DropDownMovieSchedule();
		MovieSchedule.remove(ms);
		System.out.println("Movie Schedule Removed");
		System.out.println("////////////////////////////////////////////////////");
		exportMovieSchedule();
	}
	public static void AdminUIAddNewEmployee(){
		//add new staff
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Add New Staff");
		System.out.print("Staff Name :");
		String name = sc.nextLine();
		//String dum = sc.next();
		System.out.print("Staff Title :");
		String title = sc.next();
		//System.out.print("Staff Shift :");
		//boolean shift = sc.nextBoolean();
		System.out.print("Staff Email :");
		String email = sc.next();
		System.out.print("Staff Password :");
		String password = sc.next();
		Staff.add(new Staff(title, false, name, email, password));
		System.out.println("Staff Added");
		System.out.println("////////////////////////////////////////////////////");
		exportStaff();
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
		exportStaff();
	}

	public static void AdminUIAddHoliday(){
		//print holiday date
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		//print all holiday 
		for (int i=0;i<HolidayDate.size();i++){
			System.out.println(HolidayDate.get(i).getDate());
		}

		System.out.println("Add Holiday");
		System.out.println("Holiday Date (DD/MM/YYYY) :");
		String d = sc.next();
		HolidayDate.add(new Holiday(d));
		System.out.println("Holiday Added");
		exportHoliday();
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

	public static boolean MovieGoerUILogin(){
		//Login
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Login");
		System.out.print("Username :");
		String email = sc.next();
		System.out.print("Password :");
		String password = sc.next();
		for (int i = 0; i < Customer.size(); i++) {
			if(Customer.get(i).getEmail().equals(email) && Customer.get(i).getPassword().equals(password)) {
				//Save customer object to currentCustomer
				currentCustomer = Customer.get(i);
				System.out.println("Login Successful");
				System.out.println("");
				System.out.println("////////////////////////////////////////////////////");
				return true;
			}
		}
		System.out.println("Invalid Email or Password");
		return false;
		
	}
	public static void MovieGoerUICreateAccount(){
        //Create Account
        Scanner sc = new Scanner(System.in);
        System.out.println("////////////////////////////////////////////////////");
        //System.out.println("Create Account");
        System.out.print("Name :");
        String name = sc.nextLine();
        System.out.println("Email :");
        String email = sc.nextLine();
        System.out.println("Password :");
        String password = sc.nextLine();
        //System.out.println("Any valid concession? :");
        //String typeofCustomer = sc.next();
        //add new customer
        Customer.add(new Customer(name, email, password, "Adult"));
        System.out.println("Account Created");
        System.out.println("////////////////////////////////////////////////////");
		exportCustomer();
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
		System.out.println("5. Top 5 Movies by Ratings");
		System.out.println("6. Add a review");
		System.out.println("7. Logout");
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

	public static void MovieGoerUIBookTicket() throws ParseException{
		//Book Ticket 
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Select Movie From Schedule:");
		//MovieSchedule MS = DropDownMovieSchedule();

		//Select movie only where status is "Now Showing" or "Coming Soon"
		for (int i = 0; i < Cineplex.size(); i++) {
			System.out.println((i+1) + ". " + Cineplex.get(i).getName());
		}
		System.out.println( (Cineplex.size()+1) + ". Exit");
		int d= sc.nextInt() - 1 ;

		for (int i = 0; i < MovieSchedule.size(); i++) {
			MovieSchedule ms = MovieSchedule.get(i);
			if(d == ms.getCineplexID()){
				System.out.println(
				i + 1 + ". " + ms.getMovie()
				+ ", Date: " + ms.getDate() 
				+ ", Time: " + ms.getTime() 
				+ ", At: " + ms.getCineplex() + " " + Cineplex.get(ms.getCineplexID()).getCinema().get(ms.getLocation()).getLocation()
				+ ", Room: " + (ms.getRoom().getRoomNum()+1)
				);
			}
		}

		int ms = sc.nextInt() - 1 ;
		MovieSchedule MS = MovieSchedule.get(ms);
		int input = DropDownSeat(MS);
		//are you a concession holder?
		System.out.println("Are you a concession holder? \n1. Yes \n2. No"); //Student / Elderly
		int concession = sc.nextInt();

		//get Customer Object

		//generate ticket 
		Ticket.add(new Ticket(MS, currentCustomer,input));
		//calculate price
		double price = Ticket.get(Ticket.size()-1).calPrice(MS, concession, HolidayDate);

		System.out.println("Movie : " + MS.getMovie());
		System.out.println("Location : " + MS.getCineplex());
		System.out.println("Room : " + (MS.getRoomID()+1));
		System.out.println("Price : " + price);
		System.out.println("Confirm Booking? \n1. Yes \n2. No");
		int cb = sc.nextInt();

		if(cb == 1) {
			//generate a ticket
			
			
			//change seat status to booked
			MS.getRoom().getSeat()[input-1].setAssigned(true);


			System.out.println("Booking Confirmed");
		}
		else {
			System.out.println("Booking Cancelled");
		}
		System.out.println("Booked");
		System.out.println("////////////////////////////////////////////////////");
		
	}

	public static void MovieGoerUIViewBookingHistory(){
		//loop tickets for customer object
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Booking History: ");
		for (int i = 0; i < Ticket.size(); i++) {
			if(Ticket.get(i).getCEmail().equals(currentCustomer.getEmail())) {
				System.out.println("Date & Time: " + Ticket.get(i).getMovieShowTime() + " "
									 + Ticket.get(i).getMovieTitle());
				/*System.out.println("Location : " + Ticket.get(i).getMovieSchedule().getCineplex());
				System.out.println("Room : " + (Ticket.get(i).getMovieSchedule().getRoomID()+1));
				System.out.println("Seat : " + Ticket.get(i).getSeat());
				System.out.println("Price : " + Ticket.get(i).getPrice());
				System.out.println("Date : " + Ticket.get(i).getDate());
				System.out.println("Time : " + Ticket.get(i).getTime());*/
				System.out.println("////////////////////////////////////////////////////");
			}
		}
	}

	public static void MovieGoerUIAddReview(){
		//Add Review
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		//Select Movie
		System.out.println("Select Movie:");
		int M = DropDownMovie()-1;
		System.out.println("Review :");
		String review = sc.nextLine();
		System.out.println("Rating :");
		int rating = sc.nextInt();
		//add new review
		Movie.get(M).addReview(review,rating);
		System.out.println("Review Added");
		System.out.println("////////////////////////////////////////////////////");
	}

	/////////////////////////////////     General UIs        //////////////////////////////////////
	
	public static int UIViewMovieSchedule() throws ParseException{
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("View Movie Schedule");

		//Select movie only where status is "Now Showing" or "Coming Soon"
		for (int i = 0; i < Cineplex.size(); i++) {
			System.out.println((i+1) + ". " + Cineplex.get(i).getName());
		}
		System.out.println( (Cineplex.size()+1) + ". Exit");
		int input= sc.nextInt() - 1 ;

		for (int i = 0; i < MovieSchedule.size(); i++) {
			MovieSchedule ms = MovieSchedule.get(i);
			if(input == ms.getCineplexID()){
				System.out.println(
				i + 1 + ". " + ms.getMovie()
				+ ", Date: " + ms.getDate() 
				+ ", Time: " + ms.getTime() 
				+ ", At: " + ms.getCineplex() + " " + Cineplex.get(ms.getCineplexID()).getCinema().get(ms.getLocation()).getLocation()
				+ ", Room: " + (ms.getRoom().getRoomNum()+1)
				);
			}
		}

		int ms = sc.nextInt() - 1 ;
		// display seats remaining
		int a = DropDownSeat(MovieSchedule.get(ms));
		//System.out.println("Seats Remaining: " + MovieSchedule.get(ms).getRoom().getSeatsRemaining());
		System.out.println("////////////////////////////////////////////////////");
		return a;
	}

	public static void UIViewMovie(){	//Reminder to add Try Catch for Index Out of Bounds
		//View Movie
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("View Movie");
		System.out.println("Select Movie :");
		int input = DropDownMovie();
		Movie.get(input).printMovie();
		/*System.out.println("Movie Title : " + Movie.get(input-1).getMovieTitle());
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
			System.out.print("Review: " + Movie.get(input-1).getReview().get(i).getReviewText() + " Rating: " + Movie.get(input-1).getReview().get(i).getRating());
		}*/

		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
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

	public static MovieSchedule DropDownMovieSchedule(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Select Movie Schedule :");
		try{
			for (int i = 0; i < MovieSchedule.size(); i++) {
				MovieSchedule ms = MovieSchedule.get(i);
				System.out.println(
				i + 1 + ". " + ms.getMovie()
				+ ", Date: " + ms.getDate() 
				+ ", Time: " + ms.getTime() 
				+ ", At: " + ms.getCineplex() + " " + Cineplex.get(ms.getCineplexID()).getCinema().get(ms.getLocation()).getLocation()
				+ ", Room: " + (ms.getRoom().getRoomNum()+1)
				);
			}
		}catch(Exception e){
			System.out.println("No Movie Schedule");
		}
		int input = sc.nextInt();
		while(input < 1 && input > MovieSchedule.size()) {
			if (input >= 1 && input <= MovieSchedule.size()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return MovieSchedule.get(input-1);
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
			System.out.println(i + 1 + ". " + (Cineplex.get(cineplex).getCinema().get(cinema).getRoom().get(i).getRoomNum()+1));
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
	//pass in Movie Schedule
	public static int DropDownSeat(MovieSchedule ms){
		Scanner sc = new Scanner(System.in);
		System.out.println("Legend : Available (O) , Not Availalbe (X)");
		System.out.println("Select Seat :");
		for (int i = 0; i < ms.getRoom().getSeat().length; i++) {
			//check if assiged
			if (ms.getRoom().getSeat()[i].getAssigned())
				System.out.print(ms.getRoom().getSeat()[i].getSeatID()+1 + "(X) ");
			else
				System.out.print(ms.getRoom().getSeat()[i].getSeatID()+1 + "(O) ");
			if (i % 5 == 4) {
				System.out.println();
			}
		}
		int input = sc.nextInt();
		while(input < 1 && input > ms.getRoom().getSeat().length && !ms.getRoom().getSeat()[input-1].getAssigned()) {
			if (input >= 1 && input <= ms.getRoom().getSeat().length && !ms.getRoom().getSeat()[input-1].getAssigned()) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}

	
	public static int GetMovieRatings() {
		String [] values1 = new String [Movie.size()];
		double [] values2 = new double [Movie.size()];

		for(int i=0;i<Movie.size();i++) {
			//System.out.println(Movie.get(i).getMovieTitle());
			//System.out.println(Movie.get(i).getRating());
			values1[i]=Movie.get(i).getMovieTitle();
			values2[i]=Movie.get(i).getRating();
		}
		//insertionSort(values2,values1);
		sort.insertionSort(values2, values1);

		for(int i=0;i<5;i++) {
			System.out.println(values1[i]);
			System.out.println(values2[i]);
			
		}
		return 1;
	}

	public static void exportMovie(){
		//run this everytime a new movie is added
		try {
			FileWriter     fwStream = new FileWriter(    "Movie.txt" );
			BufferedWriter bwStream = new BufferedWriter( fwStream  );
			PrintWriter    pwStream = new PrintWriter(    bwStream  );
			//loop UserList
			for (int i = 0; i < Movie.size(); i++) {
				//write each User object to file
				pwStream.print(Movie.get(i).getMovieTitle()+"|" + 
								Movie.get(i).getShowingStatus()+"|" + 
							Movie.get(i).getSynopsis()+"|" + 
							Movie.get(i).getDirector()+"|" + 
							Movie.get(i).getCast()[0]+"," + Movie.get(i).getCast()[1]+"," + Movie.get(i).getCast()[2]+"," + Movie.get(i).getCast()[3]+"," + Movie.get(i).getCast()[4] + "|") ;
							for (int j = 0; j < Movie.get(i).getReview().size(); j++) {
								pwStream.print(Movie.get(i).getReview().get(j).getReviewText() + ";" + Movie.get(i).getReview().get(j).getRating() + ",");
							}
				pwStream.println("");
			}
		pwStream.close();
		}
		catch ( IOException e ) {
			System.out.println( "IO Error!" + e.getMessage() );
			e.printStackTrace();
			System.exit( 0 );
		}
	}
	public static void exportHoliday(){
		//run this everytime a new movie is added
		try {
			FileWriter     fwStream = new FileWriter(    "Holiday.txt" );
			BufferedWriter bwStream = new BufferedWriter( fwStream  );
			PrintWriter    pwStream = new PrintWriter(    bwStream  );
			//loop UserList
			for (int i = 0; i < HolidayDate.size(); i++) {
				//write each User object to file
				pwStream.print(HolidayDate.get(i).getHoliday());
				pwStream.println("");
			}
		pwStream.close();
		}
		catch ( IOException e ) {
			System.out.println( "IO Error!" + e.getMessage() );
			e.printStackTrace();
			System.exit( 0 );
		}
	}

	public static void exportMovieSchedule(){
		//export movie schedule
		try{
			FileWriter fwStream = new FileWriter ( "MovieSchedule.txt ");
			BufferedWriter bwStream = new BufferedWriter ( fwStream );
			PrintWriter pwStream = new PrintWriter ( bwStream );
			//Loop MovieSchedule
			for (int i = 0; i < MovieSchedule.size(); i++){
				MovieSchedule ms = MovieSchedule.get(i);
				// MovieSchedule(String Movie, int RoomID,String CinemaID, String ShowTime)
				pwStream.print(ms.getMovie() + "|" + ms.getRoomID() + "|" + ms.getCinemaID() + "|" + ms.getShowTime() + "|");
				for (int j=0;j<ms.getRoom().getSeat().length;j++){
					pwStream.print(ms.getRoom().getSeat()[j].getAssigned() + ",");
				}
				pwStream.println("");
			}
			pwStream.close();

		}
		catch ( IOException e ) {
			System.out.println( "IO Error!" + e.getMessage() );
			e.printStackTrace();
			System.exit( 0 );
		}
	}

	public static void exportCustomer(){
		//export customer
		try{
			FileWriter fwStream = new FileWriter ( "Customer.txt ");
			BufferedWriter bwStream = new BufferedWriter ( fwStream );
			PrintWriter pwStream = new PrintWriter ( bwStream );
			//Loop Customer
			for (int i = 0; i < Customer.size(); i++){
				Customer c = Customer.get(i);
				// Customer(String Username, String Password, String Name
				pwStream.print(c.getName() + "," + c.getEmail() + "," + c.getPassword() + "," + c.getType()) ;	
				pwStream.println("");

			}
			pwStream.close();
		}
		catch ( IOException e ) {
			System.out.println( "IO Error!" + e.getMessage() );
			e.printStackTrace();
			System.exit( 0 );
		}
	}

	public static void exportStaff(){
		//export staff
		try{
			FileWriter fwStream = new FileWriter ( "Staff.txt ");
			BufferedWriter bwStream = new BufferedWriter ( fwStream );
			PrintWriter pwStream = new PrintWriter ( bwStream );
			//Loop staff
			for (int i = 0; i < Staff.size(); i++){
				Staff s = Staff.get(i);
				// public Staff(String Title, boolean Shift, String Name, String Email, String Password) {
				pwStream.print(s.getTitle() + "," + s.getShift() + "," + s.getName() + "," + s.getEmail() + "," + s.getPassword()) ;	
				pwStream.println("");

			}
			pwStream.close();
		}
		catch ( IOException e ) {
			System.out.println( "IO Error!" + e.getMessage() );
			e.printStackTrace();
			System.exit( 0 );
		}
	}

	public static void exportTicket(){
		//export ticket
		try{
			FileWriter fwStream = new FileWriter ( "Ticket.txt ");
			BufferedWriter bwStream = new BufferedWriter ( fwStream );
			PrintWriter pwStream = new PrintWriter ( bwStream );
			//Loop ticket
			for (int i = 0; i < Ticket.size(); i++){
				Ticket t = Ticket.get(i);
				//Ticket(int TicketID, String Price, boolean Concession, boolean Used, String MovieTitle, String MovieShowTime, String MovieLocation, String CName, String CEmail)
				pwStream.print(t.getTicketID() + "," + t.getPrice() + "," + t.isConcession() + "," + t.isUsed() + "," + t.getMovieTitle() + "," + t.getMovieShowTime() + "," + t.getMovieLocation() + "," + t.getCName() + "," + t.getCEmail()) ;	
				pwStream.println("");

			}
			pwStream.close();
		}
		catch ( IOException e ) {
			System.out.println( "IO Error!" + e.getMessage() );
			e.printStackTrace();
			System.exit( 0 );
		}
	}
}
	/*public static void insertionSort(double[] arr,String[] arr1) {
		for(int i=1;i<arr.length;i++) {
			double ratingScore=arr[i];
			String movieName=arr1[i];
			int j=i;
			while(j>0&& arr[j-1]<ratingScore) {
				arr[j]=arr[j-1];
				arr1[j]=arr1[j-1];
				j--;
			}
			arr[j]=ratingScore;
			arr1[j]=movieName;
		}	
	}*/



		//so
		
		/*System.out.println(Movie.get(0).getMovieTitle());
		System.out.print(Movie.get(0).getRating());
		System.out.println(Movie.get(1).getMovieTitle());
		System.out.print(Movie.get(1).getRating());
		System.out.println(Movie.get(2).getMovieTitle());
		System.out.print(Movie.get(2).getRating());
		System.out.println(Movie.get(3).getMovieTitle());
		System.out.print(Movie.get(3).getRating());
		System.out.println(Movie.get(4).getMovieTitle());
		System.out.print(Movie.get(4).getRating());*/
		
	/*	
		return 1;
	}
}

*/





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