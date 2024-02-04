import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static int N;
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
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		count = 0;
	}
	private static void solve() {
		for (int i = 0; i < N; i++) {
			if (nums[i] <= 1) continue;
			if (isPrime(nums[i])) {
				count++;
			}
		}
		sb.append(count);
	}
	
	private static boolean isPrime(int num) {
		for (int i =2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}