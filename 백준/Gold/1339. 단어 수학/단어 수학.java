import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] words;
    static int[] weight = new int[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            int len = words[i].length();
            for (int j = 0; j < len; j++) {
                char c = words[i].charAt(j);
                weight[c - 'A'] += (int)Math.pow(10, len - j - 1);
            }
        }

        // 알파벳 가중치를 내림차순으로 정렬
        Integer[] order = new Integer[26];
        for (int i = 0; i < 26; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(weight[b], weight[a]));

        int num = 9;
        int[] assign = new int[26];
        Arrays.fill(assign, -1);
        for (int i = 0; i < 26 && weight[order[i]] > 0; i++) {
            assign[order[i]] = num--;
        }

        // 최종 계산
        int result = 0;
        for (String w : words) {
            int cur = 0;
            for (int j = 0; j < w.length(); j++) {
                cur = cur * 10 + assign[w.charAt(j) - 'A'];
            }
            result += cur;
        }

        System.out.println(result);
    }
}
