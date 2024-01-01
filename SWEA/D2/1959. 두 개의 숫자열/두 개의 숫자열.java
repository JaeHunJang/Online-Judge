import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] A = new int[n];
			int[] B = new int[m];
			
			for(int i = 0; i < n; i++) {
				A[i] = sc.nextInt();
			}
			for(int i = 0; i < m; i++) {
				B[i] = sc.nextInt();
			}
			
			int answer = 0;
			if(n > m) answer = calc(A, B);
			else answer = calc(B, A);
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
	static int calc(int[] big, int[] small) {
		int max = 0;
		int sum = 0;
		for(int i = 0; i < big.length - small.length + 1; i++) {
			for(int j = i; j < small.length+i; j++) {
				sum += (big[j] * small[j-i]);
			}
			max = Math.max(max, sum);
			sum = 0;
		}
		
		return max;
	}
}