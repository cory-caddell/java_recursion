//CoryCaddellAssignment1A.java

public class CoryCaddellAssignment1A {
	
	/**
	 * Method to recursively count occurrence of a letter in a word
	 * @param letter count number of occurrences in a word
	 * @param word search word for amount of time letter occurs
	 * @return helper recursive method to count occurrence of a letter in a word
	 */
	public static int coryCaddellMethod(char letter, String word) {
		
		int low = 0;
		int high = word.length() - 1;
		int count = 0;
		return coryCaddellMethod(letter, word, low, high, count);
	}
	
	/**
	 * Helper method to recursively count occurrence of a letter in a word
	 * @param letter count number of occurrences in a word
	 * @param word search word for amount of time letter occurs
	 * @param low current word index
	 * @param high max word index
	 * @param count sum of occurrences of letter in word
	 * @return count
	 */
	public static int coryCaddellMethod(char letter, String word, int low, int high, int count) {
		
		if (low > high) {
			return count;
		}
		
		if (word.charAt(low) == letter) {
			count++;
		}

		return coryCaddellMethod(letter, word, low + 1, high, count);
	}
	
	/**
	 * Method to recursively print number of times a letter occurs in a word in table format
	 * @param word search word for amount of time letter occurs
	 */
	public static void coryCaddellTable(String word) {
		
		char[] alphabet = new char[52]; 
		alphabet = coryCaddellUnicodeArray(alphabet, 0, alphabet.length - 1, (char)65);
		
		int index = 0;
		int max = alphabet.length;
		
		coryCaddellTable(word, alphabet, index, max);
		
	}
		
	/**
	 * Helper method to recursively print number of times a letter occurs in a word in table format
	 * @param word search word for amount of time letter occurs
	 * @param n index to cycle through alphabet array
	 */
	public static void coryCaddellTable(String word, char[] alphabet, int index, int max) {

		if (index < max) {
			System.out.printf("%-20s%d\n", alphabet[index], coryCaddellMethod(alphabet[index], word));
			coryCaddellTable(word, alphabet, index + 1, max);
		}
	}
	
	/** 
	 * Method to fill array with every letter in the alphabet, capitalized and lower case
	 * @param array array to be filled
	 * @param index array index
	 * @param end max array index
	 * @param unicodeVal Letter of alphabet per ASCII table
	 * @return alphabet array
	 */
	public static char[] coryCaddellUnicodeArray(char[] array, int index, int end, char unicodeVal) {
		
		if (index > end) {
			return array;
		}
		
		// skip non-alphabet characters
		if (index == 26) {
			unicodeVal = (char)97;
		}
		
		array[index] = unicodeVal;

		return coryCaddellUnicodeArray(array, index + 1, array.length - 1, (char) (unicodeVal + 1));
	}
	
	/** Program to display amount of times a letter of the alphabet occurs in a given word */
	public static void main (String[] args) {
		
		String[] words = { "cat", "dog", "Azalea", "Programming", "Supercalifragilisticexpialidocious"};
		
		for (String word : words) {
			System.out.println(word);
			System.out.printf("%-20s%s\n", "Letter", "Number");
			coryCaddellTable(word);
			System.out.println();
		}
	}
}