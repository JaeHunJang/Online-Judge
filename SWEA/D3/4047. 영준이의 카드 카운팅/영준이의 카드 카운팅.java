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
			String s = sc.next();
			int[] cards = { 13, 13, 13, 13};
			String card = "SDHC";
			
			List<String> list = new ArrayList<>();
			
			for(int i = 0; i < s.length(); i += 3) {
				String now = s.substring(i, i + 3);
				cards[card.indexOf(now.charAt(0) + "")]--;
				list.add(now);
			}
			
			System.out.print("#" + test_case + " ");
			
			if(list.size() == list.stream().distinct().count()) {
				System.out.println(cards[0] + " " + cards[1] + " " + cards[2] + " " + cards[3]);
			} else {
				System.out.println("ERROR");
			}
		}
	}
}