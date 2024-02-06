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
	private static int M;
	private static int R;
	private static String[][] map;
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
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		R = Integer.parseInt(st.nextToken()); // 연산 수
		
		map = new String[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = st.nextToken();
			}
		}
		st = new StringTokenizer(br.readLine());
	}
	
	private static void solve() {
		for (int r = 0; r < R; r++) {
			
			switch(st.nextToken()) {
			case "1": map = reverseRow(map); break;
			case "2": map = reverseCol(map); break;
			case "3": map = rotate90(map); break;
			case "4": map = rotate90(rotate90(rotate90(map)));
						break;
			case "5": map = scaleRotate90(map); break;
			case "6": map = scaleRotate90(scaleRotate90(scaleRotate90(map)));break;
			}
		}
		printArr();
	}
	
	private static String[][] reverseRow(String[][] map) {
		String[][] copyMap = new String[map.length][map[0].length];
		int N = copyMap.length-1;
		for (int i = 1; i <= N; i++) {
			copyMap[i] = map[N-i+1];
		}
		return copyMap;
	}
	
	private static String[][] reverseCol(String[][] map) {
		String[][] copyMap = new String[map.length][map[0].length];
		int N = copyMap.length-1;
		int M = copyMap[0].length-1;
		for (int j = 1; j <= M; j++) {
			for (int i = 1; i <= N; i++) {
				copyMap[i][j] = map[i][M-j+1];
			}
		}
		return copyMap;
	}
	
	private static String[][] rotate90(String[][] map) {
		String[][] copyMap = new String[map[0].length][map.length];
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				copyMap[j][map.length-i] = map[i][j];
			}
		}
		
		return copyMap;
	}
	
	private static String[][] scaleRotate90(String[][] map) {
		Queue<String> q = pull();
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[0].length; j++) {
				map[i][j] = q.poll();
			}
		}
		
		return map;
	}
	private static Queue<String> pull() {
		Queue<String> q = new LinkedList<>();
		for (int i = map.length/2+1; i < map.length; i++) {
			for (int j = 1; j < map[i].length/2+1; j++) {
				q.add(map[i][j]);
			}
			for (int j = 1; j < map[i].length/2+1; j++) {
				q.add(map[i-map.length/2][j]);
			}
		}
		for (int i = map.length/2+1; i < map.length; i++) {
			for (int j = map[i].length/2+1; j < map[i].length; j++) {
				q.add(map[i][j]);
			}
			for (int j = 1; j < map[i].length/2+1; j++) {
				q.add(map[i-map.length/2][map[i].length/2+j]);
			}
		}	
		return q;
	}
	
	private static void printArr() {
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}
}