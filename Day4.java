import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/Users/oppenheimerj/eclipse-workspace/AdventOfCode/src/input_d4.txt");
		Scanner myReader = new Scanner(file);
		
		int fullyOverlappingPairs = 0; 
		int fullyDistinctPairs = 0; 
		int totalPairs = 0; 
		 
		while (myReader.hasNextLine()) {
			// Get the assignment pairs and calculate overlap 
			String data = myReader.nextLine();
			totalPairs++; 
			
			String[] pairRanges = data.split(","); 
			String[] elf1Assignment = pairRanges[0].split("-"); 
			String[] elf2Assignment = pairRanges[1].split("-"); 
			
			int elf1Lower = Integer.parseInt(elf1Assignment[0]); // Elf 1 lower assignment 
			int elf1Upper = Integer.parseInt(elf1Assignment[1]); // Elf 1 upper assignment
			int elf2Lower = Integer.parseInt(elf2Assignment[0]); // Elf 2 lower assignment
			int elf2Upper = Integer.parseInt(elf2Assignment[1]); // Elf 2 upper assignment 
			
			
			// Count fully overlapping pairs 
			if((elf1Lower <= elf2Lower && elf2Upper <= elf1Upper) || (elf2Lower <= elf1Lower && elf1Upper <= elf2Upper)) {
				fullyOverlappingPairs++; 
			}
			
			
			// Count distinct pairs 
			if((elf1Upper < elf2Lower) || (elf2Upper < elf1Lower)) {
				fullyDistinctPairs++; 
			}
		}
		myReader.close();
		
		// Get star 1 answer
		System.out.println(fullyOverlappingPairs); 
		// Get star 2 answer 
		System.out.println(totalPairs - fullyDistinctPairs); 
	}

}
