import java.util.Scanner;

public class PatternPractice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for the inverted pyramid: ");
        int numRows = scanner.nextInt();

        for (int i = numRows; i >= 1; i--) {
            // Print leading spaces
            for (int j = 1; j <= numRows - i; j++) {
                System.out.print(" ");
            }

            // Print numbers in ascending order
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // Move to the next line
            System.out.println();
        }

        scanner.close();
	}

}
