import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static StringBuilder sb = new StringBuilder();
	private static int N, arr[], result[];
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			result = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			solve();
		}
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (result[j] == 0 || result[j] > arr[i]) {
					result[j] = arr[i];
					break;
				}
			}
//			System.out.println(Arrays.toString(result));
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (result[i] > 0) cnt++;
		}
		sb.append(cnt).append("\n");
	}
}
