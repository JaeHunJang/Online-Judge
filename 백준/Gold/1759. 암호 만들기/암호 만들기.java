import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static StringBuilder sb2 = new StringBuilder();
	private static int L;
	private static int C;
	private static String[] arr;
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		printResult();
	}
	private static void printResult() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = br.readLine().split(" ");
		
		Arrays.sort(arr);
	}
	private static void solve() {
		combination(0, "");
	}
	
	public static void combination(int start, String pw) {
		if (pw.length() == L) {
			sb2.append(pw);
			String temp = pw.replaceAll("[aeiou]", ""); // 자음만 남김
			// 자음이 2개 이상, 모음이 1개 이상인것만 저장
			if (temp.length() >=2 && pw.length() - temp.length() >=1) {
				sb.append(pw).append("\n");
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			combination(i+1, pw + arr[i]);
		}
	}
}