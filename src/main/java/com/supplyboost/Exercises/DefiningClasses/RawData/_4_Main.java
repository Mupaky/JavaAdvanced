package com.supplyboost.Exercises.DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _4_Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int maxLines = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        String[] carInfo;
        while (maxLines > 0){
            carInfo = scanner.nextLine().split("\\s");
            cars.add(Car.createCar(carInfo));
            maxLines--;
        }

        String command = scanner.nextLine();

        List<Car> allowedCars = new ArrayList<>();

        switch (command){
            case "fragile":
                for (Car car : cars){
                    if(car.isFragile()){
                        allowedCars.add(car);
                    }
                }
                break;
            case "flamable":
                for (Car car : cars){
                    if(car.isFlammable()){
                        allowedCars.add(car);
                    }
                }
                break;
            default:
                break;
        }

        allowedCars.forEach(car -> System.out.println(car.getModel()));
    }
}
