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
            String string = "";
			System.out.println("#" + test_case);
            int n = sc.nextInt();
            for(int i = 0; i < n; i++) {
                String s = sc.next();
                int m = sc.nextInt();
                for(int j = 0; j < m; j++)
                	string += s;
            }
            while(string.length() > 10) {
                System.out.println(string.substring(0,10));
                string = string.substring(10);
            }
            if(string.length() > 0)
            	System.out.println(string);
		}
	}
}