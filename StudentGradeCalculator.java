import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("STUDENT GRADE CALCULATOR");
        System.out.print("Enter the number of sunjects: ");
        
        int numSubjects = scanner.nextInt();

        if(numSubjects <= 0)
        {
            System.out.println("Invalid number of subjects. Please enter a positive number.");
            scanner.close();
            return;
        }

        double totalMarks = 0;

        for(int i=1; i<=numSubjects; i++) 
        {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            double marks = scanner.nextDouble();

            if (marks<0 || marks>100)
            {
                System.out.println("Invaild marks. Marks should be between 0 and 100.");
                scanner.close();
                return;
            }
            totalMarks += marks;
        }

        double averagePercentage=totalMarks / numSubjects;
        String grade;
        if(averagePercentage >= 90)
        {
            grade="A+";
        } else
        if(averagePercentage >= 80)
        {
            grade="A";
        }else
        if(averagePercentage >= 70)
        {
            grade="B";
        }else
        if(averagePercentage >= 60)
        {
            grade="C";
        }else
        if(averagePercentage >= 50)
        {
            grade="D";
        }else
        {
            grade="F";
        }

        System.out.println("RESULTS");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
