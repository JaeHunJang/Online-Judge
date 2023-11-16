import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int[] nums = {11, 7, 5, 3, 2};

		for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.print("#" + test_case + " ");
            String answer = "";
            int target = sc.nextInt();
            for(int n : nums) {
                int m = 0;
                int i = 0;
                while( target % n == 0) {
                    target /= n;
                    i++;
                }
                answer = i + " " + answer;
            }
            System.out.println(answer);
		}
	}
}