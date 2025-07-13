import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑아낼 원소 개수

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int target : targets) {
            int idx = 0;
            for (int num : deque) {
                if (num == target) break;
                idx++;
            }

            int half = deque.size() / 2;
            if (idx <= half) {
                // 왼쪽 회전
                while (deque.peekFirst() != target) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            } else {
                // 오른쪽 회전
                while (deque.peekFirst() != target) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }

            // 1번 연산 - 꺼내기
            deque.pollFirst();
        }

        System.out.println(count);
    }
}
