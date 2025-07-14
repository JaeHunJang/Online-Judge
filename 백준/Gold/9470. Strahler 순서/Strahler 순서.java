import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, K, M, P, I;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            I = 0;
            int[] indegrees = new int[M+1];
            List<Integer>[] list = new List[M+1];
            for (int i = 0; i <= M; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                list[A].add(B);
                indegrees[B]++;
            }

//            System.out.println(Arrays.toString(list));
//            System.out.println(Arrays.toString(indegrees));
            Queue<Integer> q = new ArrayDeque<>();
            PriorityQueue<Integer>[] steps = new PriorityQueue[M+1];
            for (int i = 0; i < steps.length; i++) {
                steps[i] = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            }
            for (int i = 1; i < indegrees.length; i++) {
                if (indegrees[i] == 0) {
                    q.offer(i);
                    steps[i].offer(1);
                }
            }
//            System.out.println(Arrays.toString(steps));

            while (!q.isEmpty()) {
                int size = q.size();
                for (int s = 0; s < size; s++) {
                    int now = q.poll();

//                    System.out.println(now);
                    for (int next : list[now]) {
                        indegrees[next]--;
                        steps[next].offer(steps[now].peek());
                        if (indegrees[next] == 0) {
                            q.offer(next);

                            int maxStep = steps[next].poll();
                            if (!steps[next].isEmpty() && steps[next].peek() == maxStep) {
                                maxStep++;
                            }
//                            I = Math.max(I, maxStep);
                            steps[next].clear();
                            steps[next].offer(maxStep);
                        }
                    }
                }
            }
//            System.out.println(Arrays.toString(steps));

            sb.append(K).append(" ").append(steps[M].peek()).append("\n");
        }
        System.out.println(sb);
    }
}
