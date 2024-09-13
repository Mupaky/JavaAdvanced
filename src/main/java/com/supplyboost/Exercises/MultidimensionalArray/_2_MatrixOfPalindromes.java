package com.supplyboost.Exercises.MultidimensionalArray;

import java.util.Scanner;

public class _2_MatrixOfPalindromes {

    private static char letterRow = 'a';
    private static char letterColumn = 'a';
    private static String[][] palindromMatrix;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");

        int matrixRow = Integer.parseInt(tokens[0]);
        int matrixColumn = Integer.parseInt(tokens[1]);
        palindromMatrix = new String[matrixRow][matrixColumn];

        makePalindromMatrix();
        printMatrix();
    }

    public static void makePalindromMatrix(){
        for(int row = 0; row < palindromMatrix.length; row++) {
            for(int column = 0; column < palindromMatrix[0].length; column++) {
              palindromMatrix[row][column] = "" + letterRow + letterColumn + letterRow;
              letterColumn++;
            }
            letterRow++;
            letterColumn = letterRow;
        }
    }

    public static void printMatrix(){
        for(int i = 0; i < palindromMatrix.length; i++) {
            for(int j = 0; j < palindromMatrix[0].length; j++) {
                System.out.print(palindromMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
