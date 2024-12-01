package app.models.lists.elements;

import app.types.Error;
import app.types.commands.Command;
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

    public SinglePlayer(String[] data, Admin admin){
        super(data[USER_NAME], admin);
        this.name = data[NAME];
        this.lastName = data[LAST_NAME];
        this.password = data[PASSWORD];
        this.userType = UserType.PLAYER;
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

    @Override
    public Command getCommand(String commandName) {
        return null;
    }

    @Override
    public Error getCommandError(Command command) {
        return null;
    }
}
