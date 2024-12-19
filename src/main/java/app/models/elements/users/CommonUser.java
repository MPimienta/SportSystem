package app.models.elements.users;

import app.types.UserType;

import java.io.Serial;
import java.io.Serializable;

public class CommonUser implements User, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
