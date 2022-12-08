import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Day5 {
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<Stack<String>> stacks1 = new ArrayList<Stack<String>>();
		ArrayList<Stack<String>> stacks2 = new ArrayList<Stack<String>>();
		// Populate stacks with start data
		String[][] startData = { { "W", "D", "G", "B", "H", "R", "V" }, { "J", "N", "G", "C", "R", "F" },
							{ "L", "S", "F", "H", "D", "N", "J" }, { "J", "D", "S", "V" },
							{ "S", "H", "D", "R", "Q", "W", "N", "V" }, { "P", "G", "H", "C", "M" },
							{ "F", "J", "B", "G", "L", "Z", "H", "C" }, { "S", "J", "R" },
							{ "L", "G", "S", "R", "B", "N", "V", "M" } };

		for (int i = 0; i < startData.length; i++) {
			stacks1.add(new Stack<String>());
			stacks2.add(new Stack<String>());
		}

		for (int i = 0; i < startData.length; i++) {
			for (int j = 0; j < startData[i].length; j++) {
				stacks1.get(i).add(startData[i][j]);
				stacks2.get(i).add(startData[i][j]);
			}

		}
		

		File file = new File("/Users/oppenheimerj/eclipse-workspace/AdventOfCode/src/input_d5.txt");
		Scanner myReader = new Scanner(file);
		
		while (myReader.hasNextLine()) {
			// Get the assignment pairs and calculate overlap
			String data = myReader.nextLine();
			String[] line = data.split(" ");
			System.out.println(Arrays.toString(line));
			int moveCount = Integer.parseInt(line[1]);
			int sourceStack = Integer.parseInt(line[3]) - 1;
			int destStack = Integer.parseInt(line[5]) - 1;
			
			
			// Star 1 Code 
			for (int i = 0; i < moveCount; i++) {
				stacks1.get(destStack).add(stacks1.get(sourceStack).pop());
			}
			
			// Star 2 Code 
			ArrayList<String> crates = new ArrayList<>();
			for(int i=0; i< moveCount; i++) {
				crates.add(stacks2.get(sourceStack).pop());
			}
			for(int i=crates.size()-1; i>=0; i--) {
				stacks2.get(destStack).add(crates.get(i));
			}

		}
		myReader.close();

		String answer1 = "";
		for (int i = 0; i < startData.length; i++) {
			answer1 += stacks1.get(i).peek();
		}
		System.out.println(answer1);
		
		String answer2 = "";
		for (int i = 0; i < startData.length; i++) {
			answer2 += stacks2.get(i).peek();
		}
		System.out.println(answer2);

	}
}
