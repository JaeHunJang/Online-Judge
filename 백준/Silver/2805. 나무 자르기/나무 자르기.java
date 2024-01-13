import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] trees = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);
		
		int h;
		int wood = 0;
		int count = 0;
		for (h = trees[--n]; h >= 0; h--) {
			while (n >= 0 && trees[n] > h) {
				count++;
				n--;
			}
			wood += count;
			if (wood >= m) {
				break;
			}
		}
		
		System.out.println(h);
	}
}