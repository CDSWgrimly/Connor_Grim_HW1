package edu.iastate.cs228.hw1;

public class Reseller extends TownCell{
    public Reseller (Town t, int r, int c){
        super(t, r, c);
    }

    @Override
    public State who(){
        return State.RESELLER;
    }

    @Override
    public TownCell next(Town tNext){
        int tCensus[] = new int[NUM_CELL_TYPE];
        census(tCensus);
        tCensus[RESELLER]--;

        //RESELLER RULES 1 & 2
        if (tCensus[CASUAL] <= 3 || tCensus[EMPTY] >= 3){
            return new Empty (tNext, row, col);
        }
        //ADDITIONAL RULE 2
        else if (tCensus[CASUAL] >= 5){
            return new Streamer (tNext, row, col);
        }
        //REMAINING RULE
        else{
            return new Reseller (tNext, row, col);
        }
    }
}