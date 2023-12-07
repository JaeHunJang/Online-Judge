import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];
			
			
            for(int i = 0; i < n; i++) {
            	int c = 0;
            	for(int j = 0; j < m; j++) {
                    if(sc.nextInt() == 1) c++;
            	}
            	arr[i] = c;
            }
            
            int max = Arrays.stream(arr).max().getAsInt();
            
            int count = (int) Arrays.stream(arr).filter(c -> c == max).count();
            
            
			System.out.println("#" + test_case + " " + count + " " + max);
		}
	}
}