import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int K;
	private static long T;
	private static long[] sharks;
	private static Stack<Long> minStack;
	private static Stack<Long> maxStack;
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
		T = Long.parseLong(st.nextToken());
		sharks = new long[N];
		minStack = new Stack<>();
		maxStack = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sharks[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void solve() {
		Arrays.sort(sharks); // 상어 오름차순 정렬
		for (int i = 0; i < N; i++) { // 먼저 먹을 수 있는 상어를 전부 넣어둠
			minStack.push(sharks[i]);
		}
		for (int i = 0; i < N; i++) { 
			if (minStack.peek() >= T) { // 샼보다 큰 상어를 빼서 따로 넣어둠
				maxStack.push(minStack.pop());
			}
		}
		
		for (int i = 0; i < K; i++) { // 상어 먹기 시작
			while (!maxStack.isEmpty() && maxStack.peek() < T) { // 샼보다 작은 상어가 큰 상어목록에 있으면 작은 상어목록으로 옮기기
				minStack.push(maxStack.pop());
			}
			if (!minStack.isEmpty()){ // 나보다 작은 상어 먹기
				T += minStack.pop();
			} else {
				break;
			}
		}
		sb.append(T);
	}
}