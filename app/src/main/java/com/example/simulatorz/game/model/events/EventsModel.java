package com.example.simulatorz.game.model.events;

import java.io.Serializable;

public class EventsModel implements Serializable {

    private Event currentEvent;

    public Event getCurrentEvent() {
        return currentEvent;
    }

    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }

}
