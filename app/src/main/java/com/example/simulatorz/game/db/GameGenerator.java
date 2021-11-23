package com.example.simulatorz.game.db;

import com.example.simulatorz.R;
import com.example.simulatorz.game.model.GameModel;
import com.example.simulatorz.game.model.events.EventsModel;
import com.example.simulatorz.game.model.events.category.ResultEvent;
import com.example.simulatorz.game.model.reports.Report;
import com.example.simulatorz.game.model.reports.ReportsModel;
import com.example.simulatorz.game.model.indicators.IndicatorsModel;
import com.example.simulatorz.game.model.survivors.PopulationModel;
import com.example.simulatorz.game.model.survivors.category.Cooks;
import com.example.simulatorz.game.model.survivors.category.Doctors;
import com.example.simulatorz.game.model.survivors.category.Farmers;
import com.example.simulatorz.game.model.survivors.category.Fighters;
import com.example.simulatorz.game.model.survivors.category.Fishers;
import com.example.simulatorz.game.model.survivors.category.Foresters;
import com.example.simulatorz.game.model.survivors.category.Hunters;
import com.example.simulatorz.game.model.survivors.category.Recruiters;
import com.example.simulatorz.game.model.util.InfoPart;

import java.util.ArrayList;
import java.util.List;

import static com.example.simulatorz.game.settings.IndicatorsSettings.*;

public class GameGenerator {

    public static GameModel generate() {
        return new GameModel(
                generateIndicatorsModel(),
                generateReportModel(),
                generatePopulationModel(),
                null,
                generateEventModel()
        );
    }

    private static EventsModel generateEventModel() {
        EventsModel eventsModel = new EventsModel();
        eventsModel.setCurrentEvent(new ResultEvent(new InfoPart(R.string.example_result_event)));
        return eventsModel;
    }

    private static IndicatorsModel generateIndicatorsModel() {
        return new IndicatorsModel(
                START_AUTHORITY,
                START_MOVE,
                START_FOOD,
                START_PROTECTION,
                START_MONTH
        );
    }

    private static PopulationModel generatePopulationModel() {
        return new PopulationModel(
                new Fighters(23),
                new Cooks(1),
                new Doctors(3),
                new Farmers(14),
                new Fishers(2),
                new Foresters(3),
                new Hunters(6),
                new Recruiters(1)
        );
    }

    private static ReportsModel generateReportModel() {
        return new ReportsModel();
    }

}
