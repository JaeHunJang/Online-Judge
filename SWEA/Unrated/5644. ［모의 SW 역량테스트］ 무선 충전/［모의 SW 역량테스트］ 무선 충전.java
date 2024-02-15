import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class BatteryCharger implements Comparable<BatteryCharger> { // 무선충전소 클래스
		int x, y, c, p; // 위치 x, y, 범위 c, 충전량 p

		public BatteryCharger(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
		@Override
		public boolean equals(Object obj) {
			BatteryCharger other = (BatteryCharger) obj;
			if (c != other.c)
				return false;
			if (p != other.p)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		@Override
		public int compareTo(BatteryCharger o) {
			return o.p - this.p;
		}
	}
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int T, M, A, pathA[][], pathB[][], result;
	private static BatteryCharger bc[];
	private static int deltas[][] = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
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
			M = Integer.parseInt(st.nextToken()); // 이동거리
			A = Integer.parseInt(st.nextToken()); // 충전소개수
			pathA = new int[M+1][2];
			pathB = new int[M+1][2];
			bc = new BatteryCharger[A];
			
			result = 0; // 최대 충전량
			
			pathA[0][0] = 1;
			pathA[0][1] = 1;
			
			pathB[0][0] = 10;
			pathB[0][1] = 10;
			
			st = new StringTokenizer(br.readLine());
			int d = -1;
			for (int i = 1; i <= M; i++) { // 미리 좌표 계산
				d = Integer.parseInt(st.nextToken());
				pathA[i][0] = pathA[i-1][0] + deltas[d][0];
				pathA[i][1] = pathA[i-1][1] + deltas[d][1];
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				d = Integer.parseInt(st.nextToken());
				pathB[i][0] = pathB[i-1][0] + deltas[d][0];
				pathB[i][1] = pathB[i-1][1] + deltas[d][1];
			}
			
			for (int i = 0; i < A; i++) { // 충전소 배열 초기화
				st = new StringTokenizer(br.readLine());
				bc[i] = new BatteryCharger(
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			
			solve();
			sb.append("\n");
		}
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i <= M; i++) { // 한걸음씩 충전여부 확인
			Queue<BatteryCharger> chargerA = adjBatteryChargerList(pathA[i]);
			Queue<BatteryCharger> chargerB = adjBatteryChargerList(pathB[i]);
			
			if (chargerA.size() > 0 && chargerB.size() > 0) { // 둘다 충전 가능하면 최대 충전량 확인
				result += getMaxCharge(chargerA, chargerB);
			} else if (chargerA.size() > 0) { // 하나만 충전 가능하면 해당 충전량 합산
				result += chargerA.peek().p;
			} else if (chargerB.size() > 0) {
				result += chargerB.peek().p;
			}
		}
		sb.append(result);
	}

	private static int getMaxCharge(Queue<BatteryCharger> chargerA, Queue<BatteryCharger> chargerB) {
		int max = 0;
		for (BatteryCharger bcA : chargerA) { // 완전탐색으로 가장 큰 충전량 찾기
			for (BatteryCharger bcB : chargerB) { 
				int temp = 0;
				if (bcA.equals(bcB)) { // 같은 충전소면 1개 충전소만 값을 넣음 (2로 나누기 안해줘도 됨)
					temp = bcA.p;
				} else { // 다른 충전소면 각각 더해줌
					temp = bcA.p + bcB.p;
				}
				max = Math.max(temp, max); // 최대값
			}
		}
		
		return max;
	}
	
	private static Queue<BatteryCharger> adjBatteryChargerList(int[] step) { // 해당 좌표에서 충전 가능한 충전소 목록 반환
		Queue<BatteryCharger> list = new PriorityQueue<>();
		for (int i = 0; i < A; i++) {
			if ((Math.abs(bc[i].x - step[1]) + Math.abs(bc[i].y - step[0])) <= bc[i].c) {
				list.add(bc[i]);
			}
		}
		return list;
	}
}