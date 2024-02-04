import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int[] nums;
	private static int count;
	
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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		nums = new int[N+1];
		count = 0;
		for(int i = 1; i <= N; i++) {
			nums[i] = i; 
		}
	}
	private static void solve() {
		for (int i = M; i <= N; i++) {
			if (nums[i] <= 1) continue;
			count++;
			if (isPrime(i)) {
				sb.append(i).append("\n");
				filter(i, i+i);
			}
		}
	}
	
	private static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void filter(int num, int start) {
		for (int i = start; i < N; i+=start) {
			if (nums[i] <= 1) continue;
			if (nums[i] % num == 0) {
				nums[i] = 0;
			}
		}
	}
}