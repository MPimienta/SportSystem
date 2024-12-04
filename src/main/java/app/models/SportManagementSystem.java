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
    private final Creator creator;
    private final Deleter deleter;

    public SportManagementSystem(){
        this.lists = new ListOfElements[]{
                new PlayerList(),
                new UserList(),
                new TeamList(),
                new TournamentsList()
        };
        this.creator = new Creator(this.lists);
        this.deleter = new Deleter(this.lists);

        this.currentUser = new CommonUser(this);
        this.createUser(new Admin("sudo", "sudopassword",this));
    }
    public Error createUser(User user){
        return this.creator.createUser(user);
    }

    public Error createPlayer(SinglePlayer player){
        return this.creator.createPlayer(player);
    }

    public Error createTeam(Team team){
        return this.creator.createTeam(team);
    }

    public Error createTournament(Tournament tournament){
        return this.creator.createTournament(tournament);
    }

    public Error deletePlayer(String player){
        return this.deleter.deletePlayer(player);
    }

    public Error deleteTeam(String team){
        return this.deleter.deleteTeam(team);
    }

    public Error deleteTournament(String tournament){
        return this.deleter.deleteTournament(tournament);
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

    public Tournament getTournamentByIdentifier(String tournament){
        return (Tournament) this.lists[TOURNAMENT_LIST].getElementByIdentifier(tournament);
    }

    public Error teamAdd(Team team, SinglePlayer player){
        return this.creator.teamAdd(team, player);
    }

    public Error teamRemove(Team team, String player){
        return this.deleter.teamRemove(team, player);
    }

    public Error manualMatchmake(Tournament tournament, Player[] players){
        return tournament.manualMatchmake(players);
    }

    public Error randomMatchmake(Tournament tournament){
        return tournament.randomMatchmake();
    }

    public Error tournamentAddPlayer(Player player, Tournament tournament){
        return this.creator.tournamentAddPlayer(player, tournament);
    }

    public Error tournamentRemovePlayer(Player player, Tournament tournament){
        return this.deleter.tournamentRemovePlayer(player, tournament);
    }
}
