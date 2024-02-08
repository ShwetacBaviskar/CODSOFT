import java.util.Scanner;
public class gradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         // Input: Take marks obtained (out of 100) in each subject.
        System.out.println("Enter marks obtained in each subject (out of 100):");
        int totalMarks = 0;
        int[] marks = new int[6];
        String[] subjects = {"Maths", "Science", "English", "Sanskrit","marathi","Geography"};

        for (int i = 0; i < 6; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter marks for " + subjects[i] + ": ");
                int input = scanner.nextInt();
                if (input >= 0 && input <= 100) {
                    marks[i] = input;
                    totalMarks += marks[i];
                    validInput = true;
                } else {
                    System.out.println("Marks should be within the range of 0 to 100. Please try again.");
                }
            }
        }

        // Calculate Total Marks
        double averagePercentage = (double) totalMarks / 4;

        // Display Total Marks and Average Percentage
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Grade Calculation: Assign grades based on the average percentage achieved.
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Grade
        System.out.println("Your Grade: " + grade);

        scanner.close();
    }
}

