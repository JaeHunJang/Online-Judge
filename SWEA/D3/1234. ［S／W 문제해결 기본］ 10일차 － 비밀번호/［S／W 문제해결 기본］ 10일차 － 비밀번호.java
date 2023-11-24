import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			String s = sc.next();
	
			for(int i = 1; i < n; i++) {
				if(s.charAt(i - 1) == s.charAt(i)) {
					s = s.replaceFirst(s.charAt(i) + "" + s.charAt(i), "");
					i = 0;
					n -= 2;
				}
			}
            
			System.out.println("#" + test_case + " " + s);
		}
	}
}