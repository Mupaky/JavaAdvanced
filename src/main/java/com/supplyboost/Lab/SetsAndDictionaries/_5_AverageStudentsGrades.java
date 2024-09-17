package com.supplyboost.Lab.SetsAndDictionaries;

import java.util.*;

public class _5_AverageStudentsGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        while (numberOfStudents > 0){
            String[] tokens = scanner.nextLine().split("\\s");

                studentsGrades.putIfAbsent(tokens[0], new ArrayList<>());
                List<Double> grades = studentsGrades.get(tokens[0]);
                grades.add(Double.parseDouble(tokens[1]));

                studentsGrades.put(tokens[0], grades);
            numberOfStudents--;
        }

        for(Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(grade -> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)\n", getAverageGrade(entry.getValue()));
        }
    }

    private static double getAverageGrade(List<Double> grades) {
        double sumGrades = 0;
        for (Double grade : grades){
            sumGrades += grade;
        }
        return sumGrades / grades.size();
    }
}
