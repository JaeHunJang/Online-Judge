import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		List<Double> list = new ArrayList<>();
        String[] answers = {"A+", "A0", "A-", "B+","B0","B-","C+","C0","C-","D0"};
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.print("#" + test_case+ " ");
            int n = sc.nextInt();
            int student = sc.nextInt();
            list.clear();
            for(int i = 0; i < n; i++) {
                list.add(sc.nextInt() * 0.35 + sc.nextInt() * 0.45 + sc.nextInt() * 0.2);
            }
			double temp = list.get(student-1);
            Collections.sort(list, Collections.reverseOrder());
            System.out.println(answers[list.indexOf(temp) / (n/10)]);
		}
	}
}