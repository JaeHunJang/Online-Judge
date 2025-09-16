import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static boolean[] knowTruth;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        knowTruth = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            int x = Integer.parseInt(st.nextToken());
            knowTruth[x] = true;
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            int first = -1;
            for (int j = 0; j < size; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
                if (first == -1) first = person;
                else union(first, person);
            }
            parties.add(party);
        }

        // 진실 아는 사람의 루트 표시
        boolean[] truthRoot = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (knowTruth[i]) truthRoot[find(i)] = true;
        }

        int cnt = 0;
        for (List<Integer> party : parties) {
            boolean hasTruth = false;
            for (int person : party) {
                if (truthRoot[find(person)]) {
                    hasTruth = true;
                    break;
                }
            }
            if (!hasTruth) cnt++;
        }

        System.out.println(cnt);
    }
}
