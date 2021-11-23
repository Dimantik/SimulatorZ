package com.example.simulatorz;

import android.app.Application;

import com.example.simulatorz.game.db.GameManager;

public class GameApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        GameManager.init(getApplicationContext());
    }

}
