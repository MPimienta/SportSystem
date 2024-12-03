package app.models.lists;

import app.models.lists.elements.Element;
import app.models.lists.elements.Team;
import app.models.lists.elements.Tournament;
import app.types.Error;
import app.types.users.Admin;

import java.util.Iterator;
import java.util.LinkedList;

public class TournamentsList extends ListOfElements{
    public TournamentsList(){
        super();
    }

    public LinkedList<Tournament> getPlayerTournaments(String identifier){
        LinkedList<Tournament> tournaments = new LinkedList<>();
        Iterator<Element> iterator = this.getList().iterator();
        while(iterator.hasNext()){
            Tournament tournament = (Tournament) iterator.next();
            if(tournament.hasPlayer(identifier)){
                tournaments.add(tournament);
            }
        }
        return tournaments;
    }

    public void deletePlayer(String identifier){
        Iterator<Element> iterator = this.getList().iterator();
        while(iterator.hasNext()){
            Tournament tournament = (Tournament) iterator.next();
            tournament.removePlayer(identifier);
        }
    }
}
