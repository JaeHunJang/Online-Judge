import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + test_case + " ");
            
            int count = sc.nextInt();
            int[] arr = new int[count];
			for(int i = 0; i < count; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for(int n : arr) 
            	System.out.print(n + " ");
            System.out.println();
		}
	}
}