package app.models.lists.elements;

import app.types.users.Admin;

public class Team extends Player{
    public Team(String name, Admin creator) {
        super(name, creator);
    }
}
