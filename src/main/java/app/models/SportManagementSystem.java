package app.models;

import app.models.lists.*;
import app.models.lists.elements.*;
import app.types.commands.common.TournamentList;
import app.types.users.Admin;
import app.types.users.CommonUser;
import app.types.users.User;
import app.types.Error;
import app.types.users.UserType;

import java.util.Iterator;
import java.util.LinkedList;

public class SportManagementSystem {
    private static int IDENTIFIER = 0;

    private static int PLAYER_LIST = 0;
    private static int USER_LIST = 1;
    private static int TEAM_LIST = 2;
    private static int TOURNAMENT_LIST = 3;

    private ListOfElements[] lists;
    private User currentUser;

    public SportManagementSystem(){
        this.lists = new ListOfElements[]{
                new PlayerList(),
                new UserList(),
                new TeamList(),
                new TournamentsList()
        };
        this.currentUser = new CommonUser(this);
        this.createUser(new Admin("sudo", "sudopassword",this));
    }
    public Error createUser(User user){
        return lists[USER_LIST].addElement(user);
    }

    public Error createPlayer(SinglePlayer player){
        return this.lists[PLAYER_LIST].addElement(player);
    }

    public Error createTeam(Team team){
        return this.lists[TEAM_LIST].addElement(team);
    }

    public Error createTournament(Tournament tournament){
        return lists[TOURNAMENT_LIST].addElement(tournament);
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
        return lists[TEAM_LIST].removeElement(team);
        //Todo: Search in every tournament list for the team to remove
    }

    public Error deleteTournament(String tournament){
        return lists[TOURNAMENT_LIST].removeElement(tournament);
    }

    public Error updateUser(String[] arguments){
        Error error = Error.NULL;
        int index = this.lists[USER_LIST].getIndexOfElement(arguments[IDENTIFIER]);
        if(this.lists[USER_LIST].elementExists(index)){
            this.currentUser = (User) this.lists[USER_LIST].getElement(index);
        } else {
            error = Error.USER_DOES_NOT_EXIST;
        }
        return error;

    }

    public void logout(){
        this.currentUser = new CommonUser(this);
    }

    public UserType getCurrentUserType(){
        return this.currentUser.getUserType();
    }

    public User getCurrentUser(){
        return this.currentUser;
    }

    public SinglePlayer getPlayerByIdentifier(String name){
        return (SinglePlayer) this.lists[PLAYER_LIST].getElementByIdentifier(name);
    }

    public Team getTeamByIdentifier(String name){
        return (Team) this.lists[TEAM_LIST].getElementByIdentifier(name);
    }

    public Error teamAdd(Team team, SinglePlayer player){
        return team.addPlayer(player);
    }

    public Error teamRemove(Team team, String player){
        Error error = team.removePlayer(player);
        if(team.getSize() < 2){
            this.lists[TEAM_LIST].removeElement(team.getIdentifier());
        }
        return error;

    }

    public Tournament getTournamentByIdentifier(String tournament){
        return (Tournament) this.lists[TOURNAMENT_LIST].getElementByIdentifier(tournament);
    }

    public Error manualMatchmake(Tournament tournament, Player[] players){
        return tournament.manualMatchmake(players);
    }

    public Error randomMatchmake(Tournament tournament){
        return tournament.randomMatchmake();
    }

}
