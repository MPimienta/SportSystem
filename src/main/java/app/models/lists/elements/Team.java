package app.models.lists.elements;

import app.models.lists.PlayerList;
import app.types.users.Admin;

import app.types.Error;

public class Team extends Player{
    private final PlayerList players;

    public Team(String teamName, SinglePlayer player, Admin admin){
        super(teamName, admin);
        players = new PlayerList();
        this.addPlayer(player);
    }

    public Error addPlayer(SinglePlayer player){
        return this.players.addElement(player);
    }

    public Error removePlayer(String player){
        return this.players.removeElement(player);
    }

    public int getSize(){
        return this.players.getSize();
    }

    public boolean hasPlayer(String player){
        if(this.players.getElementByIdentifier(player) != null){
            return true;
        } else {
            return false;
        }
    }
}
