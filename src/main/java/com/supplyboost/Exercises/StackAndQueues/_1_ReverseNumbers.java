package com.supplyboost.Exercises.StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _1_ReverseNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        String[] numbersAsChars = input.split("\\s");
        for(String number : numbersAsChars){
            numbersStack.push(Integer.parseInt(number));
        }
        for(Integer number : numbersStack){
            System.out.print(numbersStack.pop() + " ");
        }
    }
}
