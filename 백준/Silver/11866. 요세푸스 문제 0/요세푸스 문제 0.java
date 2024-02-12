import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, K;
	private static Queue<Integer> q;
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
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
	}
	
	private static void solve() {
		sb.append("<");
		int count = 1;
		while (q.size() > 1) {
			if (count++ % K == 0) {
				sb.append(q.poll()).append(", ");
			} else {
				q.offer(q.poll());
			}
		}
		sb.append(q.poll()).append(">");
	}
}
