import java.util.*;

public class Tutorial1P4 {
    public static void main(String[]args){
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Height: ");
    	int height = sc.nextInt();
    	
    	if(height < 1)
    		System.out.print("Input Error!!");
    	/*
    	for (int i = 0; i < height; i++) {
    		if(i%2==0)
	    		for(int j = 0; j<=i; j++) {
		    		if(j%2 == 0)
		    			System.out.print("AA");
		    		else
		    			System.out.print("BB");
	    		}
    		else
    		for(int j = 0; j<=i; j++) {
	    		if(j%2 == 0)
	    			System.out.print("BB");
	    		else
	    			System.out.print("AA");
    		}
    		
    		System.out.print("\n");
    	}
    	*/
    	
    	String a = "";
    	for (int i = 0; i < height; i++) {
    		if(i%2 == 0) 
    			a = "AA" + a;
    		else
    			a = "BB" + a;
    		System.out.println(a);
    	}
    	
    	
    }
}
