package com.example.simulatorz.game.core.survivors_cores;

import com.example.simulatorz.R;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.reports.Report;
import com.example.simulatorz.game.model.util.InfoPart;
import com.example.simulatorz.game.model.util.Random;

import static com.example.simulatorz.game.settings.SurvivorsSettings.FarmersSettings.*;

public class FarmersCore {

    public static Event execute(GameModel gameModel) {
        if (gameModel.getPopulationModel().getFarmers().getQuantity() == 0) {
            return null;
        }

        for (int noGrownFoodMonth : NO_GROWN_FOOD_MONTHS) {
            if (noGrownFoodMonth == gameModel.getIndicatorsModel().getCurrentMonth()) {
                return null;
            }
        }

        int winnerId = Random.getOneOfManyResult(CHANCE_TO_HURRICANE, CHANE_TO_DROUGHT, Random.MAX_PERCENT - CHANCE_TO_HURRICANE - CHANE_TO_DROUGHT);

        double multiplier;

        switch (winnerId) {
            case Random.WINNER_FIRST_ID:
                multiplier = REDUCE_GROWN_FOOD_IF_HURRICANE;
                break;
            case Random.WINNER_SECOND_ID:
                multiplier = REDUCE_GROWN_FOOD_IF_DROUGHT;
                break;
            default:
                multiplier = 1.0;
        }


        double grownFood = Random.getRandomNumber(
                gameModel.getPopulationModel().getFarmers().getQuantity() * MIN_GROWN_FOOD_BY_ONE_FARMER,
                gameModel.getPopulationModel().getFarmers().getQuantity() * MAX_GROWN_FOOD_BY_ONE_FARMER
        );

        grownFood *= multiplier;

        gameModel.getIndicatorsModel().increaseFood(grownFood);

        Report report;

        switch (winnerId) {
            case Random.WINNER_FIRST_ID:
                report = new Report(new InfoPart(R.string.farmers_grown_food_hurricane, (int) grownFood));
                break;
            case Random.WINNER_SECOND_ID:
                report = new Report(new InfoPart(R.string.farmers_grown_food_drought, (int) grownFood));
                break;
            default:
                report = new Report(new InfoPart(R.string.farmers_grown_food, (int) grownFood));
        }

        gameModel.getReportsModel().addReport(report);

        return null;
    }

}
