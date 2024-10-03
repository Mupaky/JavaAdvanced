package com.supplyboost.Exercises.Generics.CustomList;

public class CustomList<T extends Comparable<T>> {
    private Object[] elements;
    private int size;

    // Default initial capacity
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    public CustomList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Add an element to the list
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Get an element at a specific index
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Remove an element at a specific index
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];

        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        // Null out the last element and decrease size
        elements[--size] = null;

        return removedElement;
    }

    public boolean contains(T element){
        for(int index = 0; index <= elements.length - 1; index++){
            if(element.compareTo((T)elements[index]) == 0){
                return true;
            }
        }
        return false;
    }

    public void swap(int x, int y){
        checkIndex(x);
        checkIndex(y);
        T element = get(x);
        elements[x] = elements[y];
        elements[y] = element;
    }

    public int count(T comparing){
        int count = 0;
        for(int index = 0; index < size(); index++){
            if(comparing.compareTo(get(index)) < 0){
                count++;
            }
        }
        return count;
    }

    public T getMin(){
        T min = get(0);
        for(int index = 1; index < size(); index++){
            if(min.compareTo(get(index)) > 0){
                min = get(index);
            }
        }
        return min;
    }

    public T getMax(){
        T max = get(0);
        for(int index = 1; index < size(); index++){
            if(max.compareTo(get(index)) < 0){
                max = get(index);
            }
        }
        return max;
    }

    protected transient int modCount = 0;

    // Get the current size of the list
    public int size() {
        return size;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Clear all elements from the list
    public void clear() {
        // Null out all elements for garbage collection
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Ensure there's enough capacity to add a new element
    private void ensureCapacity() {
        if (size == elements.length) {
            // Double the capacity
            int newCapacity = elements.length * 2;
            Object[] newArray =  new Object[newCapacity];

            // Copy old elements to the new array
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }

            elements = newArray;
        }
    }

    // Check if the index is within bounds
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + ", Size " + size);
        }
    }

    // Convert the list to a string representation
    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);

            if (i != size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
