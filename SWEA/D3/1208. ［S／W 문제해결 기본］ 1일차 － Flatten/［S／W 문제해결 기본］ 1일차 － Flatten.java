import java.util.Scanner;
import java.io.FileInputStream;
import java.util.PriorityQueue;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			for(int i = 0; i < 100; i++) {
				pq.add(sc.nextInt());
			}
			
			for(int i = 0; i < n; i++) {
				pq.add(pq.poll() + 1);
				int max = pq.stream().mapToInt(Integer::intValue).max().getAsInt();
				pq.remove(max);
				pq.add(max - 1);
			}
			int max = pq.stream().mapToInt(Integer::intValue).max().getAsInt();
			
			System.out.println("#" + test_case + " " + (max - pq.poll()));
		}
	}
}