import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day3 {
	public static void main(String[] args) {

		// First star code
		int prioritySum = 0;
		try {
			File file = new File("/Users/oppenheimerj/eclipse-workspace/AdventOfCode/src/input_d3.txt");
			Scanner myReader = new Scanner(file);

			while (myReader.hasNextLine()) {
				// Get the compartments of the rucksacks
				String data = myReader.nextLine();
				String compartment1 = data.substring(0, data.length() / 2);
				String compartment2 = data.substring(data.length() / 2, data.length());

				// Populate a hashmap with the number of each item type in compartment1
				HashMap<Character, Integer> contents1 = new HashMap<>();
				for (int i = 0; i < compartment1.length(); i++) {
					if (contents1.get(compartment1.charAt(i)) == null) { // Item type hasn't been added to contents
						contents1.put(compartment1.charAt(i), 1);
					} else {
						contents1.put(compartment1.charAt(i), contents1.get(compartment1.charAt(i)) + 1); // Increment
																											// the count
																											// by 1
					}
				}

				// Populate a hashmap with the number of each item type in compartment2
				HashMap<Character, Integer> contents2 = new HashMap<>();
				for (int i = 0; i < compartment2.length(); i++) {
					if (contents2.get(compartment2.charAt(i)) == null) { // Item type hasn't been added to contents
						contents2.put(compartment2.charAt(i), 1);
					} else {
						contents2.put(compartment2.charAt(i), contents2.get(compartment2.charAt(i)) + 1); // Increment
																											// the count
																											// by 1
					}
				}

				// Check which keys are in both sets
				for (char key : contents1.keySet()) {
					if (contents2.get(key) != null) {
						prioritySum += convertLetterToPriority(key);
					}
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Print the total priority of all the matching items
		System.out.println(prioritySum);

		try {
			File file = new File("/Users/oppenheimerj/eclipse-workspace/AdventOfCode/src/input_d3.txt");
			Scanner myReader = new Scanner(file);

			while (myReader.hasNextLine()) {
				// Get the compartments of the rucksacks
				String data = myReader.nextLine();
				String compartment1 = data.substring(0, data.length() / 2);
				String compartment2 = data.substring(data.length() / 2, data.length());

				// Populate a hashmap with the number of each item type in compartment1
				HashMap<Character, Integer> contents1 = new HashMap<>();
				for (int i = 0; i < compartment1.length(); i++) {
					if (contents1.get(compartment1.charAt(i)) == null) { // Item type hasn't been added to contents
						contents1.put(compartment1.charAt(i), 1);
					} else {
						contents1.put(compartment1.charAt(i), contents1.get(compartment1.charAt(i)) + 1); // Increment
																											// the count
																											// by 1
					}
				}

				// Populate a hashmap with the number of each item type in compartment2
				HashMap<Character, Integer> contents2 = new HashMap<>();
				for (int i = 0; i < compartment2.length(); i++) {
					if (contents2.get(compartment2.charAt(i)) == null) { // Item type hasn't been added to contents
						contents2.put(compartment2.charAt(i), 1);
					} else {
						contents2.put(compartment2.charAt(i), contents2.get(compartment2.charAt(i)) + 1); // Increment
																											// the count
																											// by 1
					}
				}

				// Check which keys are in both sets
				for (char key : contents1.keySet()) {
					if (contents2.get(key) != null) {
						prioritySum += convertLetterToPriority(key);
					}
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Second star code

		int totalBadgeValues = 0;
		try {
			File file = new File("/Users/oppenheimerj/eclipse-workspace/AdventOfCode/src/input_d3.txt");
			Scanner myReader = new Scanner(file);

			while (myReader.hasNextLine()) {
				// Get the first three rucksacks for a group of elves
				String elf1Sack = myReader.nextLine();
				String elf2Sack = myReader.nextLine();
				String elf3Sack = myReader.nextLine();

				// Populate badge type hash maps for each of the three elves
				HashMap<Character, Integer> contents1 = new HashMap<>();
				for (int i = 0; i < elf1Sack.length(); i++) {
					contents1.put(elf1Sack.charAt(i), 1);
				}
				HashMap<Character, Integer> contents2 = new HashMap<>();
				for (int i = 0; i < elf2Sack.length(); i++) {
					contents2.put(elf2Sack.charAt(i), 1);
				}
				HashMap<Character, Integer> contents3 = new HashMap<>();
				for (int i = 0; i < elf3Sack.length(); i++) {
					contents3.put(elf3Sack.charAt(i), 1);
				}

				// Find the matching badge types
				for (char key : contents1.keySet()) {
					if ((contents2.get(key) != null) && (contents3.get(key) != null)) {
						totalBadgeValues += convertLetterToPriority(key);
					}
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		// Print the total badge values
		System.out.println(totalBadgeValues);

	}

	/**
	 * Given a letter, return the integer priority corresponding to it
	 * 
	 * Lowercase item types a through z have priorities 1 through 26. Uppercase item
	 * types A through Z have priorities 27 through 52.
	 * 
	 * @param givenLetter - the provided letter
	 * @return the priority
	 */
	public static int convertLetterToPriority(char givenLetter) {
		int asciiValue = (int) givenLetter;
		if (asciiValue >= 97) {// Letter is a lowercase letter (e.g. a is 97 and should be 1)
			return (asciiValue - 96);
		} else { // Letter is an uppercase letter (A is 65 and should be 27)
			return (asciiValue - 38);
		}
	}
}
