package com.supplyboost.Exercises.MultidimensionalArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _6_StringMatrixRotation {


    private static char[][] matrix;
    private static int rotationNumber;
    private static List<String> lines;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("[()]");
        rotationNumber = Integer.parseInt(tokens[1]);

        String token;
        lines = new ArrayList<>();
        while (true){
            token = scanner.nextLine();
            if(token.equals("END")){
                break;
            }
            lines.add(token);
        }

        rotateTheMatrix();
        printTheMatrix();

    }

    private static void constructMatrix() {
        int matrixLength = lines.stream().mapToInt(String::length).max().orElse(0);
        matrix = new char[lines.size()][matrixLength];
        for (int index = 0; index < lines.size(); index++) {
            for (int col = 0; col < matrixLength; col++) {
                if (col < lines.get(index).length()) {
                    matrix[index][col] = lines.get(index).charAt(col);
                } else {
                    matrix[index][col] = ' ';
                }
            }
        }
    }

    private static void rotateTheMatrix() {
        constructMatrix();
        if(lines.size() <= 1000){
            while (rotationNumber >= 90) {
                matrix = rotate90Degrees();  // Rotate 90 degrees
                rotationNumber -= 90;
            }
        }
    }

    private static char[][] rotate90Degrees() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] rotatedMatrix = new char[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rotatedMatrix[col][rows - 1 - row] = matrix[row][col];
            }
        }
        return rotatedMatrix;
    }

    public static void printTheMatrix(){
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
