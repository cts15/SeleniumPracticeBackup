import java.util.HashMap;
import java.util.Map;

public class UniqueNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3, 2, 4, 1, 5, 6, 7, 8, 7, 8, 9, 10, 9};

        // Create a HashMap to store the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each number in the array
        for (int num : array) {
            // If the number is not present in the map, put it with a count of 1
            // If it is already in the map, increment its count by 1
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Print unique numbers and their frequencies
        System.out.println("Unique Numbers and their Frequencies:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            System.out.println(number + " occurs " + frequency + " times.");
        }
	}

}
 