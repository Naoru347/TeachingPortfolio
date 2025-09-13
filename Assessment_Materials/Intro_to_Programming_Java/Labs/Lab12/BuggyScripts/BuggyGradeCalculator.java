import java.util.Scanner;

public class BuggyGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter grades separated by commas (e.g., 85,90,78): ");
        String gradesInput = scanner.nextLine();
        String[] grades = gradesInput.split(",");

        int total = 0;

        for (String grade : grades) {
            int numericGrade = Integer.parseInt(grade.trim());

            if (numericGrade < 0 || numericGrade > 100) {
                // Runtime Error: Placeholder-style string, but no formatting used
                System.out.println("Invalid grade found: %d", numericGrade);
                continue;
            }

            // Logic Error: grade (String) is added instead of numericGrade (int)
            total += grade;
        }

        // Logic Error: Divides by total number of entries, not number of valid grades
        double average = total / grades.length;

        System.out.printf("The average grade is: %.2f%n", average);
    }
}
