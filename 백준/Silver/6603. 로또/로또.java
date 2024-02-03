import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	private static int K;
	private static int C;
	private static int[] arr;
	private static int[] nums;
	
	public static void main(String[] args) throws Exception {
		init();
		
		printResult();
	}
	private static void printResult() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception {
		C = 6;
		while (true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			
			if (K == 0) {
				sb.deleteCharAt(sb.lastIndexOf("\n"));
				break;
			}
			arr = new int[K];
			nums = new int[C];
			
			for (int i = 0; i < K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			solve();
			sb.append("\n");
		}
	}
	private static void solve() {
		combination(nums, 0, 0);
	}
	
	public static void combination(int[] nums, int start, int count) {
		if (count == 6) {
			for (int i : nums) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < K; i++) {
			nums[count] = arr[i];
			combination(nums, i+1, count+1);
		}
	}
}