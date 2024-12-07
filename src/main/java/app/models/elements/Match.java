package app.models.elements;

import app.models.elements.users.Player;

public class Match implements Element{
    private final static int PLAYERS_IN_MATCH = 2;

    private final Player[] match;

    public Match(Player[] match){
        this.match = match;
    }

    public boolean containsPlayer(Player player){
        boolean contains = false;
        for (int i = 0; i < PLAYERS_IN_MATCH; i++) {
            if (this.match[i].getIdentifier().equals(player.getIdentifier())){
                contains = true;
            }
        }
        return contains;
    }

    public String toString(){
        return (this.match[0].getIdentifier() + " : " + this.match[1].getIdentifier());
    }

    public String getIdentifier() {
        return this.toString();
    }
}
