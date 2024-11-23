package app.models.lists.elements;

import app.types.users.Admin;
import app.types.users.User;
import app.types.users.UserType;

public class SinglePlayer extends Player implements User {
    private final String name;
    private final String lastName;
    private final String password;
    private final UserType userType;

    public SinglePlayer(String userName, String password, String name, String lastName, Admin admin){
        super(userName, admin);
        this.name = name;
        this.lastName = lastName;
        this.password = password;
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
}
