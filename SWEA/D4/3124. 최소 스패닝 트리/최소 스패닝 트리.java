import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int T, V, E, parents[];
    private static Edge edgeList[];
     
    static class Edge implements Comparable<Edge> {
        int from, to, weight;
         
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
         
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws Exception {
        init();
        print();
    }
    private static void print() {
        System.out.println(sb.toString());
    }
     
    private static void init() throws Exception { 
        T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
             
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
             
            edgeList = new Edge[E]; // 간선리스트 생성
            int from,to,weight;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(from, to, weight);
            }
             
            solve();
        }
    }
     
    private static void solve() throws Exception {
        // 전처리
        Arrays.sort(edgeList); // 간선 가중치 기준으로 정렬
 
        // 1. make-set
        make();
         
        // 2. 최소 비용 순으로 연결
        long totalWeight = 0; // 최소 비용
        int cnt = 0; // 연결된 간선의 수
        for (Edge edge : edgeList) {
            if (!union(edge.from, edge.to)) continue; // 이미 집합(트리)에 속해있으면 싸이클 발생
            totalWeight += edge.weight;
            if (++cnt == V-1) break; // 간선의 수가 V-1이 되면 최소신장트리 완성
        }
         
        sb.append(totalWeight).append("\n");
    }
     
    private static void make() {
        parents = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }
     
    private static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]); // path 압축
    }
     
    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false; // 이미 같은 집합에 속함
        parents[bRoot] = aRoot;
 
        return true;
         
    }
}