import java.util.Scanner;

public class Tutorial1P3 {
	public static void main(String[]args){
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("starting: ");
    	int starting = sc.nextInt();
    	System.out.print("ending : ");
    	int ending = sc.nextInt();
    	System.out.print("increment : ");
    	int increment = sc.nextInt();
    	
    	if (starting > ending || increment < 1)
    		System.out.println("Error input!!");
    	
    	else {
    		System.out.println("For Loop");
        	System.out.println("US$ \t\t S$");
        	System.out.println("-------------------");
			for (int i = starting; i <= ending; i+=increment) {
				System.out.println(i + " \t\t " + i*1.82);
			}
			
			System.out.println("While Loop");
			System.out.println("US$ \t\t S$");
			System.out.println("-------------------");
			int i = starting;
			while(i<=ending) {
				System.out.println(i + " \t\t " + i*1.82);
				i+=increment;
			}
		
			System.out.println("Do-While Loop");
			System.out.println("US$ \t\t S$");
			System.out.println("-------------------");
			i=starting;
			do {
				System.out.println(i + " \t\t " + i*1.82);
				i+=increment;
			}while(i<=ending);
    	}
	}
}
