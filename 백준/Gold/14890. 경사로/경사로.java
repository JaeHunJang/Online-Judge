import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14890
 */
public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, X, map[][], rmap[][], count;
	
	public static void main(String[] args) throws Exception {
		init();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 활주로 맵 크기  
        X = Integer.parseInt(st.nextToken()); // 경사로 길이
        count = 0;

        map = new int[N][N];
        rmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                rmap[j][i] = map[i][j];
            }
        }

        solve();
	}
	
	private static void solve() throws Exception {
		for (int i = 0; i < N; i++) {
			if (isValid(map[i])) count++;
			if (isValid(rmap[i])) count++;
		}
		sb.append(count);
	}
	
	private static boolean isValid(int[] line) {
		int len = 1;
		boolean isDown = false;
		for (int i = 1; i < N; i++) {
			if (Math.abs(line[i-1] - line[i]) > 1) return false;
			
			if (isDown && len == X) {
				len = 0;
                isDown = false;
            }
			
			if (line[i-1] == line[i]) { // 같은 높이
				len++;
			} else if (line[i-1] < line[i]) { // 오르막
				if (len < X) return false; // 오르막으로 올라갔는데 경사로 설치 길이가 안된다면 활주로 불가 
				len = 1;
			} else { // 내리막
				if (isDown) return false;
				isDown = true;
				len = 1;
			}
		}
		
		if (isDown && len == X) {
			isDown = false;
		}
		
		return !isDown;
	}
}
