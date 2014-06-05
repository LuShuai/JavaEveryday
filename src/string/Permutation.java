package string;
import java.util.LinkedList;

public class Permutation{

	public static LinkedList<String> permutations(String s) {
		LinkedList<String> res = new LinkedList<String>();
		if (s == null || s.length() == 0) {
			return res;
		}
		getAllPermutations("", s, res);
		return res;
	}
	
	private static void getAllPermutations(String left, String right, LinkedList<String> res) {
		if (right.length() == 0) {
			res.add(left);
			return;
		}
		for (int n = 0; n < right.length(); n++) {
			getAllPermutations(left + right.charAt(n), right.substring(0,n) + right.substring(n+ 1, right.length()), res);
		}
	}
	
	public static void main(String[] args) {
		for (String s : permutations("abc")) {
			System.out.println(s);
		}
	}

}
