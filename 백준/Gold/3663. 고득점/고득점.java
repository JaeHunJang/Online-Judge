import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            sb.append(make(input)).append("\n");
        }
        System.out.println(sb);
    }

    static int make(String input) {
        int changeCnt = 0;

        int moveCnt = input.length()-1;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            changeCnt += Math.min(ch - 'A', 'Z' - ch + 1);

            int idx = i+1;
            while (idx < input.length() && input.charAt(idx) == 'A') {
                idx++;
            }
            
            moveCnt = Math.min(moveCnt, 2*(input.length()-idx) + i);
            moveCnt = Math.min(moveCnt, 2*i + (input.length()-idx));
        }

        return moveCnt + changeCnt;
    }
}
// https://bleron.tistory.com/245