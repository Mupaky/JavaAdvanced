package com.supplyboost.Exercises.StackAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class _4_BasicStackOperations {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();



        Deque<Integer> numbersStack = new ArrayDeque<>();

        String[] inputs = firstInput.split("\\s");
        String[] numbersAsChars = secondInput.split("\\s");

        int maxInputNumbers = (Integer.parseInt(inputs[0])) ;
        int numbersToBeRemoved = (Integer.parseInt(inputs[1]));
        int presentNumber = (Integer.parseInt(inputs[2]));

        for(int index = 0; index <= maxInputNumbers - 1; index++){
            numbersStack.push(Integer.parseInt(numbersAsChars[index]));
        }
        while(numbersToBeRemoved > 0){
            numbersStack.pop();
            --numbersToBeRemoved;
        }
        if(numbersStack.contains(presentNumber)){
            System.out.println(true);
        }else if(numbersStack.isEmpty()){
            System.out.println(0);
        }else {
            System.out.println(Collections.min(numbersStack));
        }

    }
}
