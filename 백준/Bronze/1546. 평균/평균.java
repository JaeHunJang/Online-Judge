import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] scores = new int[n];
		double max = 0;
		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			max = Math.max(scores[i], max);
		}
		
		double avg = 0;
		for (int score : scores) {
			avg += score / max * 100;
		}
		
		System.out.println(avg / n);
	}
}