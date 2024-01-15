
public class MinMaxInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Create a 3x3 matrix and initialize it with values
        int[][] matrix = {
            {5, 8, 3},
            {2, 9, 1},
            {4, 7, 6}
        };

        // Initialize variables to keep track of minimum number and its indices
        int min = Integer.MAX_VALUE;
        int minRowIndex = 0;
        int minColIndex = 0;

        // Find the minimum number and its indices
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minRowIndex = i;
                    minColIndex = j;
                }
            }
        }

        // Initialize variables to keep track of maximum number in the row and column
        int maxInRow = Integer.MIN_VALUE;
        int maxInColumn = Integer.MIN_VALUE;

        // Find the maximum number in the row identified by minRowIndex
        for (int j = 0; j < 3; j++) {
            if (matrix[minRowIndex][j] > maxInRow) {
                maxInRow = matrix[minRowIndex][j];
            }
        }

        // Find the maximum number in the column identified by minColIndex
        for (int i = 0; i < 3; i++) {
            if (matrix[i][minColIndex] > maxInColumn) {
                maxInColumn = matrix[i][minColIndex];
            }
        }

        // Print the results
        System.out.println("Minimum number in the matrix: " + min);
        System.out.println("Maximum number in the row of the minimum number: " + maxInRow);
        System.out.println("Maximum number in the column of the minimum number: " + maxInColumn);
	}

}
