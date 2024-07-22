import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

// 애너그램 / 60분
public class Main {
    static char[] input;
    static char[] result;
    static int[] freq; // 알파벳 빈도 수를 저장할 배열
    static TreeSet<String> results;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            input = br.readLine().toCharArray();
            result = new char[input.length];
            freq = new int[26];
            for (char c : input) {
                freq[c - 'a']++;
            }
            results = new TreeSet<>(); // TreeSet을 사용하여 결과를 사전순으로 저장하고 중복을 제거
            dfs(0);
            for (String str : results) {
                System.out.println(str);
            }
        }
    }

    static void dfs(int cnt) {
        if (cnt == input.length) {
            results.add(new String(result)); // 결과 문자열을 TreeSet에 추가
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                result[cnt] = (char) ('a' + i);
                dfs(cnt + 1);
                freq[i]++;
            }
        }
    }
}
