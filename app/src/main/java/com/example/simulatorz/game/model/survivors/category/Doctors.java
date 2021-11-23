package com.example.simulatorz.game.model.survivors.category;

import com.example.simulatorz.R;

import static com.example.simulatorz.game.settings.SurvivorsSettings.DoctorsSettings.*;

public class Doctors extends Survivors {

    public Doctors(int quantity) {
        super(NAME, R.string.doctors, quantity);
    }

}
