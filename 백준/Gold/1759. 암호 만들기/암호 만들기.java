import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int L, C;
	private static char characters[], password[];
	private static String vowel = "aeiou";
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // 암호 길이
		C = Integer.parseInt(st.nextToken()); // 암호 조합 문자

		password = new char[L];
		characters = br.readLine().replaceAll(" ", "").toCharArray();
		Arrays.sort(characters);
	}
	
	private static void solve() throws Exception {
		combi(0, 0, 0);
	}
	
	private static void combi(int cnt, int start, int vowelCount) {
		if (cnt == L) {
			if (vowelCount >= 1 && L - vowelCount >= 2)
				sb.append(password).append("\n");
			return;
		}
		
		for (int i = start; i < C; i++) {
			password[cnt] = characters[i];
			if (vowel.contains(characters[i] + ""))
				combi(cnt+1, i+1, vowelCount + 1);
			else
				combi(cnt+1, i+1, vowelCount);
		}
	}
}