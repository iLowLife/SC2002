import java.util.Scanner;

public class Main {
	static Cineplex[] Cineplex = new Cineplex[3];
	static String assign;
	static Staff x[]= new Staff [5];
	static Customer y[] = new Customer[100];
	static int count=2;
	public static void main(String[] args) {
		 
		Init();

		for (int i=0;i<Cineplex.length;i++) {
			System.out.println(Cineplex[i].getName() + " Cineplex");
			for(int j=0;j<Cineplex[i].getNumOfCinema(); j++) {
				System.out.println(Cineplex[i].getCinema()[j].getLocation());
				for(int k=0;k < Cineplex[i].getCinema()[j].NumOfRoom;k++) {
					System.out.println("Room Number: " + Cineplex[i].getCinema()[j].getRoom()[k].getRoomNum());
					for(int l=0;l<Cineplex[i].getCinema()[j].getRoom()[k].NumOfSeat;l++) {
						if (Cineplex[i].getCinema()[j].getRoom()[k].getSeat()[l].getAssigned() == false)
							assign = "O";
						else 
							assign = "X";
						System.out.print(Cineplex[i].getCinema()[j].getRoom()[k].getSeat()[l].getSeatID() + "(" + assign + ") ");
						if (l%5 == 4){
							System.out.println();
						}
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println();
		}
		
		Scanner sc = new Scanner(System.in);
		int input = MainUI();
		
		if(input == 1){
			//System.out.println("Admin Stuff");
			int input2 = AdminUI1();
			if (input2 == 1) {
				//AdminUI2();
			}
			else if (input2 == 0){
				input = MainUI();
			}
		}
		else{
			//System.out.println("Movie Goer Stuff");
			int inputGo2 = MovieGoerUI1();
			if(inputGo2 ==1)
			{
				System.out.println("Buy Ticket Stuff");
			}
			else if (inputGo2 ==2) {
				//System.out.println("Login Stuff");
				int inputLogin=MovieGoerUI2();
				if(inputLogin==1)
					System.out.println("Login Successful!");
				else
				{
					System.out.println("Login Fail");
					input=MainUI();
				}
			}
			else {
				System.out.println("Register Stuff");
				MovieGoerUI3();
				System.out.println("Register Successful!");
			}
		}
	}

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
	//}
	
	
	static void Init() {
		//Name, Number of Cinema
		Cineplex[0] = new Cineplex("Golden Village");
		Cineplex[1] = new Cineplex("Shaws");
		Cineplex[2] = new Cineplex("Cathay");
		
		Cineplex[0].getCinema()[0].setLocation("GV @ Bedok");
		Cineplex[0].getCinema()[1].setLocation("GV @ Jurong");
		Cineplex[0].getCinema()[2].setLocation("GV @ Yishun");
		
		Cineplex[1].getCinema()[0].setLocation("Shaws @ Seletar");
		Cineplex[1].getCinema()[1].setLocation("Shaws @ NEX");
		Cineplex[1].getCinema()[2].setLocation("Shaws @ Paya Lebar");
		
		Cineplex[2].getCinema()[0].setLocation("Cathay @ West Mall");
		Cineplex[2].getCinema()[1].setLocation("Cathay @ The Cathay");
		Cineplex[2].getCinema()[2].setLocation("Cathay @ Funan");

		//Set Cathay @ Funan Room 2, Seat 0 to be assigned
		Cineplex[2].getCinema()[2].getRoom()[2].getSeat()[0].setAssigned(true);
		//Set Cathay @ Funan Room 1, Seat 24 to be assigned
		Cineplex[2].getCinema()[2].getRoom()[1].getSeat()[24].setAssigned(true);
		
		//Preset Staff Data
		x[0]= new Staff("Manager", 1000, true, "Tom", "abc@o", "1234");
		x[1]= new Staff("Staff", 2010, false, "Dick", "xyz@o", "ab21");
		x[2]= new Staff("Staff", 2011, true, "Harry", "potty@o", "qwer");
		x[3]= new Staff("Manager", 1002, false, "Jerry", "tabe@o", "1256");
		x[4]= new Staff("Staff", 2009, true, "Spike", "koc@o", "12cb");
		
		//Preset User Data
		y[0]= new Customer("Bobby","tryer@g","9876","Student");
		y[1]= new Customer("Parry","poil@g","5432","Senior Citizen");
	}

	public static int MainUI(){
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Centralized Movie Booking App");
		System.out.println("Please select a cineplex:");
		System.out.println("1. Admin Module");
		System.out.println("2. Movie-goer Module");
		System.out.println("");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		while(input != 1 || input != 2) {	//input 1 or 2 will break the while loop
			if (input == 1 || input == 2) {
				break;
			}
			System.out.println("Invalid Input");
			input = sc.nextInt();
		}
		return input;
	}

	public static int AdminUI1(){
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Admin Module Login");
		System.out.println("Email :");
		String email = sc.next();
		System.out.println("Password :");
		String password = sc.next();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
		
		for(int a=0;a<5;a++) {
			if(email.equals(x[a].getEmail())) {
				System.out.println(x[a].getPassword());
				if(password.equals(x[a].getPassword()))
					return 1;
				else 
					return 0;
			}
		}
		return 0;
	}
	
	public static int MovieGoerUI1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Movie-goer Module Login");
		System.out.println("1. Buy Ticker");
		System.out.println("2. Login");
		System.out.println("3. Register");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
		
		int inputGo = sc.nextInt();
		while(inputGo != 1 || inputGo != 2 || inputGo !=3) {	//input 1 or 2 will break the while loop
			if (inputGo == 1 || inputGo == 2 || inputGo ==3) {
				break;
			}
			System.out.println("Invalid Input");
			inputGo = sc.nextInt();
		}
		return inputGo;
	}
	
	public static int MovieGoerUI2(){
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Movie-goer Module Login");
		System.out.println("Email :");
		String email = sc.next();
		System.out.println("Password :");
		String password = sc.next();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
		
		for(int a=0;a<100;a++) {
			if(email.equals(y[a].getEmail())) {
				System.out.println(y[a].getPassword());
				if(password.equals(y[a].getPassword()))
					return 1;
				else 
					return 0;
			}
		}
		return 0;
	}
	
	public static void MovieGoerUI3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Movie-goer Module Register");
		System.out.println("Please fill up accordingly:");
		System.out.println("Name:");
		String name=sc.next();
		System.out.println("Email:");
		String email=sc.next();
		System.out.println("Password:");
		String pass=sc.next();
		System.out.println("Student/Senior Citizen/Others:");
		String typeofCust=sc.next();
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
		y[count] = new Customer(name,email,pass,typeofCust);
		count++;
	}
}
