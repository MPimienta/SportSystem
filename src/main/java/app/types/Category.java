package app.types;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private final Map<String, Integer> categories;

    public Category(){
        this.categories = new HashMap<>();

        this.categories.put("score",0);
        this.categories.put("matches_won",1);
        this.categories.put("assistance_score",2);
        this.categories.put("tournaments_won",3);
        this.categories.put("money",4);
    }

    public int getCategorie(String categorie){
        return this.categories.get(categorie);
    }
}
