import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int answer = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				sb.setLength(0);
				for(int j = 0; j < n; j++) {
					sb.append(map[j][i]);
				}
				answer += countString(sb.toString(), "12");
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
	public static int countString(String input, String target) {
		int count = 0;
        int index = 0;
        input = input.replaceAll("0", "");
        
        while ((index = input.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
        }

        return count;
	}
}