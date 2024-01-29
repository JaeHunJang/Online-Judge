import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static final String RECURSIVE_DASH = "____";
	private static final String RECURSIVE_START = "\"재귀함수가 뭔가요?\"\n";
	private static final String[] RECURSIVE = {
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"
	};
	private static final String RECURSIVE_FINAL = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	private static final String RECURSIVE_RETURN = "라고 답변하였지.\n";
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
	}
	
	private static void solve() {
		recursive(0, "");
	}
	
	private static void recursive(int count, String dash) {
		sb.append(dash).append(RECURSIVE_START);
		if (count >= N) { // 끝까지 순회했는지 확인
			sb.append(dash).append(RECURSIVE_FINAL);
			sb.append(dash).append(RECURSIVE_RETURN);
			return; 
		}
		for (int i = 0; i < RECURSIVE.length; i++) {
			sb.append(dash).append(RECURSIVE[i]);
		}
		recursive(count + 1, dash + RECURSIVE_DASH);
		sb.append(dash).append(RECURSIVE_RETURN);
	}
}
