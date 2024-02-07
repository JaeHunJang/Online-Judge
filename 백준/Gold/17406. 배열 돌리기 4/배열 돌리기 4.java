import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int M;
	private static int K;
	private static int depth;
	private static int result;
	private static String[][] map;
	private static int[][] commands;
	private static boolean[] visited;
	private static int[] indexs;
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
		K = Integer.parseInt(st.nextToken()); // 연산 회수
		
		map = new String[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = st.nextToken();
			}
		}
		
		commands = new int[K][3]; // 연산 저장
		indexs = new int[K]; // 연산 순서
		visited = new boolean[K]; // 연산 사용여부
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			commands[i][0] = Integer.parseInt(st.nextToken()); // 위치 결정자
			commands[i][1] = Integer.parseInt(st.nextToken()); // 위치 결정자
			commands[i][2] = Integer.parseInt(st.nextToken()); // 회전 회수
		}
		
		result = Integer.MAX_VALUE;
	}
	
	private static void solve() throws Exception {
		perm(0);
		sb.append(result);
	}
	
	/**
	 * 연산 순서 결정
	 * @param count
	 */
	private static void perm(int count) {
		if (count == K) {
			rotateCall();
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (visited[i]) continue;
			indexs[count] = i;
			visited[i] = true;
			perm(count+1);
			visited[i] = false;
		}
	}
	
	/**
	 * 받아온 연산 순서에 맞게 배열 회전
	 */
	private static void rotateCall() {
		int r,c,s;
		String[][] copyMap = copyMap();
		for (int i = 0; i < K; i++) {
			r = commands[indexs[i]][0];
			c = commands[indexs[i]][1];
			s = commands[indexs[i]][2];
			depth = Math.min(r+s+1,c+s+1) / 2; // 재귀 호출 횟수
			rotate(copyMap,r-s,c-s,r+s,c+s,1,1); // 복사한 배열과 회전시킬 위치 전달, 회전횟수는 1회 고정
		}
		sumArr(copyMap);
	}
	
	/**
	 * 1칸씩 회전하는 함수
	 * @param map 회전시킬 배열
	 * @param x 배열을 회전시킬 첫번재 index
	 * @param y 배열을 회전시킬 첫번재 index
	 * @param N 배열을 회전시킬 크기
	 * @param M 배열을 회전시킬 크기
	 * @param count 배열을 회전시킬 횟수
	 * @param d 재귀 호출 횟수
	 */
	private static void rotate(String[][] map, int x, int y, int N, int M, int count, int d) {
		if (!isIn(x, y) || !isIn(N, M)) return; 
		int i = x, j = y;
		String temp = ""; // 이전 칸 원소
		String temp2 = ""; // 다음 칸 원소
		for (int cnt = 0; cnt < count; cnt++) {
			temp = map[i][j];
			while (j < M) { // 오른쪽으로 한칸씩
				temp2 = map[i][++j];
				map[i][j] = temp;
				temp = temp2;
			}
			temp = temp2; // 모서리 저장
			while (i < N) { // 아래로 한칸씩
				temp2 = map[++i][j];
				map[i][j] = temp;
				temp = temp2; // 다음칸 저장
			}
			temp = temp2; // 모서리 저장
			while (j > y) { // 왼쪽으로 한칸씩
				temp2 = map[i][--j];
				map[i][j] = temp;
				temp = temp2;
			}
			temp = temp2; // 모서리 저장
			while (i > x) { // 위로 한칸씩
				temp2 = map[--i][j];
				map[i][j] = temp;
				temp = temp2;
			}
		}
		if (d < depth) {
			rotate(map, x+1, y+1, N-1, M-1, count, d+1);
		}
	}

	
	/**
	 * 넘겨받은 배열의 행 합 중 최소값을 갱신하는 함수
	 * @param map 원본 배열
	 */
	private static void sumArr(String[][] map) {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum = 0;
			for (int j = 1; j <= M; j++) {
				sum += Integer.parseInt(map[i][j]);
			}
			result = Math.min(result, sum);
		}
	}
	
	/**
	 * 배열을 복사하는 함수
	 * @return 복사한 배열
	 */
	private static String[][] copyMap() {
		String[][] copyMap = new String[N+1][M+1];
		for (int j = 0; j < copyMap.length; j++) {
			copyMap[j] = map[j].clone();
		}
		return copyMap;
	}
	
	private static boolean isIn(int i, int j) {
		return i >= 1 && i <= N && j >= 1 && j <= M;
	}
}