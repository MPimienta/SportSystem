package app.controllers;

import app.models.CLI;
import app.models.lists.elements.Element;
import app.models.lists.elements.SinglePlayer;
import app.types.Error;
import app.types.users.Admin;
import app.types.users.CommonUser;
import app.types.users.User;
import app.types.users.UserType;

public class ExecuteController extends Controller{

    public ExecuteController(CLI cli){
        super(cli);
    }

    public Error playerCreate(String[] arguments){
        Error error;
        if(this.getCurrentUserType() == UserType.ADMIN){
            Admin admin = (Admin) this.cli.getCurrentUser();
            SinglePlayer player = this.makePlayer(arguments,admin);
            error = this.cli.playerCreate(player);
        } else {
            error = Error.NOT_ADMIN;
        }

        return error;
    }

    private SinglePlayer makePlayer(String[] arguments, Admin admin){
        final int USER_NAME = 0;
        final int PASSWORD = 1;
        final int NAME = 2;
        final int LAST_NAME = 3;

        return new SinglePlayer(arguments[USER_NAME], arguments[PASSWORD], arguments[NAME], arguments[LAST_NAME], admin);
    }

    private UserType getCurrentUserType(){
        return cli.getCurrentUserType();
    }

    public Error login(String[] arguments){

        Error error = Error.NULL;
        if(this.getCurrentUserType() != UserType.COMMON){
            error = Error.USER_LOGGED_IN;
        } else {
            error = this.cli.updateUser(arguments);
        }

        return error;
    }

    public Error logout(String[] arguments){
        Error error = Error.NULL;
        if(this.getCurrentUserType() == UserType.COMMON){
            error = Error.ALREADY_LOGGED_OUT;
        } else {
            this.cli.logout();
        }

        return error;
    }


}
