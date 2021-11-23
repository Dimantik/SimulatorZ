package com.example.simulatorz.game.model.events.category;

import com.example.simulatorz.game.model.events.Event;
import com.example.simulatorz.game.model.util.InfoPart;

public class RecruitingEvent extends Event {

    public RecruitingEvent(InfoPart infoPart) {
        super(infoPart);
    }

    @Override
    public int[] getActions() {
        return new int[0];
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isResultEvent() {
        return false;
    }

}
