package com.example.simulatorz.game.core.dittional_cores;

import com.example.simulatorz.R;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.category.GameOverEvent;
import com.example.simulatorz.game.model.util.InfoPart;

public class GameOverCore {

    public static GameOverEvent execute(GameModel gameModel) {
        if (gameModel.getPopulationModel().getCurrentPopulationSize() == 0) {
            return new GameOverEvent(new InfoPart(R.string.game_over_survivors));
        }

        if (gameModel.getIndicatorsModel().getAuthority() == 0) {
            return new GameOverEvent(new InfoPart(R.string.game_over_authority));
        }

        return null;
    }

}
