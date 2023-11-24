import java.util.Scanner;
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
            int count = 0;
            String now = "0";
            for(String s : sc.next().split("")) {
                if(!now.equals(s)) {
                    count++;
                    now = s;
                }
            }
			System.out.println("#" + test_case + " " + count);
		}
	}
}