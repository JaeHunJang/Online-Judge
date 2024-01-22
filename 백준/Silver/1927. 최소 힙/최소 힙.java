import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>();
	}
	

	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (pq.isEmpty()) sb.append(0);
				else sb.append(pq.poll());
				sb.append("\n");
			} else {
				pq.add(num);
			}
		}
	}
}