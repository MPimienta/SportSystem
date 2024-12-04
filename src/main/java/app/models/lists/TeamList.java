package app.models.lists;

import app.models.lists.elements.Element;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Team;

import java.util.Iterator;
import java.util.LinkedList;

public class TeamList extends ListOfElements{
    public TeamList(){
        super();
    }

    public void deletePlayer(String player){
        Iterator<Element> iterator = this.getList().iterator();
        while(iterator.hasNext()){
            Team team = (Team) iterator.next();
            team.removePlayer(player);
        }
    }

    public LinkedList<Team> getPlayerTeams(String player){
        LinkedList<Team> teams = new LinkedList<>();
        Iterator<Element> iterator = this.getList().iterator();
        while(iterator.hasNext()){
            Team team = (Team) iterator.next();
            if(team.hasPlayer(player)){
                teams.add(team);
            }
        }
        return teams;
    }
}