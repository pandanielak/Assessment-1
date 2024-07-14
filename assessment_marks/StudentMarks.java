import java.util.Scanner;

public class StudentMarks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Asking for assignment name
        System.out.print("Enter the assignment name: ");
        String assignmentName = scanner.nextLine();
        
        // Array for student marks
        int[] studentMarks = new int[30];
        
        // Input marks for 30 students
        for (int i = 0; i < 30; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter mark for student " + (i + 1) + " (0-30): ");
                if (scanner.hasNextInt()) {
                    int mark = scanner.nextInt();
                    if (mark >= 0 && mark <= 30) {
                        studentMarks[i] = mark;
                        validInput = true;
                    } else {
                        System.out.println("Error: Invalid mark. Marks must be between 0 and 30.");
                    }
                } else {
                    System.out.println("Error: Invalid input. Please enter a number between 0 and 30.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }
        
      
        int highestMark = studentMarks[0];
        int lowestMark = studentMarks[0];
        
        // Finding the highest and lowest marks
        for (int i = 1; i < studentMarks.length; i++) {
            if (studentMarks[i] > highestMark) {
                highestMark = studentMarks[i];
            }
            if (studentMarks[i] < lowestMark) {
                lowestMark = studentMarks[i];
            }
        }
        
       // Calculating sum of marks
        int sumOfMarks = 0;
        for (int i = 0; i < studentMarks.length; i++) {
            sumOfMarks += studentMarks[i];
        }
        
        // Calculating mean
        double assignmentMean = (double) sumOfMarks / studentMarks.length;
        
        // Calculating sum of squared differences from the mean
        double sumOfSquaredDifferences = 0;
        for (int i = 0; i < studentMarks.length; i++) {
            double difference = studentMarks[i] - assignmentMean;
            sumOfSquaredDifferences += difference * difference;
        }
        
        // Calculating variance
        double variance = sumOfSquaredDifferences / studentMarks.length;
        
        // Calculating standard deviation
        double standardDeviation = Math.sqrt(variance);
        
        // Print assignment name and student marks
        System.out.println("Assignment Name: " + assignmentName);
        System.out.println("Student Marks: ");
        for (int i = 0; i < 30; i++) {
            System.out.println("Student " + (i + 1) + ": " + studentMarks[i]);
        }
        
        // Print highest and lowest marks
        System.out.println("Highest Mark: " + highestMark);
        System.out.println("Lowest Mark: " + lowestMark);

        // Print mean and standard deviation
        System.out.println("Mean: " + assignmentMean);
        System.out.println("Standard Deviation: " + standardDeviation);
        
        scanner.close();
    }
}