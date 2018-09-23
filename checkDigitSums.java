package lab1Pt1;

//This imports the scanner class from the util folder. It allows for user input. 
import java.util.Scanner;

//The class was named with a description of what the task is
public class checkDigitSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

	private static void input() {
		// This creates an object of the scanner class. I tried putting "sc.close();" near the end of the input method but this caused errors when using recursion. 
		Scanner sc = new Scanner(System.in);
		// This prompts the user to input a number in a range with no decimals or fractions.
		printer("Enter a whole number and stay positive(more than 0 and less than two billion).");
		
		// I can use an int because the user is told to input something 
		int firstNum = sc.nextInt();
		
		// Check if number is positive. If it's not, then print error message and start input over again.
		if (validate(firstNum) == false) {
			printer("OOPS. It looks like you didn't input a positive number. Try again.");
			input();
		}
		// If number is positive, user prompt for second number
		else {
			printer("Good. Now input another whole number with the same amount of digits as your first number.");
		}
		
		int secondNum = sc.nextInt();
		
		if (validate(secondNum) == false) {
			printer("OOPS. It looks like you didn't input a positive number. Try again from the beginning.");
			input();
		}
		
		// Check if the two numbers have equal amount of digits
		if (isEqualLengths(firstNum, secondNum) == false ) {
			printer("OOPS. The numbers are not the same length. Try again from the beginning.");
			input();
		}
	
		printer("Great. Your two numbers are " + firstNum + " and " + secondNum + ". Now let's compare the different numbers and their corresponding digit sums. Is it true that the sums are all equal to each other?");
		
		// Make sure the numbers have at least two digits, AKA they equal 10 or more.
		if (secondNum <= 9) {
			printer("OOPS. Can't compare the digits sums because there is only one digit. Try again.");
			input();
		}
		
		
		// Calls the compare method
		if (compare(firstNum, secondNum) == false) {
			printer("No.");
		}
		else {
			printer("Yes. It's true");
		}
		
	}

	// Takes firstNum and secondNum as inputs and compares their digits' sums
	private static boolean compare(int first, int second) {
		/* The first two declared variables here will get the last number in the "Ones" place. For example, if the number is 11118 and 11119 then we'll get 8 and 9.
		 * Those two are added up and stored in the variable "total". Then we need to see if every digit sum is equal to total. 
		 */
		
		int firstNumberOnes = first % 10;
		int secondNumberOnes = second % 10;
		
		int total = firstNumberOnes + secondNumberOnes;
		
		//The while loop works because by dividing by 10 you can methodically work through digits. You stop as soon as you get an unequal sum.
		while (first > 10) {
			first/=10;
			second/=10;
			
			if ((first%10)+(second%10) != total) {
			return false;
			}
		}
		// If the number makes it this far it means all the corresponding digit sums added up to each other so it returns true
		return true;
	}

	// This is a way to see if the numbers have the same amount of digits.
	private static boolean isEqualLengths(int fir, int sec) {
		String firStr = Integer.toString(fir);
		String secStr = Integer.toString(sec);
		if (firStr.length() == secStr.length()) {
			return true;
		}
		return false;
	}

	// Checks if the number is positive and small enough for an int variable
	public static boolean validate(int i) {
		if (i <= 0 || i > 2000000000) {
			return false;
		}
		return true;
	}

	private static void printer(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
	}

}
