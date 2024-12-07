package app.models.elements.users;

import app.types.UserType;

public class Admin implements User{
    private final UserType userType;
    private final String userName;
    private final String password;

    public Admin(String userName, String password){
        this.userType = UserType.ADMIN;
        this.userName = userName;
        this.password = password;
    }

    public UserType getUserType(){
        return this.userType;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString(){
        return ("user_name: " + this.userName + "\npassword: " + this.password + "\nrole: admin");
    }

    public String getIdentifier() {
        return this.getUserName();
    }
}