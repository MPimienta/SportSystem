package app.models.lists.elements;

public abstract class Player implements Element{
    private final String identifier;
    private final double[] statistics;

    public Player(String identifier){
        this.identifier = identifier;
        this.statistics = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
    }

    public String getIdentifier(){
        return this.identifier;
    }

}
