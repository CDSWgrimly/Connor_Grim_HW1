package edu.iastate.cs228.hw1;
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
    public Town nextTown (Town tNext){
        int tCensus[] = new int[NUM_CELL_TYPE];
        census(tCensus);
        tCensus[EMPTY]--;

        //EMPTY RULE
        return new Casual(tNext, row, col);
    }
}