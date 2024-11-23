package app.models.lists.elements;

import app.types.users.User;

public class SinglePlayer extends Player implements User {
    private final String name;
    private final String lastName;
    private final String password;

    public SinglePlayer(String name, String lastName, String userName, String password){
        super(userName);
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

}
