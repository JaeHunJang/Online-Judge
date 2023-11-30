import java.util.*;
import java.io.FileInputStream;
import java.util.stream.Collectors;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            List<Character> list = new ArrayList<>();
            
            for(int i = 0; i < n; i++) {
                list.add(sc.next().charAt(0));
            }
            
            char now = 'A';
            
            list = list.stream().distinct().sorted().collect(Collectors.toList());
            
            for(int i = 0; i < list.size(); i++) {
            	if(list.get(i) == now) now++;
            	else break;
            }
            
			System.out.println("#" + test_case + " " + (now - 'A'));
		}
	}
}