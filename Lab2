package Lab2P1;

import java.util.*;
public class Lab2p1 {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int choice; int x,y; long num;
		do {
		System.out.println("Perform the following methods:");
		System.out.println("1: Multiplication test");
		System.out.println("2: Quotient using division by subtraction");
		System.out.println("3: Remainder using division by subtraction");
		System.out.println("4: Count the number of digits");
		System.out.println("5: Position of a digit");
		System.out.println("6: Extract all odd digits");
		System.out.println("7: Quit");
		choice = scanner.nextInt();
		switch (choice) {
		 case 1: /* add mulTest() call */
			 mulTest();
		 break;
		 case 2: /* add divide() call */ 
			 System.out.println("Enter a number for X:");
			 x = scanner.nextInt();
			 System.out.println("Enter a number for Y:");
			 y = scanner.nextInt();
			 System.out.printf("%d/%d = %d\n", x,y,divide(x,y));
		 break;
		 case 3: /* add modulus() call */
			 System.out.println("Enter a number for X:");
			 x = scanner.nextInt();
			 System.out.println("Enter a number for Y:");
			 y = scanner.nextInt();
			 System.out.printf("%d %% %d = %d\n", x,y,modulus(x,y));
		 break;
		 case 4: /* add countDigits() call */
			 System.out.println("Enter value: ");
			 y = scanner.nextInt();
			 x = countDigits(y);
			 if(x == 0)
				 System.out.printf("Error!\n");
			 else
				 System.out.printf("y: %d - count = %d\n", y,x);
		 break;
		 case 5: /* add position() call */
			 System.out.println("Enter number: ");
			 y = scanner.nextInt();
			 System.out.printf("Enter number to look for in %d: \n",y);
			 x = scanner.nextInt();
			 System.out.printf("Position = %d \n", position(y,x));
		 break;
		 case 6: /* add extractOddDigits() call */
			 System.out.println("Enter number: ");
			 num = scanner.nextLong();
			 if(num > 0)
				 System.out.printf("oddDigits in number = %d \n", extractOddDigits(num));
			 else
				 System.out.printf("Error!\n");
		 break;
		 case 7: System.out.println("Program terminating...\n");
		 }}while (choice < 7);	
}
	//3.2
	public static void mulTest()
	{
		int numOfCorrect = 0;
		Random rand = new Random();
		//Test questions 5 times
		for(int i = 0; i < 5; i++)
		{
			int num1 = rand.nextInt(10);
			int num2 = rand.nextInt(10);
			num1 += (num1 != 0) ? 0 : 1;
			num2 += (num2 != 0) ? 0 : 1;
			System.out.printf("How much is %d times %d? ", num1, num2);
			if((num1 * num2) == scanner.nextInt())
				numOfCorrect++;
		}
		System.out.printf("%d answers out of 5 are correct.\n", numOfCorrect);
	}
	//3.3
	public static int divide(int x, int y)
	{
		int counter = 0;
		while(x > 0)
		{
			x -= y;
			if(x >= 0)
				counter++;
		}
		return counter;
	}
	//3.4
	public static int modulus(int x, int y)
	{
		int remainder = 0;
		while(x > 0)
		{
			remainder = x;
			x -= y;
		}
		return (x != 0) ? remainder : 0;
	}
	//3.5
	public static int countDigits(int x)
	{
		int counter = 0;
		while(x > 0)
		{
			x /= 10;
			counter++;
		}
		return counter;
	}
	//3.6
	public static int position(int x, int digit)
	{
		int pos = 1;
		while(x > 0)
		{
			if(x % 10 == digit)
				return pos;
			x /= 10;
			pos++;
		}
		return -1;
	}
	//3.7
	public static long extractOddDigits(long x)
	{
		long oddDigits = 0;long counter = 1;
		while(x > 0)
		{
			if((x % 10) % 2 != 0)
			{
				oddDigits += (counter * (x % 10));
				counter *= 10;
			}
			x /= 10;
		}
		return (oddDigits != 0) ? oddDigits : -1;
	}
}
		 
