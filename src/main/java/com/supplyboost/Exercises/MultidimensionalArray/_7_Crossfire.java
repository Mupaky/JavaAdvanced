package com.supplyboost.Exercises.MultidimensionalArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _7_Crossfire {

    private static List<List<String>> matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int matrixRow = Integer.parseInt(dimensions[0]);
        int matrixColumn = Integer.parseInt(dimensions[1]);

        if (matrixRow >= 2 && matrixRow <= 100 && matrixColumn >= 2 && matrixColumn <= 100) {
            matrix = new ArrayList<>();
            fillMatrix(matrixRow, matrixColumn);

            while (true) {
                String token = scanner.nextLine();
                if (token.equals("Nuke it from orbit")) {
                    break;
                }

                String[] coordinates = token.split("\\s+");

                try {
                    int row = Integer.parseInt(coordinates[0]);
                    int col = Integer.parseInt(coordinates[1]);
                    int radius = Integer.parseInt(coordinates[2]);

                    destroyElements(row, col, radius);
                } catch (NumberFormatException e) {
                    // Invalid input, skip to next command
                }
            }

            printTheMatrix();
        }
    }

    // Function to fill the matrix with increasing numbers
    public static void fillMatrix(int rows, int cols) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            List<String> currentRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                currentRow.add(String.valueOf(number++));
            }
            matrix.add(currentRow);
        }
    }

    // Function to destroy elements in a cross-like pattern
    private static void destroyElements(int targetRow, int targetCol, int radius) {
        // Destroy cells vertically
        for (int row = targetRow - radius; row <= targetRow + radius; row++) {
            if (isInBounds(row, targetCol)) {
                matrix.get(row).set(targetCol, null);
            }
        }

        // Destroy cells horizontally
        for (int col = targetCol - radius; col <= targetCol + radius; col++) {
            if (isInBounds(targetRow, col)) {
                matrix.get(targetRow).set(col, null);
            }
        }

        // Remove destroyed cells and empty rows
        cleanMatrix();
    }

    // Check if the given coordinates are within the matrix bounds
    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    // Clean the matrix by removing null elements and empty rows
    private static void cleanMatrix() {
        for (int row = 0; row < matrix.size(); row++) {
            matrix.get(row).removeIf(e -> e == null);
        }
        matrix.removeIf(List::isEmpty);
    }

    // Function to print the matrix
    public static void printTheMatrix() {
        for (List<String> row : matrix) {
            System.out.println(String.join(" ", row));
        }
    }
}
