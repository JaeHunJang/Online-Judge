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
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int answer = 0;
			
			StringBuilder sb = new StringBuilder();
			for(; a <= b; a++) {
				sb.setLength(0);
				String s = a+"";
				sb.append(s.substring(s.length()/2));
				int sqrt = (int) Math.sqrt(a);
				if(s.startsWith(sb.reverse().toString()) && Math.sqrt(a) == sqrt) {
					sb.setLength(0);
					s = sqrt+"";
					if(s.startsWith(sb.append(s.substring(s.length()/2)).reverse().toString())) answer++;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}