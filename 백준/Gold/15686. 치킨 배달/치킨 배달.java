import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N, M, minDist;
	private static List<Coordinate> house, chicken;
	private static Coordinate selectedChicken[];
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
		N = Integer.parseInt(st.nextToken()); // 도시 크기
		M = Integer.parseInt(st.nextToken()); // 치킨집 최대 개수 
		minDist = Integer.MAX_VALUE; // 도시의 치킨 거리의 최소값
		selectedChicken = new Coordinate[M]; // 선택된 치킨집 
		
		house = new ArrayList<>(); // 집 좌표들 저장
		chicken = new ArrayList<>(); // 치킨집 좌표들 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1) {
					house.add(new Coordinate(i, j));
				} else if (input == 2) {
					chicken.add(new Coordinate(i, j));
				}
			}
		}
	}
	
	private static void solve() throws Exception {
		selectChicken(0, 0);
		sb.append(minDist);
	}
	
	private static void selectChicken(int cnt, int start) {
		if (cnt == M) {
			// 선택된 치킨집 기준으로 도시의 최소 치킨 거리 계산
			sumMinDist();
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			selectedChicken[cnt] = chicken.get(i);
			selectChicken(cnt+1, i+1);
		}
	}
	
	private static void sumMinDist() {
		int sumDist = 0;
		for (Coordinate h : house) {
			int distance = Integer.MAX_VALUE;
			for (Coordinate c : selectedChicken) {
				distance = Math.min(distance, calcDist(h, c));
			}
			sumDist += distance;
		}
		minDist = Math.min(sumDist, minDist);
	}
	
	
	private static int calcDist(Coordinate house, Coordinate chicken) {
		return Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
	}
	
	static class Coordinate {
		int r, c;

		public Coordinate(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Coordinate [r=" + r + ", c=" + c + "]";
		}
	}
}
