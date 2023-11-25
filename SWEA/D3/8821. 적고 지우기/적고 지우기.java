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
            String numbers = sc.next();
            List<String> list = new ArrayList<>();
            for(String n : numbers.split("")){
                if (list.contains(n)) list.remove(n);
                else list.add(n);
            }
			System.out.println("#" + test_case + " " + list.stream().count());
		}
	}
}