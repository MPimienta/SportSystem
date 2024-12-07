package app.models.lists;

import app.models.elements.Element;

public class PlayerList extends ListOfElements{
    public PlayerList(){
        super();
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Element player : this.getList()){
            result.append(player.toString()).append("\n");
        }
        return result.toString();
    }



}
