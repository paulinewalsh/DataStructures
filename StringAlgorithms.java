import java.util.Hashtable;

public class StringAlgorithms {

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


	public static void main(String[] args) {
		String s = "abcdefg";
		boolean unique = allUnique(s);
		assert unique;

		s = "abaabec";
		unique = allUnique(s);
		assert !unique;
	}


}