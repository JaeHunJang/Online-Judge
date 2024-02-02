import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static Queue<Integer> cards;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		N = Integer.parseInt(br.readLine()); // 카드 수
		cards = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			cards.offer(i);
		}
	}
	
	private static void solve() {
		while (cards.size() > 1) { // 마지막 카드가 남을때까지 반복
			cards.poll(); // 첫카드는 버리기
			cards.offer(cards.poll()); // 두번째는 다시 넣기
		}
		sb.append(cards.poll());
	}
}