import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로봇 조립 
public class Main {
    static int N, parents[], count[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        parents = new int[1000001];
        count = new int[1000001];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            count[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if ("I".equals(st.nextToken())) {
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                a = Integer.parseInt(st.nextToken());
                sb.append(count[find(a)]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        if (count[pa] < count[pb]) {
            parents[pa] = pb;
            count[pb] += count[pa];  // pb에 pa의 부품 수를 추가
        } else {
            parents[pb] = pa;
            count[pa] += count[pb];  // pa에 pb의 부품 수를 추가
        }

        return true;
    }
}