package com.supplyboost.Exercises.MultidimensionalArray;

import java.util.Scanner;

public class _4_MaximalSum {

    private static int[][] matrix;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int matrixRow = Integer.parseInt(tokens[0]);
        int matrixColumn = Integer.parseInt(tokens[1]);

        matrix = new int[matrixRow][matrixColumn];
        fillMatrix(scanner);

        checkLargestMatrix3x3();
    }

    public static void fillMatrix(Scanner scanner){
        int matrixLength = matrix.length;
        int row = 0;
        while (matrixLength > 0){
            String[] tokens = scanner.nextLine().split(" ");
            for(int column = 0; column < matrix[0].length; column++) {
                matrix[row][column] = Integer.parseInt(tokens[column]);
            }
            row++;
            matrixLength--;
        }
    }

    public static int sumSquare(int initRow, int initColumn){
        int sum = 0;
        for(int row = initRow; row <= initRow + 2; row++) {
            for(int column = initColumn; column <= initColumn + 2; column++) {
              sum += matrix[row][column];
            }
        }
        return sum;
    }

    public static void checkLargestMatrix3x3(){
        int initRow = 0;
        int initColumn = 0;
        int maxSum = 0;
        for(int row = 0; row < matrix.length - 2; row++) {
            for(int column = 0; column < matrix[0].length - 2; column++) {
                int sum = sumSquare(row, column);
              if(maxSum < sum){
                  initRow = row;
                  initColumn = column;
                  maxSum = sum;
              }
            }
        }

        System.out.println("Sum = " + maxSum);
        printMatrix(initRow, initColumn);

    }

    public static void printMatrix(int row, int column){
        for(int i = row; i < row + 3; i++) {
            for(int j = column; j < column + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
