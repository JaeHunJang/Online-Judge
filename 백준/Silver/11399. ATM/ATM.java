import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] P = new int[n];
		
		int i = 0;
		for(String s : br.readLine().split(" ")) {
			P[i++] = Integer.parseInt(s);
		}

		Arrays.sort(P);
		int answer = 0;
		for(i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				answer += P[j];
			}
		}
		
		System.out.print(answer);
	}
}