package com.supplyboost.Exercises.Generics.GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1_Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int lines = Integer.parseInt(scanner.nextLine());

        List<Box> boxes = new ArrayList<>();
        while (lines > 0){
            Box<String> box = new Box<>();
            box.setTypeData(scanner.nextLine());
            boxes.add(box);
            lines--;
        }

        boxes.forEach(box -> System.out.println(box.toString()));



    }
}
