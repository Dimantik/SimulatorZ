package com.example.simulatorz.game.model.survivors.category;


import com.example.simulatorz.R;

import static com.example.simulatorz.game.settings.SurvivorsSettings.RecruitersSettings.*;

public class Recruiters extends Survivors {

    private double recruitingProgress;

    public Recruiters(int quantity) {
        super(NAME, R.string.recruiters, quantity);
        recruitingProgress = 0.0;
    }

    public void increaseRecruitingProgress(int progress) {
        recruitingProgress += progress;
    }

    public void resetRecruitingProgress() {
        this.recruitingProgress = 0.0;
    }

    public double getRecruitingProgress() {
        return recruitingProgress;
    }

}
