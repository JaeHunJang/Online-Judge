import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T, N, X, K, cups[], nowPosotion;
	
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	
	static void print() {
		System.out.println(sb.toString());
	}
	
	static void init() throws Exception {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
//			cups = new int[N+1];
//			cups[X] = 1;
			nowPosotion = X;
			solve();
	}
	
	static void solve() throws Exception {
		int from, to;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			swap(from, to);
		}
		
//		for (int i = 1; i < N; i++) {
//			if (cups[i] == 1) {
//				sb.append(i).append("\n");
//				break;
//			}
//		}
		sb.append(nowPosotion);
	}
	
	static void swap(int from, int to) {
		if (from == nowPosotion) {
			nowPosotion = to;
		} else if (to == nowPosotion) {
			nowPosotion = from;
		}
//		int temp = cups[from];
//		cups[from] = cups[to];
//		cups[to] = temp;
	}
}
