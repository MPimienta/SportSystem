package app.models;

import app.models.lists.ListOfElements;
import app.models.lists.PlayerList;
import app.models.lists.TournamentList;
import app.models.lists.UserList;
import app.types.users.CommonUser;
import app.types.users.User;
import app.types.Error;

public class CLI {
    private static int PLAYER_LIST = 0;
    private static int USER_LIST = 1;
    private static int TEAM_LIST = 2;
    private static int TOURNAMENT_LIST = 3;

    private ListOfElements[] lists;
    private User currentUser;

    public CLI(){
        this.lists = new ListOfElements[]{
                new PlayerList(),
                new UserList(),
                new PlayerList(),
                new TournamentList()
        };
        this.currentUser = new CommonUser();
    }

    public Error playerCreate(String[] arguments){
        return lists[PLAYER_LIST].addElement(arguments);
    }

    public void updateUser(User newUser){

    }
}
