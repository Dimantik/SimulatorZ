package com.example.simulatorz.game.core;

import com.example.simulatorz.R;
import com.example.simulatorz.game.core.dittional_cores.GameOverCore;
import com.example.simulatorz.game.core.survivors_cores.*;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.events.category.GameOverEvent;
import com.example.simulatorz.game.model.events.category.ResultEvent;
import com.example.simulatorz.game.model.util.InfoPart;

import java.util.ArrayList;
import java.util.List;

public class Core {

    public static void nextMove(GameModel gameModel) {
        gameModel.getIndicatorsModel().nextMove();
        gameModel.getReportsModel().clearReportList();

        List<Event> survivorsMainEventList = new ArrayList<>();

        //survivors
        survivorsMainEventList.add(FarmersCore.execute(gameModel));
        survivorsMainEventList.add(ForestersCore.execute(gameModel));
        survivorsMainEventList.add(HuntersCore.execute(gameModel));
        survivorsMainEventList.add(FishersCore.execute(gameModel));
        survivorsMainEventList.add(CooksCore.execute(gameModel));
        survivorsMainEventList.add(DoctorsCore.execute(gameModel));
        survivorsMainEventList.add(FightersCore.execute(gameModel));

        //additional
        GameOverEvent gameOverEvent = GameOverCore.execute(gameModel);

        if (gameOverEvent != null) {
            gameModel.getEventsModel().setCurrentEvent(gameOverEvent);
        } else {
            gameModel.getEventsModel().setCurrentEvent(new ResultEvent(new InfoPart(R.string.example_result_event)));
        }

    }

}
