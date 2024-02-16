package edu.iastate.cs228.hw1;

public class Streamer extends TownCell{
    public Streamer (Town t, int r, int c){
        super(t, r, c);
    }

    @Override
    public State who(){
        return State.STREAMER;
    }

    @Override
    public Town nextTown(Town tNext){
        int tCensus = new int[NUM_CELL_TYPE];
        census(tCensus);
        tCensus[STREAMER]--;

        //ADDITIONAL RULE 1
        if (tCensus[EMPTY] + tCensus[OUTAGE] <= 1){
            return new Reseller(tNext, row, col);
        }
        //STREAMER RULE 1
        else if (tCensus[RESELLER] > 0){
            return new Outage(tNext, row, col);
        }
        //STREAMER RULE 1
        else if (tCensus[OUTAGE] > 0){
            return new Empty(tNext, row, col);
        }
        //REMAINING RULE
        else{
            return new Streamer(tNext, row, col);
        }
    }
}