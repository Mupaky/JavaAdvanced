package com.supplyboost.Exercises.DefiningClasses.CompanyRoster;


import java.util.*;

public class _2_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxReadLines = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();


        while (maxReadLines > 0){
            String[] info = scanner.nextLine().split("\\s");
            String departmentName = info[3];
            if (!departments.containsKey(departmentName)) {
                departments.put(departmentName, new Department(departmentName));
            }
            departments.get(departmentName).getEmployees().add(Employee.createNewEmployee(info));
            maxReadLines--;
        }

        Department bestSalarayForDepartment = null;
        double maxAverageSalary = 0;
        for (Department department : departments.values()){
            if(maxAverageSalary < department.averageSalary()){
                bestSalarayForDepartment = department;
                maxAverageSalary = department.averageSalary();
            }
        }
        assert bestSalarayForDepartment != null;
        System.out.printf("Highest Average Salary: %s\n", bestSalarayForDepartment.getName());
        bestSalarayForDepartment.getEmployees().sort(Comparator.comparing(Employee::getSalary).reversed());
        bestSalarayForDepartment.getEmployees()
                .forEach(employee -> System.out.printf("%s %.2f %s %d\n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));

    }
}
