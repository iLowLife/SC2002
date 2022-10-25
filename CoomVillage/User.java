import java.util.*;

public class User {

	private String Name;
	private String Email;
	private String Password;
	private boolean Role;


	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Coom Village!");
		System.out.println("Name:");
		String strName = sc.nextLine();
		System.out.println("Email:");
		String strMail = sc.nextLine();
		System.out.println("Password:");
		String strPW = sc.nextLine();
		System.out.println("Role:");
		String strRole = sc.nextLine();

		if(strRole=="User")
			Role="T";
		else
	}
}