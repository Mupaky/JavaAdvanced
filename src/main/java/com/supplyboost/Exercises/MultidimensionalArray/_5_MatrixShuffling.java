package com.supplyboost.Exercises.MultidimensionalArray;

import java.util.Scanner;

public class _5_MatrixShuffling {

    public static final String INVALID = "Invalid input!";
    private static String[][] matrix;
    private static int matrixRow;
    private static int matrixColumn;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s");
        matrixRow = Integer.parseInt(tokens[0]);
        matrixColumn = Integer.parseInt(tokens[1]);

        matrix = new String[matrixRow][matrixColumn];

        fillMatrixA(scanner);

        boolean end = false;

        while (!end){
            String[] command = scanner.nextLine().split("\\s");
            switch (command[0]){
                case "swap":
                    if(command.length == 5){
                        try{
                            String variable = matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])];
                            matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])] = matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])];
                            matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])] = variable;
                            printTheMatrix();
                        }catch (ArrayIndexOutOfBoundsException e){
                            System.out.println(INVALID);
                        }
                    }else {
                        System.out.println(INVALID);
                    }
                    break;
                case "END":
                    return;
                default:
                    System.out.println(INVALID);
                    break;
            }
        }



    }

    public static void fillMatrixA(Scanner scanner){
        int linesToRead = matrixRow;
        int row = 0;
        while (linesToRead > 0){
            String[] tokens = scanner.nextLine().split("\\s");
            for(int column = 0; column <= matrix[0].length - 1; column++){
                matrix[row][column] = tokens[column];
            }
            linesToRead--;
            row++;
        }

    }

    public static void printTheMatrix(){
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
