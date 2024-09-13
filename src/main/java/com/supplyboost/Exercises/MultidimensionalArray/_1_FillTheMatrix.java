package com.supplyboost.Exercises.MultidimensionalArray;

import java.util.Scanner;

public class _1_FillTheMatrix {

    private static int[][] matrix;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(tokens[0]);

        matrix = new int[matrixSize][matrixSize];

        switch (tokens[1]){
            case "A":
                fillMatrixA();
                break;
            case "B":
                fillMatrixB();
                break;
            default:
                break;
        }
        printTheMatrix();
    }

    public static void fillMatrixA(){
        int number = 1;
        for(int column = 0; column <= matrix.length - 1; column++){
            for(int row = 0; row <= matrix.length - 1; row++){
                matrix[row][column] = number;
                number++;
            }
        }
    }

    public static void fillMatrixB(){
        int number = 1;
        for(int column = 0; column <= matrix.length - 1; column++){
            if(column % 2 == 0){
                for(int row = 0; row <= matrix.length - 1; row++){
                    matrix[row][column] = number;
                    number++;
                }
            }else{
                for(int row = matrix.length - 1; row >= 0; row--){
                    matrix[row][column] = number;
                    number++;
                }
            }
        }
    }

    public static void printTheMatrix(){
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
