import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Pos[] mines = new Pos[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                mines[i] = new Pos(x, y);
            }

            // x 정렬
            Arrays.sort(mines, Comparator.comparingInt(a -> a.x));
            int max = 0;

            for (int i = 0; i < N; i++) {
                // x 기준 슬라이딩
                List<Integer> yList = new ArrayList<>();
                for (int j = i; j < N && mines[j].x <= mines[i].x + 10; j++) {
                    yList.add(mines[j].y);
                }

                // y 정렬 후 투 포인터
                Collections.sort(yList);
                int l = 0;
                for (int r = 0; r < yList.size(); r++) {
                    while (yList.get(r) - yList.get(l) > 10) l++;
                    max = Math.max(max, r - l + 1);
                }
            }

            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }
}
