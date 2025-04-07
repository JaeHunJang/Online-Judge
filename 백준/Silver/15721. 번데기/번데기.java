import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int sign = Integer.parseInt(br.readLine()); // 0 뻔, 1 데기
        int[] signs = new int[2];

        int cnt = -1;
        for (int i = 1; i <= T*2; i++) {
            String game = game(i);
            for (int j = 0; j < game.length(); j++) {
                signs[game.charAt(j) - '0']++;
                cnt++;
                if(signs[sign] == T) {
                    System.out.println(cnt % A);
                    return;
                }
            }
        }
    }

    static String game(int cnt) {
        StringBuilder sb = new StringBuilder();
        sb.append("0101");
        for (int i = 0; i <= cnt; i++) {
            sb.append("0");
        }
        for (int i = 0; i <= cnt; i++) {
            sb.append("1");
        }

        return sb.toString();
    }
}