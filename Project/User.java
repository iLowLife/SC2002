import java.util.*;

public class User {

	private static String Name;
	private static String Email;
	private static String Password;
	private static boolean Role;

	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Coom Village!");
		System.out.println("Please insert the necessary details!");
		System.out.println("Name:");
		Name = sc.nextLine();
		System.out.println("Email:");
		Email = sc.nextLine();
		System.out.println("Password:");
		Password = sc.nextLine();
		System.out.println("Role:");
		String strRole = sc.nextLine();

		if(strRole=="User"||strRole=="user")
			Role=true;
		else
			Role=false;
		
			
		System.out.println(Name);
		System.out.println(Email);
		System.out.println(Password);
		System.out.println(strRole);
		if(Role==true)
			System.out.println("User");
		else
			System.out.println("Admin");
		
	}
}
