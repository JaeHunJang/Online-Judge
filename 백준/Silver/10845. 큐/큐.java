import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static Queue<String> q;
	private static String last;
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(sb.toString());
	}

	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			solve();
		}
	}

	private static void solve() throws Exception {
		String cmd = br.readLine();
		if (cmd.contains("push")) {
			last = cmd.split(" ")[1];
			q.add(last);
		} else {
			cmd = cmd.split(" ")[0];
			if ("size".equals(cmd)) {
				sb.append(q.size());
			} else if ("empty".equals(cmd)) {
				sb.append(q.isEmpty() ? "1" : "0");
			} else if ("pop".equals(cmd)) {
				sb.append(q.isEmpty() ? "-1" : q.poll());
			} else {
				if (q.isEmpty()) sb.append("-1");
				else {
					if ("front".equals(cmd)) {
						sb.append(q.peek());
					} else {
						sb.append(last);
					}
				}
			}
			sb.append("\n");
		}
	}
}