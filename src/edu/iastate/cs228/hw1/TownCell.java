package edu.iastate.cs228.hw1;

/**
 * 
 * @author Connor Grim
 *	Also provide appropriate comments for this class
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;
	
	
	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;
	
	public static final int NUM_CELL_TYPE = 5;
	
	//Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];

	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}
	
	/**
	 * Checks all neigborhood cell types in the neighborhood.
	 * Refer to homework pdf for neighbor definitions (all adjacent
	 * neighbors excluding the center cell).
	 * Use who() method to get who is present in the neighborhood
	 *  
	 * @param nCensus which is the count of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0;
		nCensus[EMPTY] = 0;
		nCensus[CASUAL] = 0;
		nCensus[OUTAGE] = 0;
		nCensus[STREAMER] = 0;

		//Gets bounds of a 3x3 neighborhood
		int upper = Math.max(0, row - 1);
		int lower = Math.min(plain.grid.length - 1, row + 1);
		int left = Math.max(0, col - 1);
		int right = Math.min(plain.grid.length - 1, col + 1);

		//Checks each cell and increments the State nCensus by 1
		for (int i = lower; i >= upper; i--){
			for (int j = right; j >= left; j--){
				if(plain.grid[i][j].who().equals(State.RESELLER)){
					nCensus[RESELLER]++;
				}
				else if (plain.grid[i][j].who().equals(State.EMPTY)){
					nCensus[EMPTY]++;
				}
				else if (plain.grid[i][j].who().equals(State.CASUAL)){
					nCensus[CASUAL]++;
				}
				else if (plain.grid[i][j].who().equals(State.OUTAGE)){
					nCensus[OUTAGE]++;
				}
				else if (plain.grid[i][j].who().equals(State.STREAMER)){
					nCensus[STREAMER]++;
				}
			}
		}

	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}
