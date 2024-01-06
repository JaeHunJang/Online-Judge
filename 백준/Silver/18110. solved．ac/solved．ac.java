import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int floor = (int)Math.round(n * 0.15);
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        Arrays.sort(arr);
        
        int sum = 0;
        n -= floor;
		for (int i = floor; i < n; i++) {
			sum += arr[i];
		}
        
		System.out.println((int) Math.round(sum / (n - floor * 1.0)));
	}
}