package app.types.users;

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

    @Override
    public String getPassword() {
        return "null";
    }

    @Override
    public String getIdentifier() {
        return "";
    }
}
