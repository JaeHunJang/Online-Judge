import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int map[][], deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static Set<Integer> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5];
        set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, map[i][j], 1);
            }
        }

        System.out.println(set.size());
    }

    static void dfs(int x, int y, int num, int cnt) {
        if (cnt == 6) {
            set.add(num);
            return;
        }
        for (int d = 0; d < deltas.length; d++) {
            int nx = deltas[d][0] + x;
            int ny = deltas[d][1] + y;
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            dfs(nx, ny, num*10+map[nx][ny], cnt+1);
        }
    }
}
