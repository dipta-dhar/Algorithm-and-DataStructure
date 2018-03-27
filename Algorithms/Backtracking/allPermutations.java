package Backtracking;


import java.util.HashSet;
import java.util.Set;

public class allPermutations {

	public static Set<String> crunchifyPermutation(String str) {
		Set<String> crunchifyResult = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			crunchifyResult.add("");
			return crunchifyResult;
		}
 
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = crunchifyPermutation(rem);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				crunchifyResult.add(crunchifyCharAdd(newString, firstChar, i));
			}
		}
		return crunchifyResult;
	}
 
	public static String crunchifyCharAdd(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}
	
	public static void main(String[] args) {
		String str = "abc";
		
		System.out.println("\nString: " + str + "\nPermutations: " + crunchifyPermutation(str));
	}
}