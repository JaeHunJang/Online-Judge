import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<Integer> goldNums = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		generateGoldNumbers(0);

		// 오름차순 정렬 → 사전순 우선
		Collections.sort(goldNums);

		// BFS: [현재합, 리스트]
		Queue<Node> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];

		for (int num : goldNums) {
			if (num > N) continue;
			List<Integer> start = new ArrayList<>();
			start.add(num);
			q.offer(new Node(num, start));
			visited[num] = true;
		}

		while (!q.isEmpty()) {
			Node now = q.poll();
			if (now.sum == N) {
				for (int val : now.list) System.out.print(val + " ");
				System.out.println();
				return;
			}

			for (int num : goldNums) {
				int nextSum = now.sum + num;
				if (nextSum > N) continue;
				if (visited[nextSum]) continue;

				List<Integer> nextList = new ArrayList<>(now.list);
				nextList.add(num);
				q.offer(new Node(nextSum, nextList));
				visited[nextSum] = true;
			}
		}

		// 불가능한 경우
		System.out.println("-1");
	}

	static void generateGoldNumbers(int num) {
		if (num > N) return;
		if (num != 0) goldNums.add(num);
		generateGoldNumbers(num * 10 + 4);
		generateGoldNumbers(num * 10 + 7);
	}

	static class Node {
		int sum;
		List<Integer> list;

		Node(int sum, List<Integer> list) {
			this.sum = sum;
			this.list = list;
		}
	}
}
