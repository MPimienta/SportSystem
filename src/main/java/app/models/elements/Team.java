package app.models.elements;

import app.models.elements.users.Player;
import app.models.elements.users.SinglePlayer;
import app.models.lists.PlayerList;
import app.models.elements.users.Admin;

import app.types.Error;

import java.io.Serial;
import java.io.Serializable;

public class Team extends Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final static int MINIMUM_PLAYERS = 2;

    private final PlayerList players;

    public Team(String teamName, SinglePlayer[] newPlayers, Admin admin){
        super(teamName, admin);
        players = new PlayerList();
        for (int i = 0; i < MINIMUM_PLAYERS; i++) {
            this.addPlayer(newPlayers[i]);
        }

    }

    public Error addPlayer(SinglePlayer player){
        Error error = this.players.addElement(player);
        if(error.isNull()){
            this.updateStatistics();
        }
        return error;
    }

    private void updateStatistics(){
        double[] statistics = this.getStatistics();
        for (int i = 0; i < statistics.length; i++) {
            double sum = 0;
            for (int j = 0; j < players.getSize(); j++) {
                SinglePlayer player = (SinglePlayer) players.getElement(j);
                double[] playerStatistics = player.getStatistics();
                sum += playerStatistics[i];
            }
            statistics[i] = sum / players.getSize();
        }
    }

    public Error removePlayer(String player){
        Error error = this.players.removeElement(player);
        if(error.isNull()){
            this.updateStatistics();
        }
        return error;
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
