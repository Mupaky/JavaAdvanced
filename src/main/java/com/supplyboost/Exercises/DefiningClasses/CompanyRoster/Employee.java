package com.supplyboost.Exercises.DefiningClasses.CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    public Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = "n/a";
        this.age = -1;
    }
    public Employee(String name, double salary, String position, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = email;
        this.age = -1;
    }
    public Employee(String name, double salary, String position, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = email;
        this.age = age;
    }

    public static Employee createNewEmployee(String[] info){
        String name = info[0];
        double salary = Double.parseDouble(info[1]);
        String position = info[2];
        switch (info.length) {
            case 5:
                if(info[4].contains("@")){
                    return  new Employee(name, salary, position, info[4]);
                }else{
                    return  new Employee(name, salary, position,"n/a",Integer.parseInt(info[4]));
                }
            case 6:
                int age = Integer.parseInt(info[5]);
                return new Employee(name, salary, position, info[4], age);
            default:
                return new Employee(name, salary, position);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
