import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;
public class battingTeamAverage {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String cont = "y"; // count for times batter hit more than 0
		int batter = 0;
		float [] battingAverage;
		float[] sluggingAverage;
	

		while (cont.equalsIgnoreCase("y")) {
			System.out.println("How many Batters are on your team?");
			batter = scan.nextInt();
			battingAverage= new float [batter];
			sluggingAverage = new float[batter];
			scan.nextLine();
			
			
			teamPercentage(scan, batter, battingAverage, sluggingAverage);
		
			for( int z = 0; z < batter;z++)	{	
				DecimalFormat df = new DecimalFormat();
		        df.setMinimumFractionDigits(3);	
			System.out.println("Batter " + (z+1) +": Batting Average " + df.format(battingAverage[z]) +"\t"+ "Slugging Percentage " + df.format(sluggingAverage[z]));
			
			}
			
			System.out.println("Another Team? y or n");
			cont = scan.nextLine();
		}
		System.out.println("Goodbye");
	
		scan.close();
	}

	public static void teamPercentage(Scanner scan, int batter, float[] battingAverage, float[] sluggingAverage) {
		float average;
		float slugging;
		int result;
		int timesAtBat;
		float[][] atBat;
		int count =0;
		int sum = 0;

		for (int k = 0; k < batter; k++) {
			System.out.println("How many times has batter " + (k + 1) + " been at bat?");
			timesAtBat = scan.nextInt();
			atBat = new float[batter][timesAtBat];
			scan.nextLine();

			System.out.println("0 = out, 1 = single, 3 = triple 4 = home run");

			for (int i = 0; i < timesAtBat; i++) {

				System.out.println("Result for at-bat " + (i + 1));
				result = scan.nextInt(); // takes in each user's input to
				scan.nextLine();
				while(result>=0 && result<=4)
				try {
                    throw new InputMismatchException();
                } catch (InputMismatchException e) {
                    System.out.println("enter number from 0 to 4");
                }
				
				sum = sum + result;
				atBat[k][i] = result;
				if (result> 0)
					count++;
				
			}
			average=count/timesAtBat;
			slugging=sum/timesAtBat;
			battingAverage[k]=average;
			sluggingAverage[k]=slugging;
			count = 0;
			sum  = 0;
		}
	}
}
