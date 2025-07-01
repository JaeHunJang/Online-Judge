import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static char map[][];
    static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
    static final String cmd = "UDLR";
    static int[] p;
    static List<int[]> goals;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gameCnt = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            map = new char[N][M];
            goals = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int j = 0;
                for (char ch : br.readLine().toCharArray()) {
                    map[i][j] = ch;
                    if (ch == 'w' || ch == 'W') {
                        p = new int[]{i, j};
                    }
                    if (ch == '+' || ch == 'W' || ch == 'B') {
                        goals.add(new int[]{i, j});
                    }
                    j++;
                }
            }

            boolean isComp = false;
            for (String ch : br.readLine().split("")) {
                move(cmd.indexOf(ch));

//                System.out.println(ch);
//                for (int i = 0; i < N; i++) {
//                    System.out.println(map[i]);
//                }
//                System.out.println();
                isComp = isComplete();
                if (isComp) {
                    break;
                }
            }
            sb.append("Game ").append(gameCnt++).append(": ");
            if (!isComp) {
                sb.append("in");
            }
            sb.append("complete\n");
            for (int i = 0; i < N; i++) {
                sb.append(map[i]).append("\n");
//                    System.out.println(map[i]);
            }

        }
        System.out.println(sb);
    }

    static boolean isComplete() {
        for (int[] goal : goals) {
            if (map[goal[0]][goal[1]] == 'W' || map[goal[0]][goal[1]] == '+') return false;
        }
        return true;
    }

    static void move(int d) {
        int nr = p[0] + deltas[d][0];
        int nc = p[1] + deltas[d][1];
        if (0 <= nr && nr < N && 0 <= nc && nc < M) {
            if (map[nr][nc] == 'b') {
                int nnr = nr + deltas[d][0];
                int nnc = nc + deltas[d][1];
                if (0 <= nnr && nnr < N && 0 <= nnc && nnc < M) {
                    if (map[nnr][nnc] == '.') {
                        map[nnr][nnc] = 'b';
                        if (map[p[0]][p[1]] == 'W') {
                            map[p[0]][p[1]] = '+';
                        } else {
                            map[p[0]][p[1]] = '.';
                        }
                        map[nr][nc] = 'w';
                        p[0] = nr;
                        p[1] = nc;
                    } else if (map[nnr][nnc] == '+') {
                        map[nnr][nnc] = 'B';
                        if (map[p[0]][p[1]] == 'W') {
                            map[p[0]][p[1]] = '+';
                        } else {
                            map[p[0]][p[1]] = '.';
                        }
                        map[nr][nc] = 'w';
                        p[0] = nr;
                        p[1] = nc;
                    }
                }
            } else if (map[nr][nc] == 'B') {
                int nnr = nr + deltas[d][0];
                int nnc = nc + deltas[d][1];
                if (0 <= nnr && nnr < N && 0 <= nnc && nnc < M) {
                    if (map[nnr][nnc] == '.') {
                        map[nnr][nnc] = 'b';
                        if (map[p[0]][p[1]] == 'W') {
                            map[p[0]][p[1]] = '+';
                        } else {
                            map[p[0]][p[1]] = '.';
                        }
                        map[nr][nc] = 'W';
                        p[0] = nr;
                        p[1] = nc;
                    } else if (map[nnr][nnc] == '+') {
                        map[nnr][nnc] = 'B';
                        if (map[p[0]][p[1]] == 'W') {
                            map[p[0]][p[1]] = '+';
                        } else {
                            map[p[0]][p[1]] = '.';
                        }
                        map[nr][nc] = 'W';
                        p[0] = nr;
                        p[1] = nc;
                    }
                }
            } else if (map[nr][nc] == '.') {
                if (map[p[0]][p[1]] == 'W') {
                    map[p[0]][p[1]] = '+';
                } else {
                    map[p[0]][p[1]] = '.';
                }
                map[nr][nc] = 'w';
                p[0] = nr;
                p[1] = nc;
            } else if (map[nr][nc] == '+') {
                if (map[p[0]][p[1]] == 'W') {
                    map[p[0]][p[1]] = '+';
                } else {
                    map[p[0]][p[1]] = '.';
                }
                map[nr][nc] = 'W';
                p[0] = nr;
                p[1] = nc;
            }
        }
    }
}