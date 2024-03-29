import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1786. 찾기 / 100분 
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int pi[], count;
	static List<Integer> list;
	
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		String pattern = br.readLine();
		pi = new int[pattern.length()];
		list = new ArrayList<>();
		
		findSub(pattern);
		kmp(target,pattern);
	}
	
	static void findSub(String pattern) {
		int n = pattern.length();
		// j = 접두사, i = 접미사
		int j = 0;
		for (int i = 1; i < n; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
	}
	
	static void kmp(String target, String pattern) {
		int n = target.length();
		int m = pattern.length();
		// j = 접두사, i = 접미사
		int j = 0;
		for (int i = 0; i < n; i++) {
			while(j > 0 && target.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if (target.charAt(i) == pattern.charAt(j)) {
				if (j == m - 1) {
					count++;
					list.add(i-j+1);
					j = pi[j];
				} else j++;
			}
		}
		sb.append(count).append("\n");
		for (int num : list) {
			sb.append(num).append(" ");
		}
	}
}