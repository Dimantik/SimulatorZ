package com.example.simulatorz.game.model.reports;

import android.content.Context;

import com.example.simulatorz.game.model.util.InfoBuilder;
import com.example.simulatorz.game.model.util.InfoPart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Report implements Serializable {

    protected List<InfoPart> infoPartsList;

    public Report(InfoPart infoPart) {
        infoPartsList = new ArrayList<>();
        infoPartsList.add(infoPart);
    }

    public void addInfoPart(InfoPart infoPart) {
        infoPartsList.add(infoPart);
    }

    public String getInfo(Context context) {
        return InfoBuilder.buildInfo(infoPartsList, context);
    }

}
