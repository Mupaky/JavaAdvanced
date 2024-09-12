package com.supplyboost.Exercises.StackAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _5_BalancedParentheses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int pushCount = Integer.parseInt(tokens[0]);
        int popCount = Integer.parseInt(tokens[1]);
        int findElement = Integer.parseInt(tokens[2]);

        tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (stack.size() < pushCount) {
                stack.push(Integer.parseInt(token));
            }
        }

        for (int i = 0; i < popCount; i++) {
            if (stack.isEmpty()) {
                break;
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(findElement)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }

}
