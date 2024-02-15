import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T, H, W, r, c;
	private static char map[][];
	private static int deltas[][] = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static String command = "SUDLR", direction = " ^v<>";
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // 맵의 높이
			W = Integer.parseInt(st.nextToken()); // 맵의 너비
			map = new char[H][W]; // 맵
			
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			a:for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (direction.contains(map[i][j]+"")) {
						r = i; // 탱크 시작 좌표
						c = j;
						break a;
					}
				}
			}
			
			br.readLine();
			solve();
			sb.append("\n");
		}
	}
	
	private static void solve() throws Exception {
		for (String input : br.readLine().split("")) { // 명령어 입력받는 대로 처리
			if ("S".equals(input)) { // 포탄 발사
				int[] d = deltas[direction.indexOf(map[r][c]+"")];
				int nr = r + d[0];
				int nc = c + d[1];
				while (isIn(nr, nc)) {
					if ('*' == map[nr][nc]) { // 벽 부수기
						map[nr][nc] = '.';
						break;
					} else if ('#' == map[nr][nc]) { // 벽 못부수고 포탄 폭발
						break;
					}
					nr += d[0]; // 폭탄 직선으로 계속 이동
					nc += d[1];
				}
			} else { // 이동
				char tank = direction.charAt(command.indexOf(input));
				int[] d = deltas[direction.indexOf(tank+"")];
				int nr = r + d[0];
				int nc = c + d[1];
				if (isIn(nr, nc) && map[nr][nc] == '.') { // 평지면 이동
					map[r][c] = '.';
					map[nr][nc] = tank;
					r = nr;
					c = nc;
				} else { // 못가면 방향만 전환
					map[r][c] = tank;
				}
				
			}
		}
		for (int i = 0; i < H; i++) {
			sb.append(map[i]).append("\n");
		}
		sb.deleteCharAt(sb.lastIndexOf("\n"));
	}
	
	private static boolean isIn(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}