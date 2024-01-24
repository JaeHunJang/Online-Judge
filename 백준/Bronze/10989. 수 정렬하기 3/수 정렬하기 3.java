import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[] nums;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(br.readLine());
	}

	private static void solve() throws Exception {
		Arrays.sort(nums);
		for (int num : nums)
			sb.append(num).append("\n");
	}
}