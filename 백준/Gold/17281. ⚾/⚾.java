import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, playerResult[][], selectedPlayer[], totalPlayer, base[], maxScore;
	static final int MAX_OUT_COUNT = 3, BASE_COUNT = 3;
	static boolean visited[];
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
		N = Integer.parseInt(st.nextToken()); // 이닝 숫자
		totalPlayer = 9; // 선수 총 인원
		playerResult = new int[N][totalPlayer]; // 선수의 결과
		
		selectedPlayer = new int[totalPlayer]; // 타순 결정
		visited = new boolean[totalPlayer];
		
		base = new int[BASE_COUNT]; // 1~3루
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < totalPlayer; j++) {
				playerResult[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxScore = 0; // 저장할 최고 점수
	}
	
	private static void solve() throws Exception {
		selectedPlayer[3] = 0; // 1번 선수(인덱스 0)은 4번 타자 고정
		visited[0] = true;
		
		selectPlayer(0);
		sb.append(maxScore);
	}
	
	private static void simulation() {
		int p = 0; // player 타순을 가져올 인덱스, 다음 이닝에도 이어져야함
		int score = 0; // 현재 타순으로 나온 경기 결과 점수
		for (int inning = 0; inning < N; inning++) {
			Arrays.fill(base, 0);
			int out = 0; // out 이 3회가 될때까지 이닝 결과 반복
			while (out < MAX_OUT_COUNT) {
				if (playerResult[inning][selectedPlayer[p]] == 0) { // 선수의 결과가 아웃일때
					out++;
				} else {
					score += moveBase(playerResult[inning][selectedPlayer[p]]); // 선수의 결과가 타격일때
				}
				p = (p + 1) % totalPlayer;
			}
		}
		maxScore = Math.max(maxScore, score); // 최고점 갱신
	}
	
	private static int moveBase(int cnt) {
		int score = 0;
		for (int i = 0; i < cnt; i++) {
			if (base[2] == 1) { // 3루 주자 > home으로
				score++;
			}
			base[2] = base[1]; // 2루 주자 > 3루로
			base[1] = base[0]; // 1루 주자 > 2루로
			base[0] = 0; // 1루에는 아무도 없음
		}
		if (cnt == 4) { // 홈런은 점수만 올려주기
			score++; 
		} else {
			base[cnt-1] = 1; // 타자, 출루
		}
		return score;
	}
	
	private static void selectPlayer(int cnt) {
		if (cnt == totalPlayer) {
			simulation();
			return;
		}
		
		for (int i = 0; i < totalPlayer; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selectedPlayer[cnt] = i;
			if (cnt == 2) { // 4번 타자는 넘기기
				selectPlayer(cnt+2);
			} else {
				selectPlayer(cnt+1);
			}
			visited[i] = false;
		}
	}
}