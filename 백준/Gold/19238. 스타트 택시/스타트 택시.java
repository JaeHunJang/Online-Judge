import java.io.*;
import java.util.*;

public class Main {
    static int N, M, texi[], map[][], deltas[][] = {{-1,0},{0,-1},{0,1},{1,0}};
    static long F;
    static List<Customer> list;
    static class Customer {
        int n, sr, sc, er, ec;

        public Customer(int n, int sr, int sc, int er, int ec) {
            this.n = n;
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "n=" + n +
                    ", sr=" + sr +
                    ", sc=" + sc +
                    ", er=" + er +
                    ", ec=" + ec +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        texi = new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1};
        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());
            map[sr-1][sc-1] = i+2;
            list.add(new Customer(i+2, sr-1, sc-1, er-1, ec-1));
        }

//        print();
        int cnt = 0;
        while (F > 0 && cnt < M) {
            int customer = findCustomer();
            if (customer == -1) {
                System.out.println(-1);
                return;
            }
//            print();
//            System.out.println(F);
            int dist = moveGoal(customer);
            if (dist == -1 || dist > F) {
                System.out.println(-1);
                return;
            }
            F += dist;
//            System.out.println(F);
            cnt++;
        }
        System.out.println(F);
    }
    static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));

        }
        System.out.println();
    }

    static int findCustomer() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{texi[0], texi[1], 0});
        int[][] visited = new int[N][N];
        visited[texi[0]][texi[1]] = 1;

        int dist = 0;
        List<Integer> findCustomers = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] now = q.poll();

                if (map[now[0]][now[1]] >= 2) {
                    findCustomers.add(map[now[0]][now[1]]-2);
                }

                for (int d = 0; d < deltas.length; d++) {
                    int nr = now[0] + deltas[d][0];
                    int nc = now[1] + deltas[d][1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] > 0 || map[nr][nc] == 1) continue;
                    visited[nr][nc] = 1;
                    q.offer(new int[]{nr, nc, now[2] + 1});
                }

//                for (int[] t : q) {
//                    System.out.print(Arrays.toString(t) + ",");
//                }
//                System.out.println();
            }
            if (!findCustomers.isEmpty()) break; // 손님 찾으면 나감
            dist++;
        }

        if (findCustomers.isEmpty()) return -1; // 손님 못찾음
        if (F - dist < 0) return -1; // 연료 다씀
        F -= dist;

        Collections.sort(findCustomers, (o1, o2) -> {
            Customer c1 = list.get(o1);
            Customer c2 = list.get(o2);
            if (c1.sr == c2.sr) {
                return Integer.compare(c1.sc, c2.sc);
            }
            return Integer.compare(c1.sr, c2.sr);
        });

        return findCustomers.get(0);
    }

    static int moveGoal(int key) {
        Customer c = list.get(key);
//        System.out.println(c);
//        System.out.println(Arrays.toString(texi));
        map[c.sr][c.sc] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{c.sr, c.sc, 0});
        int[][] visited = new int[N][N];
        visited[c.sr][c.sc] = 1;

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] now = q.poll();

                if (c.er == now[0] && c.ec == now[1]) {
                    texi[0] = c.er;
                    texi[1] = c.ec;
                    return dist;
                }

                for (int[] d : deltas) {
                    int nr = now[0] + d[0];
                    int nc = now[1] + d[1];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] > 0 || map[nr][nc] == 1) continue;
                    visited[nr][nc] = 1;
                    q.offer(new int[] {nr, nc, now[2]+1});
                }
            }
            dist++;
        }

        return -1; // 목적지에 못간 경우
    }
}
