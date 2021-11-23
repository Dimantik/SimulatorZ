package com.example.simulatorz.game.model.util;

import android.content.Context;

public class InfoPart {

    private final int info;
    private final Object[] args;

    public InfoPart(int info, Object... args) {
        this.info = info;
        this.args = args;
    }

    public String getInfo(Context context) {
        return String.format(context.getResources().getString(info), args);
    }

}