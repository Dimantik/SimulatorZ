package com.example.simulatorz.game.model.survivors.category;

import java.io.Serializable;

public abstract class Survivors implements Serializable {

    protected final String name;
    protected final int nameWithQuantity;
    protected int quantity;
    protected int patientsQuantity;
    protected int goneQuantity;

    protected Survivors(String name, int nameWithQuantity, int quantity) {
        this.name = name;
        this.nameWithQuantity = nameWithQuantity;
        this.quantity = quantity;
        this.patientsQuantity = 0;
        this.goneQuantity = 0;
    }

    //Get
    public int getPatientsQuantity() {
        return patientsQuantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getNameWithQuantity() {
        return nameWithQuantity;
    }

    //Custom
    public void increasePatientsQuantity(int quantity) {
        this.patientsQuantity += quantity;
    }

    public int deadPatients() {
        int deadQuantity = this.patientsQuantity;
        this.quantity -= patientsQuantity;
        this.patientsQuantity -= patientsQuantity;
        return deadQuantity;
    }

    public void healOnePatient() {
        this.patientsQuantity--;
        this.quantity++;
    }

    public void increaseGoneQuantity(int quantity) {
        this.quantity -= quantity;
        this.goneQuantity += quantity;
    }

    public void reduceGoneQuantity(int quantity) {
        this.quantity += quantity;
        this.goneQuantity -= quantity;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

}
