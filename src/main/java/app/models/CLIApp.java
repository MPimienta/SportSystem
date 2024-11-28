package app.models;

import app.models.lists.ListOfElements;
import app.models.lists.PlayerList;
import app.models.lists.TournamentList;
import app.models.lists.UserList;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Team;
import app.models.lists.elements.Tournament;
import app.types.users.Admin;
import app.types.users.CommonUser;
import app.types.users.User;
import app.types.Error;
import app.types.users.UserType;

public class CLIApp {
    private static int IDENTIFIER = 0;

    private static int PLAYER_LIST = 0;
    private static int USER_LIST = 1;
    private static int TEAM_LIST = 2;
    private static int TOURNAMENT_LIST = 3;

    private ListOfElements[] lists;
    private User currentUser;

    public CLIApp(){
        this.lists = new ListOfElements[]{
                new PlayerList(),
                new UserList(),
                new PlayerList(),
                new TournamentList()
        };
        this.currentUser = new CommonUser(this);

        this.AdminCreate(new Admin("sudo", "sudopassword",this));
    }
    public Error AdminCreate(Admin admin){
        return lists[USER_LIST].addElement(admin);
    }

    public Error createPlayer(SinglePlayer player){
        Error error = lists[PLAYER_LIST].addElement(player);
        if(error.isNull()){
            lists[USER_LIST].addElement(player);
        }
        return error;
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
    }

    public Error createTeam(Team team, String playerName){
        Error error = Error.NULL;

        SinglePlayer player = (SinglePlayer) this.lists[PLAYER_LIST].getElementByIdentifier(playerName);
        if(player == null){
            error = Error.PLAYER_DOES_NOT_EXIST;
        } else {
            error = team.addPlayer(player);
            if(error.isNull()){
                error = this.lists[TEAM_LIST].addElement(player);
            } else {
                error = this.lists[TEAM_LIST].addElement(team);
            }
        }

        return error;
    }

    public Error createTournament(Tournament tournament){
        return lists[TOURNAMENT_LIST].addElement(tournament);
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


}
