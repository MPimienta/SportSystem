package app.controllers;

import app.models.SportManagementSystem;
import app.models.lists.elements.SinglePlayer;
import app.views.console.PlayersView;

public class ShowController {
    private final SportManagementSystem sportManagementSystem;
    private final PlayersView playersView;

    public ShowController(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
        this.playersView = new PlayersView();
    }

    public void showStatisticsCsv(){
        this.playersView.showStatisticsCsv((SinglePlayer) this.sportManagementSystem.getCurrentUser());
    }

    public void showStatisticsJson(){
        this.playersView.showStatisticsJson((SinglePlayer) this.sportManagementSystem.getCurrentUser());
    }
}
