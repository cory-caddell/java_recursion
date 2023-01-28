//CoryCaddellAssignment1A.java

public class CoryCaddellAssignment1A {
	
	public static int coryCaddellMethod(char letter, String word) {
		
		int low = 0;
		int high = word.length() - 1;
		int count = 0;
		return coryCaddellMethod(letter, word, low, high, count);
	}
	
	public static int coryCaddellMethod(char letter, String word, int low, int high, int count) {
		
		if (low > high) {
			return count;
		}
		
		if (word.charAt(low) == letter) {
			count++;
		}

		return coryCaddellMethod(letter, word, low + 1, high, count);
	}
	
	public static void coryCaddellTable(String word, int n) {
		
		char[] alphabet = new char[52]; 
		alphabet = coryCaddellUnicodeArray(alphabet, 0, alphabet.length - 1, (char)65);
		
		if (n < alphabet.length) {
			System.out.printf("%-20s%d\n", alphabet[n], coryCaddellMethod(alphabet[n], word));
			coryCaddellTable(word, n + 1);
		}
	}
	
	public static char[] coryCaddellUnicodeArray(char[] array, int index, int end, char unicodeVal) {
		
		if (index > end) {
			return array;
		}
		
		if (index == 26) {
			unicodeVal = (char)97;
		}
		
		array[index] = unicodeVal;

		return coryCaddellUnicodeArray(array, index + 1, array.length - 1, (char) (unicodeVal + 1));
	}
	
	public static void main (String[] args) {
		
		String[] words = { "cat", "dog", "Azalea", "Programming", "Supercalifragilisticexpialidocious"};
		
		for (String word : words) {
			System.out.println(word);
			System.out.printf("%-20s%s\n", "Letter", "Number");
			coryCaddellTable(word, 0);
			System.out.println();
		}
	}
}