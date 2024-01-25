import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int[] nums;
	public static void main(String[] args) throws Exception {
		solve();
		System.out.println(sb.toString());
	}	

	private static void solve() throws Exception {
		while (true) {
			String line = br.readLine();
			if ("0 0 0".equals(line)) break;
			st = new StringTokenizer(line, " ");
			nums = new int[3];
			for (int i = 0; i < 3; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			if (Math.pow(nums[2], 2) == (Math.pow(nums[0], 2) + Math.pow(nums[1], 2))) {
				sb.append("right\n");
			} else {
				sb.append("wrong\n");
			}
		}
	}
}
