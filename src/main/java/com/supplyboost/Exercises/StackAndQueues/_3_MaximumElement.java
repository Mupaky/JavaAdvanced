package com.supplyboost.Exercises.StackAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class _3_MaximumElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        String input;
        Deque<Integer> numbersStack = new ArrayDeque<>();

        while (commandsCount != 0){
            input = scanner.nextLine();
            String[] inputs = input.split("\\s");
            switch (inputs[0]){
                case "1":
                    numbersStack.push(Integer.parseInt(inputs[1]));
                    break;
                case "2":
                    numbersStack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbersStack));
                    break;
                default:
                    break;
            }
            --commandsCount;
        }

    }
}
