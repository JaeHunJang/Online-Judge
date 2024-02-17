import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static List<Node> tree;
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
		N = Integer.parseInt(st.nextToken()); // 노드의 개수

		tree = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			Node current = new Node(st.nextToken());
			current.left = new Node(st.nextToken());
			current.right = new Node(st.nextToken());
			tree.add(current);
		}
	}
	
	private static void solve() throws Exception {
		dfs(0, 1);
		sb.append("\n");
		dfs(0, 2);
		sb.append("\n");
		dfs(0, 3);
	}
	
	private static void dfs(int cnt, int mode) {
		if (cnt == N) {
			return;
		}
		
		Node current = tree.get(cnt);
		if (mode == 1) sb.append(current.data); // 전위
		if (!".".equals(current.left.data)) {
			dfs(tree.indexOf(new Node(current.left.data)), mode);
		}
		if (mode == 2) sb.append(current.data); // 중위
		if (!".".equals(current.right.data)) {
			dfs(tree.indexOf(new Node(current.right.data)), mode);
		}
		if (mode == 3) sb.append(current.data); // 후위
	}
	
	static class Node {
		String data;
		Node left,right;
		public Node(String data) {
			this.data = data;
		}

		@Override
		public boolean equals(Object obj) {
			Node other = (Node) obj;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			return true;
		}
	}
}