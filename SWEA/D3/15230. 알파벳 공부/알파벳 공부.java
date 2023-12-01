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
            String english = "abcdefghijklmnopqrstuvwxyz";
            String s = sc.next();
            int count = 0;
            for(char ch : s.toCharArray()) {
                if(ch == english.charAt(count)) count++;
                else break;
            }
			System.out.println("#" + test_case + " " + count);
		}
	}
}