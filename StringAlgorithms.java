import java.util.Collection;
import java.util.HashMap;
import java.util.Arrays;


/* These problems are all taken from Cracking the Coding Interview, 5th Ed */
public class StringAlgorithms {

    /* Given a string, check to see if all of the characters are unique. 
       Time Complexity:  O(n) where n is string length.
       Space Complexity: O(n) 
       */
    public static boolean allUnique(String s) {
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars.containsKey(c)) {
                return false;

            }
            else {
                chars.put(c, 1);
            }
        }
        return true;

    }

    /* Given two strings, check to see if one is a permutation of another.
       Complexity:  O(n log n) where n is string length. 
       */
    public static boolean isPermutation(String s1, String s2) {
        // First check for the simple case -- if the lengths are different, return false.
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

    /*  Given a string, check to see if the characters can be used (in any order) to form a palindrome.
        Count the occurrences of each character. At most, a palindrome can only have 1 letter with an
        odd number of occurrences.
        Time Complexity: O(N)
        */
    public static boolean isPalindrome(String s1) {
        
        s1 = s1.toLowerCase();  // O(n) 
        HashMap<Character, Integer> map = mapString(s1);
        return hasMultipleOddCounts(map);   
        
    }

    public static HashMap<Character,Integer> mapString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {  // O(n)
            char c = s.charAt(i);
            // Ignore spaces. 
            if (c == ' ') continue;
            Integer value = map.get(c); //O(1)
            if (value != null) {  
                map.put(c, value + 1); //O(1)
            }
            else {
                map.put(c, 1);  //O(1)
            }

        }
        return map;
    }

    public static boolean hasMultipleOddCounts(HashMap<Character, Integer> map) {
        int oddCount = 0;
        Collection<Integer> values = map.values();  //O(n)
        for (int val:values) {  //O(n)
            if (val % 2 == 1) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;

    }


    /* Run methods on some test cases. Run with java -ea StringAlgorithms to check assertions. */
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


        s = "taco cat";
        boolean pal = isPalindrome(s);
        assert pal;

        s = "loopy";
        pal = isPalindrome(s);
        assert !pal;
    }


}