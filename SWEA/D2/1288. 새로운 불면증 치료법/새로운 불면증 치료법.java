import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        Set<String> set = new HashSet<>();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.print("#" + test_case + " ");
            int n = sc.nextInt();
            int i;
            set.clear();
            for (i = 1; set.size() < 10; i++) {
                for(String s : ((i*n)+"").split("")) {
                    set.add(s);
                }
            }
            System.out.println(n * --i);
		}
	}
}