package com.supplyboost.Exercises.DefiningClasses.CarSalesman;

import java.util.*;

public class _5_Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int engineLines = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        String[] info;

        while (engineLines > 0){
            info = scanner.nextLine().split("\\s");
            String model = info[0];
            int power = Integer.parseInt(info[1]);
            switch (info.length){
                case 2:
                    engines.put(model, new Engine(model, power));
                    break;
                case 3:
                    try {
                        //Where info[2] is displacement
                        engines.put(model, new Engine(model, power, Integer.parseInt(info[2])));
                    }catch (NumberFormatException e){
                        //Where info[2] is efficiency
                        engines.put(model, new Engine(model, power, info[2]));
                    }
                    break;
                case 4:
                    //Where info[2] is displacement and info[3] is efficiency
                    engines.put(model, new Engine(model, power, Integer.parseInt(info[2]), info[3]));
                    break;
                default:
                    break;
            }

            engineLines--;
        }

        int carLines = Integer.parseInt(scanner.nextLine());

        while (carLines > 0){
            info = scanner.nextLine().split("\\s");
            String model = info[0];
            String engineModel = info[1];
            switch (info.length){
                case 2:
                    cars.add(new Car(model, engines.get(engineModel)));
                    break;
                case 3:
                    try {
                        //Where info[2] is weight
                        cars.add(new Car(model, engines.get(engineModel), Integer.parseInt(info[2])));
                    }catch (NumberFormatException e){
                        //Where info[2] is color
                        cars.add(new Car(model, engines.get(engineModel), info[2]));
                    }
                    break;
                case 4:
                    //Where info[2] is weight and info[3] is color
                    cars.add(new Car(model, engines.get(engineModel), Integer.parseInt(info[2]), info[3]));
                    break;
                default:
                    break;
            }

            carLines--;
        }

        cars.forEach(car -> System.out.println(car.toString()));

    }
}
