import java.util.Scanner;

public class Lab1P1 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		char choice = sc.next().charAt(0);
		
		switch(choice) {
		case 'a','A':
			System.out.println("Action movie fan\n");
			break;
		case 'c','C':
			System.out.println("Comedy movie fan\n");
			break;
		case 'd','D':
		System.out.println("Drama movie fan\n");
			break;
		default:
			System.out.println("Invalid choice\n");
		}
		/*
		if ((choice == 'A') || (choice == 'a'))
			System.out.println("Action movie fan\n");
		else if ((choice == 'C') || (choice == 'c'))
			System.out.println("Comedy movie fan\n");
		else if ((choice == 'D') || (choice == 'd'))
			System.out.println("Drama movie fan\n");
		else
			System.out.println("Invalid choice\n");*/
	}
}
