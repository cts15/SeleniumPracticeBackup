import java.util.Scanner;

public class PatternPractice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for the pyramid: ");
        int numRows = scanner.nextInt();
        
        for (int i = 1; i <= numRows; i++) {
            // Print leading spaces
            for (int j = 1; j <= numRows - i; j++) {
                System.out.print(" ");
            }
            
            // Print numbers in ascending order
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            
            // Print numbers in descending order (excluding 1)
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }
            
            // Move to the next line
            System.out.println();
        }
        
        scanner.close();
		
	}

}
