package com.supplyboost.Exercises.StackAndQueues;

import java.util.*;

public class _6_RecursiveFibonacci {
    private static long[] memo;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();

        int inputNumber = Integer.parseInt(firstInput);

        if(inputNumber >= 1 && inputNumber <= 49){
            inputNumber++;
            memo = new long[inputNumber + 1];
            Arrays.fill(memo, -1);
            System.out.println(getFibonacci(inputNumber));
        }
    }

    public static long getFibonacci(int maxNumber){
        if(memo[maxNumber] != -1){
            return memo[maxNumber];
        }

        // Base cases
        if (maxNumber <= 1) {
            return maxNumber;
        }

        memo[maxNumber] = getFibonacci(maxNumber - 1) + getFibonacci(maxNumber - 2);
        return memo[maxNumber];

    }

}
