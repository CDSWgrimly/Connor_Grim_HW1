package edu.iastate.cs228.hw1;

/**
 * @author Connor Grim
 */
public class Casual extends TownCell{
    public Casual(Town p, int r, int c){
        super(p, r, c);
    }


    @Override
    public State who(){
        return State.CASUAL;
    }

    //Sets cell in next Town iteration based on rules in description
    @Override
    public TownCell next(Town tNext){
        int[] tCensus = new int[NUM_CELL_TYPE];
        census(tCensus);
        tCensus[CASUAL]--;

        //ADDITIONAL RULE 1
        if (tCensus[OUTAGE] + tCensus[EMPTY] <= 1){
            return new Reseller(tNext, row, col);
        }
        //CASUAL RULE 1
        else if (tCensus[RESELLER] > 0){
            return new Reseller(tNext, row, col);
        }
        //CASUAL RULE 2
        else if (tCensus[STREAMER] > 0){
            return new Streamer(tNext, row, col);
        }
        //ADDITIONAL RULE 2
        else if (tCensus[CASUAL] >= 5){
            return new Streamer(tNext, row, col);
        }
        else{
            return new Casual(tNext, row, col);
        }
    }
}