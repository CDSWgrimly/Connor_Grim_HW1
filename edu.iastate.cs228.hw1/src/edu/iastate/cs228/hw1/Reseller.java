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
    public Town nextTown (Town tNext){
        int tCensus = new int[NUM_CELL_TYPE];
        census(tCensus);
        tCensus[RESELLER]--;

        if (tCensus[CASUAL] <= 3 || tCensus[EMPTY] >= 3){
            return new Empty (tNext, row, col);
        }
        else if (tCensus[CASUAL] >= 5){
            return new Streamer (tNext, row, col);
        }
        else{
            return new Casual (tNext, row, col);
        }
    }
}