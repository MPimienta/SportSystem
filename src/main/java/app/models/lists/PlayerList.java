package app.models.lists;

import app.models.lists.elements.Element;
import app.models.lists.elements.SinglePlayer;
import app.types.Error;
import app.types.users.Admin;

public class PlayerList extends ListOfElements{
    public PlayerList(){
        super();
    }

    public String toString(){
        String result = "";
        for(Element player : this.getList()){
            result = result + player.toString() + "\n";
        }
        return result;
    }



}
