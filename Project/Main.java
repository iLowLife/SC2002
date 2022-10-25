//package MovieBooking;

import java.util.Scanner;

public class Main {
	static Cineplex[] Cineplex = new Cineplex[3];
	public static void main(String[] args) {
		 
		Init();
		
		for (int i=0;i<Cineplex.length;i++) {
			System.out.println(Cineplex[i].getName() + " Cineplex");
			for(int j=0;j<Cineplex[i].getNumOfCinema(); j++) {
				System.out.println(Cineplex[i].getCinema()[j].getLocation());
				for(int k=0;k < Cineplex[i].getCinema()[j].NumOfRoom;k++) {
					System.out.println(Cineplex[i].getCinema()[j].getRoom()[k].getRoomNum());
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Movie Booking App");
		System.out.println("Please select a cineplex:");
		System.out.println("1. Golden Village");
		System.out.println("2. Shaws");
		System.out.println("3. Cathay");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
		
		Scanner sc = new Scanner(System.in);
		int CNPX = sc.nextInt()-1;
		
		System.out.println("////////////////////////////////////////////////////");
		System.out.println(Cineplex[CNPX].getName() + " Selected");
		System.out.println("Movie Show Time");
		System.out.println("1. Movie 1");
		System.out.println("2. Movie 2");
		System.out.println("3. Movie 3");
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");
	}
	
	static void Init() {
		//Name, Number of Cinema
		Cineplex[0] = new Cineplex("Golden Village");
		Cineplex[1] = new Cineplex("Shaws");
		Cineplex[2] = new Cineplex("Cathay");
		
		Cineplex[0].getCinema()[0].setLocation("GV @ Bedok");
		Cineplex[0].getCinema()[1].setLocation("GV @ Jurong");
		Cineplex[0].getCinema()[2].setLocation("GV @ Yishun");
		//Cineplex[0].getCinema()[3].setLocation("GV @ Bishan");
		//Cineplex[0].getCinema()[4].setLocation("GV @ Katong");
		
		Cineplex[1].getCinema()[0].setLocation("Shaws @ Seletar");
		Cineplex[1].getCinema()[1].setLocation("Shaws @ NEX");
		Cineplex[1].getCinema()[2].setLocation("Shaws @ Paya Lebar");
		
		Cineplex[2].getCinema()[0].setLocation("Cathay @ West Mall");
		Cineplex[2].getCinema()[1].setLocation("Cathay @ The Cathay");
		Cineplex[2].getCinema()[2].setLocation("Cathay @ Funan");

		/*Cineplex[0].getCinema()[0].setNumOfRoom(3);
		Cineplex[0].getCinema()[1].setNumOfRoom(4);
		Cineplex[0].getCinema()[2].setNumOfRoom(5);
		Cineplex[0].getCinema()[3].setNumOfRoom(6);
		Cineplex[0].getCinema()[4].setNumOfRoom(7);
		
		Cineplex[1].getCinema()[0].setNumOfRoom(2);
		Cineplex[1].getCinema()[1].setNumOfRoom(3);
		Cineplex[1].getCinema()[2].setNumOfRoom(4);
		
		Cineplex[2].getCinema()[0].setNumOfRoom(2);
		Cineplex[2].getCinema()[1].setNumOfRoom(3);*/
	}
}
