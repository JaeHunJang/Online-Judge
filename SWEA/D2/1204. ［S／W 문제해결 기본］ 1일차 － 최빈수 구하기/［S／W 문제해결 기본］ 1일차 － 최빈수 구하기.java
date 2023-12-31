import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			System.out.print("#" + br.readLine() + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] scores = new int[101];
			while (st.hasMoreTokens()) {
				scores[Integer.parseInt(st.nextToken())]++;
			}
			
			int max = -1;
			int idx = -1;
			for(int j = 0; j < scores.length; j++) {
				if(scores[j] >= max) {
					max = scores[j];
					idx = j;
				}
			}
			System.out.println(idx);
		}
	}
}
	