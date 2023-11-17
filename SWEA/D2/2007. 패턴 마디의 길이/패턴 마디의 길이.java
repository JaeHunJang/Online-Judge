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
            System.out.print("#" + test_case + " ");
            String s = sc.next();
            int i = 1;
            for(; i < s.length(); i++) {
                String text = s.substring(0,i);
                if(text.startsWith(s.replaceAll(text,"")))
                    break;
            }
            System.out.println(i);
		}
	}
}