import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static PriorityQueue<int[]> pq;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
	}
	

	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (pq.isEmpty()) sb.append(0);
				else sb.append(pq.poll()[1]);
				sb.append("\n");
			} else {
				pq.add(new int[]{Math.abs(num), num});
			}
		}
	}
}
