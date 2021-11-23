package com.example.simulatorz.game.core.survivors_cores;

import com.example.simulatorz.R;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.reports.Report;
import com.example.simulatorz.game.model.util.InfoPart;
import com.example.simulatorz.game.model.util.Random;

import static com.example.simulatorz.game.settings.SurvivorsSettings.FightersSettings.*;

public class FightersCore {

    public static Event execute(GameModel gameModel) {
        if (gameModel.getPopulationModel().getFighters().getQuantity() == 0) {
            return null;
        }

        sortie(gameModel);

        return null;
    }

    private static void die(GameModel gameModel) {

    }

    private static void sortie(GameModel gameModel) {
        int winnerId = Random.getOneOfManyResult(
                CHANE_TO_FIND_SMALL_FOOD_SUPPLIES,
                CHANE_TO_FIND_MEDIUM_FOOD_SUPPLIES,
                CHANE_TO_FIND_LARGE_FOOD_SUPPLIES,
                Random.MAX_PERCENT
                        - CHANE_TO_FIND_LARGE_FOOD_SUPPLIES
                        - CHANE_TO_FIND_MEDIUM_FOOD_SUPPLIES
                        - CHANE_TO_FIND_SMALL_FOOD_SUPPLIES
        );

        double loadCapacity = gameModel.getPopulationModel().getFighters().getQuantity();
        double foodExtraction;

        switch (winnerId) {
            case Random.WINNER_FIRST_ID:
                foodExtraction = Random.getRandomNumber(MIN_SMALL_FOOD_SUPPLIES, MAX_SMALL_FOOD_SUPPLIES);
                if (foodExtraction > loadCapacity) {
                    gameModel.getReportsModel().addReport(
                            new Report(
                                    new InfoPart(
                                            R.string.fighters_find_small_food_supplies_take_not_all,
                                            (int) foodExtraction,
                                            (int) loadCapacity
                                    )
                            )
                    );
                } else {
                    gameModel.getReportsModel().addReport(
                            new Report(
                                    new InfoPart(
                                            R.string.fighters_find_small_food_supplies_take_all,
                                            (int) foodExtraction
                                    )
                            )
                    );
                }
                break;
            case Random.WINNER_SECOND_ID:
                foodExtraction = Random.getRandomNumber(MIN_MEDIUM_FOOD_SUPPLIES, MAX_MEDIUM_FOOD_SUPPLIES);
                if (foodExtraction > loadCapacity) {
                    gameModel.getReportsModel().addReport(
                            new Report(
                                    new InfoPart(
                                            R.string.fighters_find_medium_food_supplies_take_not_all,
                                            (int) foodExtraction,
                                            (int) loadCapacity
                                    )
                            )
                    );
                } else {
                    gameModel.getReportsModel().addReport(
                            new Report(
                                    new InfoPart(
                                            R.string.fighters_find_medium_food_supplies_take_all,
                                            (int) foodExtraction
                                    )
                            )
                    );
                }
                break;
            case Random.WINNER_THIRD_ID:
                foodExtraction = Random.getRandomNumber(MIN_LARGE_FOOD_SUPPLIES, MAX_LARGE_FOOD_SUPPLIES);
                if (foodExtraction > loadCapacity) {
                    gameModel.getReportsModel().addReport(
                            new Report(
                                    new InfoPart(
                                            R.string.fighters_find_large_food_supplies_take_not_all,
                                            (int) foodExtraction,
                                            (int) loadCapacity
                                    )
                            )
                    );
                } else {
                    gameModel.getReportsModel().addReport(
                            new Report(
                                    new InfoPart(
                                            R.string.fighters_find_large_food_supplies_take_all,
                                            (int) foodExtraction
                                    )
                            )
                    );
                }
                break;
        }

    }

}
