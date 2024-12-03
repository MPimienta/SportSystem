package app.models;

import app.models.lists.ListOfElements;
import app.models.lists.PlayerList;
import app.models.lists.TournamentList;
import app.models.lists.UserList;
import app.models.lists.elements.Player;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Team;
import app.models.lists.elements.Tournament;
import app.types.users.Admin;
import app.types.users.CommonUser;
import app.types.users.User;
import app.types.Error;
import app.types.users.UserType;

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
                new PlayerList(),
                new TournamentList()
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
        Error error = lists[PLAYER_LIST].removeElement(player);
        if(error.isNull()){
            lists[USER_LIST].removeElement(player);
            //Todo: Search in every team list for the player to remove
        }
        return error;
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
        return team.removePlayer(player);
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
