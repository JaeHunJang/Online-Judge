import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int alpha[];
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	static void print() {
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		alpha = new int[26];
		for (char c : br.readLine().toUpperCase().toCharArray()) {
			alpha[c-'A']++;
		}
	}
	
	static void solve() throws Exception {
		int max = Arrays.stream(alpha).max().getAsInt();
		int cnt = 0;
		int idx = -1;
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] == max) {
				cnt++;
				idx = i;
			}
		}
		System.out.println(cnt > 1 ? "?" : (char)(idx+'A'));
	}
}