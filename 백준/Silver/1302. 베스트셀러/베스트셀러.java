import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0)+1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> {
            int cmp = Integer.compare(map.get(o2), map.get(o1));
            if (cmp == 0) {
                return o1.compareTo(o2);
            }

            return cmp;
        });
        System.out.println(keySet.get(0));
    }
}
