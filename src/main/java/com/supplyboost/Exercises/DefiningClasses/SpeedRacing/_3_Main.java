package com.supplyboost.Exercises.DefiningClasses.SpeedRacing;

import java.util.Map;
import java.util.Scanner;

public class _3_Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountOfCars = Integer.parseInt(scanner.nextLine());

        while (amountOfCars > 0){
            String[] carInfo = scanner.nextLine().split("\\s");
            Car car = Car.getInstance(carInfo[0]);
            car.setFuelAmount(Double.parseDouble(carInfo[1]));
            car.setFuelCostForKilometer(Double.parseDouble(carInfo[2]));
            amountOfCars--;
        }

        String[] commands = scanner.nextLine().split("\\s");
        while (!commands[0].equals("End")){
            if(commands[0].equals("Drive")){
                Car car = Car.getInstance(commands[1]);
                if(!car.drive(Integer.parseInt(commands[2]))){
                    System.out.println("Insufficient fuel for the drive");
                }
            }

            commands = scanner.nextLine().split("\\s");
        }

        for(Map.Entry<String, Car> car : Car.models.entrySet()){
            System.out.printf("%s %.2f %d\n", car.getKey(), car.getValue().getFuelAmount(), car.getValue().getDistanceTraveled());
        }

    }
}
