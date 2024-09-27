package com.supplyboost.Exercises.DefiningClasses.CompanyRoster;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _2_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxReadLines = Integer.parseInt(scanner.nextLine());

        Set<Department> departments = new HashSet<>();



        while (maxReadLines > 0){
            String[] info = scanner.nextLine().split("\\s");
            String departmentName = info[3];
            String email = "n/a";
            int age = -1;
            if(info.length == 5){
                email = info[4];
            }
            if(info.length > 5){
                age = Integer.parseInt(info[5]);
            }
            boolean found = false;
            for (Department department : departments) {
                if (department.getName().equals(departmentName)) {
                    department.getEmployees().add(new Employee(info[0], Double.parseDouble(info[1]), info[2], email, age));
                    found = true;
                    break;
                }
            }
            if(!found){

            }

            maxReadLines--;
        }
        departments.forEach(department -> System.out.println(department.getName()));
    }
}
