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
			int n = 7;
			int[] arr = new int[7];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			List<Integer> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					for(int k = j + 1; k < n; k++) {
						list.add(arr[i] + arr[j] + arr[k]);
					}
				}
			}
			int answer = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(4).limit(1).mapToInt(Integer::intValue).sum();
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}