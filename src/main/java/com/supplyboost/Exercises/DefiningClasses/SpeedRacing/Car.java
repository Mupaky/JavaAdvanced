package com.supplyboost.Exercises.DefiningClasses.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;

public class Car {

    public static Map<String, Car> models = new LinkedHashMap<>();

    private String model;
    private double fuelAmount;
    private double fuelCostForKilometer;
    private int distanceTraveled;

    private Car(String model){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKilometer = fuelCostForKilometer;
        distanceTraveled = 0;
    }

    public static Car getInstance(String model){
        if(!models.containsKey(model)){
            models.put(model, new Car(model));
        }
        return models.get(model);
    }

    public boolean drive(int distance){
        if(fuelCostForKilometer * distance > fuelAmount){
            return false;
        }
        distanceTraveled += distance;
        fuelAmount -= fuelCostForKilometer * distance;
        return true;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostForKilometer() {
        return fuelCostForKilometer;
    }

    public void setFuelCostForKilometer(double fuelCostForKilometer) {
        this.fuelCostForKilometer = fuelCostForKilometer;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
}
