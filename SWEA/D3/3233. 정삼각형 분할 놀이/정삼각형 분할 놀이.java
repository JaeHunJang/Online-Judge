import java.util.Scanner;
import java.io.FileInputStream;
import java.math.BigInteger;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            long answer = 0;
            for(long i = 0, count = 1; i < a / b; i++, count+=2) {
            	answer += count;
            }
			System.out.println("#" + test_case + " " + answer);
		}
	}
}