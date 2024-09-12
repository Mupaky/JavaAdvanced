package com.supplyboost.Exercises.StackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _7_SimpleTextEditor {

    public static final int MAXEXTENTS = 1000000;
    public static final int PARAMETERIZATION = 1;

    private static StringBuilder text;
    private static Deque<String> memorizedText;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputLines = Integer.parseInt(scanner.nextLine());

        if(inputLines < 1 || inputLines > 105){
            return;
        }

        text = new StringBuilder();
        memorizedText = new ArrayDeque<>();
        memorizedText.push("");

        while (inputLines > 0){
            commands(scanner.nextLine().split("\\s"));
            --inputLines;
        }
    }

    public static void commands(String[] commands){

        switch (Integer.parseInt(commands[0])){
            case 1:
                if (commands[PARAMETERIZATION].matches("^[a-zA-Z]+$")
                        && commands[PARAMETERIZATION].length() <= MAXEXTENTS) {
                    text.append(commands[1]);
                    memorizedText.push(text.toString());
                }
                break;
            case 2:
                if(Integer.parseInt(commands[1]) <= text.length()){
                    text.delete((text.length()) - Integer.parseInt(commands[1]), text.length());
                    memorizedText.push(text.toString());
                }
                break;
            case 3:
                System.out.println(text.charAt(Integer.parseInt(commands[1]) - 1));
                break;
            case 4:
                if(memorizedText.size() > 1) {
                    memorizedText.pop();
                    text.delete(0, text.length());
                    text.append(memorizedText.peek());
                }
                break;
            default:
                break;
        }
    }
}
