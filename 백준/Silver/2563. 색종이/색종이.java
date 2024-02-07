import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int[][] map;
	private static final int WHITE_MAX_SIZE = 100;
	private static final int BLACK_MAX_SIZE = 10;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		N = Integer.parseInt(br.readLine()); // 색종의 개수
		
		map = new int[WHITE_MAX_SIZE+1][WHITE_MAX_SIZE+1]; // 흰색 도화지
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			paste(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		sb.append(
				Arrays.stream(map)
				.flatMap(arr -> Arrays.stream(arr).boxed())
				.mapToInt(Integer::intValue)
				.sum()
				);
	}
	
	private static void paste(int i, int j) {
		for (int x = i; x < i+BLACK_MAX_SIZE; x++) {
			for (int y = j; y < j+BLACK_MAX_SIZE; y++) {
				map[x][y] = 1;
			}
		}
	}
}