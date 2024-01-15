
public class SmallestNumberInMatrix {
	
	public static void main(String[] args) {
        // Create a 3x3 matrix and initialize it with values
        int[][] matrix = {
            {5, 8, 3},
            {2, 9, 1},
            {4, 7, 6}
        };

        // Initialize the minimum value to the maximum possible integer value
        int min = Integer.MAX_VALUE;

        // Iterate through the matrix to find the smallest number
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        // Print the smallest number
        System.out.println("The smallest number in the matrix is: " + min);
    } 

}
