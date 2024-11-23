package app.models.lists;

import app.models.lists.elements.Element;
import app.models.lists.elements.SinglePlayer;
import app.types.Error;
import app.types.users.Admin;
import app.types.users.User;
import app.types.users.UserType;

public class UserList extends ListOfElements{

    public Error addAdmin(String[] arguments) {
        final int IDENTIFIER = 0;
        Error error = Error.NULL;

        int index = this.getIndexOfElement(arguments[IDENTIFIER]);

        if(!this.elementExists(index)){
            Element element = this.createAdmin(arguments);
            this.getList().add(element);
        } else {
            error = Error.USER_ALREADY_EXISTS;
        }

        return error;
    }


    private Element createAdmin(String[] arguments){
        final int USER_NAME = 0;
        final int PASSWORD = 1;

        return new Admin(arguments[USER_NAME], arguments[PASSWORD]);
    }


}
