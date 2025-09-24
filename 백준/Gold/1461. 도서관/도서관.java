import java.io.*;
import java.util.*;

public class Main {
    static int N, M, books[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int book = Integer.parseInt(st.nextToken());
            if (book > 0) list1.add(book);
            else list2.add(-book);
        }

        Collections.sort(list1, Collections.reverseOrder());
        Collections.sort(list2, Collections.reverseOrder());

        int maxDist = 0;
        if (!list1.isEmpty()) maxDist = Math.max(maxDist, list1.get(0));
        if (!list2.isEmpty()) maxDist = Math.max(maxDist, list2.get(0));

        int result = 0;

        // 양수 쪽 처리
        for (int i = 0; i < list1.size(); i += M) {
            result += list1.get(i) * 2;
        }

        // 음수 쪽 처리
        for (int i = 0; i < list2.size(); i += M) {
            result += list2.get(i) * 2;
        }

        result -= maxDist;

        System.out.println(result);
    }
}
