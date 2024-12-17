package app.models.lists;

import app.models.elements.Element;
import app.models.elements.Tournament;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class TournamentsList extends ListOfElements implements Serializable {
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

    public String toString(){
        String result = "";
        for(Element tournament : this.getList()){
            result = result + tournament.toString() + "\n";
        }

        return result;
    }

    public void deletePastTournaments(){
        Iterator<Element> iterator = this.getList().iterator();
        while(iterator.hasNext()){
            Tournament tournament = (Tournament) iterator.next();
            if(tournament.hasEnded()){
                this.removeElement(tournament.getIdentifier());
            }
        }
    }

    public String rankedToString(){
        String result = "";
        for(Element element : this.getList()){
            Tournament tournament = (Tournament) element;
            result = result + tournament.rankedToString() + "\n";
        }
        return result;
    }
}
