package com.supplyboost.Exercises.DefiningClasses.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;

    public Person(String name) {
        this.name = name;
        company = new Company();
        car = new Car();
        pokemons = new ArrayList<>();
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    public void addInfo(String[] info){
        switch (info[1]){
            case "company":
                //Where {companyName} {department} {salary}
                if (info.length >= 5) {  // Ensure there are at least 5 elements
                    try {
                        company = new Company(info[2], info[3], Double.parseDouble(info[4]));
                    } catch (NumberFormatException e) {
                    }
                }
                break;
            case "pokemon":
                if (info.length == 4) {
                    pokemons.add(new Pokemon(info[2], info[3]));
                }
                break;
            case "parents":
                if (info.length == 4) {
                    parents.add(new Parent(info[2], info[3]));
                }
                break;
            case "children":
                if (info.length == 4) {
                    children.add(new Child(info[2], info[3]));
                }
                break;
            case "car":
                if (info.length >= 4) {
                    try {
                        car = new Car(info[2], Integer.parseInt(info[3]));
                    } catch (NumberFormatException e) {
                    }
                }
                break;
        }
    }

    private String pokemonsToString(){
        StringBuilder pokemonsListInString = new StringBuilder();
        if(this.pokemons.isEmpty()){
            return "";
        }
        for(Pokemon pokemon : this.pokemons){
           pokemonsListInString.append("\n").append(pokemon.toString());
        }
        return pokemonsListInString.toString();
    }

    private String parentsToString(){
        StringBuilder parentsListInString = new StringBuilder();
        if(this.parents.isEmpty()){
            return "";
        }
        for(Parent parent : this.parents){
            parentsListInString.append("\n").append(parent.toString());
        }
        return parentsListInString.toString();
    }

    private String childrenToString(){
        StringBuilder childrenListInString = new StringBuilder();
        if(this.children.isEmpty()){
            return "";
        }
        for(Child child : this.children){
            childrenListInString.append("\n").append(child.toString());
        }
        return childrenListInString.toString();
    }

    private class Company{
        private String name;
        private String department;
        private double salary;

        public Company() {
            this.name = "";
        }

        public Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            if(name.isEmpty()){
                return name;
            }
            return "\n" +  this.name + " " + this.department + " " + String.format("%.2f", this.salary);
        }
    }

    private class Pokemon{
        private String name;
        private String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return this.name + " " + this.type;
        }
    }

    private class Parent{
        private String name;
        private String birthday;

        public Parent(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return this.name + " " + this.birthday;
        }
    }

    private class Child extends Parent{


        public Child(String name, String birthday) {
            super(name, birthday);
        }
    }

    private class Car{
        private String model;
        private int speed;

        public Car() {
            this.model = "";
        }

        public Car(String model, int speed) {
            this.model = model;
            this.speed = speed;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        @Override
        public String toString() {
            if(model.isEmpty()){
                return model;
            }
            return "\n" + this.model + " " + this.speed;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }


    @Override
    public String toString() {
        return name  +
                "\nCompany:" + company.toString() +
                "\nCar:" + car.toString() +
                "\nPokemon:" + pokemonsToString() +
                "\nParents:" + parentsToString() +
                "\nChildren:" + childrenToString();
    }
}
