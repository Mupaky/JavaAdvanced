package com.supplyboost.Exercises.StackAndQueues;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _8_InfixToPostfix {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s");

        Deque<String> outputQueue  = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        for (String token : tokens){
            if(token.length() > 1){
                outputQueue.offer(token);
            }else {
                if(isOperator(token)){
                    if(operatorStack.isEmpty()){
                        operatorStack.push(token);
                    }else{
                        while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")
                              && hasPrecedence(token, operatorStack.peek())){
                            outputQueue.offer(operatorStack.pop());
                        }
                        operatorStack.push(token);
                    }
                }else if (token.equals("(")) {
                    operatorStack.push(token);
                } else if (token.equals(")")) {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        outputQueue.offer(operatorStack.pop());
                    }
                    operatorStack.pop();
                } else {
                    outputQueue.offer(token);
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }

        while (!outputQueue.isEmpty()) {
            System.out.printf("%s ", outputQueue.poll());
        }
        System.out.println();

    }

    private static boolean isOperator(String operator) {
        return (operator.equals("+")) || (operator.equals("-")) || ( operator.equals("*")) || (operator.equals("/"));
    }

    private static boolean hasPrecedence(String operator1, String operator2) {
        return (!operator1.equals("*") && !operator1.equals("/")) || (!operator2.equals("+") && !operator2.equals("-"));
    }

}
