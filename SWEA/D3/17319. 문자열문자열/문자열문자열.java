import java.util.*;
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
            String s = sc.next();
            String answer = "No";
            if(s.substring(n/2).equals(s.substring(0,n/2)))
                answer = "Yes";
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}