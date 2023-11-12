import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.print("#" + test_case + " ");
            int answer = 1;
            
            int m1 = sc.nextInt()-1;
            int d1 = sc.nextInt();
            answer += days[m1] - d1;
            int m2 = sc.nextInt()-1;
            int d2 = sc.nextInt();
            for(++m1; m1 < m2; m1++) {
                answer += days[m1];
            }
            if(m1 == m2) {
            	answer += d2;
            }
            System.out.println(answer);
		}
	}
}