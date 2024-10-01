package com.supplyboost.Exercises.DefiningClasses.CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private double weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, double weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = color;
    }

    public Car(String model, Engine engine, double weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String weight = "n/a";
        String displacement = "n/a";
        if(this.weight > 0){
            weight = String.format("%.0f", this.weight);
        }
        if(this.engine.getDisplacement() > 0){
            displacement = "" + this.engine.getDisplacement();
        }
        return getModel() + ":\n" +
                this.engine.getModel() +
                ":\nPower: " + this.engine.getPower() +
                "\nDisplacement: " + displacement +
                "\nEfficiency: " + this.engine.getEfficiency() +
                "\nWeight: " + weight +
                "\nColor: " + this.color;
    }
}
