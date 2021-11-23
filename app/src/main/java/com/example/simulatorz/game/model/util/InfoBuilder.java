package com.example.simulatorz.game.model.util;

import android.content.Context;

import java.util.List;

public class InfoBuilder {

    public static String buildInfo(List<InfoPart> infoPartsList, Context context) {
        StringBuilder result = new StringBuilder();

        for (InfoPart infoPart : infoPartsList) {
            result.append(infoPart.getInfo(context));
        }

        return result.toString();
    }

}
