package edu.iastate.cs228.hw1;

/**
 * @author Connor Grim
 */
public class Empty extends TownCell{
    //Super Constructor
    public Empty (Town t, int r, int c){
        super (t, r, c);
    }

    //Sets State to EMPTY
    @Override
    public State who(){
        return State.EMPTY;
    }

    //Sets cell to Casual in next iteration
    @Override
    public TownCell next(Town tNext){
        int[] tCensus = new int[NUM_CELL_TYPE];
        census(tCensus);
        tCensus[EMPTY]--;

        if (tCensus[EMPTY] + tCensus[OUTAGE] <= 1){
            return new Reseller(tNext, row, col);
        }
        else{
            return new Casual(tNext, row, col);
        }
    }
}