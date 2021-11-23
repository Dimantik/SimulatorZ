package com.example.simulatorz.game.model.events;

import android.content.Context;

import com.example.simulatorz.game.model.util.InfoBuilder;
import com.example.simulatorz.game.model.util.InfoPart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Event implements Serializable {

    protected int selectedActionId;
    protected List<InfoPart> infoPartsList;

    public Event(InfoPart infoPart) {
        infoPartsList = new ArrayList<>();
        infoPartsList.add(infoPart);
    }

    public void addInfoPart(InfoPart infoPart) {
        infoPartsList.add(infoPart);
    }

    public String getInfo(Context context) {
        return InfoBuilder.buildInfo(infoPartsList, context);
    }

    public void selectAction(int selectedActionId) {
        this.selectedActionId = selectedActionId;
    }

    public abstract int[] getActions();

    public abstract void execute();

    public abstract boolean isResultEvent();

}
