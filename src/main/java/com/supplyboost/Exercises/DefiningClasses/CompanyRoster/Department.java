package com.supplyboost.Exercises.DefiningClasses.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public double averageSalary(){
        double averageSalary = 0;
        for (Employee employee : employees){
            averageSalary += employee.getSalary();
        }
        return averageSalary / employees.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
