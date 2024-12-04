package app.models.lists.elements;

import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;
import app.types.managers.CommandManager;
import app.types.managers.PlayerCommandManager;
import app.types.users.Admin;
import app.types.users.User;
import app.types.users.UserType;

public class SinglePlayer extends Player implements User {
    private static final int USER_NAME = 0;
    private static final int PASSWORD = 1;
    private static final int NAME = 2;
    private static final int LAST_NAME = 3;


    private final String name;
    private final String lastName;
    private final String password;
    private final UserType userType;
    private final CommandManager commandManager;

    public SinglePlayer(String[] data, Admin admin, SportManagementSystem sportManagementSystem){
        super(data[USER_NAME], admin);
        this.name = data[NAME];
        this.lastName = data[LAST_NAME];
        this.password = data[PASSWORD];
        this.userType = UserType.PLAYER;
        this.commandManager = new PlayerCommandManager(sportManagementSystem);
    }

    public UserType getUserType() {
        return this.userType;
    }

    public String getUserName() {
        return super.getIdentifier();
    }

    public String getPassword() {
        return this.password;
    }

    public Command getCommand(String input) {
        return this.commandManager.getCommand(input);
    }

    public Error getCommandError(Command command){
        Error error;

        if(command == null){
            error = Error.INVALID_COMMAND;
        } else {
            error = Error.NULL;
        }

        return error;
    }

    public String toCsvFormat(){
        String result = this.name + "," + this.lastName + "," + this.getIdentifier() + "," + this.getScore() + "," +
                        this.getMatchesWon() + "," + this.getAssistanceScore() + "," + this.getAssistanceScore() +
                        "," + this.getMoney();

        return result;
    }

    public String toJsonFormat(){
        String result = "name: " + this.name + "\nlastname: " + this.lastName + "\nusername: " + this.getUserName() +
                        "\nscore: " + this.getScore() + "\nmatches_won: " + this.getMatchesWon() +
                        "\nassistance_score" + this.getAssistanceScore() + "\ntournaments_won: "
                        + this.getTournamentsWon() + "\nmoney: " + this.getMoney();

        return result;
    }
}
