import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class BatteryCharger implements Comparable<BatteryCharger> {
		int x, y, c, p;

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
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			pathA = new int[M+1][2];
			pathB = new int[M+1][2];
			bc = new BatteryCharger[A];
			
			result = 0;
			
			pathA[0][0] = 1;
			pathA[0][1] = 1;
			
			pathB[0][0] = 10;
			pathB[0][1] = 10;
			
			st = new StringTokenizer(br.readLine());
			int d = -1;
			for (int i = 1; i <= M; i++) {
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
			
			for (int i = 0; i < A; i++) {
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
		for (int i = 0; i <= M; i++) {
			Queue<BatteryCharger> chargerA = isInBc(pathA[i]);
			Queue<BatteryCharger> chargerB = isInBc(pathB[i]);
			
			if (chargerA.size() > 0 && chargerB.size() > 0) {
				result += getMaxCharge(chargerA, chargerB);
			} else if (chargerA.size() > 0) {
				result += chargerA.peek().p;
			} else if (chargerB.size() > 0) {
				result += chargerB.peek().p;
			}
		}
		sb.append(result);
	}

	private static int getMaxCharge(Queue<BatteryCharger> chargerA, Queue<BatteryCharger> chargerB) {
		int max = 0;
		for (BatteryCharger bcA : chargerA) {
			for (BatteryCharger bcB : chargerB) {
				int temp = 0;
				if (bcA.equals(bcB)) {
					temp = bcA.p;
				} else {
					temp = bcA.p + bcB.p;
				}
				max = Math.max(temp, max);
			}
		}
		
		return max;
	}
	
	private static Queue<BatteryCharger> isInBc(int[] step) {
		Queue<BatteryCharger> list = new PriorityQueue<>();
		for (int i = 0; i < A; i++) {
			if ((Math.abs(bc[i].x - step[1]) + Math.abs(bc[i].y - step[0])) <= bc[i].c) {
				list.add(bc[i]);
			}
		}
		return list;
	}
}