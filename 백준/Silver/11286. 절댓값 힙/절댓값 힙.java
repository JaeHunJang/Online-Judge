import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static PriorityQueue<Integer> pq;
	private static String command;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		pq = new PriorityQueue<>(new Comparator<Integer>() { // 절대값 힙
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) { // 절대값이 같은게 여러개면
					return o1 - o2; // 실제 숫자가 작은 것으로 정렬
				}
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		N = Integer.parseInt(br.readLine()); // 숫자
		
		command = "";
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) {
			command = br.readLine();
			if (!"0".equals(command)) {
				pq.add(Integer.parseInt(command));
			} else {
				if (pq.isEmpty()) sb.append("0");
				else sb.append(pq.poll());
				sb.append("\n");
			}
		}
	}
}