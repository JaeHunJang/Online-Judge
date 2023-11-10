import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        List<Integer> list = new ArrayList<>();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			list.add(sc.nextInt());
		}
        Collections.sort(list);
        System.out.println(list.get(list.size()/2));
	}
}