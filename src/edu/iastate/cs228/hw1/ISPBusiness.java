package edu.iastate.cs228.hw1;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Connor Grim
 * The ISPBusiness class performs simulation over a grid 
 * plain with cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {
	
	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		Town tNew = new Town(tOld.getLength(), tOld.getWidth());
		for (int i = 0; i <= tOld.getLength() - 1; i++){
			for (int j = 0; j <= tOld.getWidth() - 1; j++){
				tNew.grid[i][j] = tOld.grid[i][j].next(tNew);
			}
		}
		return tNew;
	}
	
	/**
	 * Returns the profit for the current state in the town grid.
	 * @param town
	 * @return Number of casual users in the town
	 */
	public static int getProfit(Town town) {
		//Profit = Number of Casual Users
		int numCasuals = 0;
		for (int i = 0; i <= town.getLength() - 1; i++){
			for (int j = 0; j <= town.getWidth() - 1; j++){
				if (town.grid[i][j].who().equals(State.CASUAL)){
					numCasuals++;
				}
			}
		}
		return numCasuals;
	}
	

	/**
	 *  Main method. Interact with the user and ask if user wants to specify elements of grid
	 *  via an input file (option: 1) or wants to generate it randomly (option: 2).
	 *  
	 *  Depending on the user choice, create the Town object using respective constructor and
	 *  if user choice is to populate it randomly, then populate the grid here.
	 *  
	 *  Finally: For 12 billing cycle calculate the profit and update town object (for each cycle).
	 *  Print the final profit in terms of %. You should print the profit percentage
	 *  with two digits after the decimal point:  Example if profit is 35.5600004, your output
	 *  should be:
	 *
	 *	35.56%
	 *  
	 * Note that this method does not throw any exception, so you need to handle all the exceptions
	 * in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String []args) {
		Scanner scnr = new Scanner(System.in);
		Town t;
		int option;
		double profitPercentage;

		System.out.println("Please enter number for option to populate grid: \n1.) From input file \n2.) Random with input seed");
		option = scnr.nextInt();
		switch(option){
			case 1:
				//Option 1: Scan for input file and create Town t from file
				String fileName;
				System.out.println("Enter file name: ");
				fileName = scnr.nextLine();
				try {
					t = new Town(fileName);
				}
				catch (FileNotFoundException e){
					System.out.println("Input file not found.");
					scnr.close();
					return;
				}
				break;
			case 2:
				//Option 2: Manually enter length, width and generation seed and randomly assign values to grid
				int len = 0;
				int wid = 0;
				int seed = 0;
				System.out.println("Enter grid length: ");
				len = scnr.nextInt();
				System.out.println("Enter grid width: ");
				wid = scnr.nextInt();
				System.out.println("Enter seed: ");
				seed = scnr.nextInt();
				t = new Town(len, wid);
				t.randomInit(seed);
				break;
			default:
				System.out.println("Invalid option.");
				return;
		}

		//Iterates 12 times; calculates profit and updates for next iteration
		int profit = 0;
		for (int i = 1; i <= 12; i++) {
			System.out.println("Iteration: " + i);
			System.out.println(t);

			profit = getProfit(t);
			System.out.println("Profit: " + profit);
			t = updatePlain(t);
		}
		//Displays Final Profit and calculated Profit %
		System.out.println("Final Profit: " + profit);
		profitPercentage = ((profit * 100) / (double) (t.getLength() * t.getWidth()));
		System.out.println("Profit %: ");
		System.out.printf("%.2f", profitPercentage);
	}
}
