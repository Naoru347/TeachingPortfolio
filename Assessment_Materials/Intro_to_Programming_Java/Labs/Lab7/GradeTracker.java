// Lab 7: Grade Tracker Starter Program

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Setup
        ArrayList<Integer> grades = new ArrayList<>();
        Collections.addAll(grades, 85, 90, 78, 92, 88);

        // Print initial grades
        System.out.println("Initial grades: " + grades);

        // Calculate average grade
        double average = calculateAverage(grades);
        System.out.println("Average grade: " + average);

        // Step 2: Manipulation
        // TODO: Add, remove, and slice grades

        // Step 3: Analysis
        // TODO: Print pass/fail for each grade
        for (int grade : grades) {
            if (grade >= 70) {
                System.out.println(grade + " is a Pass.");
            } else {
                System.out.println(grade + " is a Fail.");
            }
        }

        // Step 4: User Interaction
        // TODO: Allow user to add a grade
        System.out.print("Enter a new grade to add: ");
        int newGrade = scanner.nextInt();
        grades.add(newGrade);
        System.out.println("Updated grades: " + grades);

        // TODO: Check if a grade exists
        System.out.print("Enter a grade to check: ");
        int checkGrade = scanner.nextInt();
        if (grades.contains(checkGrade)) {
            System.out.println("Grade " + checkGrade + " is in the list.");
        } else {
            System.out.println("Grade " + checkGrade + " is not in the list.");
        }

        // Summary
        gradeSummary(grades);
    }

    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public static void gradeSummary(ArrayList<Integer> grades) {
        int max = Collections.max(grades);
        int min = Collections.min(grades);
        double avg = calculateAverage(grades);

        System.out.println("Highest grade: " + max);
        System.out.println("Lowest grade: " + min);
        System.out.println("Average grade: " + String.format("%.2f", avg));
    }
}
