package com.supplyboost.Exercises.StackAndQueues;

import java.util.*;


public class _2_BasicQueueOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();

        // Stack to track opening parentheses
        Deque<Character> stack = new ArrayDeque<>();

        // Flag to track whether input is valid
        boolean isValid = true;

        // Iterate through the entire input string
        for (int i = 0; i < firstInput.length(); i++) {
            char current = firstInput.charAt(i);

            // Push opening parentheses onto the stack
            if (current == '{' || current == '[' || current == '(') {
                stack.push(current);
            }
            // For closing parentheses, check if it matches the top of the stack
            else if (current == '}' || current == ']' || current == ')') {
                if (stack.isEmpty()) {
                    isValid = false;  // No matching opening parenthesis
                    break;
                }
                char top = stack.pop();
                if ((current == '}' && top != '{') ||
                        (current == ']' && top != '[') ||
                        (current == ')' && top != '(')) {
                    isValid = false;  // Mismatch found
                    break;
                }
            }
        }

        // After processing, the stack should be empty if the input is valid
        if (isValid && stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
