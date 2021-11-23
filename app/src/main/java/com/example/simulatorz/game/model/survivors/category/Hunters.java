package com.example.simulatorz.game.model.survivors.category;

import com.example.simulatorz.R;

import static com.example.simulatorz.game.settings.SurvivorsSettings.HuntersSettings.*;

public class Hunters extends Survivors {

    public Hunters(int quantity) {
        super(NAME, R.string.hunters, quantity);
    }

}
