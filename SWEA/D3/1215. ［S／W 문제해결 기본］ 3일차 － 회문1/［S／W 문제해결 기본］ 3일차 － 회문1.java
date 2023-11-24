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
			String[][] arr = new String[8][8];
            
            for(int i = 0; i < 8; i++) {
                arr[i] = sc.next().split("");
            }
            
            int answer = 0;
            for(int i = 0; i < 8; i++) {
            	for(int j = 0; j+n <= 8; j++) {
            		answer += check(n, i, j, arr);
            	}
            }
            
			System.out.println("#" + test_case + " " + answer);
		}
	}
    
    	public static int check(int n, int i, int j, String[][] arr) {
		int count = 0;
		String row = "";
    	String col = "";
		for(int x = j; x < j+n; x++) {
			row += arr[i][x];
    		col += arr[x][i];
		}
		
		StringBuilder sb = new StringBuilder(row.substring(n/2));
		if (row.startsWith(sb.reverse().toString())) count++;
		sb.setLength(0);
		if (col.startsWith(sb.append(col.substring(n/2)).reverse().toString())) count++;
		
		return count;
	}
}