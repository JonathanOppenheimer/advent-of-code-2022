import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
	public static void main(String[] args) {
		ArrayList<Integer> calorieCounts = new ArrayList<>();
		calorieCounts.add(0);

		// Read the file with elf calorie information and populate the arraylist with
		// elves total calorie counts
		try {
			File file = new File("/Users/oppenheimerj/eclipse-workspace/AdventOfCode/src/input_d1.txt");
			Scanner myReader = new Scanner(file);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();

				// File contains a space so calorie counts are for a new elf
				if (data.equals("")) {
					calorieCounts.add(0);
				} else {
					calorieCounts.set(calorieCounts.size() - 1,
										calorieCounts.get(calorieCounts.size() - 1) + Integer.parseInt(data));
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Sort the array for larger values
		Collections.sort(calorieCounts);

		// Print the elf carrying the most calories
		System.out.println(calorieCounts.get(calorieCounts.size() - 1));

		// Get the total calorie count carried by the top three elves
		int totalCalories = 0;
		for (int i = 1; i < 4; i++) {
			totalCalories += calorieCounts.get(calorieCounts.size() - i);
		}

		// Print the total calories carried by the three 'fattest' elves
		System.out.println(totalCalories);
	}
}
