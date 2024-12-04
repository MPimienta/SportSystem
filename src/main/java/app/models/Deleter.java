package app.models;

import app.models.lists.ListOfElements;
import app.models.lists.TeamList;
import app.models.lists.TournamentsList;
import app.models.lists.elements.Team;
import app.models.lists.elements.Tournament;
import app.types.Error;

import java.util.Iterator;
import java.util.LinkedList;

public class Deleter {
    private static final int IDENTIFIER = 0;

    private static final int PLAYER_LIST = 0;
    private static final int USER_LIST = 1;
    private static final int TEAM_LIST = 2;
    private static final int TOURNAMENT_LIST = 3;

    private final ListOfElements[] lists;

    public Deleter(ListOfElements[] lists){
        this.lists = lists;
    }

    public Error deletePlayer(String player){
        Error error;
        if(!this.isInOngoingTournament(player)){
            this.deletePlayerInTeams(player);
            this.deletePlayerInTournaments(player);
            error = lists[PLAYER_LIST].removeElement(player);
            if(error.isNull()){
                lists[USER_LIST].removeElement(player);
            }
        } else {
            error = Error.PLAYER_IN_ONGOING_TOURNAMENT;
        }

        return error;
    }

    private boolean isInOngoingTournament(String identifier){
        LinkedList<Tournament> tournaments = this.getPlayerTournaments(identifier);
        Iterator<Tournament> iterator = tournaments.iterator();
        boolean isInOngoing = false;
        while(iterator.hasNext() && !isInOngoing){
            Tournament tournament = iterator.next();
            if(tournament.isOngoing()){
                isInOngoing = true;
            }
        }
        return isInOngoing;
    }

    private LinkedList<Tournament> getPlayerTournaments(String identifier){
        TournamentsList tournamentsList = (TournamentsList) this.lists[TOURNAMENT_LIST];
        return tournamentsList.getPlayerTournaments(identifier);
    }

    private LinkedList<Team> getPlayerTeams(String player){
        TeamList teamList = (TeamList) this.lists[TEAM_LIST];
        return teamList.getPlayerTeams(player);
    }

    private void deletePlayerInTeams(String identifier){
        LinkedList<Team> teams = this.getPlayerTeams(identifier);
        Iterator<Team> iterator = teams.iterator();

        while(iterator.hasNext()){
            Team team = iterator.next();
            if(this.isInOngoingTournament(team.getIdentifier())){
                team.removePlayer(identifier);
            }
        }
    }

    private void deletePlayerInTournaments(String identifier){
        TournamentsList tournamentList = (TournamentsList) this.lists[TOURNAMENT_LIST];
        tournamentList.deletePlayer(identifier);
    }

    public Error deleteTeam(String team){
        if(!this.isInOngoingTournament(team)){
            this.deletePlayerInTournaments(team);
            return lists[TEAM_LIST].removeElement(team);
        } else {
            return Error.PLAYER_IN_ONGOING_TOURNAMENT;
        }
    }

    public Error deleteTournament(String tournament){
        return lists[TOURNAMENT_LIST].removeElement(tournament);
    }

}