package com.supplyboost.Exercises.Generics.CountMethodStringsAndDoubles;


public class Box<T extends Comparable<T>>  {

    private T typeData;

    public Box(T typeData){
        this.typeData = typeData;
    }


    public T getTypeData() {
        return typeData;
    }

    public void setTypeData(T typeData) {
        this.typeData = typeData;
    }

    public static <T> boolean campareTo(T left, T right){
        System.out.println(left);
        return true;
    }


    @Override
    public String toString() {
        return getTypeData().getClass().getName() + ": " + getTypeData();
    }

    public int compareTo(Box<T> obj){
        return getTypeData().compareTo(obj.getTypeData());
    }

}
