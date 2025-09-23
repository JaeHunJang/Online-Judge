import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            int B = Integer.parseInt(st.nextToken());
            int gcd = euclidean(A, B);
            System.out.println((A / gcd) + "/" + (B / gcd));
        }
    }

    static int euclidean(int a, int b) {
        if (b == 0)
            return a;
        return euclidean(b, a % b);
    }
}
