import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, r, c, len, cnt, result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cnt = 0;
        result = -1;

        len = (int) Math.pow(2, N);
        conquer(0, 0, len, len, len);
        System.out.println(result);
    }

    static void conquer(int sr, int sc, int er, int ec, int size) {
        if (result != -1) return;
        if (sr <= r && r < er && sc <= c && c < ec) {
//            System.out.printf("%d %d %d %d %d\n", cnt, sr, sc, er, ec);
            if (sr == r && sc == c) {
                result = cnt;
            } else if (size / 2 >= 1) {
                int l = size / 2;
                conquer(sr, sc, sr + l, sc + l, l);
                conquer(sr, sc + l, sr + l, ec, l);
                conquer(sr + l, sc, er, sc + l, l);
                conquer(sr + l, sc + l, er, ec, l);
            }
        } else {
            cnt += size * size;
        }
    }
}
