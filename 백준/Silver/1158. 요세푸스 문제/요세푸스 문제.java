import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int K;
	private static Queue<Integer> queue;
	private static int count;
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
		N = Integer.parseInt(st.nextToken()); // N명
		K = Integer.parseInt(st.nextToken()); // K번째
		count = 1; // 현재 몇번째인지
		queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) { // 1 ~ N명
			queue.add(i);
		}
	}
	
	private static void solve() {
		sb.append("<");
		while (!queue.isEmpty()) {
			if (count++ % K == 0) { // K번째 사람인지 확인
				sb.append(queue.poll()).append(", ");
			} else {
				queue.offer(queue.poll());
			}
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		sb.append(">");
		
	}
}