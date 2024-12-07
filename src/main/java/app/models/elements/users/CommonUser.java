package app.models.elements.users;

import app.types.UserType;

public class CommonUser implements User{
    private final UserType userType;

    public CommonUser(){
        this.userType = UserType.COMMON;
    }

    public UserType getUserType(){
        return this.userType;
    }

    public String getUserName() {
        return "guest";
    }

    public String getPassword() {
        return "null";
    }

    public String getIdentifier() {
        return "";
    }
}
