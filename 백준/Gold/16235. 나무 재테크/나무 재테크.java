import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] initEnergy;
    static int[][] energy;
    static int[][] visited;
    static int[][] deltas = {{0,-1},{-1,0},{0,1},{1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    static PriorityQueue<Tree> trees;
    static class Tree {
        int r, c, n;

        public Tree(int r, int c, int n) {
            this.r = r;
            this.c = c;
            this.n = n;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "r=" + r +
                    ", c=" + c +
                    ", n=" + n +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        trees = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.n, o2.n));

        energy = new int[N][N];
        initEnergy = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                initEnergy[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(energy[i], 5);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            trees.offer(new Tree(r-1, c-1, n));
        }

        PriorityQueue<Tree> newTrees = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.n, o2.n));
        Queue<Tree> dieTrees = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
//            System.out.println((i+1)+"번째");
//            System.out.println(" 봄 : " + trees);
            // spring
            while (!trees.isEmpty()) {
                Tree t = trees.poll();

                if (energy[t.r][t.c] >= t.n) {
                    energy[t.r][t.c] -= t.n;
                    newTrees.offer(new Tree(t.r, t.c, t.n+1));
                } else {
                    dieTrees.offer(t);
                }
            }

//            System.out.println("여름 : " + dieTrees);
            // summer
            while (!dieTrees.isEmpty()) {
                Tree t = dieTrees.poll();
                energy[t.r][t.c] += t.n/2;
            }

//            System.out.println("가을 : " + newTrees);
            // autumn
            while (!newTrees.isEmpty()) {
                Tree t = newTrees.poll();

                if (t.n % 5 == 0) {
                    for (int d = 0; d < 8; d++) {
                        int nr = t.r + deltas[d][0];
                        int nc = t.c + deltas[d][1];
                        if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                            trees.offer(new Tree(nr, nc, 1));
                        }
                    }
                }
                trees.offer(new Tree(t.r, t.c, t.n));
            }

            // winter
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    energy[x][y] += initEnergy[x][y];
                }
//                System.out.println(Arrays.toString(energy[x]));
            }
//            System.out.println();
        }

        System.out.println(trees.size());
    }
}
