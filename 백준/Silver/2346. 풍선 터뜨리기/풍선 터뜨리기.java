import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> valueQueue = new ArrayDeque<>();
        ArrayDeque<Integer> indexQueue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            valueQueue.addLast(Integer.parseInt(st.nextToken()));
            indexQueue.addLast(i);
        }

        while (!valueQueue.isEmpty()) {
            int move = valueQueue.pollFirst();
            int idx = indexQueue.pollFirst();
            sb.append(idx).append(" ");

            if (valueQueue.isEmpty()) break;

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    valueQueue.addLast(valueQueue.pollFirst());
                    indexQueue.addLast(indexQueue.pollFirst());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    valueQueue.addFirst(valueQueue.pollLast());
                    indexQueue.addFirst(indexQueue.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}