package edu.iastate.cs228.hw1;

public class Outage extends TownCell{
    public Outage (Town t, int r, int c){
        super(t, r, c);
    }

    @Override
    public State who(){
        return State.OUTAGE;
    }

    @Override
    public Town nextTown(Town tNext){
        int tCensus = new int[NUM_CELL_TYPE];
        census(tCensus);
        tCensus[OUTAGE]--;

        //OUTAGE RULE
        return new Empty(tNext, row, col);
    }
}