import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int answer = Integer.MAX_VALUE;
		for(int i = n / 5; i >= 0; i--) {
			if((n - (i * 5)) % 3 == 0) {
				answer = Math.min(answer, i + (n - (i * 5)) / 3);
			}
		}
		
		for(int i = n / 3; i >= 0; i--) {
			if((n - (i * 3)) % 5 == 0) {
				answer = Math.min(answer, i + (n - (i * 3)) / 5);
			}
		}
		answer = answer == Integer.MAX_VALUE ? -1 : answer;
		
		System.out.print(answer);
	}
}