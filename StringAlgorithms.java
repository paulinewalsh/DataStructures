import java.util.Hashtable;
import java.util.Arrays;

public class StringAlgorithms {

	// Complexity:  O(n) where n is string length
	public static boolean allUnique(String s) {
		Hashtable<String, Integer> chars = new Hashtable<String, Integer>();

		for (int i = 0; i < s.length(); i++) {
			String c = Character.toString(s.charAt(i));
			if (chars.contains(c)) {
				return true;
			}
			else {
				chars.put(c, 1);
			}
		}
		return false;

	}


	// Complexity:  O(n log n) where n is string length
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] c1 = s1.toCharArray();  //O(n) 
		char[] c2 = s2.toCharArray();  // O(n)

		Arrays.sort(c1);  //O(n log n)
		Arrays.sort(c2);  //O(n log n)

		for (int i = 0; i < c1.length; i++) {  //O(n)
			if (c1[i] != c2[i]) {
				return false;
			}
		}
		return true;
	}



	public static void main(String[] args) {
		String s = "abcdefg";
		boolean unique = allUnique(s);
		assert unique;

		s = "abaabec";
		unique = allUnique(s);
		assert !unique;


		String s1 = "abcdefg";
		String s2 = "gfabedc";
		boolean perm = isPermutation(s1, s2);
		assert perm;

		s2 = "hijklmno";
		perm = isPermutation(s1, s2);
		assert !perm;
	}


}