public class Casual extends TownCell{
    public Casual(Town p, int r, int c){
        super(p, r, c);
    }


    public State who(){
        return State.CASUAL;
    }
}