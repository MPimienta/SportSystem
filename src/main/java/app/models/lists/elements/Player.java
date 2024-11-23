package app.models.lists.elements;

import app.types.users.Admin;

public abstract class Player implements Element{
    private final String identifier;
    private final Admin creator;
    private final double[] statistics;

    public Player(String identifier, Admin creator){
        this.identifier = identifier;
        this.creator = creator;
        this.statistics = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
    }

    public String getIdentifier(){
        return this.identifier;
    }

    public Admin getCreator(){
        return this.creator;
    }

}
