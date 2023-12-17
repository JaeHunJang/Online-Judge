import java.util.LinkedList;
import java.util.Queue;
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
			sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			
			for(int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}
			
			int n = 0;
			do {
				for(int i = 1; i <= 5; i++) {
					n = q.poll() - i;
					if(n <= 0) {
						q.add(0);
						break;
					} else q.add(n);
				}
			} while(n > 0);
            
			String answer = "";
			for(int i = 0; i < 8; i++) {
				answer += q.poll() + " ";
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}