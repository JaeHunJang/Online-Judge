import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[26];
            int prevKey = -1;
            boolean isGroup = true;
            String input = br.readLine();
            
            for (char ch : input.toCharArray()) {
                int key = ch - 'a';
                if (prevKey != key) {
                    if (visited[key]) {
                        isGroup = false;
                        break;
                    }
                    visited[key] = true;
                }
                prevKey = key;
            }
            if (isGroup) cnt++;
        }
        System.out.println(cnt);
    }
}