package com.example.simulatorz.game.core.survivors_cores;

import com.example.simulatorz.R;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.reports.Report;
import com.example.simulatorz.game.model.util.InfoPart;
import com.example.simulatorz.game.model.util.Random;

import static com.example.simulatorz.game.settings.SurvivorsSettings.CooksSettings.*;

public class CooksCore {

    public static Event execute(GameModel gameModel) {
        double requiredFood;

        if (gameModel.getPopulationModel().getCooks().getQuantity() == 0) {
            requiredFood = Random.getRandomNumber(
                    gameModel.getPopulationModel().getCurrentPopulationSize() * MIN_REQUIRED_FOOD_BY_ONE_SURVIVOR_PER_MOVE,
                    gameModel.getPopulationModel().getCurrentPopulationSize() * MAX_REQUIRED_FOOD_BY_ONE_SURVIVOR_PER_MOVE
            );
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.cooks_waste_food_for_nutrition, requiredFood)));
            gameModel.getIndicatorsModel().reduceFood(requiredFood);

            return null;
        }

        int survivorsWithCooks = gameModel.getPopulationModel().getCooks().getQuantity() * POWER;
        if (survivorsWithCooks > gameModel.getPopulationModel().getCurrentPopulationSize()) {
            survivorsWithCooks = gameModel.getPopulationModel().getCurrentPopulationSize();
        }
        int survivorsWithoutCooks = gameModel.getPopulationModel().getCurrentPopulationSize() - survivorsWithCooks;

        requiredFood = Random.getRandomNumber(
                survivorsWithoutCooks * MIN_REQUIRED_FOOD_BY_ONE_SURVIVOR_PER_MOVE,
                survivorsWithoutCooks * MAX_REQUIRED_FOOD_BY_ONE_SURVIVOR_PER_MOVE
        );

        requiredFood += REDUCE_MULTIPLIER * Random.getRandomNumber(
                survivorsWithCooks * MIN_REQUIRED_FOOD_BY_ONE_SURVIVOR_PER_MOVE,
                survivorsWithCooks * MAX_REQUIRED_FOOD_BY_ONE_SURVIVOR_PER_MOVE
        );

        gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.cooks_waste_food_for_nutrition, (int) requiredFood)));
        gameModel.getIndicatorsModel().reduceFood(requiredFood);

        int chanceToSpoilFood = MIN_CHANCE_TO_SPOIL_FOOD + (int) ((gameModel.getIndicatorsModel().getFood() / REQUIRED_FOOD_TO_INCREASE_CHANCE_TO_SPOIL_FOOD) * INCREASE_MIN_CHANCE_TO_SPOIL_FOOD);

        boolean isWin = Random.isWin(chanceToSpoilFood);

        if (isWin) {
            double spoilFood = gameModel.getIndicatorsModel().getFood() - gameModel.getIndicatorsModel().getFood() * REDUCE_FOOD_IS_SPOIL;
            gameModel.getIndicatorsModel().reduceFood(spoilFood);
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.cooks_food_has_gone_bad, (int) spoilFood)));
        }

        if (survivorsWithoutCooks == 0) {
            return null;
        }

        int poisonedSurvivors = 0;
        for (int i = 0; i < survivorsWithoutCooks; i++) {
            boolean isPoisoned = Random.isWin(CHANCE_TO_POISONED);
            if (isPoisoned) {
                poisonedSurvivors++;
            }
        }

        double reduceAuthority = poisonedSurvivors * REDUCE_AUTHORITY_IF_POISONED_ONE_SURVIVOR;
        gameModel.getIndicatorsModel().reduceAuthority(reduceAuthority);
        if (poisonedSurvivors != 0) {
            gameModel.getReportsModel().addReport(new Report( new InfoPart(R.string.cooks_poisoned_survivors, poisonedSurvivors, reduceAuthority)));
        }

        return null;
    }

}
