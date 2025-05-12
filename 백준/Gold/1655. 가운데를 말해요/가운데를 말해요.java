import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (left.isEmpty() || left.peek() >= num) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            if (right.size() > left.size()) {
                left.offer(right.poll());
            } else if (right.size() + 1 < left.size()) {
                right.offer(left.poll());
            }

            sb.append(left.peek()).append("\n");
//            System.out.println(left.peek() + ": " + left + "|" + right);
        }
        
        System.out.println(sb);
    }
}