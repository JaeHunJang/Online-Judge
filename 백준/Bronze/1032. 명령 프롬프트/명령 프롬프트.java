import java.io.*;
import java.util.*;

public class Main {
    static int N, counts[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        String first = br.readLine();
        counts = new int[first.length()];
        Arrays.fill(counts, 1);
        for (int i = 0; i < N-1; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (first.charAt(j) == input.charAt(j)) {
                    counts[j]++;
                }
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == N) {
                System.out.print(first.charAt(i));
            } else {
                System.out.print("?");
            }
        }
    }
}
