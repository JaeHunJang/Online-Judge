import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 애너그램 / 60분
public class Main {
    static char[] input;
    static char[] result;
    static int[] visited;
    static Set<String> results;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            input = br.readLine().toCharArray();
            sb = new StringBuilder();
            result = new char[input.length];
            visited = new int[26];
            for (int j = 0; j < input.length; j++) {
                visited[input[j] - 'a']++;
            }
            results = new HashSet<>();
            dfs(0);
            System.out.print(sb);
        }
    }

    static void dfs(int cnt) {
        if (cnt == input.length) {
            StringBuilder temp = new StringBuilder();
            temp.append(result);
            if (results.contains(temp.toString())) return;
            results.add(temp.toString());
            sb.append(result).append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (visited[i] == 0) continue;
            visited[i]--;
            result[cnt] = (char)('a' + i);
            dfs(cnt+1);
            visited[i]++;
        }
    }
}