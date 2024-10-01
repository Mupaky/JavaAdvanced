package com.supplyboost.Exercises.DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;


    private Car(String model, int speed, int power, int weight, String type) {
        this.model = model;
        engine = new Engine(speed,power);
        cargo = new Cargo(weight,type);
    }

    public static Car createCar(String[] carInfo){
        Car car = new Car(carInfo[0], Integer.parseInt(carInfo[1]), Integer.parseInt(carInfo[2]),
                Integer.parseInt(carInfo[3]), carInfo[4]);
        car.setTires(new ArrayList<>());
        for(int infoIndex = 5; infoIndex < carInfo.length; infoIndex++){
            car.tires.add(new Tire(Double.parseDouble(carInfo[infoIndex])
                    , Integer.parseInt(carInfo[infoIndex + 1])));
            infoIndex++;
        }
        return car;
    }

    public boolean isFragile(){
        boolean isFragile = false;
        for (Tire tire : tires){
            if (tire.getPressure() < 1 && cargo.getType().equals("fragile")) {
                isFragile = true;
                break;
            }
        }
        return isFragile;
    }

    public boolean isFlammable(){
        return engine.getPower() > 250 && cargo.getType().equals("flamable");
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }
}
