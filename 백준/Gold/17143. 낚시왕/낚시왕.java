import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int R, C, M, sum, deltas[][] = {{-1,0},{1,0},{0,1},{0,-1}};
    static List<Shark> list;
    static class Shark {
        int n, r, c, s, d, z;

        public Shark(int n, int r, int c, int s, int d, int z) {
            this.n = n;
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return (char)((n-1) + 'A') +
                    ""+ d + "," + z ;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        sum = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            list.add(new Shark(i+1, r-1, c-1, s, d-1, z));
        }


        for (int i = 0; i < C; i++) {
            fishing(i);
            moving();
        }
        System.out.println(sum);
    }

    static void moving() {
        Shark[][] map = new Shark[R][C];

        for (Shark shark : list) {
            if (shark.s == 0) {
                if (map[shark.r][shark.c] == null || map[shark.r][shark.c].z < shark.z) {
                    map[shark.r][shark.c] = shark;
                }
            } else {
//                System.out.println(shark.r + ", " + shark.c + ", " + shark.d);
                int speed = shark.s;
                if (shark.d <= 1) {
                    speed = speed % (2 * (R-1));
                } else {
                    speed = speed % (2 * (C-1));
                }

                int cnt = 0;
                for (int i = 0; i < speed; i++) {
                    int nr = shark.r + deltas[shark.d][0];
                    int nc = shark.c + deltas[shark.d][1];
                    if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                        shark.r = nr;
                        shark.c = nc;
                        cnt++;
                    } else {
                        if (shark.d == 0) {
                            shark.d = 1;
                        } else if (shark.d == 1) {
                            shark.d = 0;
                        } else if (shark.d == 2) {
                            shark.d = 3;
                        } else if (shark.d == 3){
                            shark.d = 2;
                        }
                        i--;
                    }
                }
//                int remain = shark.s - cnt;
//                if (remain > 0) {
//                    int t = 0;
//                    int m = 0;
//                    if (shark.d <= 1) {
//                        t = remain / (R-1);
//                        m = remain % (R-1);
//                    } else {
//                        t = remain / (C-1);
//                        m = remain % (C-1);
//                    }
//                    System.out.println(shark.n + " : " + remain + ", " + t + ", " + m);
//
//                    if (t % 2 == 1) { // 턴이 홀수면 방향 변경
//                        if (shark.d == 0) {
//                            shark.d = 1;
//                        } else if (shark.d == 1) {
//                            shark.d = 0;
//                        } else if (shark.d == 2) {
//                            shark.d = 3;
//                        } else if (shark.d == 3){
//                            shark.d = 2;
//                        }
//                    }
//                    System.out.println(shark.r + ", " + shark.c + ", " + shark.d);
//                    shark.r = shark.r + (m * deltas[shark.d][0]);
//                    shark.c = shark.c + (m * deltas[shark.d][1]);
//                    System.out.println((m * deltas[shark.d][0]) + " | " + (m * deltas[shark.d][1]));
//                    System.out.println(shark.r + ", " + shark.c + ", " + shark.d);
//
//                }
                if (map[shark.r][shark.c] == null || map[shark.r][shark.c].z < shark.z) { // 상어 배치
                    map[shark.r][shark.c] = shark;
                }
            }
        }
//        for (int i = 0; i < R; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();
        list.clear();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == null) continue;
                list.add(map[i][j]);
            }
        }
    }

    static void fishing(int c) {
        Shark findShark = null;
        for (Shark shark : list) {
            if (shark.c == c) {
                if (findShark == null || findShark.r > shark.r) {
                    findShark = shark;
                }
            }
        }

        if (findShark != null) {
            sum += findShark.z;
            list.remove(findShark);
        }
    }
}