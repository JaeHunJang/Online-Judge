import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] numbers = new int[n+1];
		int[] dp = new int[n+1];
		for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
		
		int idx = 0;
		int len = 0;
		for(int i=0; i<n; i++) {
			if(numbers[i] > dp[len]) {
				len++;
				dp[len] = numbers[i];
			}else {
				/* binarySearch */
				int key = numbers[i];
				int left = 0;
				int right = len;
				int mid = 0;
				while(left < right) {
					mid = (left + right) / 2;
					if(dp[mid] < key) {
						left = mid+1;
					} else {
						right = mid;
					}
				}
				idx = right;
				dp[idx] = numbers[i];
			}
		}
		System.out.println(len);
	}
}