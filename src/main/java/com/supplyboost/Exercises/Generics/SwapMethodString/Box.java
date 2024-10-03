package com.supplyboost.Exercises.Generics.SwapMethodString;

public class Box<T> {

    private T typeData;


    public T getTypeData() {
        return typeData;
    }

    public void setTypeData(T typeData) {
        this.typeData = typeData;
    }


    @Override
    public String toString() {
        return getTypeData().getClass().getName() + ": " + getTypeData();
    }
}
