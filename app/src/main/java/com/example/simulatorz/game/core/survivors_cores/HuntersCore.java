package com.example.simulatorz.game.core.survivors_cores;

import com.example.simulatorz.R;
import com.example.simulatorz.game.core.util.SurvivorsUtil;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.reports.Report;
import com.example.simulatorz.game.model.util.InfoPart;
import com.example.simulatorz.game.model.util.Random;

import static com.example.simulatorz.game.settings.SurvivorsSettings.HuntersSettings.*;

public class HuntersCore {

    public static Event execute(GameModel gameModel) {
        if (gameModel.getPopulationModel().getHunters().getQuantity() == 0) {
            return null;
        }

        die(gameModel);

        if (gameModel.getPopulationModel().getHunters().getQuantity() == 0) {
            return null;
        }

        hunt(gameModel);

        return null;
    }

    private static void die(GameModel gameModel) {
        SurvivorsUtil.Result result = SurvivorsUtil.die(
                gameModel.getPopulationModel().getHunters(),
                CHANCE_TO_DIE,
                CHANCE_TO_PATIENT,
                CHANCE_TO_GONE
        );

        if (result.getDieQuantity() != 0) {
            gameModel.getPopulationModel().getHunters().reduceQuantity(result.getDieQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.hunters_die_several, result.getDieQuantity())));
        }

        if (result.getPatientQuantity() != 0) {
            gameModel.getPopulationModel().getHunters().increasePatientsQuantity(result.getPatientQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.hunters_wounded_several, result.getPatientQuantity())));
        }

        if (result.getGoneQuantity() != 0) {
            gameModel.getPopulationModel().getHunters().increasePatientsQuantity(result.getGoneQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.hunters_gone_several, result.getGoneQuantity())));
        }


        if (result.getBackQuantity() != 0) {
            gameModel.getPopulationModel().getHunters().reduceGoneQuantity(result.getBackQuantity());
            gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.hunters_back_several, result.getBackQuantity())));
        }
    }

    private static void hunt(GameModel gameModel) {
        double extractedFood = Random.getRandomNumber(
                gameModel.getPopulationModel().getHunters().getQuantity() * MIN_EXTRACTED_FOOD_BY_ONE_HUNTER,
                gameModel.getPopulationModel().getHunters().getQuantity() * MAX_EXTRACTED_FOOD_BY_ONE_HUNTER
        );

        for (int fewFoodExtractionMonth : FEW_FOOD_EXTRACTION_MONTHS) {
            if (fewFoodExtractionMonth == gameModel.getIndicatorsModel().getCurrentMonth()) {
                extractedFood *= FEW_FOOD_EXTRACTION_MULTIPLIER;
            }
        }

        for (int muchFoodExtractionMonth : MUCH_FOOD_EXTRACTION_MONTHS) {
            if (muchFoodExtractionMonth == gameModel.getIndicatorsModel().getCurrentMonth()) {
                extractedFood *= MUCH_FOOD_EXTRACTION_MULTIPLIER;
            }
        }

        gameModel.getIndicatorsModel().increaseFood(extractedFood);

        gameModel.getReportsModel().addReport(new Report(new InfoPart(R.string.hunters_catch_beasts, (int) extractedFood)));
    }

}
