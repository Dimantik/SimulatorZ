package com.example.simulatorz.game.core.survivors_cores;

import com.example.simulatorz.R;
import com.example.simulatorz.game.core.util.SurvivorsUtil;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.reports.Report;
import com.example.simulatorz.game.model.util.InfoPart;
import com.example.simulatorz.game.model.util.Random;

import static com.example.simulatorz.game.settings.SurvivorsSettings.FishersSettings.*;

public class FishersCore {

    public static Event execute(GameModel gameModel) {
        if (gameModel.getPopulationModel().getFishers().getQuantity() == 0) {
            return null;
        }

        die(gameModel);

        if (gameModel.getPopulationModel().getFishers().getQuantity() == 0) {
            return null;
        }

        fishing(gameModel);

        return null;
    }

    private static void die(GameModel gameModel) {
        SurvivorsUtil.Result result = SurvivorsUtil.die(
                gameModel.getPopulationModel().getFishers(),
                CHANCE_TO_DIE,
                CHANCE_TO_PATIENT,
                CHANCE_TO_GONE
        );

        if (result.getDieQuantity() != 0) {
            gameModel.getPopulationModel().getFishers().reduceQuantity(result.getDieQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.fishers_die_several, result.getDieQuantity())));
        }

        if (result.getPatientQuantity() != 0) {
            gameModel.getPopulationModel().getFishers().increasePatientsQuantity(result.getPatientQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.fishers_wounded_several, result.getPatientQuantity())));
        }

        if (result.getGoneQuantity() != 0) {
            gameModel.getPopulationModel().getFishers().increasePatientsQuantity(result.getGoneQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.fishers_gone_several, result.getGoneQuantity())));
        }

        if (result.getBackQuantity() != 0) {
            gameModel.getPopulationModel().getFishers().reduceGoneQuantity(result.getBackQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.fishers_back_several, result.getBackQuantity())));
        }
    }

    private static void fishing(GameModel gameModel) {
        double caughtFish = Random.getRandomNumber(
                gameModel.getPopulationModel().getFishers().getQuantity() * MIN_CAUGHT_FISH_BY_ONE_FISHER,
                gameModel.getPopulationModel().getFishers().getQuantity() * MAX_CAUGHT_FISH_BY_ONE_FISHER
        );

        for (int fewFoodExtractionMonth : FEW_FOOD_EXTRACTION_MONTHS) {
            if (fewFoodExtractionMonth == gameModel.getIndicatorsModel().getCurrentMonth()) {
                caughtFish *= FEW_FOOD_EXTRACTION_MULTIPLIER;
            }
        }

        for (int muchFoodExtractionMonth : MUCH_FOOD_EXTRACTION_MONTHS) {
            if (muchFoodExtractionMonth == gameModel.getIndicatorsModel().getCurrentMonth()) {
                caughtFish *= MUCH_FOOD_EXTRACTION_MULTIPLIER;
            }
        }

        gameModel.getIndicatorsModel().increaseFood(caughtFish);

        gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.fishers_catch_fish, (int) caughtFish)));
    }

}
