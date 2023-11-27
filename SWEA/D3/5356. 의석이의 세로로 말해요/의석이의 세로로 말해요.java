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
			List<String> list = new ArrayList<>();
			
			for(int i = 0; i < 5; i++) {
				list.add(sc.next());
			}
			int length = list.stream().mapToInt(item -> item.length()).max().getAsInt();
			
			String answer = "";
			for(int i = 0; i < length; i++) {
				for(int j = 0; j < 5; j++) {
					if(list.get(j).length() > i) answer += list.get(j).charAt(i);
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}