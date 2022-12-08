import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day6 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/Users/oppenheimerj/eclipse-workspace/AdventOfCode/src/input_d6.txt");
		Scanner myReader = new Scanner(file);
		String data = myReader.nextLine();
		myReader.close();

		int index_flag = -1;
		int index_message = -1;
		boolean flag_set = false; 
		boolean message_set = false; 
		for (int i = 0; i < data.length(); i++) {
			if (isUniqueFlag(data.substring(i, i + 4)) && !flag_set) {
				index_flag = i + 4;
				flag_set = true; 
			}
			if (isUniqueMessage(data.substring(i, i + 14)) && !message_set) {
				index_message = i + 14;
				message_set = true; 
			}
			
			if(flag_set && message_set) {
				break; 
			}
		}
		
		System.out.println(index_flag);
		System.out.println(index_message);
	}

	public static boolean isUniqueFlag(String lastFour) {
		Set<Character> letters = new HashSet<Character>();
		System.out.println(lastFour);
		for (int i = 0; i < lastFour.length(); i++) {
			letters.add(lastFour.charAt(i));
		}
		System.out.println(letters);
		return letters.size() == 4;
	}

	public static boolean isUniqueMessage(String lastFourteen) {
		Set<Character> letters = new HashSet<Character>();
		System.out.println(lastFourteen);
		for (int i = 0; i < lastFourteen.length(); i++) {
			letters.add(lastFourteen.charAt(i));
		}
		System.out.println(letters);
		System.out.println(letters.size());
		return (letters.size() == 14);
	}
}
