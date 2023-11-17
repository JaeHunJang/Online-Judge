import java.util.*;
import java.io.FileInputStream;

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
            list.clear();
			System.out.print("#" + test_case + " ");
            for(int i = 1; i <= 10; i++){
                list.add(sc.nextInt());
            }
            Collections.sort(list);
            list.remove(9);
            list.remove(0);
            System.out.println(Math.round(list.stream().mapToInt(Integer::intValue).average().getAsDouble()));
		}
	}
}