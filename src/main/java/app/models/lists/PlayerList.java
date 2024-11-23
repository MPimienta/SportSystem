package app.models.lists;

import app.models.lists.elements.Element;
import app.models.lists.elements.SinglePlayer;
import app.types.Error;

public class PlayerList extends ListOfElements{
    @Override
    public Error addElement(String[] arguments) {
        final int USER_NAME = 2;
        Error error = Error.NULL;

        int index = this.getIndexOfElement(arguments[USER_NAME]);

        if(!this.elementExists(index)){
            Element element = this.createElement(arguments);
            this.getList().add(element);
        } else {
            error = Error.PLAYER_ALREADY_EXISTS;
        }

        return error;
    }

    private Element createElement(String[] arguments){
        final int NAME = 0;
        final int LAST_NAME = 1;
        final int USER_NAME = 2;
        final int PASSWORD = 3;

        return new SinglePlayer(arguments[NAME], arguments[LAST_NAME], arguments[USER_NAME], arguments[PASSWORD]);
    }
}
