import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static char[] word;
	private static int[] chars;
	
	public static void main(String[] args) throws Exception {
		init();
		printResult();
	}
	private static void printResult() {
		for (int i = 0; i < chars.length; i++) {
			sb.append(chars[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception {
		chars = new int[26];
		Arrays.fill(chars, -1);
		word = br.readLine().toCharArray();
		solve();
	}
	
	private static void solve() {
		for (int i = 0; i < word.length; i++) {
			if (chars[word[i]-'a'] == -1)
				chars[word[i]-'a'] = i; 
		}
	}
}