package com.example.simulatorz.game.model;

import com.example.simulatorz.game.model.events.EventsModel;
import com.example.simulatorz.game.model.reports.ReportsModel;
import com.example.simulatorz.game.model.improvements.ImprovementsModel;
import com.example.simulatorz.game.model.indicators.IndicatorsModel;
import com.example.simulatorz.game.model.survivors.PopulationModel;

import java.io.Serializable;

public class GameModel implements Serializable {

    private final IndicatorsModel indicatorsModel;
    private final ReportsModel reportsModel;
    private final PopulationModel populationModel;
    private final ImprovementsModel improvementsModel;
    private final EventsModel eventsModel;

    public GameModel(
            IndicatorsModel indicatorsModel,
            ReportsModel reportsModel,
            PopulationModel populationModel,
            ImprovementsModel improvementsModel,
            EventsModel eventsModel
    ) {
        this.indicatorsModel = indicatorsModel;
        this.reportsModel = reportsModel;
        this.populationModel = populationModel;
        this.improvementsModel = improvementsModel;
        this.eventsModel = eventsModel;
    }

    public ReportsModel getReportsModel() {
        return reportsModel;
    }

    public IndicatorsModel getIndicatorsModel() {
        return indicatorsModel;
    }

    public PopulationModel getPopulationModel() {
        return populationModel;
    }

    public ImprovementsModel getImprovementsModel() {
        return improvementsModel;
    }

    public EventsModel getEventsModel() {
        return eventsModel;
    }
}
