package com.example.simulatorz.game.model.survivors;

import com.example.simulatorz.game.model.survivors.category.Cooks;
import com.example.simulatorz.game.model.survivors.category.Doctors;
import com.example.simulatorz.game.model.survivors.category.Farmers;
import com.example.simulatorz.game.model.survivors.category.Fighters;
import com.example.simulatorz.game.model.survivors.category.Fishers;
import com.example.simulatorz.game.model.survivors.category.Foresters;
import com.example.simulatorz.game.model.survivors.category.Hunters;
import com.example.simulatorz.game.model.survivors.category.Recruiters;
import com.example.simulatorz.game.model.survivors.category.Survivors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PopulationModel implements Serializable {

    private final List<Survivors> survivorsList;

    private final Fighters fighters;
    private final Cooks cooks;
    private final Doctors doctors;
    private final Farmers farmers;
    private final Fishers fishers;
    private final Foresters foresters;
    private final Hunters hunters;
    private final Recruiters recruiters;

    public PopulationModel(
            Fighters fighters,
            Cooks cooks,
            Doctors doctors,
            Farmers farmers,
            Fishers fishers,
            Foresters foresters,
            Hunters hunters,
            Recruiters recruiters
    ) {
        this.fighters = fighters;
        this.cooks = cooks;
        this.doctors = doctors;
        this.farmers = farmers;
        this.fishers = fishers;
        this.foresters = foresters;
        this.hunters = hunters;
        this.recruiters = recruiters;

        survivorsList = new ArrayList<>();

        survivorsList.add(fighters);
        survivorsList.add(cooks);
        survivorsList.add(doctors);
        survivorsList.add(farmers);
        survivorsList.add(fishers);
        survivorsList.add(foresters);
        survivorsList.add(hunters);
    }


    public List<Survivors> getSurvivorsList() {
        return survivorsList;
    }

    public Fighters getFighters() {
        return fighters;
    }

    public Cooks getCooks() {
        return cooks;
    }

    public Doctors getDoctors() {
        return doctors;
    }

    public Farmers getFarmers() {
        return farmers;
    }

    public Fishers getFishers() {
        return fishers;
    }

    public Foresters getForesters() {
        return foresters;
    }

    public Hunters getHunters() {
        return hunters;
    }

    public Recruiters getRecruiters() {
        return recruiters;
    }

    public int getCurrentPopulationSize() {
        int size = 0;
        for (Survivors survivors : survivorsList) {
            size += survivors.getQuantity();
        }
        return size;
    }

    public boolean isExistPatients() {
        for (Survivors survivors : survivorsList) {
            if (survivors.getPatientsQuantity() != 0) {
                return true;
            }
        }

        return false;
    }
}
