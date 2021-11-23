package com.example.simulatorz.game.model.indicators;

import java.io.Serializable;

public class IndicatorsModel implements Serializable {

    private double authority;
    private int currentMove;

    private double food;
    private double protection;
    private int currentMonth;

    public IndicatorsModel(
            double authority,
            int currentMove,
            double food,
            double protection,
            int currentMonth
    ) {
        this.authority = authority;
        this.currentMove = currentMove;
        this.food = food;
        this.protection = protection;
        this.currentMonth = currentMonth;
    }

    //GET
    public double getFood() {
        return food;
    }

    public int getCurrentMove() {
        return currentMove;
    }

    public double getAuthority() {
        return authority;
    }

    public double getProtection() {
        return protection;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    //CUSTOM
    public void reduceAuthority(double authority) {
        this.authority -= authority;
    }

    public void increaseAuthority(double authority) {
        this.authority += authority;
    }

    public void reduceFood(double food) {
        this.food -= food;
    }

    public void increaseFood(double food) {
        this.food += food;
    }

    public void reduceProtection(double protection) {
        this.protection -= protection;
    }

    public void increaseProtection(double protection) {
        this.protection += protection;
    }

    public void nextMove() {
        this.currentMove++;
        nextMonth();
    }

    private void nextMonth() {
        if (currentMonth == 12) {
            currentMonth = 1;
        } else {
            currentMonth++;
        }
    }

}
