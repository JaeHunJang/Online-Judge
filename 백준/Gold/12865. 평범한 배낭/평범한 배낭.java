import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, K, wv[][], dp[][], result;
	static Item items[];
	
	static class Item {
		int w, v;

		public Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 물건 개수
		K = Integer.parseInt(st.nextToken()); // 최대 무게
		dp = new int[N+1][K+1];
		
		items = new Item[N+1];
		int w, v;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 무게
			v = Integer.parseInt(st.nextToken()); // 가치
			items[i] = new Item(w,v);
		}
		
		
		result = 0;
		
		solve();
	}
	
	static void solve() throws Exception {
		for (int n = 1; n <= N; n++) {
			for (int w = 1; w <= K; w++) {
				if (items[n].w > w) {
					dp[n][w] = dp[n-1][w];
				} else {
					dp[n][w] = Math.max(items[n].v + dp[n-1][w-items[n].w], dp[n-1][w]);
				}
				result = Math.max(result, dp[n][w]);
			}
		}
		
		sb.append(result);
	}
	
}