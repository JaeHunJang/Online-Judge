import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, Q, A[], pos;
    static TreeSet<Integer> places;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        places = new TreeSet<>();
        pos = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (A[i] == 1) places.add(i);
        }

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (1 == cmd) {
                int i = Integer.parseInt(st.nextToken());
                A[i] = (A[i]+1) % 2;
                if (A[i] == 1) {
                    places.add(i);
                } else {
                    places.remove(i);
                }
            } else if (2 == cmd) {
                int x = Integer.parseInt(st.nextToken());
                pos = (pos + x - 1) % N + 1;
            } else {
                if (places.isEmpty()) sb.append(-1); // 명소 없음
                else {
                    if (A[pos] == 1) sb.append(0); // 현재가 명소
                    else {
                        Integer upper = places.ceiling(pos);
                        int lower = places.first();

                        if (upper == null) {
                            sb.append((N-pos+lower));
                        } else {
                            sb.append((upper-pos));
                        }
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
