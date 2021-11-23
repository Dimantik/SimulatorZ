package com.example.simulatorz.game.interfaces;

import com.example.simulatorz.game.core.Core;
import com.example.simulatorz.game.db.GameManager;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.reports.Report;
import com.example.simulatorz.game.model.survivors.category.Survivors;

import java.util.List;

public class GameInterface {

    private static GameModel getGameModel() {
        return GameManager.getInstance().getGameModel();
    }

    public static int getCurrentMove() {
        return getGameModel().getIndicatorsModel().getCurrentMove();
    }

    public static double getAuthority() {
        return getGameModel().getIndicatorsModel().getAuthority();
    }

    public static double getFood() {
        return getGameModel().getIndicatorsModel().getFood();
    }

    public static double getPower() {
        return getGameModel().getPopulationModel().getFighters().getPower();
    }

    public static int getCurrentMonth() {
        return getGameModel().getIndicatorsModel().getCurrentMonth();
    }

    public static double getProtection() {
        return  getGameModel().getIndicatorsModel().getProtection();
    }

    public static List<Survivors> getSurvivorsList() {
        return getGameModel().getPopulationModel().getSurvivorsList();
    }

    public static List<Report> getReportList() {
        return getGameModel().getReportsModel().getReportList();
    }

    public static void nextMove() {
        Core.nextMove(getGameModel());
    }

    public static int getCurrentPopulationSize() {
        return getGameModel().getPopulationModel().getCurrentPopulationSize();
    }

    public static Event getCurrentEvent() {
        return getGameModel().getEventsModel().getCurrentEvent();
    }

    public static void executeLeftAction() {
    }

    public static void executeRightAction() {
    }

}
