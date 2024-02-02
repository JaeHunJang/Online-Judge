import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static long A;
	private static long B;
	private static long minCount;
	private static String temp;
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
		A = Long.parseLong(st.nextToken()); // 시작값
		B = Long.parseLong(st.nextToken()); // 목표값
		minCount = 1;
		temp = "";
	}
	
	private static void solve() {
		while (B > A) {
			temp = B+"";
			if (temp.length() > 1 && temp.endsWith("1"))
				B = Long.parseLong(temp.substring(0, temp.length()-1));
			else if (B % 2 == 0){
				B /= 2;
			} else {
				minCount = -1;
				break;
			}
			minCount++;
		}
		if (B == A)
			sb.append(minCount);
		else
			sb.append(-1);
	}
}