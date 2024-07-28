import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// A와 B 2
public class Main {
	static StringBuilder sb = new StringBuilder();
	static String input, answer;
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		answer = br.readLine();

		dfs(0, answer);
		System.out.println(ans);
	}

	static void dfs(int cnt, String make) {
		if (ans == 1) return;
		if (cnt == answer.length()-input.length()) {
			if (input.equals(make)) ans = 1;

			return;
		}

		StringBuilder sb = new StringBuilder();
		if (make.charAt(make.length()-1) == 'A') dfs(cnt+1, sb.append(make).deleteCharAt(make.length()-1).toString());
		sb.setLength(0);
		sb.append(make);
		if (make.charAt(0) == 'B') dfs(cnt+1, sb.deleteCharAt(0).reverse().toString());
	}
}
