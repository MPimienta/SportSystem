package app.models.lists;

import app.models.lists.elements.Match;
import app.models.lists.elements.Player;
import app.types.Error;
import app.types.users.Admin;
import java.util.Random;

import java.util.ArrayList;

public class MatchList extends ListOfElements{
    private final static int PLAYERS_IN_MATCH = 2;

    public MatchList(){
        super();
    }

    public void clearMatches(){
        this.getList().clear();
    }

    public void randomMatchmake(PlayerList playerList){

        Random random = new Random();
        ArrayList<Integer> indexList = this.makeAuxIndexList(playerList.getSize());

        for (int i = 0; i < playerList.getSize()/2; i++) {
            Player[] players = new Player[PLAYERS_IN_MATCH];
            for (int j = 0; j < PLAYERS_IN_MATCH; j++) {
                int randomIndex = random.nextInt(indexList.size());
                players[j] = (Player) playerList.getElement(indexList.get(randomIndex));
                indexList.remove(randomIndex);
            }
            this.addElement(new Match(players));
        }
    }

    private ArrayList<Integer> makeAuxIndexList(int size){
        ArrayList<Integer> indexList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            indexList.set(i, i);
        }
        return indexList;
    }

    public Error manualMatchmake(Player[] players){

    }



}
