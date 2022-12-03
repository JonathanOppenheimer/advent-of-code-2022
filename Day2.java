import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
	public static void main(String[] args) {
		int firstTotalScore = 0;
		int secondTotalScore = 0;


		// Read the rock paper scissors strategy guide and simulate the total score if
		// the games followed the guide
		try {
			File file = new File("/Users/oppenheimerj/eclipse-workspace/AdventOfCode/src/input_d2.txt");
			Scanner myReader = new Scanner(file);

			while (myReader.hasNextLine()) {
				// Get the two moves for the elf and me
				String data = myReader.nextLine();
				String[] moves = data.split(" ");
				String elfMove = moves[0];
				String myMove = moves[1];

				// First star code

				/*
				 * The score for a single round is the score for the shape you selected (1 for
				 * Rock, 2 for Paper, and 3 for Scissors) plus the score for the outcome of the
				 * round (0 if you lost, 3 if the round was a draw, and 6 if you won).
				 */

				/*
				 * Elf moves: A - Rock B - Paper C - Scissors
				 * 
				 * My moves: X - Rock Y - Paper Z - Scissors
				 */
				switch (myMove) {
				case "X": // I play rock
					firstTotalScore += 1;
					switch (elfMove) {
					case "A": // Elf plays rock
						firstTotalScore += 3;
						break;
					case "B": // Elf plays paper
						firstTotalScore += 0;
						break;
					case "C": // Elf plays scissors
						firstTotalScore += 6;
						break;
					}
					break;
				case "Y": // I play paper
					firstTotalScore += 2;
					switch (elfMove) {
					case "A": // Elf plays rock
						firstTotalScore += 6;
						break;
					case "B": // Elf plays paper
						firstTotalScore += 3;
						break;
					case "C": // Elf plays scissors
						firstTotalScore += 0;
						break;
					}
					break;
				case "Z": // I play scissors
					firstTotalScore += 3;
					switch (elfMove) {
					case "A": // Elf plays rock
						firstTotalScore += 0;
						break;
					case "B": // Elf plays paper
						firstTotalScore += 6;
						break;
					case "C": // Elf plays scissors
						firstTotalScore += 3;
						break;
					}
					break;
				}

				// Second star code
			
				/*
				 * Elf moves: A - Rock B - Paper C - Scissors
				 * 
				 * What X, Y, Z mean X - need to lose (0 points) Y - need to draw (3 points) Z -
				 * need to win (6 points)
				 * 
				 * Response moves: Rock - 1 point Paper - 2 points Scissors - 3 points
				 */

				switch (elfMove) {
				case "A": // Elf plays rock
					switch (myMove) {
					case "X": // I must lose
						secondTotalScore += 0;
						// I will play scissors
						secondTotalScore += 3;
						break;
					case "Y": // I must draw
						secondTotalScore += 3;
						// I will play rock
						secondTotalScore += 1;
						break;
					case "Z": // I must win
						secondTotalScore += 6;
						// I will play paper
						secondTotalScore += 2;
						break;
					}
					break;
				case "B": // Elf plays paper
					switch (myMove) {
					case "X": // I must lose
						secondTotalScore += 0;
						// I will play rock
						secondTotalScore += 1;
						break;
					case "Y": // I must draw
						secondTotalScore += 3;
						// I will play paper
						secondTotalScore += 2;
						break;
					case "Z": // I must win
						secondTotalScore += 6;
						// I will play scissors
						secondTotalScore += 3;
						break;
					}
					break;
				case "C": // Elf plays scissors
					switch (myMove) {
					case "X": // I must lose
						secondTotalScore += 0;
						// I will play paper
						secondTotalScore += 2;
						break;
					case "Y": // I must draw
						secondTotalScore += 3;
						// I will play scissors
						secondTotalScore += 3;
						break;
					case "Z": // I must win
						secondTotalScore += 6;
						// I will play rock
						secondTotalScore += 1;
						break;
					}
					break;
				}

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		// Print the total score for the first star 
		System.out.println(firstTotalScore);
		
		// Print the total score for the second star 
		System.out.println(secondTotalScore);
	}
}
