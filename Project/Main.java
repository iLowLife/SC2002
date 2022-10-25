//package MovieBooking;

import java.util.Scanner;

public class Main {
	static Cineplex[] Cineplex = new Cineplex[3];
	static String assign;
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
	}
		

				Scanner sc = new Scanner(System.in);
		int input = MainUI();
		
		if(input == 1){
			//System.out.println("Admin Stuff");
			int input2 = AdminUI1();
			if (input2 == 1) {
				AdminUI2();
			}
			else if (input2 == 2){
				input = MainUI();
			}
		}
		else{
			//System.out.println("Movie Goer Stuff");
			MovieGoerUI1();
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
	}
	
	
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
		if (email.equals("admin") && password.equals("admin")) {
			return 1;
		}
		else
			return 0;
	}
}
