import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static char[] S;
	private static int result;
	
	public static void main(String[] args) throws Exception {
		init();
		solve();
		System.out.println(result);
	}	
	
	private static void init() throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine().toCharArray();
		result = 0;
	}
	
	private static void solve() throws Exception {
		int count = 0;
		for (int i = 1; i < M-1;) {
			if ('I' == S[i-1] && 'O' == S[i] && 'I' == S[i+1]) { //IOI인지 확인
				count++;
				if (count == N) { // Pn 만큼 반복되었으면 개수증가, count감소(다음 개수 확인)
					result++;
					count--; 
				}
				i += 2; //OI 반복만큼 인덱스 이동
			} else {
				count = 0; // I가 아니면 초기화, 한칸 이동
				i++;
			}
		}
	}
}