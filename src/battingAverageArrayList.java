import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class battingAverageArrayList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float sum = 0; // used to calculate the sum of the results in the array
		float count = 0;
		float average = 0; // variable used to calculate batting average
		float slugging = 0; // variable used to calculate slugging percentage
		int result = 0; // used to take result at each bat also used to push
		String cont = "y"; // count for times batter hit more than 0

		while (cont.equalsIgnoreCase("y")) {
			System.out.println("What is the name of the player?");
			String input = scan.nextLine();
			System.out.println("How many times has " + input + " been at bat?");

	
			ArrayList<Integer> atBat = new ArrayList<Integer>(); // this is now the number of
			int bat = scan.nextInt();
			scan.nextLine();							// elements in the array
			System.out.println("0 = out, 1 = single, 3 = triple 4 = home run");

			for (int i = 0; i < bat; i++) { // For loop takes the atBat input and assigns a postion in the Array
														
				System.out.println("Result for at-bat " + (i + 1));
				result = scan.nextInt(); // takes in each user's input to assign
				scan.nextLine();// to the array	
		
				if (result<=4&&result>=0)	{
				atBat.add(result);
				}else{
					System.out.println("Invalid input");
				i--;
				}
				if (result > 0&&result<=4)
					count++;// count needed to only count if the batter hits
							// anything used in batting average
				
				}

			for (int a : atBat) // adds together the amount of points earned atBat				
				sum += a;

			average = count / bat; // batting average = total number of
											// at bats where more than zero was
											// earned / total number at bats
			slugging = sum /bat;

			System.out.println(input + " was at-bat " + bat
					+ " times. Of those times a score greater than zero was obtained " + count + " times. " + input
					+ "'s batting average is " + average + " and the slugging percentage is " + slugging + "\n");
			
			System.out.println("Another Batter? y or n");
			cont = scan.nextLine();
		}
		System.out.println("Goodbye");
		
	scan.close();
	}
}
