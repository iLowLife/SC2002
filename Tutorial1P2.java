import java.util.*;

public class Tutorial1P2 {
    public static void main(String[]args){
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Salary: ");
    	int salary = sc.nextInt();
    	System.out.println("Merit: ");
    	int merit = sc.nextInt();

    	if ((salary >=500) && (salary < 650))
    		if ((salary >=600) && (salary < 650) && (merit >= 10))
    			System.out.println("Grade: B \n");
    		else
    			System.out.println("Grade: C \n");
    	
    	else if ((salary >=600) && (salary < 800))
    		if ((salary >=700) && (salary < 800) && (merit >= 20))
    			System.out.println("Grade: A \n");
    		else
    			System.out.println("Grade: B \n");
    	
    	else if ((salary >=700) && (salary < 900))
    		System.out.println("Grade: A \n");
    	else
    		System.out.println("Invalid choice\n");
    }
}
