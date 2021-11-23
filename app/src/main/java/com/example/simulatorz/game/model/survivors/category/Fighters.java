package com.example.simulatorz.game.model.survivors.category;

import com.example.simulatorz.R;

import static com.example.simulatorz.game.settings.SurvivorsSettings.FightersSettings.*;

public class Fighters extends Survivors {

    public Fighters(int quantity) {
        super(NAME, R.string.fighters, quantity);
    }

    public double getPower() {
        return quantity * POWER;
    }

}
