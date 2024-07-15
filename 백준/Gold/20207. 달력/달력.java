import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 달력 / 60분
public class Main {
    static int N, map[], sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[366];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                map[j]++;
            }
        }

        sum = 0;
        int width = 0, hegiht = 0;
        for (int i = 1; i <= 365; i++) {
            if (map[i] > 0) {
                width++;
                hegiht = Math.max(hegiht,  map[i]);
            } else {
                sum += width * hegiht;
                width = 0;
                hegiht = 0;
            }
        }
        sum += width * hegiht;

        System.out.println(sum);
    }
}
