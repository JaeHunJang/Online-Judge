import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, L, fruits[];
	private static boolean visited[];
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
		N = Integer.parseInt(st.nextToken()); // 과일개수
		L = Integer.parseInt(st.nextToken()); // 현재 새의 길이
		fruits = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(fruits); // 과일 오름차순으로 정렬
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) {
			if (fruits[i] <= L) { // 새보다 작은 과일 먹기
				L++;
			}
		}
		sb.append(L);
	}
}