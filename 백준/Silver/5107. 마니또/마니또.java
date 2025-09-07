import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<String,Integer> map;
    static List<Integer>[] list;
    static int parents[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) return;

            parents = new int[N + 1];
            map = new HashMap<>();
            list = new List[N + 1];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
                parents[i] = i;
            }
            int cnt = 1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a)) {
                    map.put(a, cnt++);
                }
                if (!map.containsKey(b)) {
                    map.put(b, cnt++);
                }
                union(map.get(a), map.get(b));
            }

            for (int i = 0; i < parents.length; i++) {
                find(i);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < parents.length; i++) {
                set.add(parents[i]);
            }
            System.out.println(T++ + " " + set.size());
        }
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        parents[pa] = pb;
        return true;
    }
}
