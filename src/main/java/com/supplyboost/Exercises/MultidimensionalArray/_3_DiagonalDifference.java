package com.supplyboost.Exercises.MultidimensionalArray;

import java.util.Scanner;

public class _3_DiagonalDifference {

    private static int[][] matrix;
    private static int matrixLength;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        matrixLength = Integer.parseInt(scanner.nextLine());
        matrix = new int[matrixLength][matrixLength];

        fillMatrix(scanner);
        System.out.println(Math.abs(leftDiagonal()-rightDiagonal()));

    }

    public static void fillMatrix(Scanner scanner){
        int row = 0;
        while (matrixLength > 0){
            String[] tokens = scanner.nextLine().split(" ");
            for(int column = 0; column < matrix.length; column++) {
                matrix[row][column] = Integer.parseInt(tokens[column]);
            }
            row++;
            matrixLength--;
        }
        matrixLength = matrix.length;
    }

    public static int rightDiagonal(){
        int rightToLeft = 0;
        int column = matrix.length - 1;
        for(int row = 0; row < matrix.length; row++) {
            rightToLeft += matrix[row][column];
            column--;
        }
        return rightToLeft;
    }

    public static int leftDiagonal(){
        int leftToRight = 0;
        for(int index = 0; index < matrix.length; index++) {
          leftToRight += matrix[index][index];
        }
        return leftToRight;
    }

}
