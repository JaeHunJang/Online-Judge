import java.io.*;
import java.util.*;

public class Main {
    static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() > S.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            } else { // 'B'
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }
        System.out.println(S.equals(T.toString()) ? 1 : 0);
    }
}
