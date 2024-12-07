package app.models.lists;

import app.models.elements.Element;

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
