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
            int m = sc.nextInt();
            
            int index = 0;
            for(String digit : new StringBuilder(Integer.toString(m, 2)).reverse().toString().split("")) {
            	if(digit.equals("1")) index++;
            	else break;
            }
            
            String answer = "OFF";
            if(index >= n) answer = "ON";
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
}